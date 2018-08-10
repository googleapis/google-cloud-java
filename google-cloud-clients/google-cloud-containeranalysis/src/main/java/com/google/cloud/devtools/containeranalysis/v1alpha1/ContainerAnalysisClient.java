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
package com.google.cloud.devtools.containeranalysis.v1alpha1;

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
import com.google.cloud.devtools.containeranalysis.v1alpha1.stub.ContainerAnalysisStub;
import com.google.cloud.devtools.containeranalysis.v1alpha1.stub.ContainerAnalysisStubSettings;
import com.google.containeranalysis.v1alpha1.CreateNoteRequest;
import com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.DeleteNoteRequest;
import com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.GetNoteRequest;
import com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest;
import com.google.containeranalysis.v1alpha1.GetOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest;
import com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse;
import com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest;
import com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse;
import com.google.containeranalysis.v1alpha1.ListNotesRequest;
import com.google.containeranalysis.v1alpha1.ListNotesResponse;
import com.google.containeranalysis.v1alpha1.ListOccurrencesRequest;
import com.google.containeranalysis.v1alpha1.ListOccurrencesResponse;
import com.google.containeranalysis.v1alpha1.Note;
import com.google.containeranalysis.v1alpha1.Occurrence;
import com.google.containeranalysis.v1alpha1.UpdateNoteRequest;
import com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Retrieves the results of vulnerability scanning of cloud components such as
 * container images. The Container Analysis API is an implementation of the [Grafeas](grafeas.io)
 * API.
 *
 * <p>The vulnerability results are stored as a series of Occurrences. An `Occurrence` contains
 * information about a specific vulnerability in a resource. An `Occurrence` references a `Note`. A
 * `Note` contains details about the vulnerability and is stored in a stored in a separate project.
 * Multiple `Occurrences` can reference the same `Note`. For example, an SSL vulnerability could
 * affect multiple packages in an image. In this case, there would be one `Note` for the
 * vulnerability and an `Occurrence` for each package with the vulnerability referencing that
 * `Note`.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
 *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
 *   Occurrence response = containerAnalysisClient.getOccurrence(formattedName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the containerAnalysisClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of ContainerAnalysisSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ContainerAnalysisSettings containerAnalysisSettings =
 *     ContainerAnalysisSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContainerAnalysisClient containerAnalysisClient =
 *     ContainerAnalysisClient.create(containerAnalysisSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ContainerAnalysisSettings containerAnalysisSettings =
 *     ContainerAnalysisSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContainerAnalysisClient containerAnalysisClient =
 *     ContainerAnalysisClient.create(containerAnalysisSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ContainerAnalysisClient implements BackgroundResource {
  private final ContainerAnalysisSettings settings;
  private final ContainerAnalysisStub stub;

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

  /** Constructs an instance of ContainerAnalysisClient with default settings. */
  public static final ContainerAnalysisClient create() throws IOException {
    return create(ContainerAnalysisSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContainerAnalysisClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContainerAnalysisClient create(ContainerAnalysisSettings settings)
      throws IOException {
    return new ContainerAnalysisClient(settings);
  }

  /**
   * Constructs an instance of ContainerAnalysisClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use ContainerAnalysisSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ContainerAnalysisClient create(ContainerAnalysisStub stub) {
    return new ContainerAnalysisClient(stub);
  }

  /**
   * Constructs an instance of ContainerAnalysisClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ContainerAnalysisClient(ContainerAnalysisSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContainerAnalysisStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ContainerAnalysisClient(ContainerAnalysisStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContainerAnalysisSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ContainerAnalysisStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the requested `Occurrence`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   Occurrence response = containerAnalysisClient.getOccurrence(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name of the occurrence of the form
   *     "projects/{project_id}/occurrences/{OCCURRENCE_ID}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence getOccurrence(String name) {
    OCCURRENCE_PATH_TEMPLATE.validate(name, "getOccurrence");
    GetOccurrenceRequest request = GetOccurrenceRequest.newBuilder().setName(name).build();
    return getOccurrence(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the requested `Occurrence`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   GetOccurrenceRequest request = GetOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Occurrence response = containerAnalysisClient.getOccurrence(request);
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
   * Returns the requested `Occurrence`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   GetOccurrenceRequest request = GetOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Occurrence&gt; future = containerAnalysisClient.getOccurrenceCallable().futureCall(request);
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
   * Lists active `Occurrences` for a given project matching the filters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   for (Occurrence element : containerAnalysisClient.listOccurrences(formattedParent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent This contains the project Id for example: projects/{project_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOccurrencesPagedResponse listOccurrences(String parent) {
    PROJECT_PATH_TEMPLATE.validate(parent, "listOccurrences");
    ListOccurrencesRequest request = ListOccurrencesRequest.newBuilder().setParent(parent).build();
    return listOccurrences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists active `Occurrences` for a given project matching the filters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   ListOccurrencesRequest request = ListOccurrencesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (Occurrence element : containerAnalysisClient.listOccurrences(request).iterateAll()) {
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
   * Lists active `Occurrences` for a given project matching the filters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   ListOccurrencesRequest request = ListOccurrencesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListOccurrencesPagedResponse&gt; future = containerAnalysisClient.listOccurrencesPagedCallable().futureCall(request);
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
   * Lists active `Occurrences` for a given project matching the filters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   ListOccurrencesRequest request = ListOccurrencesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListOccurrencesResponse response = containerAnalysisClient.listOccurrencesCallable().call(request);
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
   * Deletes the given `Occurrence` from the system. Use this when an `Occurrence` is no longer
   * applicable for the given resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   containerAnalysisClient.deleteOccurrence(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name of the occurrence in the form of
   *     "projects/{project_id}/occurrences/{OCCURRENCE_ID}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteOccurrence(String name) {
    OCCURRENCE_PATH_TEMPLATE.validate(name, "deleteOccurrence");
    DeleteOccurrenceRequest request = DeleteOccurrenceRequest.newBuilder().setName(name).build();
    deleteOccurrence(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the given `Occurrence` from the system. Use this when an `Occurrence` is no longer
   * applicable for the given resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   DeleteOccurrenceRequest request = DeleteOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   containerAnalysisClient.deleteOccurrence(request);
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
   * Deletes the given `Occurrence` from the system. Use this when an `Occurrence` is no longer
   * applicable for the given resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   DeleteOccurrenceRequest request = DeleteOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = containerAnalysisClient.deleteOccurrenceCallable().futureCall(request);
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
   * Creates a new `Occurrence`. Use this method to create `Occurrences` for a resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   Occurrence response = containerAnalysisClient.createOccurrence(formattedParent, occurrence);
   * }
   * </code></pre>
   *
   * @param parent This field contains the project Id for example: "projects/{project_id}"
   * @param occurrence The occurrence to be inserted
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
   * Creates a new `Occurrence`. Use this method to create `Occurrences` for a resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   CreateOccurrenceRequest request = CreateOccurrenceRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setOccurrence(occurrence)
   *     .build();
   *   Occurrence response = containerAnalysisClient.createOccurrence(request);
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
   * Creates a new `Occurrence`. Use this method to create `Occurrences` for a resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   CreateOccurrenceRequest request = CreateOccurrenceRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setOccurrence(occurrence)
   *     .build();
   *   ApiFuture&lt;Occurrence&gt; future = containerAnalysisClient.createOccurrenceCallable().futureCall(request);
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
   * Updates an existing occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   Occurrence response = containerAnalysisClient.updateOccurrence(formattedName, occurrence);
   * }
   * </code></pre>
   *
   * @param name The name of the occurrence. Should be of the form
   *     "projects/{project_id}/occurrences/{OCCURRENCE_ID}".
   * @param occurrence The updated occurrence.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence updateOccurrence(String name, Occurrence occurrence) {
    OCCURRENCE_PATH_TEMPLATE.validate(name, "updateOccurrence");
    UpdateOccurrenceRequest request =
        UpdateOccurrenceRequest.newBuilder().setName(name).setOccurrence(occurrence).build();
    return updateOccurrence(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   UpdateOccurrenceRequest request = UpdateOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .setOccurrence(occurrence)
   *     .build();
   *   Occurrence response = containerAnalysisClient.updateOccurrence(request);
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
   * Updates an existing occurrence.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   UpdateOccurrenceRequest request = UpdateOccurrenceRequest.newBuilder()
   *     .setName(formattedName)
   *     .setOccurrence(occurrence)
   *     .build();
   *   ApiFuture&lt;Occurrence&gt; future = containerAnalysisClient.updateOccurrenceCallable().futureCall(request);
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
   * Gets the `Note` attached to the given `Occurrence`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   Note response = containerAnalysisClient.getOccurrenceNote(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name of the occurrence in the form
   *     "projects/{project_id}/occurrences/{OCCURRENCE_ID}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note getOccurrenceNote(String name) {
    OCCURRENCE_PATH_TEMPLATE.validate(name, "getOccurrenceNote");
    GetOccurrenceNoteRequest request = GetOccurrenceNoteRequest.newBuilder().setName(name).build();
    return getOccurrenceNote(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the `Note` attached to the given `Occurrence`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   GetOccurrenceNoteRequest request = GetOccurrenceNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Note response = containerAnalysisClient.getOccurrenceNote(request);
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
   * Gets the `Note` attached to the given `Occurrence`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
   *   GetOccurrenceNoteRequest request = GetOccurrenceNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Note&gt; future = containerAnalysisClient.getOccurrenceNoteCallable().futureCall(request);
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
   * Returns the requested `Note`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   Note response = containerAnalysisClient.getNote(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name of the note in the form of "providers/{provider_id}/notes/{NOTE_ID}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note getNote(String name) {
    NOTE_PATH_TEMPLATE.validate(name, "getNote");
    GetNoteRequest request = GetNoteRequest.newBuilder().setName(name).build();
    return getNote(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the requested `Note`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   GetNoteRequest request = GetNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Note response = containerAnalysisClient.getNote(request);
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
   * Returns the requested `Note`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   GetNoteRequest request = GetNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Note&gt; future = containerAnalysisClient.getNoteCallable().futureCall(request);
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
   * Lists all `Notes` for a given project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   for (Note element : containerAnalysisClient.listNotes(formattedParent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent This field contains the project Id for example: "projects/{PROJECT_ID}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotesPagedResponse listNotes(String parent) {
    PROJECT_PATH_TEMPLATE.validate(parent, "listNotes");
    ListNotesRequest request = ListNotesRequest.newBuilder().setParent(parent).build();
    return listNotes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all `Notes` for a given project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   ListNotesRequest request = ListNotesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (Note element : containerAnalysisClient.listNotes(request).iterateAll()) {
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
   * Lists all `Notes` for a given project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   ListNotesRequest request = ListNotesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListNotesPagedResponse&gt; future = containerAnalysisClient.listNotesPagedCallable().futureCall(request);
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
   * Lists all `Notes` for a given project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   ListNotesRequest request = ListNotesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListNotesResponse response = containerAnalysisClient.listNotesCallable().call(request);
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
   * Deletes the given `Note` from the system.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   containerAnalysisClient.deleteNote(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name of the note in the form of "providers/{provider_id}/notes/{NOTE_ID}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNote(String name) {
    NOTE_PATH_TEMPLATE.validate(name, "deleteNote");
    DeleteNoteRequest request = DeleteNoteRequest.newBuilder().setName(name).build();
    deleteNote(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the given `Note` from the system.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   DeleteNoteRequest request = DeleteNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   containerAnalysisClient.deleteNote(request);
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
   * Deletes the given `Note` from the system.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   DeleteNoteRequest request = DeleteNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = containerAnalysisClient.deleteNoteCallable().futureCall(request);
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
   * Creates a new `Note`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   String noteId = "";
   *   Note note = Note.newBuilder().build();
   *   Note response = containerAnalysisClient.createNote(formattedParent, noteId, note);
   * }
   * </code></pre>
   *
   * @param parent This field contains the project Id for example: "projects/{project_id}
   * @param noteId The ID to use for this note.
   * @param note The Note to be inserted
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
   * Creates a new `Note`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   String noteId = "";
   *   Note note = Note.newBuilder().build();
   *   CreateNoteRequest request = CreateNoteRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setNoteId(noteId)
   *     .setNote(note)
   *     .build();
   *   Note response = containerAnalysisClient.createNote(request);
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
   * Creates a new `Note`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   String noteId = "";
   *   Note note = Note.newBuilder().build();
   *   CreateNoteRequest request = CreateNoteRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setNoteId(noteId)
   *     .setNote(note)
   *     .build();
   *   ApiFuture&lt;Note&gt; future = containerAnalysisClient.createNoteCallable().futureCall(request);
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
   * Updates an existing `Note`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   Note note = Note.newBuilder().build();
   *   Note response = containerAnalysisClient.updateNote(formattedName, note);
   * }
   * </code></pre>
   *
   * @param name The name of the note. Should be of the form
   *     "projects/{provider_id}/notes/{note_id}".
   * @param note The updated note.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note updateNote(String name, Note note) {
    NOTE_PATH_TEMPLATE.validate(name, "updateNote");
    UpdateNoteRequest request = UpdateNoteRequest.newBuilder().setName(name).setNote(note).build();
    return updateNote(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing `Note`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   Note note = Note.newBuilder().build();
   *   UpdateNoteRequest request = UpdateNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .setNote(note)
   *     .build();
   *   Note response = containerAnalysisClient.updateNote(request);
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
   * Updates an existing `Note`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   Note note = Note.newBuilder().build();
   *   UpdateNoteRequest request = UpdateNoteRequest.newBuilder()
   *     .setName(formattedName)
   *     .setNote(note)
   *     .build();
   *   ApiFuture&lt;Note&gt; future = containerAnalysisClient.updateNoteCallable().futureCall(request);
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
   * Lists `Occurrences` referencing the specified `Note`. Use this method to get all occurrences
   * referencing your `Note` across all your customer projects.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   for (Occurrence element : containerAnalysisClient.listNoteOccurrences(formattedName).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param name The name field will contain the note name for example:
   *     "provider/{provider_id}/notes/{note_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNoteOccurrencesPagedResponse listNoteOccurrences(String name) {
    NOTE_PATH_TEMPLATE.validate(name, "listNoteOccurrences");
    ListNoteOccurrencesRequest request =
        ListNoteOccurrencesRequest.newBuilder().setName(name).build();
    return listNoteOccurrences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists `Occurrences` referencing the specified `Note`. Use this method to get all occurrences
   * referencing your `Note` across all your customer projects.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   ListNoteOccurrencesRequest request = ListNoteOccurrencesRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   for (Occurrence element : containerAnalysisClient.listNoteOccurrences(request).iterateAll()) {
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
   * Lists `Occurrences` referencing the specified `Note`. Use this method to get all occurrences
   * referencing your `Note` across all your customer projects.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   ListNoteOccurrencesRequest request = ListNoteOccurrencesRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;ListNoteOccurrencesPagedResponse&gt; future = containerAnalysisClient.listNoteOccurrencesPagedCallable().futureCall(request);
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
   * Lists `Occurrences` referencing the specified `Note`. Use this method to get all occurrences
   * referencing your `Note` across all your customer projects.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedName = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   ListNoteOccurrencesRequest request = ListNoteOccurrencesRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   while (true) {
   *     ListNoteOccurrencesResponse response = containerAnalysisClient.listNoteOccurrencesCallable().call(request);
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
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   GetVulnzOccurrencesSummaryResponse response = containerAnalysisClient.getVulnzOccurrencesSummary(formattedParent);
   * }
   * </code></pre>
   *
   * @param parent This contains the project Id for example: projects/{project_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetVulnzOccurrencesSummaryResponse getVulnzOccurrencesSummary(String parent) {
    PROJECT_PATH_TEMPLATE.validate(parent, "getVulnzOccurrencesSummary");
    GetVulnzOccurrencesSummaryRequest request =
        GetVulnzOccurrencesSummaryRequest.newBuilder().setParent(parent).build();
    return getVulnzOccurrencesSummary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   GetVulnzOccurrencesSummaryRequest request = GetVulnzOccurrencesSummaryRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   GetVulnzOccurrencesSummaryResponse response = containerAnalysisClient.getVulnzOccurrencesSummary(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetVulnzOccurrencesSummaryResponse getVulnzOccurrencesSummary(
      GetVulnzOccurrencesSummaryRequest request) {
    return getVulnzOccurrencesSummaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedParent = ContainerAnalysisClient.formatProjectName("[PROJECT]");
   *   GetVulnzOccurrencesSummaryRequest request = GetVulnzOccurrencesSummaryRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;GetVulnzOccurrencesSummaryResponse&gt; future = containerAnalysisClient.getVulnzOccurrencesSummaryCallable().futureCall(request);
   *   // Do something
   *   GetVulnzOccurrencesSummaryResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
      getVulnzOccurrencesSummaryCallable() {
    return stub.getVulnzOccurrencesSummaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified `Note` or `Occurrence`. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a `Note` or an `Occurrence`, respectively. Attempting to call
   * this method without these permissions will result in a ` `PERMISSION_DENIED` error. Attempting
   * to call this method on a non-existent resource will result in a `NOT_FOUND` error if the user
   * has `containeranalysis.notes.list` permission on a `Note` or
   * `containeranalysis.occurrences.list` on an `Occurrence`, or a `PERMISSION_DENIED` error
   * otherwise. The resource takes the following formats:
   * `projects/{projectid}/occurrences/{occurrenceid}` for occurrences and
   * projects/{projectid}/notes/{noteid} for notes
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = containerAnalysisClient.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    NOTE_PATH_TEMPLATE.validate(resource, "setIamPolicy");
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified `Note` or `Occurrence`. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a `Note` or an `Occurrence`, respectively. Attempting to call
   * this method without these permissions will result in a ` `PERMISSION_DENIED` error. Attempting
   * to call this method on a non-existent resource will result in a `NOT_FOUND` error if the user
   * has `containeranalysis.notes.list` permission on a `Note` or
   * `containeranalysis.occurrences.list` on an `Occurrence`, or a `PERMISSION_DENIED` error
   * otherwise. The resource takes the following formats:
   * `projects/{projectid}/occurrences/{occurrenceid}` for occurrences and
   * projects/{projectid}/notes/{noteid} for notes
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = containerAnalysisClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified `Note` or `Occurrence`. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a `Note` or an `Occurrence`, respectively. Attempting to call
   * this method without these permissions will result in a ` `PERMISSION_DENIED` error. Attempting
   * to call this method on a non-existent resource will result in a `NOT_FOUND` error if the user
   * has `containeranalysis.notes.list` permission on a `Note` or
   * `containeranalysis.occurrences.list` on an `Occurrence`, or a `PERMISSION_DENIED` error
   * otherwise. The resource takes the following formats:
   * `projects/{projectid}/occurrences/{occurrenceid}` for occurrences and
   * projects/{projectid}/notes/{noteid} for notes
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = containerAnalysisClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a note or an `Occurrence` resource. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or occurrence, respectively. Attempting to call this
   * method on a resource without the required permission will result in a `PERMISSION_DENIED`
   * error. Attempting to call this method on a non-existent resource will result in a `NOT_FOUND`
   * error if the user has list permission on the project, or a `PERMISSION_DENIED` error otherwise.
   * The resource takes the following formats: `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}`
   * for occurrences and projects/{PROJECT_ID}/notes/{NOTE_ID} for notes
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   Policy response = containerAnalysisClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    NOTE_PATH_TEMPLATE.validate(resource, "getIamPolicy");
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a note or an `Occurrence` resource. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or occurrence, respectively. Attempting to call this
   * method on a resource without the required permission will result in a `PERMISSION_DENIED`
   * error. Attempting to call this method on a non-existent resource will result in a `NOT_FOUND`
   * error if the user has list permission on the project, or a `PERMISSION_DENIED` error otherwise.
   * The resource takes the following formats: `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}`
   * for occurrences and projects/{PROJECT_ID}/notes/{NOTE_ID} for notes
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = containerAnalysisClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a note or an `Occurrence` resource. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or occurrence, respectively. Attempting to call this
   * method on a resource without the required permission will result in a `PERMISSION_DENIED`
   * error. Attempting to call this method on a non-existent resource will result in a `NOT_FOUND`
   * error if the user has list permission on the project, or a `PERMISSION_DENIED` error otherwise.
   * The resource takes the following formats: `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}`
   * for occurrences and projects/{PROJECT_ID}/notes/{NOTE_ID} for notes
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = containerAnalysisClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the permissions that a caller has on the specified note or occurrence resource.
   * Requires list permission on the project (for example, "storage.objects.list" on the containing
   * bucket for testing permission of an object). Attempting to call this method on a non-existent
   * resource will result in a `NOT_FOUND` error if the user has list permission on the project, or
   * a `PERMISSION_DENIED` error otherwise. The resource takes the following formats:
   * `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for `Occurrences` and
   * `projects/{PROJECT_ID}/notes/{NOTE_ID}` for `Notes`
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = containerAnalysisClient.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested.
   *     `resource` is usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    NOTE_PATH_TEMPLATE.validate(resource, "testIamPermissions");
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the permissions that a caller has on the specified note or occurrence resource.
   * Requires list permission on the project (for example, "storage.objects.list" on the containing
   * bucket for testing permission of an object). Attempting to call this method on a non-existent
   * resource will result in a `NOT_FOUND` error if the user has list permission on the project, or
   * a `PERMISSION_DENIED` error otherwise. The resource takes the following formats:
   * `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for `Occurrences` and
   * `projects/{PROJECT_ID}/notes/{NOTE_ID}` for `Notes`
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = containerAnalysisClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the permissions that a caller has on the specified note or occurrence resource.
   * Requires list permission on the project (for example, "storage.objects.list" on the containing
   * bucket for testing permission of an object). Attempting to call this method on a non-existent
   * resource will result in a `NOT_FOUND` error if the user has list permission on the project, or
   * a `PERMISSION_DENIED` error otherwise. The resource takes the following formats:
   * `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for `Occurrences` and
   * `projects/{PROJECT_ID}/notes/{NOTE_ID}` for `Notes`
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String formattedResource = ContainerAnalysisClient.formatNoteName("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = containerAnalysisClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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
