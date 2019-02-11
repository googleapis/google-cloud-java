/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.InterconnectStub;
import com.google.cloud.compute.v1.stub.InterconnectStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
 *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
 *   Operation response = interconnectClient.deleteInterconnect(interconnect);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the interconnectClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of InterconnectSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InterconnectSettings interconnectSettings =
 *     InterconnectSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InterconnectClient interconnectClient =
 *     InterconnectClient.create(interconnectSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InterconnectSettings interconnectSettings =
 *     InterconnectSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InterconnectClient interconnectClient =
 *     InterconnectClient.create(interconnectSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InterconnectClient implements BackgroundResource {
  private final InterconnectSettings settings;
  private final InterconnectStub stub;

  /** Constructs an instance of InterconnectClient with default settings. */
  public static final InterconnectClient create() throws IOException {
    return create(InterconnectSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InterconnectClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InterconnectClient create(InterconnectSettings settings) throws IOException {
    return new InterconnectClient(settings);
  }

  /**
   * Constructs an instance of InterconnectClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use InterconnectSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InterconnectClient create(InterconnectStub stub) {
    return new InterconnectClient(stub);
  }

  /**
   * Constructs an instance of InterconnectClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected InterconnectClient(InterconnectSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InterconnectStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InterconnectClient(InterconnectStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InterconnectSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InterconnectStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   Operation response = interconnectClient.deleteInterconnect(interconnect);
   * }
   * </code></pre>
   *
   * @param interconnect Name of the interconnect to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInterconnect(ProjectGlobalInterconnectName interconnect) {

    DeleteInterconnectHttpRequest request =
        DeleteInterconnectHttpRequest.newBuilder()
            .setInterconnect(interconnect == null ? null : interconnect.toString())
            .build();
    return deleteInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   Operation response = interconnectClient.deleteInterconnect(interconnect.toString());
   * }
   * </code></pre>
   *
   * @param interconnect Name of the interconnect to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInterconnect(String interconnect) {

    DeleteInterconnectHttpRequest request =
        DeleteInterconnectHttpRequest.newBuilder().setInterconnect(interconnect).build();
    return deleteInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   DeleteInterconnectHttpRequest request = DeleteInterconnectHttpRequest.newBuilder()
   *     .setInterconnect(interconnect.toString())
   *     .build();
   *   Operation response = interconnectClient.deleteInterconnect(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInterconnect(DeleteInterconnectHttpRequest request) {
    return deleteInterconnectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   DeleteInterconnectHttpRequest request = DeleteInterconnectHttpRequest.newBuilder()
   *     .setInterconnect(interconnect.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectClient.deleteInterconnectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteInterconnectHttpRequest, Operation>
      deleteInterconnectCallable() {
    return stub.deleteInterconnectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect. Get a list of available interconnects by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   Interconnect response = interconnectClient.getInterconnect(interconnect);
   * }
   * </code></pre>
   *
   * @param interconnect Name of the interconnect to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Interconnect getInterconnect(ProjectGlobalInterconnectName interconnect) {

    GetInterconnectHttpRequest request =
        GetInterconnectHttpRequest.newBuilder()
            .setInterconnect(interconnect == null ? null : interconnect.toString())
            .build();
    return getInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect. Get a list of available interconnects by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   Interconnect response = interconnectClient.getInterconnect(interconnect.toString());
   * }
   * </code></pre>
   *
   * @param interconnect Name of the interconnect to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Interconnect getInterconnect(String interconnect) {

    GetInterconnectHttpRequest request =
        GetInterconnectHttpRequest.newBuilder().setInterconnect(interconnect).build();
    return getInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect. Get a list of available interconnects by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   GetInterconnectHttpRequest request = GetInterconnectHttpRequest.newBuilder()
   *     .setInterconnect(interconnect.toString())
   *     .build();
   *   Interconnect response = interconnectClient.getInterconnect(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Interconnect getInterconnect(GetInterconnectHttpRequest request) {
    return getInterconnectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect. Get a list of available interconnects by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   GetInterconnectHttpRequest request = GetInterconnectHttpRequest.newBuilder()
   *     .setInterconnect(interconnect.toString())
   *     .build();
   *   ApiFuture&lt;Interconnect&gt; future = interconnectClient.getInterconnectCallable().futureCall(request);
   *   // Do something
   *   Interconnect response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetInterconnectHttpRequest, Interconnect> getInterconnectCallable() {
    return stub.getInterconnectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the interconnectDiagnostics for the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   InterconnectsGetDiagnosticsResponse response = interconnectClient.getDiagnosticsInterconnect(interconnect);
   * }
   * </code></pre>
   *
   * @param interconnect Name of the interconnect resource to query.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InterconnectsGetDiagnosticsResponse getDiagnosticsInterconnect(
      ProjectGlobalInterconnectName interconnect) {

    GetDiagnosticsInterconnectHttpRequest request =
        GetDiagnosticsInterconnectHttpRequest.newBuilder()
            .setInterconnect(interconnect == null ? null : interconnect.toString())
            .build();
    return getDiagnosticsInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the interconnectDiagnostics for the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   InterconnectsGetDiagnosticsResponse response = interconnectClient.getDiagnosticsInterconnect(interconnect.toString());
   * }
   * </code></pre>
   *
   * @param interconnect Name of the interconnect resource to query.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InterconnectsGetDiagnosticsResponse getDiagnosticsInterconnect(String interconnect) {

    GetDiagnosticsInterconnectHttpRequest request =
        GetDiagnosticsInterconnectHttpRequest.newBuilder().setInterconnect(interconnect).build();
    return getDiagnosticsInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the interconnectDiagnostics for the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   GetDiagnosticsInterconnectHttpRequest request = GetDiagnosticsInterconnectHttpRequest.newBuilder()
   *     .setInterconnect(interconnect.toString())
   *     .build();
   *   InterconnectsGetDiagnosticsResponse response = interconnectClient.getDiagnosticsInterconnect(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InterconnectsGetDiagnosticsResponse getDiagnosticsInterconnect(
      GetDiagnosticsInterconnectHttpRequest request) {
    return getDiagnosticsInterconnectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the interconnectDiagnostics for the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   GetDiagnosticsInterconnectHttpRequest request = GetDiagnosticsInterconnectHttpRequest.newBuilder()
   *     .setInterconnect(interconnect.toString())
   *     .build();
   *   ApiFuture&lt;InterconnectsGetDiagnosticsResponse&gt; future = interconnectClient.getDiagnosticsInterconnectCallable().futureCall(request);
   *   // Do something
   *   InterconnectsGetDiagnosticsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          GetDiagnosticsInterconnectHttpRequest, InterconnectsGetDiagnosticsResponse>
      getDiagnosticsInterconnectCallable() {
    return stub.getDiagnosticsInterconnectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Interconnect in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   Operation response = interconnectClient.insertInterconnect(project, interconnectResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param interconnectResource Represents an Interconnects resource. The Interconnects resource is
   *     a dedicated connection between Google's network and your on-premises network. For more
   *     information, see the Dedicated overview page. (== resource_for v1.interconnects ==) (==
   *     resource_for beta.interconnects ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInterconnect(
      ProjectName project, Interconnect interconnectResource) {

    InsertInterconnectHttpRequest request =
        InsertInterconnectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setInterconnectResource(interconnectResource)
            .build();
    return insertInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Interconnect in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   Operation response = interconnectClient.insertInterconnect(project.toString(), interconnectResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param interconnectResource Represents an Interconnects resource. The Interconnects resource is
   *     a dedicated connection between Google's network and your on-premises network. For more
   *     information, see the Dedicated overview page. (== resource_for v1.interconnects ==) (==
   *     resource_for beta.interconnects ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInterconnect(String project, Interconnect interconnectResource) {

    InsertInterconnectHttpRequest request =
        InsertInterconnectHttpRequest.newBuilder()
            .setProject(project)
            .setInterconnectResource(interconnectResource)
            .build();
    return insertInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Interconnect in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   InsertInterconnectHttpRequest request = InsertInterconnectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setInterconnectResource(interconnectResource)
   *     .build();
   *   Operation response = interconnectClient.insertInterconnect(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInterconnect(InsertInterconnectHttpRequest request) {
    return insertInterconnectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Interconnect in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   InsertInterconnectHttpRequest request = InsertInterconnectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setInterconnectResource(interconnectResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectClient.insertInterconnectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertInterconnectHttpRequest, Operation>
      insertInterconnectCallable() {
    return stub.insertInterconnectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Interconnect element : interconnectClient.listInterconnects(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInterconnectsPagedResponse listInterconnects(ProjectName project) {
    ListInterconnectsHttpRequest request =
        ListInterconnectsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listInterconnects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Interconnect element : interconnectClient.listInterconnects(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInterconnectsPagedResponse listInterconnects(String project) {
    ListInterconnectsHttpRequest request =
        ListInterconnectsHttpRequest.newBuilder().setProject(project).build();
    return listInterconnects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListInterconnectsHttpRequest request = ListInterconnectsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (Interconnect element : interconnectClient.listInterconnects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInterconnectsPagedResponse listInterconnects(
      ListInterconnectsHttpRequest request) {
    return listInterconnectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListInterconnectsHttpRequest request = ListInterconnectsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListInterconnectsPagedResponse&gt; future = interconnectClient.listInterconnectsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Interconnect element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListInterconnectsHttpRequest, ListInterconnectsPagedResponse>
      listInterconnectsPagedCallable() {
    return stub.listInterconnectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListInterconnectsHttpRequest request = ListInterconnectsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     InterconnectList response = interconnectClient.listInterconnectsCallable().call(request);
   *     for (Interconnect element : response.getItemsList()) {
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
  @BetaApi
  public final UnaryCallable<ListInterconnectsHttpRequest, InterconnectList>
      listInterconnectsCallable() {
    return stub.listInterconnectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = interconnectClient.patchInterconnect(interconnect, interconnectResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param interconnect Name of the interconnect to update.
   * @param interconnectResource Represents an Interconnects resource. The Interconnects resource is
   *     a dedicated connection between Google's network and your on-premises network. For more
   *     information, see the Dedicated overview page. (== resource_for v1.interconnects ==) (==
   *     resource_for beta.interconnects ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInterconnect(
      ProjectGlobalInterconnectName interconnect,
      Interconnect interconnectResource,
      List<String> fieldMask) {

    PatchInterconnectHttpRequest request =
        PatchInterconnectHttpRequest.newBuilder()
            .setInterconnect(interconnect == null ? null : interconnect.toString())
            .setInterconnectResource(interconnectResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = interconnectClient.patchInterconnect(interconnect.toString(), interconnectResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param interconnect Name of the interconnect to update.
   * @param interconnectResource Represents an Interconnects resource. The Interconnects resource is
   *     a dedicated connection between Google's network and your on-premises network. For more
   *     information, see the Dedicated overview page. (== resource_for v1.interconnects ==) (==
   *     resource_for beta.interconnects ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInterconnect(
      String interconnect, Interconnect interconnectResource, List<String> fieldMask) {

    PatchInterconnectHttpRequest request =
        PatchInterconnectHttpRequest.newBuilder()
            .setInterconnect(interconnect)
            .setInterconnectResource(interconnectResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchInterconnectHttpRequest request = PatchInterconnectHttpRequest.newBuilder()
   *     .setInterconnect(interconnect.toString())
   *     .setInterconnectResource(interconnectResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = interconnectClient.patchInterconnect(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInterconnect(PatchInterconnectHttpRequest request) {
    return patchInterconnectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
   *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchInterconnectHttpRequest request = PatchInterconnectHttpRequest.newBuilder()
   *     .setInterconnect(interconnect.toString())
   *     .setInterconnectResource(interconnectResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectClient.patchInterconnectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchInterconnectHttpRequest, Operation> patchInterconnectCallable() {
    return stub.patchInterconnectCallable();
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

  public static class ListInterconnectsPagedResponse
      extends AbstractPagedListResponse<
          ListInterconnectsHttpRequest,
          InterconnectList,
          Interconnect,
          ListInterconnectsPage,
          ListInterconnectsFixedSizeCollection> {

    public static ApiFuture<ListInterconnectsPagedResponse> createAsync(
        PageContext<ListInterconnectsHttpRequest, InterconnectList, Interconnect> context,
        ApiFuture<InterconnectList> futureResponse) {
      ApiFuture<ListInterconnectsPage> futurePage =
          ListInterconnectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInterconnectsPage, ListInterconnectsPagedResponse>() {
            @Override
            public ListInterconnectsPagedResponse apply(ListInterconnectsPage input) {
              return new ListInterconnectsPagedResponse(input);
            }
          });
    }

    private ListInterconnectsPagedResponse(ListInterconnectsPage page) {
      super(page, ListInterconnectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInterconnectsPage
      extends AbstractPage<
          ListInterconnectsHttpRequest, InterconnectList, Interconnect, ListInterconnectsPage> {

    private ListInterconnectsPage(
        PageContext<ListInterconnectsHttpRequest, InterconnectList, Interconnect> context,
        InterconnectList response) {
      super(context, response);
    }

    private static ListInterconnectsPage createEmptyPage() {
      return new ListInterconnectsPage(null, null);
    }

    @Override
    protected ListInterconnectsPage createPage(
        PageContext<ListInterconnectsHttpRequest, InterconnectList, Interconnect> context,
        InterconnectList response) {
      return new ListInterconnectsPage(context, response);
    }

    @Override
    public ApiFuture<ListInterconnectsPage> createPageAsync(
        PageContext<ListInterconnectsHttpRequest, InterconnectList, Interconnect> context,
        ApiFuture<InterconnectList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInterconnectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterconnectsHttpRequest,
          InterconnectList,
          Interconnect,
          ListInterconnectsPage,
          ListInterconnectsFixedSizeCollection> {

    private ListInterconnectsFixedSizeCollection(
        List<ListInterconnectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInterconnectsFixedSizeCollection createEmptyCollection() {
      return new ListInterconnectsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInterconnectsFixedSizeCollection createCollection(
        List<ListInterconnectsPage> pages, int collectionSize) {
      return new ListInterconnectsFixedSizeCollection(pages, collectionSize);
    }
  }
}
