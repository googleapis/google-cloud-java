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
import com.google.cloud.compute.v1.stub.HttpHealthCheckStub;
import com.google.cloud.compute.v1.stub.HttpHealthCheckStubSettings;
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
 * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
 *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
 *   Operation response = httpHealthCheckClient.deleteHttpHealthCheck(httpHealthCheck);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the httpHealthCheckClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of HttpHealthCheckSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * HttpHealthCheckSettings httpHealthCheckSettings =
 *     HttpHealthCheckSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HttpHealthCheckClient httpHealthCheckClient =
 *     HttpHealthCheckClient.create(httpHealthCheckSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * HttpHealthCheckSettings httpHealthCheckSettings =
 *     HttpHealthCheckSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HttpHealthCheckClient httpHealthCheckClient =
 *     HttpHealthCheckClient.create(httpHealthCheckSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class HttpHealthCheckClient implements BackgroundResource {
  private final HttpHealthCheckSettings settings;
  private final HttpHealthCheckStub stub;

  /** Constructs an instance of HttpHealthCheckClient with default settings. */
  public static final HttpHealthCheckClient create() throws IOException {
    return create(HttpHealthCheckSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HttpHealthCheckClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HttpHealthCheckClient create(HttpHealthCheckSettings settings)
      throws IOException {
    return new HttpHealthCheckClient(settings);
  }

  /**
   * Constructs an instance of HttpHealthCheckClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use HttpHealthCheckSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final HttpHealthCheckClient create(HttpHealthCheckStub stub) {
    return new HttpHealthCheckClient(stub);
  }

  /**
   * Constructs an instance of HttpHealthCheckClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpHealthCheckClient(HttpHealthCheckSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HttpHealthCheckStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected HttpHealthCheckClient(HttpHealthCheckStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final HttpHealthCheckSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public HttpHealthCheckStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   Operation response = httpHealthCheckClient.deleteHttpHealthCheck(httpHealthCheck);
   * }
   * </code></pre>
   *
   * @param httpHealthCheck Name of the HttpHealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteHttpHealthCheck(ProjectGlobalHttpHealthCheckName httpHealthCheck) {

    DeleteHttpHealthCheckHttpRequest request =
        DeleteHttpHealthCheckHttpRequest.newBuilder()
            .setHttpHealthCheck(httpHealthCheck == null ? null : httpHealthCheck.toString())
            .build();
    return deleteHttpHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   Operation response = httpHealthCheckClient.deleteHttpHealthCheck(httpHealthCheck.toString());
   * }
   * </code></pre>
   *
   * @param httpHealthCheck Name of the HttpHealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteHttpHealthCheck(String httpHealthCheck) {

    DeleteHttpHealthCheckHttpRequest request =
        DeleteHttpHealthCheckHttpRequest.newBuilder().setHttpHealthCheck(httpHealthCheck).build();
    return deleteHttpHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   DeleteHttpHealthCheckHttpRequest request = DeleteHttpHealthCheckHttpRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck.toString())
   *     .build();
   *   Operation response = httpHealthCheckClient.deleteHttpHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteHttpHealthCheck(DeleteHttpHealthCheckHttpRequest request) {
    return deleteHttpHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   DeleteHttpHealthCheckHttpRequest request = DeleteHttpHealthCheckHttpRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpHealthCheckClient.deleteHttpHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteHttpHealthCheckHttpRequest, Operation>
      deleteHttpHealthCheckCallable() {
    return stub.deleteHttpHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpHealthCheck resource. Gets a list of available HTTP health checks by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   HttpHealthCheck2 response = httpHealthCheckClient.getHttpHealthCheck(httpHealthCheck);
   * }
   * </code></pre>
   *
   * @param httpHealthCheck Name of the HttpHealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HttpHealthCheck2 getHttpHealthCheck(
      ProjectGlobalHttpHealthCheckName httpHealthCheck) {

    GetHttpHealthCheckHttpRequest request =
        GetHttpHealthCheckHttpRequest.newBuilder()
            .setHttpHealthCheck(httpHealthCheck == null ? null : httpHealthCheck.toString())
            .build();
    return getHttpHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpHealthCheck resource. Gets a list of available HTTP health checks by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   HttpHealthCheck2 response = httpHealthCheckClient.getHttpHealthCheck(httpHealthCheck.toString());
   * }
   * </code></pre>
   *
   * @param httpHealthCheck Name of the HttpHealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HttpHealthCheck2 getHttpHealthCheck(String httpHealthCheck) {

    GetHttpHealthCheckHttpRequest request =
        GetHttpHealthCheckHttpRequest.newBuilder().setHttpHealthCheck(httpHealthCheck).build();
    return getHttpHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpHealthCheck resource. Gets a list of available HTTP health checks by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   GetHttpHealthCheckHttpRequest request = GetHttpHealthCheckHttpRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck.toString())
   *     .build();
   *   HttpHealthCheck2 response = httpHealthCheckClient.getHttpHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HttpHealthCheck2 getHttpHealthCheck(GetHttpHealthCheckHttpRequest request) {
    return getHttpHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpHealthCheck resource. Gets a list of available HTTP health checks by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   GetHttpHealthCheckHttpRequest request = GetHttpHealthCheckHttpRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck.toString())
   *     .build();
   *   ApiFuture&lt;HttpHealthCheck2&gt; future = httpHealthCheckClient.getHttpHealthCheckCallable().futureCall(request);
   *   // Do something
   *   HttpHealthCheck2 response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetHttpHealthCheckHttpRequest, HttpHealthCheck2>
      getHttpHealthCheckCallable() {
    return stub.getHttpHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   Operation response = httpHealthCheckClient.insertHttpHealthCheck(project, httpHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpHealthCheckResource An HttpHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTP.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertHttpHealthCheck(
      ProjectName project, HttpHealthCheck2 httpHealthCheckResource) {

    InsertHttpHealthCheckHttpRequest request =
        InsertHttpHealthCheckHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setHttpHealthCheckResource(httpHealthCheckResource)
            .build();
    return insertHttpHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   Operation response = httpHealthCheckClient.insertHttpHealthCheck(project.toString(), httpHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpHealthCheckResource An HttpHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTP.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertHttpHealthCheck(
      String project, HttpHealthCheck2 httpHealthCheckResource) {

    InsertHttpHealthCheckHttpRequest request =
        InsertHttpHealthCheckHttpRequest.newBuilder()
            .setProject(project)
            .setHttpHealthCheckResource(httpHealthCheckResource)
            .build();
    return insertHttpHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   InsertHttpHealthCheckHttpRequest request = InsertHttpHealthCheckHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setHttpHealthCheckResource(httpHealthCheckResource)
   *     .build();
   *   Operation response = httpHealthCheckClient.insertHttpHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertHttpHealthCheck(InsertHttpHealthCheckHttpRequest request) {
    return insertHttpHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   InsertHttpHealthCheckHttpRequest request = InsertHttpHealthCheckHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setHttpHealthCheckResource(httpHealthCheckResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpHealthCheckClient.insertHttpHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertHttpHealthCheckHttpRequest, Operation>
      insertHttpHealthCheckCallable() {
    return stub.insertHttpHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (HttpHealthCheck2 element : httpHealthCheckClient.listHttpHealthChecks(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListHttpHealthChecksPagedResponse listHttpHealthChecks(ProjectName project) {
    ListHttpHealthChecksHttpRequest request =
        ListHttpHealthChecksHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listHttpHealthChecks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (HttpHealthCheck2 element : httpHealthCheckClient.listHttpHealthChecks(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListHttpHealthChecksPagedResponse listHttpHealthChecks(String project) {
    ListHttpHealthChecksHttpRequest request =
        ListHttpHealthChecksHttpRequest.newBuilder().setProject(project).build();
    return listHttpHealthChecks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListHttpHealthChecksHttpRequest request = ListHttpHealthChecksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (HttpHealthCheck2 element : httpHealthCheckClient.listHttpHealthChecks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListHttpHealthChecksPagedResponse listHttpHealthChecks(
      ListHttpHealthChecksHttpRequest request) {
    return listHttpHealthChecksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListHttpHealthChecksHttpRequest request = ListHttpHealthChecksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListHttpHealthChecksPagedResponse&gt; future = httpHealthCheckClient.listHttpHealthChecksPagedCallable().futureCall(request);
   *   // Do something
   *   for (HttpHealthCheck2 element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListHttpHealthChecksHttpRequest, ListHttpHealthChecksPagedResponse>
      listHttpHealthChecksPagedCallable() {
    return stub.listHttpHealthChecksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListHttpHealthChecksHttpRequest request = ListHttpHealthChecksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     HttpHealthCheckList response = httpHealthCheckClient.listHttpHealthChecksCallable().call(request);
   *     for (HttpHealthCheck2 element : response.getItemsList()) {
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
  public final UnaryCallable<ListHttpHealthChecksHttpRequest, HttpHealthCheckList>
      listHttpHealthChecksCallable() {
    return stub.listHttpHealthChecksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = httpHealthCheckClient.patchHttpHealthCheck(httpHealthCheck, httpHealthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param httpHealthCheck Name of the HttpHealthCheck resource to patch.
   * @param httpHealthCheckResource An HttpHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTP.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchHttpHealthCheck(
      ProjectGlobalHttpHealthCheckName httpHealthCheck,
      HttpHealthCheck2 httpHealthCheckResource,
      List<String> fieldMask) {

    PatchHttpHealthCheckHttpRequest request =
        PatchHttpHealthCheckHttpRequest.newBuilder()
            .setHttpHealthCheck(httpHealthCheck == null ? null : httpHealthCheck.toString())
            .setHttpHealthCheckResource(httpHealthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchHttpHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = httpHealthCheckClient.patchHttpHealthCheck(httpHealthCheck.toString(), httpHealthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param httpHealthCheck Name of the HttpHealthCheck resource to patch.
   * @param httpHealthCheckResource An HttpHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTP.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchHttpHealthCheck(
      String httpHealthCheck, HttpHealthCheck2 httpHealthCheckResource, List<String> fieldMask) {

    PatchHttpHealthCheckHttpRequest request =
        PatchHttpHealthCheckHttpRequest.newBuilder()
            .setHttpHealthCheck(httpHealthCheck)
            .setHttpHealthCheckResource(httpHealthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchHttpHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchHttpHealthCheckHttpRequest request = PatchHttpHealthCheckHttpRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck.toString())
   *     .setHttpHealthCheckResource(httpHealthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = httpHealthCheckClient.patchHttpHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchHttpHealthCheck(PatchHttpHealthCheckHttpRequest request) {
    return patchHttpHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchHttpHealthCheckHttpRequest request = PatchHttpHealthCheckHttpRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck.toString())
   *     .setHttpHealthCheckResource(httpHealthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpHealthCheckClient.patchHttpHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchHttpHealthCheckHttpRequest, Operation>
      patchHttpHealthCheckCallable() {
    return stub.patchHttpHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = httpHealthCheckClient.updateHttpHealthCheck(httpHealthCheck, httpHealthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param httpHealthCheck Name of the HttpHealthCheck resource to update.
   * @param httpHealthCheckResource An HttpHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTP.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateHttpHealthCheck(
      ProjectGlobalHttpHealthCheckName httpHealthCheck,
      HttpHealthCheck2 httpHealthCheckResource,
      List<String> fieldMask) {

    UpdateHttpHealthCheckHttpRequest request =
        UpdateHttpHealthCheckHttpRequest.newBuilder()
            .setHttpHealthCheck(httpHealthCheck == null ? null : httpHealthCheck.toString())
            .setHttpHealthCheckResource(httpHealthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateHttpHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = httpHealthCheckClient.updateHttpHealthCheck(httpHealthCheck.toString(), httpHealthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param httpHealthCheck Name of the HttpHealthCheck resource to update.
   * @param httpHealthCheckResource An HttpHealthCheck resource. This resource defines a template
   *     for how individual instances should be checked for health, via HTTP.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateHttpHealthCheck(
      String httpHealthCheck, HttpHealthCheck2 httpHealthCheckResource, List<String> fieldMask) {

    UpdateHttpHealthCheckHttpRequest request =
        UpdateHttpHealthCheckHttpRequest.newBuilder()
            .setHttpHealthCheck(httpHealthCheck)
            .setHttpHealthCheckResource(httpHealthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateHttpHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateHttpHealthCheckHttpRequest request = UpdateHttpHealthCheckHttpRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck.toString())
   *     .setHttpHealthCheckResource(httpHealthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = httpHealthCheckClient.updateHttpHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateHttpHealthCheck(UpdateHttpHealthCheckHttpRequest request) {
    return updateHttpHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
   *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
   *   HttpHealthCheck2 httpHealthCheckResource = HttpHealthCheck2.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateHttpHealthCheckHttpRequest request = UpdateHttpHealthCheckHttpRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck.toString())
   *     .setHttpHealthCheckResource(httpHealthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpHealthCheckClient.updateHttpHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateHttpHealthCheckHttpRequest, Operation>
      updateHttpHealthCheckCallable() {
    return stub.updateHttpHealthCheckCallable();
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

  public static class ListHttpHealthChecksPagedResponse
      extends AbstractPagedListResponse<
          ListHttpHealthChecksHttpRequest,
          HttpHealthCheckList,
          HttpHealthCheck2,
          ListHttpHealthChecksPage,
          ListHttpHealthChecksFixedSizeCollection> {

    public static ApiFuture<ListHttpHealthChecksPagedResponse> createAsync(
        PageContext<ListHttpHealthChecksHttpRequest, HttpHealthCheckList, HttpHealthCheck2> context,
        ApiFuture<HttpHealthCheckList> futureResponse) {
      ApiFuture<ListHttpHealthChecksPage> futurePage =
          ListHttpHealthChecksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListHttpHealthChecksPage, ListHttpHealthChecksPagedResponse>() {
            @Override
            public ListHttpHealthChecksPagedResponse apply(ListHttpHealthChecksPage input) {
              return new ListHttpHealthChecksPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListHttpHealthChecksPagedResponse(ListHttpHealthChecksPage page) {
      super(page, ListHttpHealthChecksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHttpHealthChecksPage
      extends AbstractPage<
          ListHttpHealthChecksHttpRequest,
          HttpHealthCheckList,
          HttpHealthCheck2,
          ListHttpHealthChecksPage> {

    private ListHttpHealthChecksPage(
        PageContext<ListHttpHealthChecksHttpRequest, HttpHealthCheckList, HttpHealthCheck2> context,
        HttpHealthCheckList response) {
      super(context, response);
    }

    private static ListHttpHealthChecksPage createEmptyPage() {
      return new ListHttpHealthChecksPage(null, null);
    }

    @Override
    protected ListHttpHealthChecksPage createPage(
        PageContext<ListHttpHealthChecksHttpRequest, HttpHealthCheckList, HttpHealthCheck2> context,
        HttpHealthCheckList response) {
      return new ListHttpHealthChecksPage(context, response);
    }

    @Override
    public ApiFuture<ListHttpHealthChecksPage> createPageAsync(
        PageContext<ListHttpHealthChecksHttpRequest, HttpHealthCheckList, HttpHealthCheck2> context,
        ApiFuture<HttpHealthCheckList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHttpHealthChecksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHttpHealthChecksHttpRequest,
          HttpHealthCheckList,
          HttpHealthCheck2,
          ListHttpHealthChecksPage,
          ListHttpHealthChecksFixedSizeCollection> {

    private ListHttpHealthChecksFixedSizeCollection(
        List<ListHttpHealthChecksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHttpHealthChecksFixedSizeCollection createEmptyCollection() {
      return new ListHttpHealthChecksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHttpHealthChecksFixedSizeCollection createCollection(
        List<ListHttpHealthChecksPage> pages, int collectionSize) {
      return new ListHttpHealthChecksFixedSizeCollection(pages, collectionSize);
    }
  }
}
