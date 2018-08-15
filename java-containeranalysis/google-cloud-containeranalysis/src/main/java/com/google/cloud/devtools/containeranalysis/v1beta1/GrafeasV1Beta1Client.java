/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.devtools.containeranalysis.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.devtools.containeranalysis.v1beta1.stub.GrafeasV1Beta1Stub;
import com.google.cloud.devtools.containeranalysis.v1beta1.stub.GrafeasV1Beta1StubSettings;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
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
 * <pre>
 * <code>
 * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
 *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
 *   Occurrence response = grafeasV1Beta1Client.getOccurrence(formattedName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the grafeasV1Beta1Client object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
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
 * <pre>
 * <code>
 * GrafeasV1Beta1Settings grafeasV1Beta1Settings =
 *     GrafeasV1Beta1Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GrafeasV1Beta1Client grafeasV1Beta1Client =
 *     GrafeasV1Beta1Client.create(grafeasV1Beta1Settings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GrafeasV1Beta1Settings grafeasV1Beta1Settings =
 *     GrafeasV1Beta1Settings.newBuilder().setEndpoint(myEndpoint).build();
 * GrafeasV1Beta1Client grafeasV1Beta1Client =
 *     GrafeasV1Beta1Client.create(grafeasV1Beta1Settings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GrafeasV1Beta1Client implements BackgroundResource {
  private final GrafeasV1Beta1Settings settings;
  private final GrafeasV1Beta1Stub stub;

  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate NOTE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/notes/{note}");

  private static final PathTemplate OCCURRENCE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/occurrences/{occurrence}");

  /** Formats a string containing the fully-qualified path to represent a project resource. */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /** Formats a string containing the fully-qualified path to represent a note resource. */
  public static final String formatNoteName(String project, String note) {
    return NOTE_PATH_TEMPLATE.instantiate(
        "project", project,
        "note", note);
  }

  /** Formats a string containing the fully-qualified path to represent a occurrence resource. */
  public static final String formatOccurrenceName(String project, String occurrence) {
    return OCCURRENCE_PATH_TEMPLATE.instantiate(
        "project", project,
        "occurrence", occurrence);
  }

  /** Parses the project from the given fully-qualified path which represents a project resource. */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /** Parses the project from the given fully-qualified path which represents a note resource. */
  public static final String parseProjectFromNoteName(String noteName) {
    return NOTE_PATH_TEMPLATE.parse(noteName).get("project");
  }

  /** Parses the note from the given fully-qualified path which represents a note resource. */
  public static final String parseNoteFromNoteName(String noteName) {
    return NOTE_PATH_TEMPLATE.parse(noteName).get("note");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a occurrence resource.
   */
  public static final String parseProjectFromOccurrenceName(String occurrenceName) {
    return OCCURRENCE_PATH_TEMPLATE.parse(occurrenceName).get("project");
  }

  /**
   * Parses the occurrence from the given fully-qualified path which represents a occurrence
   * resource.
   */
  public static final String parseOccurrenceFromOccurrenceName(String occurrenceName) {
    return OCCURRENCE_PATH_TEMPLATE.parse(occurrenceName).get("occurrence");
  }

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
   * for advanced usage - prefer to use GrafeasV1Beta1Settings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GrafeasV1Beta1Client(GrafeasV1Beta1Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GrafeasV1Beta1Settings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GrafeasV1Beta1Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   Occurrence response = grafeasV1Beta1Client.getOccurrence(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence getOccurrence(String name) {
    OCCURRENCE_PATH_TEMPLATE.validate(name, "getOccurrence");
    GetOccurrenceRequest request = GetOccurrenceRequest.newBuilder().setName(name).build();
    return getOccurrence(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   GetOccurrenceRequest request = GetOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Occurrence response = grafeasV1Beta1Client.getOccurrence(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Occurrence getOccurrence(GetOccurrenceRequest request) {
    return getOccurrenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   GetOccurrenceRequest request = GetOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Occurrence&gt; future = grafeasV1Beta1Client.getOccurrenceCallable().futureCall(request);
   *   // Do something
   *   Occurrence response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetOccurrenceRequest, Occurrence> getOccurrenceCallable() {
    return stub.getOccurrenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists occurrences for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   for (Occurrence element : grafeasV1Beta1Client.listOccurrences(formattedParent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The name of the project to list occurrences for in the form of
   *     `projects/[PROJECT_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOccurrencesPagedResponse listOccurrences(String parent, String filter) {
    PROJECT_PATH_TEMPLATE.validate(parent, "listOccurrences");
    ListOccurrencesRequest request =
        ListOccurrencesRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listOccurrences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists occurrences for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   ListOccurrencesRequest request = ListOccurrencesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (Occurrence element : grafeasV1Beta1Client.listOccurrences(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOccurrencesPagedResponse listOccurrences(ListOccurrencesRequest request) {
    return listOccurrencesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists occurrences for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   ListOccurrencesRequest request = ListOccurrencesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListOccurrencesPagedResponse&gt; future = grafeasV1Beta1Client.listOccurrencesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Occurrence element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListOccurrencesRequest, ListOccurrencesPagedResponse>
      listOccurrencesPagedCallable() {
    return stub.listOccurrencesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists occurrences for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   ListOccurrencesRequest request = ListOccurrencesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListOccurrencesResponse response = grafeasV1Beta1Client.listOccurrencesCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<ListOccurrencesRequest, ListOccurrencesResponse>
      listOccurrencesCallable() {
    return stub.listOccurrencesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified occurrence. For example, use this method to delete an occurrence when the
   * occurrence is no longer applicable for the given resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   grafeasV1Beta1Client.deleteOccurrence(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteOccurrence(String name) {
    OCCURRENCE_PATH_TEMPLATE.validate(name, "deleteOccurrence");
    DeleteOccurrenceRequest request = DeleteOccurrenceRequest.newBuilder().setName(name).build();
    deleteOccurrence(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified occurrence. For example, use this method to delete an occurrence when the
   * occurrence is no longer applicable for the given resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   DeleteOccurrenceRequest request = DeleteOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   grafeasV1Beta1Client.deleteOccurrence(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteOccurrence(DeleteOccurrenceRequest request) {
    deleteOccurrenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified occurrence. For example, use this method to delete an occurrence when the
   * occurrence is no longer applicable for the given resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   DeleteOccurrenceRequest request = DeleteOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = grafeasV1Beta1Client.deleteOccurrenceCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteOccurrenceRequest, Empty> deleteOccurrenceCallable() {
    return stub.deleteOccurrenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   Occurrence response = grafeasV1Beta1Client.createOccurrence(formattedParent, occurrence);
   * }
   * </code></pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     occurrence is to be created.
   * @param occurrence The occurrence to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence createOccurrence(String parent, Occurrence occurrence) {
    PROJECT_PATH_TEMPLATE.validate(parent, "createOccurrence");
    CreateOccurrenceRequest request =
        CreateOccurrenceRequest.newBuilder().setParent(parent).setOccurrence(occurrence).build();
    return createOccurrence(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   CreateOccurrenceRequest request = CreateOccurrenceRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setOccurrence(occurrence)
   *     .build();
   *   Occurrence response = grafeasV1Beta1Client.createOccurrence(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence createOccurrence(CreateOccurrenceRequest request) {
    return createOccurrenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   CreateOccurrenceRequest request = CreateOccurrenceRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setOccurrence(occurrence)
   *     .build();
   *   ApiFuture&lt;Occurrence&gt; future = grafeasV1Beta1Client.createOccurrenceCallable().futureCall(request);
   *   // Do something
   *   Occurrence response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateOccurrenceRequest, Occurrence> createOccurrenceCallable() {
    return stub.createOccurrenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates new occurrences in batch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   List&lt;Occurrence&gt; occurrences = new ArrayList&lt;&gt;();
   *   BatchCreateOccurrencesResponse response = grafeasV1Beta1Client.batchCreateOccurrences(formattedParent, occurrences);
   * }
   * </code></pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     occurrences are to be created.
   * @param occurrences The occurrences to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateOccurrencesResponse batchCreateOccurrences(
      String parent, List<Occurrence> occurrences) {
    PROJECT_PATH_TEMPLATE.validate(parent, "batchCreateOccurrences");
    BatchCreateOccurrencesRequest request =
        BatchCreateOccurrencesRequest.newBuilder()
            .setParent(parent)
            .addAllOccurrences(occurrences)
            .build();
    return batchCreateOccurrences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates new occurrences in batch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   List&lt;Occurrence&gt; occurrences = new ArrayList&lt;&gt;();
   *   BatchCreateOccurrencesRequest request = BatchCreateOccurrencesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .addAllOccurrences(occurrences)
   *     .build();
   *   BatchCreateOccurrencesResponse response = grafeasV1Beta1Client.batchCreateOccurrences(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateOccurrencesResponse batchCreateOccurrences(
      BatchCreateOccurrencesRequest request) {
    return batchCreateOccurrencesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates new occurrences in batch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   List&lt;Occurrence&gt; occurrences = new ArrayList&lt;&gt;();
   *   BatchCreateOccurrencesRequest request = BatchCreateOccurrencesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .addAllOccurrences(occurrences)
   *     .build();
   *   ApiFuture&lt;BatchCreateOccurrencesResponse&gt; future = grafeasV1Beta1Client.batchCreateOccurrencesCallable().futureCall(request);
   *   // Do something
   *   BatchCreateOccurrencesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesCallable() {
    return stub.batchCreateOccurrencesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Occurrence response = grafeasV1Beta1Client.updateOccurrence(formattedName, occurrence, updateMask);
   * }
   * </code></pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @param occurrence The updated occurrence.
   * @param updateMask The fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence updateOccurrence(
      String name, Occurrence occurrence, FieldMask updateMask) {
    OCCURRENCE_PATH_TEMPLATE.validate(name, "updateOccurrence");
    UpdateOccurrenceRequest request =
        UpdateOccurrenceRequest.newBuilder()
            .setName(name)
            .setOccurrence(occurrence)
            .setUpdateMask(updateMask)
            .build();
    return updateOccurrence(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   UpdateOccurrenceRequest request = UpdateOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .setOccurrence(occurrence)
   *     .build();
   *   Occurrence response = grafeasV1Beta1Client.updateOccurrence(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence updateOccurrence(UpdateOccurrenceRequest request) {
    return updateOccurrenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   UpdateOccurrenceRequest request = UpdateOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .setOccurrence(occurrence)
   *     .build();
   *   ApiFuture&lt;Occurrence&gt; future = grafeasV1Beta1Client.updateOccurrenceCallable().futureCall(request);
   *   // Do something
   *   Occurrence response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateOccurrenceRequest, Occurrence> updateOccurrenceCallable() {
    return stub.updateOccurrenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the note attached to the specified occurrence. Consumer projects can use this method to
   * get a note that belongs to a provider project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   Note response = grafeasV1Beta1Client.getOccurrenceNote(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note getOccurrenceNote(String name) {
    OCCURRENCE_PATH_TEMPLATE.validate(name, "getOccurrenceNote");
    GetOccurrenceNoteRequest request = GetOccurrenceNoteRequest.newBuilder().setName(name).build();
    return getOccurrenceNote(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the note attached to the specified occurrence. Consumer projects can use this method to
   * get a note that belongs to a provider project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   GetOccurrenceNoteRequest request = GetOccurrenceNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Note response = grafeasV1Beta1Client.getOccurrenceNote(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Note getOccurrenceNote(GetOccurrenceNoteRequest request) {
    return getOccurrenceNoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the note attached to the specified occurrence. Consumer projects can use this method to
   * get a note that belongs to a provider project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   GetOccurrenceNoteRequest request = GetOccurrenceNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Note&gt; future = grafeasV1Beta1Client.getOccurrenceNoteCallable().futureCall(request);
   *   // Do something
   *   Note response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetOccurrenceNoteRequest, Note> getOccurrenceNoteCallable() {
    return stub.getOccurrenceNoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   Note response = grafeasV1Beta1Client.getNote(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note getNote(String name) {
    NOTE_PATH_TEMPLATE.validate(name, "getNote");
    GetNoteRequest request = GetNoteRequest.newBuilder().setName(name).build();
    return getNote(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   GetNoteRequest request = GetNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Note response = grafeasV1Beta1Client.getNote(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Note getNote(GetNoteRequest request) {
    return getNoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   GetNoteRequest request = GetNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Note&gt; future = grafeasV1Beta1Client.getNoteCallable().futureCall(request);
   *   // Do something
   *   Note response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetNoteRequest, Note> getNoteCallable() {
    return stub.getNoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists notes for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   for (Note element : grafeasV1Beta1Client.listNotes(formattedParent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The name of the project to list notes for in the form of `projects/[PROJECT_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotesPagedResponse listNotes(String parent, String filter) {
    PROJECT_PATH_TEMPLATE.validate(parent, "listNotes");
    ListNotesRequest request =
        ListNotesRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listNotes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists notes for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   ListNotesRequest request = ListNotesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (Note element : grafeasV1Beta1Client.listNotes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotesPagedResponse listNotes(ListNotesRequest request) {
    return listNotesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists notes for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   ListNotesRequest request = ListNotesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListNotesPagedResponse&gt; future = grafeasV1Beta1Client.listNotesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Note element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListNotesRequest, ListNotesPagedResponse> listNotesPagedCallable() {
    return stub.listNotesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists notes for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   ListNotesRequest request = ListNotesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
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
   * </code></pre>
   */
  public final UnaryCallable<ListNotesRequest, ListNotesResponse> listNotesCallable() {
    return stub.listNotesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   grafeasV1Beta1Client.deleteNote(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNote(String name) {
    NOTE_PATH_TEMPLATE.validate(name, "deleteNote");
    DeleteNoteRequest request = DeleteNoteRequest.newBuilder().setName(name).build();
    deleteNote(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   DeleteNoteRequest request = DeleteNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   grafeasV1Beta1Client.deleteNote(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteNote(DeleteNoteRequest request) {
    deleteNoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   DeleteNoteRequest request = DeleteNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = grafeasV1Beta1Client.deleteNoteCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteNoteRequest, Empty> deleteNoteCallable() {
    return stub.deleteNoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   String noteId = "";
   *   Note note = Note.newBuilder().build();
   *   Note response = grafeasV1Beta1Client.createNote(formattedParent, noteId, note);
   * }
   * </code></pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     note is to be created.
   * @param noteId The ID to use for this note.
   * @param note The note to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note createNote(String parent, String noteId, Note note) {
    PROJECT_PATH_TEMPLATE.validate(parent, "createNote");
    CreateNoteRequest request =
        CreateNoteRequest.newBuilder().setParent(parent).setNoteId(noteId).setNote(note).build();
    return createNote(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   String noteId = "";
   *   Note note = Note.newBuilder().build();
   *   CreateNoteRequest request = CreateNoteRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setNoteId(noteId)
   *     .setNote(note)
   *     .build();
   *   Note response = grafeasV1Beta1Client.createNote(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note createNote(CreateNoteRequest request) {
    return createNoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   String noteId = "";
   *   Note note = Note.newBuilder().build();
   *   CreateNoteRequest request = CreateNoteRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setNoteId(noteId)
   *     .setNote(note)
   *     .build();
   *   ApiFuture&lt;Note&gt; future = grafeasV1Beta1Client.createNoteCallable().futureCall(request);
   *   // Do something
   *   Note response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateNoteRequest, Note> createNoteCallable() {
    return stub.createNoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates new notes in batch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   Map&lt;String, Note&gt; notes = new HashMap&lt;&gt;();
   *   BatchCreateNotesResponse response = grafeasV1Beta1Client.batchCreateNotes(formattedParent, notes);
   * }
   * </code></pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     notes are to be created.
   * @param notes The notes to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateNotesResponse batchCreateNotes(String parent, Map<String, Note> notes) {
    PROJECT_PATH_TEMPLATE.validate(parent, "batchCreateNotes");
    BatchCreateNotesRequest request =
        BatchCreateNotesRequest.newBuilder().setParent(parent).putAllNotes(notes).build();
    return batchCreateNotes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates new notes in batch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   Map&lt;String, Note&gt; notes = new HashMap&lt;&gt;();
   *   BatchCreateNotesRequest request = BatchCreateNotesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .putAllNotes(notes)
   *     .build();
   *   BatchCreateNotesResponse response = grafeasV1Beta1Client.batchCreateNotes(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateNotesResponse batchCreateNotes(BatchCreateNotesRequest request) {
    return batchCreateNotesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates new notes in batch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   Map&lt;String, Note&gt; notes = new HashMap&lt;&gt;();
   *   BatchCreateNotesRequest request = BatchCreateNotesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .putAllNotes(notes)
   *     .build();
   *   ApiFuture&lt;BatchCreateNotesResponse&gt; future = grafeasV1Beta1Client.batchCreateNotesCallable().futureCall(request);
   *   // Do something
   *   BatchCreateNotesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesCallable() {
    return stub.batchCreateNotesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   Note note = Note.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Note response = grafeasV1Beta1Client.updateNote(formattedName, note, updateMask);
   * }
   * </code></pre>
   *
   * @param name The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @param note The updated note.
   * @param updateMask The fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note updateNote(String name, Note note, FieldMask updateMask) {
    NOTE_PATH_TEMPLATE.validate(name, "updateNote");
    UpdateNoteRequest request =
        UpdateNoteRequest.newBuilder()
            .setName(name)
            .setNote(note)
            .setUpdateMask(updateMask)
            .build();
    return updateNote(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   Note note = Note.newBuilder().build();
   *   UpdateNoteRequest request = UpdateNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .setNote(note)
   *     .build();
   *   Note response = grafeasV1Beta1Client.updateNote(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note updateNote(UpdateNoteRequest request) {
    return updateNoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   Note note = Note.newBuilder().build();
   *   UpdateNoteRequest request = UpdateNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .setNote(note)
   *     .build();
   *   ApiFuture&lt;Note&gt; future = grafeasV1Beta1Client.updateNoteCallable().futureCall(request);
   *   // Do something
   *   Note response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateNoteRequest, Note> updateNoteCallable() {
    return stub.updateNoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists occurrences referencing the specified note. Provider projects can use this method to get
   * all occurrences across consumer projects referencing the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   String filter = "";
   *   for (Occurrence element : grafeasV1Beta1Client.listNoteOccurrences(formattedName, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param name The name of the note to list occurrences for in the form of
   *     `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNoteOccurrencesPagedResponse listNoteOccurrences(String name, String filter) {
    NOTE_PATH_TEMPLATE.validate(name, "listNoteOccurrences");
    ListNoteOccurrencesRequest request =
        ListNoteOccurrencesRequest.newBuilder().setName(name).setFilter(filter).build();
    return listNoteOccurrences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists occurrences referencing the specified note. Provider projects can use this method to get
   * all occurrences across consumer projects referencing the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   ListNoteOccurrencesRequest request = ListNoteOccurrencesRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   for (Occurrence element : grafeasV1Beta1Client.listNoteOccurrences(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNoteOccurrencesPagedResponse listNoteOccurrences(
      ListNoteOccurrencesRequest request) {
    return listNoteOccurrencesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists occurrences referencing the specified note. Provider projects can use this method to get
   * all occurrences across consumer projects referencing the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   ListNoteOccurrencesRequest request = ListNoteOccurrencesRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;ListNoteOccurrencesPagedResponse&gt; future = grafeasV1Beta1Client.listNoteOccurrencesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Occurrence element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesPagedCallable() {
    return stub.listNoteOccurrencesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists occurrences referencing the specified note. Provider projects can use this method to get
   * all occurrences across consumer projects referencing the specified note.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedName = GrafeasV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
   *   ListNoteOccurrencesRequest request = ListNoteOccurrencesRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   while (true) {
   *     ListNoteOccurrencesResponse response = grafeasV1Beta1Client.listNoteOccurrencesCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesCallable() {
    return stub.listNoteOccurrencesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   VulnerabilityOccurrencesSummary response = grafeasV1Beta1Client.getVulnerabilityOccurrencesSummary(formattedParent, filter);
   * }
   * </code></pre>
   *
   * @param parent The name of the project to get a vulnerability summary for in the form of
   *     `projects/[PROJECT_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityOccurrencesSummary getVulnerabilityOccurrencesSummary(
      String parent, String filter) {
    PROJECT_PATH_TEMPLATE.validate(parent, "getVulnerabilityOccurrencesSummary");
    GetVulnerabilityOccurrencesSummaryRequest request =
        GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
            .setParent(parent)
            .setFilter(filter)
            .build();
    return getVulnerabilityOccurrencesSummary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   GetVulnerabilityOccurrencesSummaryRequest request = GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   VulnerabilityOccurrencesSummary response = grafeasV1Beta1Client.getVulnerabilityOccurrencesSummary(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityOccurrencesSummary getVulnerabilityOccurrencesSummary(
      GetVulnerabilityOccurrencesSummaryRequest request) {
    return getVulnerabilityOccurrencesSummaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   String formattedParent = GrafeasV1Beta1Client.formatProjectName("[PROJECT]");
   *   GetVulnerabilityOccurrencesSummaryRequest request = GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;VulnerabilityOccurrencesSummary&gt; future = grafeasV1Beta1Client.getVulnerabilityOccurrencesSummaryCallable().futureCall(request);
   *   // Do something
   *   VulnerabilityOccurrencesSummary response = future.get();
   * }
   * </code></pre>
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
          ListOccurrencesRequest, ListOccurrencesResponse, Occurrence, ListOccurrencesPage,
          ListOccurrencesFixedSizeCollection> {

    public static ApiFuture<ListOccurrencesPagedResponse> createAsync(
        PageContext<ListOccurrencesRequest, ListOccurrencesResponse, Occurrence> context,
        ApiFuture<ListOccurrencesResponse> futureResponse) {
      ApiFuture<ListOccurrencesPage> futurePage =
          ListOccurrencesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListOccurrencesPage, ListOccurrencesPagedResponse>() {
            @Override
            public ListOccurrencesPagedResponse apply(ListOccurrencesPage input) {
              return new ListOccurrencesPagedResponse(input);
            }
          });
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
          ListOccurrencesRequest, ListOccurrencesResponse, Occurrence, ListOccurrencesPage,
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
          futurePage,
          new ApiFunction<ListNotesPage, ListNotesPagedResponse>() {
            @Override
            public ListNotesPagedResponse apply(ListNotesPage input) {
              return new ListNotesPagedResponse(input);
            }
          });
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
          ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence,
          ListNoteOccurrencesPage, ListNoteOccurrencesFixedSizeCollection> {

    public static ApiFuture<ListNoteOccurrencesPagedResponse> createAsync(
        PageContext<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence> context,
        ApiFuture<ListNoteOccurrencesResponse> futureResponse) {
      ApiFuture<ListNoteOccurrencesPage> futurePage =
          ListNoteOccurrencesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListNoteOccurrencesPage, ListNoteOccurrencesPagedResponse>() {
            @Override
            public ListNoteOccurrencesPagedResponse apply(ListNoteOccurrencesPage input) {
              return new ListNoteOccurrencesPagedResponse(input);
            }
          });
    }

    private ListNoteOccurrencesPagedResponse(ListNoteOccurrencesPage page) {
      super(page, ListNoteOccurrencesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNoteOccurrencesPage
      extends AbstractPage<
          ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence,
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
          ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence,
          ListNoteOccurrencesPage, ListNoteOccurrencesFixedSizeCollection> {

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
