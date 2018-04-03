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
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.paging.FixedSizeCollection;
import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.stub.HttpsHealthCheckStub;
import com.google.cloud.compute.v1.stub.HttpsHealthCheckStubSettings;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
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
 *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
 *   String requestId = "";
 *   Operation response = httpsHealthCheckClient.deleteHttpsHealthCheck(httpsHealthCheck, requestId);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the httpsHealthCheckClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * API callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of HttpsHealthCheckSettings to
 * create(). For example:
 *
 * To customize credentials:
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
@Generated("by GAPIC v0.0.5")
@BetaApi
public class HttpsHealthCheckClient implements BackgroundResource {
  private final HttpsHealthCheckSettings settings;
  private final HttpsHealthCheckStub stub;



  /**
   * Constructs an instance of HttpsHealthCheckClient with default settings.
   */
  public static final HttpsHealthCheckClient create() throws IOException {
    return create(HttpsHealthCheckSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HttpsHealthCheckClient, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final HttpsHealthCheckClient create(HttpsHealthCheckSettings settings) throws IOException {
    return new HttpsHealthCheckClient(settings);
  }

  /**
   * Constructs an instance of HttpsHealthCheckClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use HttpsHealthCheckSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final HttpsHealthCheckClient create(HttpsHealthCheckStub stub) {
    return new HttpsHealthCheckClient(stub);
  }

  /**
   * Constructs an instance of HttpsHealthCheckClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
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
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   Operation response = httpsHealthCheckClient.deleteHttpsHealthCheck(httpsHealthCheck, requestId);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to delete.
   * @param requestId An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed.
   *
   * For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments.
   *
   * The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteHttpsHealthCheck(ProjectHttpsHealthCheckName httpsHealthCheck, String requestId) {

    DeleteHttpsHealthCheckHttpRequest request =
        DeleteHttpsHealthCheckHttpRequest.newBuilder()
        .setHttpsHealthCheck(httpsHealthCheck == null ? null : httpsHealthCheck.toString())
        .setRequestId(requestId)
        .build();
    return deleteHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpsHealthCheck resource.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   Operation response = httpsHealthCheckClient.deleteHttpsHealthCheck(httpsHealthCheck.toString(), requestId);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to delete.
   * @param requestId An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed.
   *
   * For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments.
   *
   * The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteHttpsHealthCheck(String httpsHealthCheck, String requestId) {

    DeleteHttpsHealthCheckHttpRequest request =
        DeleteHttpsHealthCheckHttpRequest.newBuilder()
        .setHttpsHealthCheck(httpsHealthCheck)
        .setRequestId(requestId)
        .build();
    return deleteHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpsHealthCheck resource.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   DeleteHttpsHealthCheckHttpRequest request = DeleteHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck.toString())
   *     .setRequestId(requestId)
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
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   DeleteHttpsHealthCheckHttpRequest request = DeleteHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck.toString())
   *     .setRequestId(requestId)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthCheckClient.deleteHttpsHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteHttpsHealthCheckHttpRequest, Operation> deleteHttpsHealthCheckCallable() {
    return stub.deleteHttpsHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Get a list of available HTTPS health checks by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck response = httpsHealthCheckClient.getHttpsHealthCheck(httpsHealthCheck);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HttpsHealthCheck getHttpsHealthCheck(ProjectHttpsHealthCheckName httpsHealthCheck) {

    GetHttpsHealthCheckHttpRequest request =
        GetHttpsHealthCheckHttpRequest.newBuilder()
        .setHttpsHealthCheck(httpsHealthCheck == null ? null : httpsHealthCheck.toString())
        .build();
    return getHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Get a list of available HTTPS health checks by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   HttpsHealthCheck response = httpsHealthCheckClient.getHttpsHealthCheck(httpsHealthCheck.toString());
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HttpsHealthCheck getHttpsHealthCheck(String httpsHealthCheck) {

    GetHttpsHealthCheckHttpRequest request =
        GetHttpsHealthCheckHttpRequest.newBuilder()
        .setHttpsHealthCheck(httpsHealthCheck)
        .build();
    return getHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Get a list of available HTTPS health checks by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   GetHttpsHealthCheckHttpRequest request = GetHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck.toString())
   *     .build();
   *   HttpsHealthCheck response = httpsHealthCheckClient.getHttpsHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HttpsHealthCheck getHttpsHealthCheck(GetHttpsHealthCheckHttpRequest request) {
    return getHttpsHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Get a list of available HTTPS health checks by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   GetHttpsHealthCheckHttpRequest request = GetHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck.toString())
   *     .build();
   *   ApiFuture&lt;HttpsHealthCheck&gt; future = httpsHealthCheckClient.getHttpsHealthCheckCallable().futureCall(request);
   *   // Do something
   *   HttpsHealthCheck response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetHttpsHealthCheckHttpRequest, HttpsHealthCheck> getHttpsHealthCheckCallable() {
    return stub.getHttpsHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String requestId = "";
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   Operation response = httpsHealthCheckClient.insertHttpsHealthCheck(requestId, project, httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param requestId An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed.
   *
   * For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments.
   *
   * The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
   * @param project Project ID for this request.
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template for how individual instances should be checked for health, via HTTPS.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertHttpsHealthCheck(String requestId, ProjectName project, HttpsHealthCheck httpsHealthCheckResource) {

    InsertHttpsHealthCheckHttpRequest request =
        InsertHttpsHealthCheckHttpRequest.newBuilder()
        .setRequestId(requestId)
        .setProject(project == null ? null : project.toString())
        .setHttpsHealthCheckResource(httpsHealthCheckResource)
        .build();
    return insertHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String requestId = "";
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   Operation response = httpsHealthCheckClient.insertHttpsHealthCheck(requestId, project.toString(), httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param requestId An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed.
   *
   * For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments.
   *
   * The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
   * @param project Project ID for this request.
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template for how individual instances should be checked for health, via HTTPS.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertHttpsHealthCheck(String requestId, String project, HttpsHealthCheck httpsHealthCheckResource) {

    InsertHttpsHealthCheckHttpRequest request =
        InsertHttpsHealthCheckHttpRequest.newBuilder()
        .setRequestId(requestId)
        .setProject(project)
        .setHttpsHealthCheckResource(httpsHealthCheckResource)
        .build();
    return insertHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String requestId = "";
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   InsertHttpsHealthCheckHttpRequest request = InsertHttpsHealthCheckHttpRequest.newBuilder()
   *     .setRequestId(requestId)
   *     .setProject(project.toString())
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
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   String requestId = "";
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   InsertHttpsHealthCheckHttpRequest request = InsertHttpsHealthCheckHttpRequest.newBuilder()
   *     .setRequestId(requestId)
   *     .setProject(project.toString())
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthCheckClient.insertHttpsHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertHttpsHealthCheckHttpRequest, Operation> insertHttpsHealthCheckCallable() {
    return stub.insertHttpsHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (HttpsHealthCheck element : httpsHealthCheckClient.listHttpsHealthChecks(project).iterateAll()) {
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
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (HttpsHealthCheck element : httpsHealthCheckClient.listHttpsHealthChecks(project.toString()).iterateAll()) {
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
        ListHttpsHealthChecksHttpRequest.newBuilder()
        .setProject(project)
        .build();
    return listHttpsHealthChecks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListHttpsHealthChecksHttpRequest request = ListHttpsHealthChecksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (HttpsHealthCheck element : httpsHealthCheckClient.listHttpsHealthChecks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListHttpsHealthChecksPagedResponse listHttpsHealthChecks(ListHttpsHealthChecksHttpRequest request) {
    return listHttpsHealthChecksPagedCallable()
        .call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListHttpsHealthChecksHttpRequest request = ListHttpsHealthChecksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListHttpsHealthChecksPagedResponse&gt; future = httpsHealthCheckClient.listHttpsHealthChecksPagedCallable().futureCall(request);
   *   // Do something
   *   for (HttpsHealthCheck element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListHttpsHealthChecksHttpRequest, ListHttpsHealthChecksPagedResponse> listHttpsHealthChecksPagedCallable() {
    return stub.listHttpsHealthChecksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListHttpsHealthChecksHttpRequest request = ListHttpsHealthChecksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     HttpsHealthCheckList response = httpsHealthCheckClient.listHttpsHealthChecksCallable().call(request);
   *     for (HttpsHealthCheck element : response.getItemsList()) {
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
  public final UnaryCallable<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList> listHttpsHealthChecksCallable() {
    return stub.listHttpsHealthChecksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   Operation response = httpsHealthCheckClient.patchHttpsHealthCheck(httpsHealthCheck, requestId, httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to patch.
   * @param requestId An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed.
   *
   * For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments.
   *
   * The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template for how individual instances should be checked for health, via HTTPS.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchHttpsHealthCheck(ProjectHttpsHealthCheckName httpsHealthCheck, String requestId, HttpsHealthCheck httpsHealthCheckResource) {

    PatchHttpsHealthCheckHttpRequest request =
        PatchHttpsHealthCheckHttpRequest.newBuilder()
        .setHttpsHealthCheck(httpsHealthCheck == null ? null : httpsHealthCheck.toString())
        .setRequestId(requestId)
        .setHttpsHealthCheckResource(httpsHealthCheckResource)
        .build();
    return patchHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   Operation response = httpsHealthCheckClient.patchHttpsHealthCheck(httpsHealthCheck.toString(), requestId, httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to patch.
   * @param requestId An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed.
   *
   * For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments.
   *
   * The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template for how individual instances should be checked for health, via HTTPS.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchHttpsHealthCheck(String httpsHealthCheck, String requestId, HttpsHealthCheck httpsHealthCheckResource) {

    PatchHttpsHealthCheckHttpRequest request =
        PatchHttpsHealthCheckHttpRequest.newBuilder()
        .setHttpsHealthCheck(httpsHealthCheck)
        .setRequestId(requestId)
        .setHttpsHealthCheckResource(httpsHealthCheckResource)
        .build();
    return patchHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   PatchHttpsHealthCheckHttpRequest request = PatchHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck.toString())
   *     .setRequestId(requestId)
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
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
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   PatchHttpsHealthCheckHttpRequest request = PatchHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck.toString())
   *     .setRequestId(requestId)
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthCheckClient.patchHttpsHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchHttpsHealthCheckHttpRequest, Operation> patchHttpsHealthCheckCallable() {
    return stub.patchHttpsHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   Operation response = httpsHealthCheckClient.updateHttpsHealthCheck(httpsHealthCheck, requestId, httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to update.
   * @param requestId An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed.
   *
   * For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments.
   *
   * The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template for how individual instances should be checked for health, via HTTPS.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateHttpsHealthCheck(ProjectHttpsHealthCheckName httpsHealthCheck, String requestId, HttpsHealthCheck httpsHealthCheckResource) {

    UpdateHttpsHealthCheckHttpRequest request =
        UpdateHttpsHealthCheckHttpRequest.newBuilder()
        .setHttpsHealthCheck(httpsHealthCheck == null ? null : httpsHealthCheck.toString())
        .setRequestId(requestId)
        .setHttpsHealthCheckResource(httpsHealthCheckResource)
        .build();
    return updateHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   Operation response = httpsHealthCheckClient.updateHttpsHealthCheck(httpsHealthCheck.toString(), requestId, httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to update.
   * @param requestId An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed.
   *
   * For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments.
   *
   * The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
   * @param httpsHealthCheckResource An HttpsHealthCheck resource. This resource defines a template for how individual instances should be checked for health, via HTTPS.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateHttpsHealthCheck(String httpsHealthCheck, String requestId, HttpsHealthCheck httpsHealthCheckResource) {

    UpdateHttpsHealthCheckHttpRequest request =
        UpdateHttpsHealthCheckHttpRequest.newBuilder()
        .setHttpsHealthCheck(httpsHealthCheck)
        .setRequestId(requestId)
        .setHttpsHealthCheckResource(httpsHealthCheckResource)
        .build();
    return updateHttpsHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   UpdateHttpsHealthCheckHttpRequest request = UpdateHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck.toString())
   *     .setRequestId(requestId)
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
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
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the request.
   *
   * Sample code:
   * <pre><code>
   * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
   *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
   *   String requestId = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   UpdateHttpsHealthCheckHttpRequest request = UpdateHttpsHealthCheckHttpRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck.toString())
   *     .setRequestId(requestId)
   *     .setHttpsHealthCheckResource(httpsHealthCheckResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthCheckClient.updateHttpsHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateHttpsHealthCheckHttpRequest, Operation> updateHttpsHealthCheckCallable() {
    return stub.updateHttpsHealthCheckCallable();
  }

  @Override
  public final void close() throws Exception {
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

  public static class ListHttpsHealthChecksPagedResponse extends AbstractPagedListResponse<
      ListHttpsHealthChecksHttpRequest,
      HttpsHealthCheckList,
      HttpsHealthCheck,
      ListHttpsHealthChecksPage,
      ListHttpsHealthChecksFixedSizeCollection> {

    public static ApiFuture<ListHttpsHealthChecksPagedResponse> createAsync(
        PageContext<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList, HttpsHealthCheck> context,
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
          });
    }

    private ListHttpsHealthChecksPagedResponse(ListHttpsHealthChecksPage page) {
      super(page, ListHttpsHealthChecksFixedSizeCollection.createEmptyCollection());
    }


  }

  public static class ListHttpsHealthChecksPage extends AbstractPage<
      ListHttpsHealthChecksHttpRequest,
      HttpsHealthCheckList,
      HttpsHealthCheck,
      ListHttpsHealthChecksPage> {

    private ListHttpsHealthChecksPage(
        PageContext<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList, HttpsHealthCheck> context,
        HttpsHealthCheckList response) {
      super(context, response);
    }

    private static ListHttpsHealthChecksPage createEmptyPage() {
      return new ListHttpsHealthChecksPage(null, null);
    }

    @Override
    protected ListHttpsHealthChecksPage createPage(
        PageContext<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList, HttpsHealthCheck> context,
        HttpsHealthCheckList response) {
      return new ListHttpsHealthChecksPage(context, response);
    }

    @Override
    public ApiFuture<ListHttpsHealthChecksPage> createPageAsync(
        PageContext<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList, HttpsHealthCheck> context,
        ApiFuture<HttpsHealthCheckList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }




  }

  public static class ListHttpsHealthChecksFixedSizeCollection extends AbstractFixedSizeCollection<
      ListHttpsHealthChecksHttpRequest,
      HttpsHealthCheckList,
      HttpsHealthCheck,
      ListHttpsHealthChecksPage,
      ListHttpsHealthChecksFixedSizeCollection> {

    private ListHttpsHealthChecksFixedSizeCollection(List<ListHttpsHealthChecksPage> pages, int collectionSize) {
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