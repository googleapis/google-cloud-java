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
import com.google.cloud.compute.v1.stub.ExternalVpnGatewaysStub;
import com.google.cloud.compute.v1.stub.ExternalVpnGatewaysStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The ExternalVpnGateways API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
 *   String project = "";
 *   String externalVpnGateway = "";
 *   Operation response = externalVpnGatewaysClient.delete(project, externalVpnGateway);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the externalVpnGatewaysClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ExternalVpnGatewaysSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ExternalVpnGatewaysSettings externalVpnGatewaysSettings =
 *     ExternalVpnGatewaysSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ExternalVpnGatewaysClient externalVpnGatewaysClient =
 *     ExternalVpnGatewaysClient.create(externalVpnGatewaysSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ExternalVpnGatewaysSettings externalVpnGatewaysSettings =
 *     ExternalVpnGatewaysSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ExternalVpnGatewaysClient externalVpnGatewaysClient =
 *     ExternalVpnGatewaysClient.create(externalVpnGatewaysSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ExternalVpnGatewaysClient implements BackgroundResource {
  private final ExternalVpnGatewaysSettings settings;
  private final ExternalVpnGatewaysStub stub;

  /** Constructs an instance of ExternalVpnGatewaysClient with default settings. */
  public static final ExternalVpnGatewaysClient create() throws IOException {
    return create(ExternalVpnGatewaysSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ExternalVpnGatewaysClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ExternalVpnGatewaysClient create(ExternalVpnGatewaysSettings settings)
      throws IOException {
    return new ExternalVpnGatewaysClient(settings);
  }

  /**
   * Constructs an instance of ExternalVpnGatewaysClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use ExternalVpnGatewaysSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ExternalVpnGatewaysClient create(ExternalVpnGatewaysStub stub) {
    return new ExternalVpnGatewaysClient(stub);
  }

  /**
   * Constructs an instance of ExternalVpnGatewaysClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ExternalVpnGatewaysClient(ExternalVpnGatewaysSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ExternalVpnGatewaysStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ExternalVpnGatewaysClient(ExternalVpnGatewaysStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ExternalVpnGatewaysSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ExternalVpnGatewaysStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified externalVpnGateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   String externalVpnGateway = "";
   *   Operation response = externalVpnGatewaysClient.delete(project, externalVpnGateway);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param externalVpnGateway Name of the externalVpnGateways to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String externalVpnGateway) {
    DeleteExternalVpnGatewayRequest request =
        DeleteExternalVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setExternalVpnGateway(externalVpnGateway)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified externalVpnGateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String externalVpnGateway = "";
   *   String project = "";
   *   DeleteExternalVpnGatewayRequest request = DeleteExternalVpnGatewayRequest.newBuilder()
   *     .setExternalVpnGateway(externalVpnGateway)
   *     .setProject(project)
   *     .build();
   *   Operation response = externalVpnGatewaysClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteExternalVpnGatewayRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified externalVpnGateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String externalVpnGateway = "";
   *   String project = "";
   *   DeleteExternalVpnGatewayRequest request = DeleteExternalVpnGatewayRequest.newBuilder()
   *     .setExternalVpnGateway(externalVpnGateway)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = externalVpnGatewaysClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteExternalVpnGatewayRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified externalVpnGateway. Get a list of available externalVpnGateways by making
   * a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   String externalVpnGateway = "";
   *   ExternalVpnGateway response = externalVpnGatewaysClient.get(project, externalVpnGateway);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param externalVpnGateway Name of the externalVpnGateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalVpnGateway get(String project, String externalVpnGateway) {
    GetExternalVpnGatewayRequest request =
        GetExternalVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setExternalVpnGateway(externalVpnGateway)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified externalVpnGateway. Get a list of available externalVpnGateways by making
   * a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String externalVpnGateway = "";
   *   String project = "";
   *   GetExternalVpnGatewayRequest request = GetExternalVpnGatewayRequest.newBuilder()
   *     .setExternalVpnGateway(externalVpnGateway)
   *     .setProject(project)
   *     .build();
   *   ExternalVpnGateway response = externalVpnGatewaysClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalVpnGateway get(GetExternalVpnGatewayRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified externalVpnGateway. Get a list of available externalVpnGateways by making
   * a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String externalVpnGateway = "";
   *   String project = "";
   *   GetExternalVpnGatewayRequest request = GetExternalVpnGatewayRequest.newBuilder()
   *     .setExternalVpnGateway(externalVpnGateway)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ExternalVpnGateway&gt; future = externalVpnGatewaysClient.getCallable().futureCall(request);
   *   // Do something
   *   ExternalVpnGateway response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetExternalVpnGatewayRequest, ExternalVpnGateway> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ExternalVpnGateway in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   ExternalVpnGateway externalVpnGatewayResource = ExternalVpnGateway.newBuilder().build();
   *   Operation response = externalVpnGatewaysClient.insert(project, externalVpnGatewayResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param externalVpnGatewayResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, ExternalVpnGateway externalVpnGatewayResource) {
    InsertExternalVpnGatewayRequest request =
        InsertExternalVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setExternalVpnGatewayResource(externalVpnGatewayResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ExternalVpnGateway in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   ExternalVpnGateway externalVpnGatewayResource = ExternalVpnGateway.newBuilder().build();
   *   String project = "";
   *   InsertExternalVpnGatewayRequest request = InsertExternalVpnGatewayRequest.newBuilder()
   *     .setExternalVpnGatewayResource(externalVpnGatewayResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = externalVpnGatewaysClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertExternalVpnGatewayRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ExternalVpnGateway in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   ExternalVpnGateway externalVpnGatewayResource = ExternalVpnGateway.newBuilder().build();
   *   String project = "";
   *   InsertExternalVpnGatewayRequest request = InsertExternalVpnGatewayRequest.newBuilder()
   *     .setExternalVpnGatewayResource(externalVpnGatewayResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = externalVpnGatewaysClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertExternalVpnGatewayRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of ExternalVpnGateway available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   for (ExternalVpnGateway element : externalVpnGatewaysClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListExternalVpnGatewaysRequest request =
        ListExternalVpnGatewaysRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of ExternalVpnGateway available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   ListExternalVpnGatewaysRequest request = ListExternalVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (ExternalVpnGateway element : externalVpnGatewaysClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListExternalVpnGatewaysRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of ExternalVpnGateway available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   ListExternalVpnGatewaysRequest request = ListExternalVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = externalVpnGatewaysClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (ExternalVpnGateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListExternalVpnGatewaysRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of ExternalVpnGateway available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   ListExternalVpnGatewaysRequest request = ListExternalVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     ExternalVpnGatewayList response = externalVpnGatewaysClient.listCallable().call(request);
   *     for (ExternalVpnGateway element : response.getItemsList()) {
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
  public final UnaryCallable<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an ExternalVpnGateway. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   Operation response = externalVpnGatewaysClient.setLabels(project, resource, globalSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(
      String project, String resource, GlobalSetLabelsRequest globalSetLabelsRequestResource) {
    SetLabelsExternalVpnGatewayRequest request =
        SetLabelsExternalVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
            .build();
    return setLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an ExternalVpnGateway. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   String project = "";
   *   String resource = "";
   *   SetLabelsExternalVpnGatewayRequest request = SetLabelsExternalVpnGatewayRequest.newBuilder()
   *     .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   Operation response = externalVpnGatewaysClient.setLabels(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(SetLabelsExternalVpnGatewayRequest request) {
    return setLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an ExternalVpnGateway. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   String project = "";
   *   String resource = "";
   *   SetLabelsExternalVpnGatewayRequest request = SetLabelsExternalVpnGatewayRequest.newBuilder()
   *     .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = externalVpnGatewaysClient.setLabelsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetLabelsExternalVpnGatewayRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = externalVpnGatewaysClient.testIamPermissions(project, resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project, String resource, TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsExternalVpnGatewayRequest request =
        TestIamPermissionsExternalVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsExternalVpnGatewayRequest request = TestIamPermissionsExternalVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = externalVpnGatewaysClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsExternalVpnGatewayRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsExternalVpnGatewayRequest request = TestIamPermissionsExternalVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = externalVpnGatewaysClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsExternalVpnGatewayRequest, TestPermissionsResponse>
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListExternalVpnGatewaysRequest,
          ExternalVpnGatewayList,
          ExternalVpnGateway,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList, ExternalVpnGateway>
            context,
        ApiFuture<ExternalVpnGatewayList> futureResponse) {
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
          ListExternalVpnGatewaysRequest, ExternalVpnGatewayList, ExternalVpnGateway, ListPage> {

    private ListPage(
        PageContext<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList, ExternalVpnGateway>
            context,
        ExternalVpnGatewayList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList, ExternalVpnGateway>
            context,
        ExternalVpnGatewayList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList, ExternalVpnGateway>
            context,
        ApiFuture<ExternalVpnGatewayList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExternalVpnGatewaysRequest,
          ExternalVpnGatewayList,
          ExternalVpnGateway,
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
