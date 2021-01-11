/*
 * Copyright 2020 Google LLC
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
import com.google.cloud.compute.v1.stub.TargetSslProxiesStub;
import com.google.cloud.compute.v1.stub.TargetSslProxiesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The TargetSslProxies API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
 *   String project = "";
 *   String targetSslProxy = "";
 *   Operation response = targetSslProxiesClient.delete(project, targetSslProxy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the targetSslProxiesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TargetSslProxiesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * TargetSslProxiesSettings targetSslProxiesSettings =
 *     TargetSslProxiesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetSslProxiesClient targetSslProxiesClient =
 *     TargetSslProxiesClient.create(targetSslProxiesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TargetSslProxiesSettings targetSslProxiesSettings =
 *     TargetSslProxiesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetSslProxiesClient targetSslProxiesClient =
 *     TargetSslProxiesClient.create(targetSslProxiesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetSslProxiesClient implements BackgroundResource {
  private final TargetSslProxiesSettings settings;
  private final TargetSslProxiesStub stub;

  /** Constructs an instance of TargetSslProxiesClient with default settings. */
  public static final TargetSslProxiesClient create() throws IOException {
    return create(TargetSslProxiesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetSslProxiesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetSslProxiesClient create(TargetSslProxiesSettings settings)
      throws IOException {
    return new TargetSslProxiesClient(settings);
  }

  /**
   * Constructs an instance of TargetSslProxiesClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use TargetSslProxiesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TargetSslProxiesClient create(TargetSslProxiesStub stub) {
    return new TargetSslProxiesClient(stub);
  }

  /**
   * Constructs an instance of TargetSslProxiesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetSslProxiesClient(TargetSslProxiesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetSslProxiesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TargetSslProxiesClient(TargetSslProxiesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetSslProxiesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetSslProxiesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetSslProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   String targetSslProxy = "";
   *   Operation response = targetSslProxiesClient.delete(project, targetSslProxy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String targetSslProxy) {
    DeleteTargetSslProxyRequest request =
        DeleteTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetSslProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   String targetSslProxy = "";
   *   DeleteTargetSslProxyRequest request = DeleteTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   Operation response = targetSslProxiesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteTargetSslProxyRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetSslProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   String targetSslProxy = "";
   *   DeleteTargetSslProxyRequest request = DeleteTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetSslProxiesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTargetSslProxyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetSslProxy resource. Gets a list of available target SSL proxies by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   String targetSslProxy = "";
   *   TargetSslProxy response = targetSslProxiesClient.get(project, targetSslProxy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetSslProxy get(String project, String targetSslProxy) {
    GetTargetSslProxyRequest request =
        GetTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetSslProxy resource. Gets a list of available target SSL proxies by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   String targetSslProxy = "";
   *   GetTargetSslProxyRequest request = GetTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   TargetSslProxy response = targetSslProxiesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetSslProxy get(GetTargetSslProxyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetSslProxy resource. Gets a list of available target SSL proxies by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   String targetSslProxy = "";
   *   GetTargetSslProxyRequest request = GetTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   ApiFuture&lt;TargetSslProxy&gt; future = targetSslProxiesClient.getCallable().futureCall(request);
   *   // Do something
   *   TargetSslProxy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTargetSslProxyRequest, TargetSslProxy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetSslProxy resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   TargetSslProxy targetSslProxyResource = TargetSslProxy.newBuilder().build();
   *   Operation response = targetSslProxiesClient.insert(project, targetSslProxyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, TargetSslProxy targetSslProxyResource) {
    InsertTargetSslProxyRequest request =
        InsertTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxyResource(targetSslProxyResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetSslProxy resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   TargetSslProxy targetSslProxyResource = TargetSslProxy.newBuilder().build();
   *   InsertTargetSslProxyRequest request = InsertTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxyResource(targetSslProxyResource)
   *     .build();
   *   Operation response = targetSslProxiesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertTargetSslProxyRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetSslProxy resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   TargetSslProxy targetSslProxyResource = TargetSslProxy.newBuilder().build();
   *   InsertTargetSslProxyRequest request = InsertTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxyResource(targetSslProxyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetSslProxiesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertTargetSslProxyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetSslProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   for (TargetSslProxy element : targetSslProxiesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListTargetSslProxiesRequest request =
        ListTargetSslProxiesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetSslProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   ListTargetSslProxiesRequest request = ListTargetSslProxiesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (TargetSslProxy element : targetSslProxiesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetSslProxiesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetSslProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   ListTargetSslProxiesRequest request = ListTargetSslProxiesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = targetSslProxiesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetSslProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTargetSslProxiesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetSslProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   ListTargetSslProxiesRequest request = ListTargetSslProxiesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     TargetSslProxyList response = targetSslProxiesClient.listCallable().call(request);
   *     for (TargetSslProxy element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetSslProxiesRequest, TargetSslProxyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the BackendService for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   String targetSslProxy = "";
   *   TargetSslProxiesSetBackendServiceRequest targetSslProxiesSetBackendServiceRequestResource = TargetSslProxiesSetBackendServiceRequest.newBuilder().build();
   *   Operation response = targetSslProxiesClient.setBackendService(project, targetSslProxy, targetSslProxiesSetBackendServiceRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource whose BackendService resource is to
   *     be set.
   * @param targetSslProxiesSetBackendServiceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setBackendService(
      String project,
      String targetSslProxy,
      TargetSslProxiesSetBackendServiceRequest targetSslProxiesSetBackendServiceRequestResource) {
    SetBackendServiceTargetSslProxyRequest request =
        SetBackendServiceTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .setTargetSslProxiesSetBackendServiceRequestResource(
                targetSslProxiesSetBackendServiceRequestResource)
            .build();
    return setBackendService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the BackendService for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   TargetSslProxiesSetBackendServiceRequest targetSslProxiesSetBackendServiceRequestResource = TargetSslProxiesSetBackendServiceRequest.newBuilder().build();
   *   String targetSslProxy = "";
   *   SetBackendServiceTargetSslProxyRequest request = SetBackendServiceTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxiesSetBackendServiceRequestResource(targetSslProxiesSetBackendServiceRequestResource)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   Operation response = targetSslProxiesClient.setBackendService(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setBackendService(SetBackendServiceTargetSslProxyRequest request) {
    return setBackendServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the BackendService for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   TargetSslProxiesSetBackendServiceRequest targetSslProxiesSetBackendServiceRequestResource = TargetSslProxiesSetBackendServiceRequest.newBuilder().build();
   *   String targetSslProxy = "";
   *   SetBackendServiceTargetSslProxyRequest request = SetBackendServiceTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxiesSetBackendServiceRequestResource(targetSslProxiesSetBackendServiceRequestResource)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetSslProxiesClient.setBackendServiceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceCallable() {
    return stub.setBackendServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the ProxyHeaderType for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   String targetSslProxy = "";
   *   TargetSslProxiesSetProxyHeaderRequest targetSslProxiesSetProxyHeaderRequestResource = TargetSslProxiesSetProxyHeaderRequest.newBuilder().build();
   *   Operation response = targetSslProxiesClient.setProxyHeader(project, targetSslProxy, targetSslProxiesSetProxyHeaderRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource whose ProxyHeader is to be set.
   * @param targetSslProxiesSetProxyHeaderRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setProxyHeader(
      String project,
      String targetSslProxy,
      TargetSslProxiesSetProxyHeaderRequest targetSslProxiesSetProxyHeaderRequestResource) {
    SetProxyHeaderTargetSslProxyRequest request =
        SetProxyHeaderTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .setTargetSslProxiesSetProxyHeaderRequestResource(
                targetSslProxiesSetProxyHeaderRequestResource)
            .build();
    return setProxyHeader(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the ProxyHeaderType for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   TargetSslProxiesSetProxyHeaderRequest targetSslProxiesSetProxyHeaderRequestResource = TargetSslProxiesSetProxyHeaderRequest.newBuilder().build();
   *   String targetSslProxy = "";
   *   SetProxyHeaderTargetSslProxyRequest request = SetProxyHeaderTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxiesSetProxyHeaderRequestResource(targetSslProxiesSetProxyHeaderRequestResource)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   Operation response = targetSslProxiesClient.setProxyHeader(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setProxyHeader(SetProxyHeaderTargetSslProxyRequest request) {
    return setProxyHeaderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the ProxyHeaderType for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   TargetSslProxiesSetProxyHeaderRequest targetSslProxiesSetProxyHeaderRequestResource = TargetSslProxiesSetProxyHeaderRequest.newBuilder().build();
   *   String targetSslProxy = "";
   *   SetProxyHeaderTargetSslProxyRequest request = SetProxyHeaderTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxiesSetProxyHeaderRequestResource(targetSslProxiesSetProxyHeaderRequestResource)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetSslProxiesClient.setProxyHeaderCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetProxyHeaderTargetSslProxyRequest, Operation>
      setProxyHeaderCallable() {
    return stub.setProxyHeaderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes SslCertificates for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   String targetSslProxy = "";
   *   TargetSslProxiesSetSslCertificatesRequest targetSslProxiesSetSslCertificatesRequestResource = TargetSslProxiesSetSslCertificatesRequest.newBuilder().build();
   *   Operation response = targetSslProxiesClient.setSslCertificates(project, targetSslProxy, targetSslProxiesSetSslCertificatesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource whose SslCertificate resource is to
   *     be set.
   * @param targetSslProxiesSetSslCertificatesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setSslCertificates(
      String project,
      String targetSslProxy,
      TargetSslProxiesSetSslCertificatesRequest targetSslProxiesSetSslCertificatesRequestResource) {
    SetSslCertificatesTargetSslProxyRequest request =
        SetSslCertificatesTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .setTargetSslProxiesSetSslCertificatesRequestResource(
                targetSslProxiesSetSslCertificatesRequestResource)
            .build();
    return setSslCertificates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes SslCertificates for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   TargetSslProxiesSetSslCertificatesRequest targetSslProxiesSetSslCertificatesRequestResource = TargetSslProxiesSetSslCertificatesRequest.newBuilder().build();
   *   String targetSslProxy = "";
   *   SetSslCertificatesTargetSslProxyRequest request = SetSslCertificatesTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxiesSetSslCertificatesRequestResource(targetSslProxiesSetSslCertificatesRequestResource)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   Operation response = targetSslProxiesClient.setSslCertificates(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setSslCertificates(SetSslCertificatesTargetSslProxyRequest request) {
    return setSslCertificatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes SslCertificates for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   TargetSslProxiesSetSslCertificatesRequest targetSslProxiesSetSslCertificatesRequestResource = TargetSslProxiesSetSslCertificatesRequest.newBuilder().build();
   *   String targetSslProxy = "";
   *   SetSslCertificatesTargetSslProxyRequest request = SetSslCertificatesTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetSslProxiesSetSslCertificatesRequestResource(targetSslProxiesSetSslCertificatesRequestResource)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetSslProxiesClient.setSslCertificatesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesCallable() {
    return stub.setSslCertificatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the SSL policy for TargetSslProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the SSL proxy load balancer. They do
   * not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   String targetSslProxy = "";
   *   SslPolicyReference sslPolicyReferenceResource = SslPolicyReference.newBuilder().build();
   *   Operation response = targetSslProxiesClient.setSslPolicy(project, targetSslProxy, sslPolicyReferenceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource whose SSL policy is to be set. The
   *     name must be 1-63 characters long, and comply with RFC1035.
   * @param sslPolicyReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setSslPolicy(
      String project, String targetSslProxy, SslPolicyReference sslPolicyReferenceResource) {
    SetSslPolicyTargetSslProxyRequest request =
        SetSslPolicyTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .setSslPolicyReferenceResource(sslPolicyReferenceResource)
            .build();
    return setSslPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the SSL policy for TargetSslProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the SSL proxy load balancer. They do
   * not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   SslPolicyReference sslPolicyReferenceResource = SslPolicyReference.newBuilder().build();
   *   String targetSslProxy = "";
   *   SetSslPolicyTargetSslProxyRequest request = SetSslPolicyTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setSslPolicyReferenceResource(sslPolicyReferenceResource)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   Operation response = targetSslProxiesClient.setSslPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setSslPolicy(SetSslPolicyTargetSslProxyRequest request) {
    return setSslPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the SSL policy for TargetSslProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the SSL proxy load balancer. They do
   * not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "";
   *   SslPolicyReference sslPolicyReferenceResource = SslPolicyReference.newBuilder().build();
   *   String targetSslProxy = "";
   *   SetSslPolicyTargetSslProxyRequest request = SetSslPolicyTargetSslProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setSslPolicyReferenceResource(sslPolicyReferenceResource)
   *     .setTargetSslProxy(targetSslProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetSslProxiesClient.setSslPolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetSslPolicyTargetSslProxyRequest, Operation> setSslPolicyCallable() {
    return stub.setSslPolicyCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListTargetSslProxiesRequest,
          TargetSslProxyList,
          TargetSslProxy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy> context,
        ApiFuture<TargetSslProxyList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy, ListPage> {

    private ListPage(
        PageContext<ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy> context,
        TargetSslProxyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy> context,
        TargetSslProxyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy> context,
        ApiFuture<TargetSslProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetSslProxiesRequest,
          TargetSslProxyList,
          TargetSslProxy,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
