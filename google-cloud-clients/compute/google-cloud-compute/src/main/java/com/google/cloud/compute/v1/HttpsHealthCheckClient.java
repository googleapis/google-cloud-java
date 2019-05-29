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
import com.google.cloud.compute.v1.stub.HttpsHealthCheckStub;
import com.google.cloud.compute.v1.stub.HttpsHealthCheckStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
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
 * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
 *   ProjectGlobalHttpsHealthCheckName httpsHealthCheck = ProjectGlobalHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
 *   Operation response = httpsHealthCheckClient.deleteHttpsHealthCheck(httpsHealthCheck);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the httpsHealthCheckClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of HttpsHealthCheckSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * HttpsHealthCheckSettings httpsHealthCheckSettings =
 *     HttpsHealthCheckSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HttpsHealthCheckClient httpsHealthCheckClient =
 *     HttpsHealthCheckClient.create(httpsHealthCheckSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * HttpsHealthCheckSettings httpsHealthCheckSettings =
 *     HttpsHealthCheckSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HttpsHealthCheckClient httpsHealthCheckClient =
 *     HttpsHealthCheckClient.create(httpsHealthCheckSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class HttpsHealthCheckClient implements BackgroundResource {
  private final HttpsHealthCheckSettings settings;
  private final HttpsHealthCheckStub stub;

  /** Constructs an instance of HttpsHealthCheckClient with default settings. */
  public static final HttpsHealthCheckClient create() throws IOException {
    return create(HttpsHealthCheckSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HttpsHealthCheckClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HttpsHealthCheckClient create(HttpsHealthCheckSettings settings)
      throws IOException {
    return new HttpsHealthCheckClient(settings);
  }

  /**
   * Constructs an instance of HttpsHealthCheckClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use HttpsHealthCheckSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final HttpsHealthCheckClient create(HttpsHealthCheckStub stub) {
    return new HttpsHealthCheckClient(stub);
  }

  /**
   * Constructs an instance of HttpsHealthCheckClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpsHealthCheckClient(HttpsHealthCheckSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HttpsHealthCheckStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected HttpsHealthCheckClient(HttpsHealthCheckStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final HttpsHealthCheckSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public HttpsHealthCheckStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpsHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectGlobalHttpsHealthCheckName httpsHealthCheck = ProjectGlobalHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   Operation response = httpsHealthCheckClient.deleteHttpsHealthCheck(httpsHealthCheck);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteHttpsHealthCheck(
      ProjectGlobalHttpsHealthCheckName httpsHealthCheck) {

    DeleteHttpsHealthCheckHttpRequest request =
        DeleteHttpsHealthCheckHttpRequest.newBuilder()
            .setHttpsHealthCheck(httpsHealthCheck == null ? null : httpsHealthCheck.toString())
            .build();
    return deleteHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpsHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectGlobalHttpsHealthCheckName httpsHealthCheck = ProjectGlobalHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   Operation response = httpsHealthCheckClient.deleteHttpsHealthCheck(httpsHealthCheck.toString());
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteHttpsHealthCheck(String httpsHealthCheck) {

    DeleteHttpsHealthCheckHttpRequest request =
        DeleteHttpsHealthCheckHttpRequest.newBuilder()
            .setHttpsHealthCheck(httpsHealthCheck)
            .build();
    return deleteHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpsHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedHttpsHealthCheck = ProjectGlobalHttpsHealthCheckName.format("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   DeleteHttpsHealthCheckHttpRequest request = DeleteHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(formattedHttpsHealthCheck)
   *     .build();
   *   Operation response = httpsHealthCheckClient.deleteHttpsHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteHttpsHealthCheck(DeleteHttpsHealthCheckHttpRequest request) {
    return deleteHttpsHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpsHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedHttpsHealthCheck = ProjectGlobalHttpsHealthCheckName.format("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   DeleteHttpsHealthCheckHttpRequest request = DeleteHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(formattedHttpsHealthCheck)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthCheckClient.deleteHttpsHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteHttpsHealthCheckHttpRequest, Operation>
      deleteHttpsHealthCheckCallable() {
    return stub.deleteHttpsHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Gets a list of available HTTPS health checks
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectGlobalHttpsHealthCheckName httpsHealthCheck = ProjectGlobalHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck2 response = httpsHealthCheckClient.getHttpsHealthCheck(httpsHealthCheck);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HttpsHealthCheck2 getHttpsHealthCheck(
      ProjectGlobalHttpsHealthCheckName httpsHealthCheck) {

    GetHttpsHealthCheckHttpRequest request =
        GetHttpsHealthCheckHttpRequest.newBuilder()
            .setHttpsHealthCheck(httpsHealthCheck == null ? null : httpsHealthCheck.toString())
            .build();
    return getHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Gets a list of available HTTPS health checks
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectGlobalHttpsHealthCheckName httpsHealthCheck = ProjectGlobalHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck2 response = httpsHealthCheckClient.getHttpsHealthCheck(httpsHealthCheck.toString());
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HttpsHealthCheck2 getHttpsHealthCheck(String httpsHealthCheck) {

    GetHttpsHealthCheckHttpRequest request =
        GetHttpsHealthCheckHttpRequest.newBuilder().setHttpsHealthCheck(httpsHealthCheck).build();
    return getHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Gets a list of available HTTPS health checks
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedHttpsHealthCheck = ProjectGlobalHttpsHealthCheckName.format("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   GetHttpsHealthCheckHttpRequest request = GetHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(formattedHttpsHealthCheck)
   *     .build();
   *   HttpsHealthCheck2 response = httpsHealthCheckClient.getHttpsHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HttpsHealthCheck2 getHttpsHealthCheck(GetHttpsHealthCheckHttpRequest request) {
    return getHttpsHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Gets a list of available HTTPS health checks
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedHttpsHealthCheck = ProjectGlobalHttpsHealthCheckName.format("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   GetHttpsHealthCheckHttpRequest request = GetHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(formattedHttpsHealthCheck)
   *     .build();
   *   ApiFuture&lt;HttpsHealthCheck2&gt; future = httpsHealthCheckClient.getHttpsHealthCheckCallable().futureCall(request);
   *   // Do something
   *   HttpsHealthCheck2 response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetHttpsHealthCheckHttpRequest, HttpsHealthCheck2>
      getHttpsHealthCheckCallable() {
    return stub.getHttpsHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   Operation response = httpsHealthCheckClient.insertHttpsHealthCheck(project, httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTPS.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertHttpsHealthCheck(
      ProjectName project, HttpsHealthCheck2 httpsHealthCheckResource) {

    InsertHttpsHealthCheckHttpRequest request =
        InsertHttpsHealthCheckHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setHttpsHealthCheckResource(httpsHealthCheckResource)
            .build();
    return insertHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   Operation response = httpsHealthCheckClient.insertHttpsHealthCheck(project.toString(), httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTPS.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertHttpsHealthCheck(
      String project, HttpsHealthCheck2 httpsHealthCheckResource) {

    InsertHttpsHealthCheckHttpRequest request =
        InsertHttpsHealthCheckHttpRequest.newBuilder()
            .setProject(project)
            .setHttpsHealthCheckResource(httpsHealthCheckResource)
            .build();
    return insertHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   InsertHttpsHealthCheckHttpRequest request = InsertHttpsHealthCheckHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
   *     .build();
   *   Operation response = httpsHealthCheckClient.insertHttpsHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertHttpsHealthCheck(InsertHttpsHealthCheckHttpRequest request) {
    return insertHttpsHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   InsertHttpsHealthCheckHttpRequest request = InsertHttpsHealthCheckHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthCheckClient.insertHttpsHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertHttpsHealthCheckHttpRequest, Operation>
      insertHttpsHealthCheckCallable() {
    return stub.insertHttpsHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (HttpsHealthCheck2 element : httpsHealthCheckClient.listHttpsHealthChecks(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListHttpsHealthChecksPagedResponse listHttpsHealthChecks(ProjectName project) {
    ListHttpsHealthChecksHttpRequest request =
        ListHttpsHealthChecksHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listHttpsHealthChecks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (HttpsHealthCheck2 element : httpsHealthCheckClient.listHttpsHealthChecks(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListHttpsHealthChecksPagedResponse listHttpsHealthChecks(String project) {
    ListHttpsHealthChecksHttpRequest request =
        ListHttpsHealthChecksHttpRequest.newBuilder().setProject(project).build();
    return listHttpsHealthChecks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListHttpsHealthChecksHttpRequest request = ListHttpsHealthChecksHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (HttpsHealthCheck2 element : httpsHealthCheckClient.listHttpsHealthChecks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListHttpsHealthChecksPagedResponse listHttpsHealthChecks(
      ListHttpsHealthChecksHttpRequest request) {
    return listHttpsHealthChecksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListHttpsHealthChecksHttpRequest request = ListHttpsHealthChecksHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;ListHttpsHealthChecksPagedResponse&gt; future = httpsHealthCheckClient.listHttpsHealthChecksPagedCallable().futureCall(request);
   *   // Do something
   *   for (HttpsHealthCheck2 element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListHttpsHealthChecksHttpRequest, ListHttpsHealthChecksPagedResponse>
      listHttpsHealthChecksPagedCallable() {
    return stub.listHttpsHealthChecksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListHttpsHealthChecksHttpRequest request = ListHttpsHealthChecksHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     HttpsHealthCheckList response = httpsHealthCheckClient.listHttpsHealthChecksCallable().call(request);
   *     for (HttpsHealthCheck2 element : response.getItemsList()) {
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
  public final UnaryCallable<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList>
      listHttpsHealthChecksCallable() {
    return stub.listHttpsHealthChecksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectGlobalHttpsHealthCheckName httpsHealthCheck = ProjectGlobalHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = httpsHealthCheckClient.patchHttpsHealthCheck(httpsHealthCheck, httpsHealthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to patch.
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTPS.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchHttpsHealthCheck(
      ProjectGlobalHttpsHealthCheckName httpsHealthCheck,
      HttpsHealthCheck2 httpsHealthCheckResource,
      List<String> fieldMask) {

    PatchHttpsHealthCheckHttpRequest request =
        PatchHttpsHealthCheckHttpRequest.newBuilder()
            .setHttpsHealthCheck(httpsHealthCheck == null ? null : httpsHealthCheck.toString())
            .setHttpsHealthCheckResource(httpsHealthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectGlobalHttpsHealthCheckName httpsHealthCheck = ProjectGlobalHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = httpsHealthCheckClient.patchHttpsHealthCheck(httpsHealthCheck.toString(), httpsHealthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to patch.
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTPS.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchHttpsHealthCheck(
      String httpsHealthCheck, HttpsHealthCheck2 httpsHealthCheckResource, List<String> fieldMask) {

    PatchHttpsHealthCheckHttpRequest request =
        PatchHttpsHealthCheckHttpRequest.newBuilder()
            .setHttpsHealthCheck(httpsHealthCheck)
            .setHttpsHealthCheckResource(httpsHealthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedHttpsHealthCheck = ProjectGlobalHttpsHealthCheckName.format("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchHttpsHealthCheckHttpRequest request = PatchHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(formattedHttpsHealthCheck)
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = httpsHealthCheckClient.patchHttpsHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchHttpsHealthCheck(PatchHttpsHealthCheckHttpRequest request) {
    return patchHttpsHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedHttpsHealthCheck = ProjectGlobalHttpsHealthCheckName.format("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchHttpsHealthCheckHttpRequest request = PatchHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(formattedHttpsHealthCheck)
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthCheckClient.patchHttpsHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchHttpsHealthCheckHttpRequest, Operation>
      patchHttpsHealthCheckCallable() {
    return stub.patchHttpsHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectGlobalHttpsHealthCheckName httpsHealthCheck = ProjectGlobalHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = httpsHealthCheckClient.updateHttpsHealthCheck(httpsHealthCheck, httpsHealthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to update.
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTPS.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateHttpsHealthCheck(
      ProjectGlobalHttpsHealthCheckName httpsHealthCheck,
      HttpsHealthCheck2 httpsHealthCheckResource,
      List<String> fieldMask) {

    UpdateHttpsHealthCheckHttpRequest request =
        UpdateHttpsHealthCheckHttpRequest.newBuilder()
            .setHttpsHealthCheck(httpsHealthCheck == null ? null : httpsHealthCheck.toString())
            .setHttpsHealthCheckResource(httpsHealthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectGlobalHttpsHealthCheckName httpsHealthCheck = ProjectGlobalHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = httpsHealthCheckClient.updateHttpsHealthCheck(httpsHealthCheck.toString(), httpsHealthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to update.
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTPS.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateHttpsHealthCheck(
      String httpsHealthCheck, HttpsHealthCheck2 httpsHealthCheckResource, List<String> fieldMask) {

    UpdateHttpsHealthCheckHttpRequest request =
        UpdateHttpsHealthCheckHttpRequest.newBuilder()
            .setHttpsHealthCheck(httpsHealthCheck)
            .setHttpsHealthCheckResource(httpsHealthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedHttpsHealthCheck = ProjectGlobalHttpsHealthCheckName.format("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateHttpsHealthCheckHttpRequest request = UpdateHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(formattedHttpsHealthCheck)
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = httpsHealthCheckClient.updateHttpsHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateHttpsHealthCheck(UpdateHttpsHealthCheckHttpRequest request) {
    return updateHttpsHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String formattedHttpsHealthCheck = ProjectGlobalHttpsHealthCheckName.format("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck2 httpsHealthCheckResource = HttpsHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateHttpsHealthCheckHttpRequest request = UpdateHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(formattedHttpsHealthCheck)
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthCheckClient.updateHttpsHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateHttpsHealthCheckHttpRequest, Operation>
      updateHttpsHealthCheckCallable() {
    return stub.updateHttpsHealthCheckCallable();
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

  public static class ListHttpsHealthChecksPagedResponse
      extends AbstractPagedListResponse<
          ListHttpsHealthChecksHttpRequest,
          HttpsHealthCheckList,
          HttpsHealthCheck2,
          ListHttpsHealthChecksPage,
          ListHttpsHealthChecksFixedSizeCollection> {

    public static ApiFuture<ListHttpsHealthChecksPagedResponse> createAsync(
        PageContext<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList, HttpsHealthCheck2>
            context,
        ApiFuture<HttpsHealthCheckList> futureResponse) {
      ApiFuture<ListHttpsHealthChecksPage> futurePage =
          ListHttpsHealthChecksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListHttpsHealthChecksPage, ListHttpsHealthChecksPagedResponse>() {
            @Override
            public ListHttpsHealthChecksPagedResponse apply(ListHttpsHealthChecksPage input) {
              return new ListHttpsHealthChecksPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListHttpsHealthChecksPagedResponse(ListHttpsHealthChecksPage page) {
      super(page, ListHttpsHealthChecksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHttpsHealthChecksPage
      extends AbstractPage<
          ListHttpsHealthChecksHttpRequest,
          HttpsHealthCheckList,
          HttpsHealthCheck2,
          ListHttpsHealthChecksPage> {

    private ListHttpsHealthChecksPage(
        PageContext<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList, HttpsHealthCheck2>
            context,
        HttpsHealthCheckList response) {
      super(context, response);
    }

    private static ListHttpsHealthChecksPage createEmptyPage() {
      return new ListHttpsHealthChecksPage(null, null);
    }

    @Override
    protected ListHttpsHealthChecksPage createPage(
        PageContext<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList, HttpsHealthCheck2>
            context,
        HttpsHealthCheckList response) {
      return new ListHttpsHealthChecksPage(context, response);
    }

    @Override
    public ApiFuture<ListHttpsHealthChecksPage> createPageAsync(
        PageContext<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList, HttpsHealthCheck2>
            context,
        ApiFuture<HttpsHealthCheckList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHttpsHealthChecksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHttpsHealthChecksHttpRequest,
          HttpsHealthCheckList,
          HttpsHealthCheck2,
          ListHttpsHealthChecksPage,
          ListHttpsHealthChecksFixedSizeCollection> {

    private ListHttpsHealthChecksFixedSizeCollection(
        List<ListHttpsHealthChecksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHttpsHealthChecksFixedSizeCollection createEmptyCollection() {
      return new ListHttpsHealthChecksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHttpsHealthChecksFixedSizeCollection createCollection(
        List<ListHttpsHealthChecksPage> pages, int collectionSize) {
      return new ListHttpsHealthChecksFixedSizeCollection(pages, collectionSize);
    }
  }
}
