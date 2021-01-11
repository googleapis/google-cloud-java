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
import com.google.cloud.compute.v1.stub.BackendServicesStub;
import com.google.cloud.compute.v1.stub.BackendServicesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The BackendServices API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
 *   String project = "";
 *   String backendService = "";
 *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
 *   Operation response = backendServicesClient.addSignedUrlKey(project, backendService, signedUrlKeyResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the backendServicesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of BackendServicesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * BackendServicesSettings backendServicesSettings =
 *     BackendServicesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BackendServicesClient backendServicesClient =
 *     BackendServicesClient.create(backendServicesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * BackendServicesSettings backendServicesSettings =
 *     BackendServicesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BackendServicesClient backendServicesClient =
 *     BackendServicesClient.create(backendServicesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class BackendServicesClient implements BackgroundResource {
  private final BackendServicesSettings settings;
  private final BackendServicesStub stub;

  /** Constructs an instance of BackendServicesClient with default settings. */
  public static final BackendServicesClient create() throws IOException {
    return create(BackendServicesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BackendServicesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BackendServicesClient create(BackendServicesSettings settings)
      throws IOException {
    return new BackendServicesClient(settings);
  }

  /**
   * Constructs an instance of BackendServicesClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use BackendServicesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final BackendServicesClient create(BackendServicesStub stub) {
    return new BackendServicesClient(stub);
  }

  /**
   * Constructs an instance of BackendServicesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BackendServicesClient(BackendServicesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BackendServicesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected BackendServicesClient(BackendServicesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BackendServicesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BackendServicesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   String backendService = "";
   *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
   *   Operation response = backendServicesClient.addSignedUrlKey(project, backendService, signedUrlKeyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to which the Signed URL Key should be
   *     added. The name should conform to RFC1035.
   * @param signedUrlKeyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addSignedUrlKey(
      String project, String backendService, SignedUrlKey signedUrlKeyResource) {
    AddSignedUrlKeyBackendServiceRequest request =
        AddSignedUrlKeyBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setSignedUrlKeyResource(signedUrlKeyResource)
            .build();
    return addSignedUrlKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
   *   AddSignedUrlKeyBackendServiceRequest request = AddSignedUrlKeyBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setSignedUrlKeyResource(signedUrlKeyResource)
   *     .build();
   *   Operation response = backendServicesClient.addSignedUrlKey(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addSignedUrlKey(AddSignedUrlKeyBackendServiceRequest request) {
    return addSignedUrlKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
   *   AddSignedUrlKeyBackendServiceRequest request = AddSignedUrlKeyBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setSignedUrlKeyResource(signedUrlKeyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendServicesClient.addSignedUrlKeyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AddSignedUrlKeyBackendServiceRequest, Operation>
      addSignedUrlKeyCallable() {
    return stub.addSignedUrlKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all BackendService resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, BackendServicesScopedList&gt; element : backendServicesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListBackendServicesRequest request =
        AggregatedListBackendServicesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all BackendService resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   AggregatedListBackendServicesRequest request = AggregatedListBackendServicesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, BackendServicesScopedList&gt; element : backendServicesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListBackendServicesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all BackendService resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   AggregatedListBackendServicesRequest request = AggregatedListBackendServicesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = backendServicesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, BackendServicesScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListBackendServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all BackendService resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   AggregatedListBackendServicesRequest request = AggregatedListBackendServicesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     BackendServiceAggregatedList response = backendServicesClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, BackendServicesScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   String backendService = "";
   *   Operation response = backendServicesClient.delete(project, backendService);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String backendService) {
    DeleteBackendServiceRequest request =
        DeleteBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   DeleteBackendServiceRequest request = DeleteBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .build();
   *   Operation response = backendServicesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteBackendServiceRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   DeleteBackendServiceRequest request = DeleteBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendServicesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteBackendServiceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   String backendService = "";
   *   String keyName = "";
   *   Operation response = backendServicesClient.deleteSignedUrlKey(project, backendService, keyName);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to which the Signed URL Key should be
   *     added. The name should conform to RFC1035.
   * @param keyName The name of the Signed URL Key to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteSignedUrlKey(String project, String backendService, String keyName) {
    DeleteSignedUrlKeyBackendServiceRequest request =
        DeleteSignedUrlKeyBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setKeyName(keyName)
            .build();
    return deleteSignedUrlKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String keyName = "";
   *   String project = "";
   *   DeleteSignedUrlKeyBackendServiceRequest request = DeleteSignedUrlKeyBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setKeyName(keyName)
   *     .setProject(project)
   *     .build();
   *   Operation response = backendServicesClient.deleteSignedUrlKey(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteSignedUrlKey(DeleteSignedUrlKeyBackendServiceRequest request) {
    return deleteSignedUrlKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String keyName = "";
   *   String project = "";
   *   DeleteSignedUrlKeyBackendServiceRequest request = DeleteSignedUrlKeyBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setKeyName(keyName)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendServicesClient.deleteSignedUrlKeyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeyCallable() {
    return stub.deleteSignedUrlKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified BackendService resource. Gets a list of available backend services.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   String backendService = "";
   *   BackendService response = backendServicesClient.get(project, backendService);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendService get(String project, String backendService) {
    GetBackendServiceRequest request =
        GetBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified BackendService resource. Gets a list of available backend services.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   GetBackendServiceRequest request = GetBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .build();
   *   BackendService response = backendServicesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendService get(GetBackendServiceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified BackendService resource. Gets a list of available backend services.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   GetBackendServiceRequest request = GetBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;BackendService&gt; future = backendServicesClient.getCallable().futureCall(request);
   *   // Do something
   *   BackendService response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetBackendServiceRequest, BackendService> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for this BackendService.
   *
   * <p>Example request body:
   *
   * <p>{ "group": "/zones/us-east1-b/instanceGroups/lb-backend-example" }
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   String backendService = "";
   *   ResourceGroupReference resourceGroupReferenceResource = ResourceGroupReference.newBuilder().build();
   *   BackendServiceGroupHealth response = backendServicesClient.getHealth(project, backendService, resourceGroupReferenceResource);
   * }
   * </code></pre>
   *
   * @param project
   * @param backendService Name of the BackendService resource to which the queried instance
   *     belongs.
   * @param resourceGroupReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendServiceGroupHealth getHealth(
      String project,
      String backendService,
      ResourceGroupReference resourceGroupReferenceResource) {
    GetHealthBackendServiceRequest request =
        GetHealthBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setResourceGroupReferenceResource(resourceGroupReferenceResource)
            .build();
    return getHealth(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for this BackendService.
   *
   * <p>Example request body:
   *
   * <p>{ "group": "/zones/us-east1-b/instanceGroups/lb-backend-example" }
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   ResourceGroupReference resourceGroupReferenceResource = ResourceGroupReference.newBuilder().build();
   *   GetHealthBackendServiceRequest request = GetHealthBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setResourceGroupReferenceResource(resourceGroupReferenceResource)
   *     .build();
   *   BackendServiceGroupHealth response = backendServicesClient.getHealth(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendServiceGroupHealth getHealth(GetHealthBackendServiceRequest request) {
    return getHealthCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for this BackendService.
   *
   * <p>Example request body:
   *
   * <p>{ "group": "/zones/us-east1-b/instanceGroups/lb-backend-example" }
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   ResourceGroupReference resourceGroupReferenceResource = ResourceGroupReference.newBuilder().build();
   *   GetHealthBackendServiceRequest request = GetHealthBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setResourceGroupReferenceResource(resourceGroupReferenceResource)
   *     .build();
   *   ApiFuture&lt;BackendServiceGroupHealth&gt; future = backendServicesClient.getHealthCallable().futureCall(request);
   *   // Do something
   *   BackendServiceGroupHealth response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthCallable() {
    return stub.getHealthCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a BackendService resource in the specified project using the data included in the
   * request. For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response = backendServicesClient.insert(project, backendServiceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, BackendService backendServiceResource) {
    InsertBackendServiceRequest request =
        InsertBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a BackendService resource in the specified project using the data included in the
   * request. For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   InsertBackendServiceRequest request = InsertBackendServiceRequest.newBuilder()
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = backendServicesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertBackendServiceRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a BackendService resource in the specified project using the data included in the
   * request. For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   InsertBackendServiceRequest request = InsertBackendServiceRequest.newBuilder()
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendServicesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertBackendServiceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of BackendService resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   for (BackendService element : backendServicesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListBackendServicesRequest request =
        ListBackendServicesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of BackendService resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   ListBackendServicesRequest request = ListBackendServicesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (BackendService element : backendServicesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListBackendServicesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of BackendService resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   ListBackendServicesRequest request = ListBackendServicesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = backendServicesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (BackendService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListBackendServicesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of BackendService resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   ListBackendServicesRequest request = ListBackendServicesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     BackendServiceList response = backendServicesClient.listCallable().call(request);
   *     for (BackendService element : response.getItemsList()) {
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
  public final UnaryCallable<ListBackendServicesRequest, BackendServiceList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview. This method supports PATCH semantics and uses the
   * JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response = backendServicesClient.patch(project, backendService, backendServiceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to patch.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String backendService, BackendService backendServiceResource) {
    PatchBackendServiceRequest request =
        PatchBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview. This method supports PATCH semantics and uses the
   * JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   PatchBackendServiceRequest request = PatchBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = backendServicesClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchBackendServiceRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview. This method supports PATCH semantics and uses the
   * JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   PatchBackendServiceRequest request = PatchBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendServicesClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchBackendServiceRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the security policy for the specified backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   String backendService = "";
   *   SecurityPolicyReference securityPolicyReferenceResource = SecurityPolicyReference.newBuilder().build();
   *   Operation response = backendServicesClient.setSecurityPolicy(project, backendService, securityPolicyReferenceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to which the security policy should
   *     be set. The name should conform to RFC1035.
   * @param securityPolicyReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setSecurityPolicy(
      String project,
      String backendService,
      SecurityPolicyReference securityPolicyReferenceResource) {
    SetSecurityPolicyBackendServiceRequest request =
        SetSecurityPolicyBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setSecurityPolicyReferenceResource(securityPolicyReferenceResource)
            .build();
    return setSecurityPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the security policy for the specified backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   SecurityPolicyReference securityPolicyReferenceResource = SecurityPolicyReference.newBuilder().build();
   *   SetSecurityPolicyBackendServiceRequest request = SetSecurityPolicyBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setSecurityPolicyReferenceResource(securityPolicyReferenceResource)
   *     .build();
   *   Operation response = backendServicesClient.setSecurityPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setSecurityPolicy(SetSecurityPolicyBackendServiceRequest request) {
    return setSecurityPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the security policy for the specified backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   SecurityPolicyReference securityPolicyReferenceResource = SecurityPolicyReference.newBuilder().build();
   *   SetSecurityPolicyBackendServiceRequest request = SetSecurityPolicyBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setSecurityPolicyReferenceResource(securityPolicyReferenceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendServicesClient.setSecurityPolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicyCallable() {
    return stub.setSecurityPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "";
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response = backendServicesClient.update(project, backendService, backendServiceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to update.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(
      String project, String backendService, BackendService backendServiceResource) {
    UpdateBackendServiceRequest request =
        UpdateBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return update(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   UpdateBackendServiceRequest request = UpdateBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = backendServicesClient.update(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateBackendServiceRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   UpdateBackendServiceRequest request = UpdateBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendServicesClient.updateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateBackendServiceRequest, Operation> updateCallable() {
    return stub.updateCallable();
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          Entry<String, BackendServicesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListBackendServicesRequest,
                BackendServiceAggregatedList,
                Entry<String, BackendServicesScopedList>>
            context,
        ApiFuture<BackendServiceAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListPage, AggregatedListPagedResponse>() {
            @Override
            public AggregatedListPagedResponse apply(AggregatedListPage input) {
              return new AggregatedListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          Entry<String, BackendServicesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListBackendServicesRequest,
                BackendServiceAggregatedList,
                Entry<String, BackendServicesScopedList>>
            context,
        BackendServiceAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListBackendServicesRequest,
                BackendServiceAggregatedList,
                Entry<String, BackendServicesScopedList>>
            context,
        BackendServiceAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListBackendServicesRequest,
                BackendServiceAggregatedList,
                Entry<String, BackendServicesScopedList>>
            context,
        ApiFuture<BackendServiceAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          Entry<String, BackendServicesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListBackendServicesRequest,
          BackendServiceList,
          BackendService,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListBackendServicesRequest, BackendServiceList, BackendService> context,
        ApiFuture<BackendServiceList> futureResponse) {
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
          ListBackendServicesRequest, BackendServiceList, BackendService, ListPage> {

    private ListPage(
        PageContext<ListBackendServicesRequest, BackendServiceList, BackendService> context,
        BackendServiceList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListBackendServicesRequest, BackendServiceList, BackendService> context,
        BackendServiceList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListBackendServicesRequest, BackendServiceList, BackendService> context,
        ApiFuture<BackendServiceList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackendServicesRequest,
          BackendServiceList,
          BackendService,
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
