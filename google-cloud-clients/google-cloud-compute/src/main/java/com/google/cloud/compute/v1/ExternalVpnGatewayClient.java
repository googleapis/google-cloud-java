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
import com.google.cloud.compute.v1.stub.ExternalVpnGatewayStub;
import com.google.cloud.compute.v1.stub.ExternalVpnGatewayStubSettings;
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
 * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
 *   ProjectGlobalExternalVpnGatewayName externalVpnGateway = ProjectGlobalExternalVpnGatewayName.of("[PROJECT]", "[EXTERNAL_VPN_GATEWAY]");
 *   Operation response = externalVpnGatewayClient.deleteExternalVpnGateway(externalVpnGateway);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the externalVpnGatewayClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ExternalVpnGatewaySettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ExternalVpnGatewaySettings externalVpnGatewaySettings =
 *     ExternalVpnGatewaySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ExternalVpnGatewayClient externalVpnGatewayClient =
 *     ExternalVpnGatewayClient.create(externalVpnGatewaySettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ExternalVpnGatewaySettings externalVpnGatewaySettings =
 *     ExternalVpnGatewaySettings.newBuilder().setEndpoint(myEndpoint).build();
 * ExternalVpnGatewayClient externalVpnGatewayClient =
 *     ExternalVpnGatewayClient.create(externalVpnGatewaySettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ExternalVpnGatewayClient implements BackgroundResource {
  private final ExternalVpnGatewaySettings settings;
  private final ExternalVpnGatewayStub stub;

  /** Constructs an instance of ExternalVpnGatewayClient with default settings. */
  public static final ExternalVpnGatewayClient create() throws IOException {
    return create(ExternalVpnGatewaySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ExternalVpnGatewayClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ExternalVpnGatewayClient create(ExternalVpnGatewaySettings settings)
      throws IOException {
    return new ExternalVpnGatewayClient(settings);
  }

  /**
   * Constructs an instance of ExternalVpnGatewayClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use ExternalVpnGatewaySettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ExternalVpnGatewayClient create(ExternalVpnGatewayStub stub) {
    return new ExternalVpnGatewayClient(stub);
  }

  /**
   * Constructs an instance of ExternalVpnGatewayClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ExternalVpnGatewayClient(ExternalVpnGatewaySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ExternalVpnGatewayStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ExternalVpnGatewayClient(ExternalVpnGatewayStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ExternalVpnGatewaySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ExternalVpnGatewayStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified externalVpnGateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectGlobalExternalVpnGatewayName externalVpnGateway = ProjectGlobalExternalVpnGatewayName.of("[PROJECT]", "[EXTERNAL_VPN_GATEWAY]");
   *   Operation response = externalVpnGatewayClient.deleteExternalVpnGateway(externalVpnGateway);
   * }
   * </code></pre>
   *
   * @param externalVpnGateway Name of the externalVpnGateways to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteExternalVpnGateway(
      ProjectGlobalExternalVpnGatewayName externalVpnGateway) {

    DeleteExternalVpnGatewayHttpRequest request =
        DeleteExternalVpnGatewayHttpRequest.newBuilder()
            .setExternalVpnGateway(
                externalVpnGateway == null ? null : externalVpnGateway.toString())
            .build();
    return deleteExternalVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified externalVpnGateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectGlobalExternalVpnGatewayName externalVpnGateway = ProjectGlobalExternalVpnGatewayName.of("[PROJECT]", "[EXTERNAL_VPN_GATEWAY]");
   *   Operation response = externalVpnGatewayClient.deleteExternalVpnGateway(externalVpnGateway.toString());
   * }
   * </code></pre>
   *
   * @param externalVpnGateway Name of the externalVpnGateways to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteExternalVpnGateway(String externalVpnGateway) {

    DeleteExternalVpnGatewayHttpRequest request =
        DeleteExternalVpnGatewayHttpRequest.newBuilder()
            .setExternalVpnGateway(externalVpnGateway)
            .build();
    return deleteExternalVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified externalVpnGateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedExternalVpnGateway = ProjectGlobalExternalVpnGatewayName.format("[PROJECT]", "[EXTERNAL_VPN_GATEWAY]");
   *   DeleteExternalVpnGatewayHttpRequest request = DeleteExternalVpnGatewayHttpRequest.newBuilder()
   *     .setExternalVpnGateway(formattedExternalVpnGateway)
   *     .build();
   *   Operation response = externalVpnGatewayClient.deleteExternalVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteExternalVpnGateway(DeleteExternalVpnGatewayHttpRequest request) {
    return deleteExternalVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified externalVpnGateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedExternalVpnGateway = ProjectGlobalExternalVpnGatewayName.format("[PROJECT]", "[EXTERNAL_VPN_GATEWAY]");
   *   DeleteExternalVpnGatewayHttpRequest request = DeleteExternalVpnGatewayHttpRequest.newBuilder()
   *     .setExternalVpnGateway(formattedExternalVpnGateway)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = externalVpnGatewayClient.deleteExternalVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteExternalVpnGatewayHttpRequest, Operation>
      deleteExternalVpnGatewayCallable() {
    return stub.deleteExternalVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified externalVpnGateway. Get a list of available externalVpnGateways by making
   * a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectGlobalExternalVpnGatewayName externalVpnGateway = ProjectGlobalExternalVpnGatewayName.of("[PROJECT]", "[EXTERNAL_VPN_GATEWAY]");
   *   ExternalVpnGateway response = externalVpnGatewayClient.getExternalVpnGateway(externalVpnGateway);
   * }
   * </code></pre>
   *
   * @param externalVpnGateway Name of the externalVpnGateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ExternalVpnGateway getExternalVpnGateway(
      ProjectGlobalExternalVpnGatewayName externalVpnGateway) {

    GetExternalVpnGatewayHttpRequest request =
        GetExternalVpnGatewayHttpRequest.newBuilder()
            .setExternalVpnGateway(
                externalVpnGateway == null ? null : externalVpnGateway.toString())
            .build();
    return getExternalVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified externalVpnGateway. Get a list of available externalVpnGateways by making
   * a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectGlobalExternalVpnGatewayName externalVpnGateway = ProjectGlobalExternalVpnGatewayName.of("[PROJECT]", "[EXTERNAL_VPN_GATEWAY]");
   *   ExternalVpnGateway response = externalVpnGatewayClient.getExternalVpnGateway(externalVpnGateway.toString());
   * }
   * </code></pre>
   *
   * @param externalVpnGateway Name of the externalVpnGateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ExternalVpnGateway getExternalVpnGateway(String externalVpnGateway) {

    GetExternalVpnGatewayHttpRequest request =
        GetExternalVpnGatewayHttpRequest.newBuilder()
            .setExternalVpnGateway(externalVpnGateway)
            .build();
    return getExternalVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified externalVpnGateway. Get a list of available externalVpnGateways by making
   * a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedExternalVpnGateway = ProjectGlobalExternalVpnGatewayName.format("[PROJECT]", "[EXTERNAL_VPN_GATEWAY]");
   *   GetExternalVpnGatewayHttpRequest request = GetExternalVpnGatewayHttpRequest.newBuilder()
   *     .setExternalVpnGateway(formattedExternalVpnGateway)
   *     .build();
   *   ExternalVpnGateway response = externalVpnGatewayClient.getExternalVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ExternalVpnGateway getExternalVpnGateway(GetExternalVpnGatewayHttpRequest request) {
    return getExternalVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified externalVpnGateway. Get a list of available externalVpnGateways by making
   * a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedExternalVpnGateway = ProjectGlobalExternalVpnGatewayName.format("[PROJECT]", "[EXTERNAL_VPN_GATEWAY]");
   *   GetExternalVpnGatewayHttpRequest request = GetExternalVpnGatewayHttpRequest.newBuilder()
   *     .setExternalVpnGateway(formattedExternalVpnGateway)
   *     .build();
   *   ApiFuture&lt;ExternalVpnGateway&gt; future = externalVpnGatewayClient.getExternalVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   ExternalVpnGateway response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
      getExternalVpnGatewayCallable() {
    return stub.getExternalVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ExternalVpnGateway in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ExternalVpnGateway externalVpnGatewayResource = ExternalVpnGateway.newBuilder().build();
   *   Operation response = externalVpnGatewayClient.insertExternalVpnGateway(project, externalVpnGatewayResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param externalVpnGatewayResource External VPN gateway is the on-premises VPN gateway(s) or
   *     another cloud provider?s VPN gateway that connects to your Google Cloud VPN gateway. To
   *     create a highly available VPN from Google Cloud to your on-premises side or another Cloud
   *     provider's VPN gateway, you must create a external VPN gateway resource in GCP, which
   *     provides the information to GCP about your external VPN gateway.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertExternalVpnGateway(
      ProjectName project, ExternalVpnGateway externalVpnGatewayResource) {

    InsertExternalVpnGatewayHttpRequest request =
        InsertExternalVpnGatewayHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setExternalVpnGatewayResource(externalVpnGatewayResource)
            .build();
    return insertExternalVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ExternalVpnGateway in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ExternalVpnGateway externalVpnGatewayResource = ExternalVpnGateway.newBuilder().build();
   *   Operation response = externalVpnGatewayClient.insertExternalVpnGateway(project.toString(), externalVpnGatewayResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param externalVpnGatewayResource External VPN gateway is the on-premises VPN gateway(s) or
   *     another cloud provider?s VPN gateway that connects to your Google Cloud VPN gateway. To
   *     create a highly available VPN from Google Cloud to your on-premises side or another Cloud
   *     provider's VPN gateway, you must create a external VPN gateway resource in GCP, which
   *     provides the information to GCP about your external VPN gateway.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertExternalVpnGateway(
      String project, ExternalVpnGateway externalVpnGatewayResource) {

    InsertExternalVpnGatewayHttpRequest request =
        InsertExternalVpnGatewayHttpRequest.newBuilder()
            .setProject(project)
            .setExternalVpnGatewayResource(externalVpnGatewayResource)
            .build();
    return insertExternalVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ExternalVpnGateway in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ExternalVpnGateway externalVpnGatewayResource = ExternalVpnGateway.newBuilder().build();
   *   InsertExternalVpnGatewayHttpRequest request = InsertExternalVpnGatewayHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .setExternalVpnGatewayResource(externalVpnGatewayResource)
   *     .build();
   *   Operation response = externalVpnGatewayClient.insertExternalVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertExternalVpnGateway(InsertExternalVpnGatewayHttpRequest request) {
    return insertExternalVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ExternalVpnGateway in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ExternalVpnGateway externalVpnGatewayResource = ExternalVpnGateway.newBuilder().build();
   *   InsertExternalVpnGatewayHttpRequest request = InsertExternalVpnGatewayHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .setExternalVpnGatewayResource(externalVpnGatewayResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = externalVpnGatewayClient.insertExternalVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertExternalVpnGatewayHttpRequest, Operation>
      insertExternalVpnGatewayCallable() {
    return stub.insertExternalVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of ExternalVpnGateway available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (ExternalVpnGateway element : externalVpnGatewayClient.listExternalVpnGateways(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListExternalVpnGatewaysPagedResponse listExternalVpnGateways(ProjectName project) {
    ListExternalVpnGatewaysHttpRequest request =
        ListExternalVpnGatewaysHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listExternalVpnGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of ExternalVpnGateway available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (ExternalVpnGateway element : externalVpnGatewayClient.listExternalVpnGateways(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListExternalVpnGatewaysPagedResponse listExternalVpnGateways(String project) {
    ListExternalVpnGatewaysHttpRequest request =
        ListExternalVpnGatewaysHttpRequest.newBuilder().setProject(project).build();
    return listExternalVpnGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of ExternalVpnGateway available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListExternalVpnGatewaysHttpRequest request = ListExternalVpnGatewaysHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (ExternalVpnGateway element : externalVpnGatewayClient.listExternalVpnGateways(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListExternalVpnGatewaysPagedResponse listExternalVpnGateways(
      ListExternalVpnGatewaysHttpRequest request) {
    return listExternalVpnGatewaysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of ExternalVpnGateway available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListExternalVpnGatewaysHttpRequest request = ListExternalVpnGatewaysHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;ListExternalVpnGatewaysPagedResponse&gt; future = externalVpnGatewayClient.listExternalVpnGatewaysPagedCallable().futureCall(request);
   *   // Do something
   *   for (ExternalVpnGateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListExternalVpnGatewaysHttpRequest, ListExternalVpnGatewaysPagedResponse>
      listExternalVpnGatewaysPagedCallable() {
    return stub.listExternalVpnGatewaysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of ExternalVpnGateway available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListExternalVpnGatewaysHttpRequest request = ListExternalVpnGatewaysHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     ExternalVpnGatewayList response = externalVpnGatewayClient.listExternalVpnGatewaysCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList>
      listExternalVpnGatewaysCallable() {
    return stub.listExternalVpnGatewaysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an ExternalVpnGateway. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectGlobalExternalVpnGatewayResourceName resource = ProjectGlobalExternalVpnGatewayResourceName.of("[PROJECT]", "[RESOURCE]");
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   Operation response = externalVpnGatewayClient.setLabelsExternalVpnGateway(resource, globalSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param globalSetLabelsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsExternalVpnGateway(
      ProjectGlobalExternalVpnGatewayResourceName resource,
      GlobalSetLabelsRequest globalSetLabelsRequestResource) {

    SetLabelsExternalVpnGatewayHttpRequest request =
        SetLabelsExternalVpnGatewayHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
            .build();
    return setLabelsExternalVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an ExternalVpnGateway. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectGlobalExternalVpnGatewayResourceName resource = ProjectGlobalExternalVpnGatewayResourceName.of("[PROJECT]", "[RESOURCE]");
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   Operation response = externalVpnGatewayClient.setLabelsExternalVpnGateway(resource.toString(), globalSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param globalSetLabelsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsExternalVpnGateway(
      String resource, GlobalSetLabelsRequest globalSetLabelsRequestResource) {

    SetLabelsExternalVpnGatewayHttpRequest request =
        SetLabelsExternalVpnGatewayHttpRequest.newBuilder()
            .setResource(resource)
            .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
            .build();
    return setLabelsExternalVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an ExternalVpnGateway. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedResource = ProjectGlobalExternalVpnGatewayResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   SetLabelsExternalVpnGatewayHttpRequest request = SetLabelsExternalVpnGatewayHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
   *     .build();
   *   Operation response = externalVpnGatewayClient.setLabelsExternalVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsExternalVpnGateway(
      SetLabelsExternalVpnGatewayHttpRequest request) {
    return setLabelsExternalVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an ExternalVpnGateway. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedResource = ProjectGlobalExternalVpnGatewayResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   SetLabelsExternalVpnGatewayHttpRequest request = SetLabelsExternalVpnGatewayHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = externalVpnGatewayClient.setLabelsExternalVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetLabelsExternalVpnGatewayHttpRequest, Operation>
      setLabelsExternalVpnGatewayCallable() {
    return stub.setLabelsExternalVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectGlobalExternalVpnGatewayResourceName resource = ProjectGlobalExternalVpnGatewayResourceName.of("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = externalVpnGatewayClient.testIamPermissionsExternalVpnGateway(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsExternalVpnGateway(
      ProjectGlobalExternalVpnGatewayResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsExternalVpnGatewayHttpRequest request =
        TestIamPermissionsExternalVpnGatewayHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsExternalVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   ProjectGlobalExternalVpnGatewayResourceName resource = ProjectGlobalExternalVpnGatewayResourceName.of("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = externalVpnGatewayClient.testIamPermissionsExternalVpnGateway(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsExternalVpnGateway(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsExternalVpnGatewayHttpRequest request =
        TestIamPermissionsExternalVpnGatewayHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsExternalVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedResource = ProjectGlobalExternalVpnGatewayResourceName.format("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsExternalVpnGatewayHttpRequest request = TestIamPermissionsExternalVpnGatewayHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = externalVpnGatewayClient.testIamPermissionsExternalVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsExternalVpnGateway(
      TestIamPermissionsExternalVpnGatewayHttpRequest request) {
    return testIamPermissionsExternalVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
   *   String formattedResource = ProjectGlobalExternalVpnGatewayResourceName.format("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsExternalVpnGatewayHttpRequest request = TestIamPermissionsExternalVpnGatewayHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = externalVpnGatewayClient.testIamPermissionsExternalVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsExternalVpnGatewayCallable() {
    return stub.testIamPermissionsExternalVpnGatewayCallable();
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

  public static class ListExternalVpnGatewaysPagedResponse
      extends AbstractPagedListResponse<
          ListExternalVpnGatewaysHttpRequest,
          ExternalVpnGatewayList,
          ExternalVpnGateway,
          ListExternalVpnGatewaysPage,
          ListExternalVpnGatewaysFixedSizeCollection> {

    public static ApiFuture<ListExternalVpnGatewaysPagedResponse> createAsync(
        PageContext<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList, ExternalVpnGateway>
            context,
        ApiFuture<ExternalVpnGatewayList> futureResponse) {
      ApiFuture<ListExternalVpnGatewaysPage> futurePage =
          ListExternalVpnGatewaysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListExternalVpnGatewaysPage, ListExternalVpnGatewaysPagedResponse>() {
            @Override
            public ListExternalVpnGatewaysPagedResponse apply(ListExternalVpnGatewaysPage input) {
              return new ListExternalVpnGatewaysPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListExternalVpnGatewaysPagedResponse(ListExternalVpnGatewaysPage page) {
      super(page, ListExternalVpnGatewaysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExternalVpnGatewaysPage
      extends AbstractPage<
          ListExternalVpnGatewaysHttpRequest,
          ExternalVpnGatewayList,
          ExternalVpnGateway,
          ListExternalVpnGatewaysPage> {

    private ListExternalVpnGatewaysPage(
        PageContext<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList, ExternalVpnGateway>
            context,
        ExternalVpnGatewayList response) {
      super(context, response);
    }

    private static ListExternalVpnGatewaysPage createEmptyPage() {
      return new ListExternalVpnGatewaysPage(null, null);
    }

    @Override
    protected ListExternalVpnGatewaysPage createPage(
        PageContext<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList, ExternalVpnGateway>
            context,
        ExternalVpnGatewayList response) {
      return new ListExternalVpnGatewaysPage(context, response);
    }

    @Override
    public ApiFuture<ListExternalVpnGatewaysPage> createPageAsync(
        PageContext<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList, ExternalVpnGateway>
            context,
        ApiFuture<ExternalVpnGatewayList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExternalVpnGatewaysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExternalVpnGatewaysHttpRequest,
          ExternalVpnGatewayList,
          ExternalVpnGateway,
          ListExternalVpnGatewaysPage,
          ListExternalVpnGatewaysFixedSizeCollection> {

    private ListExternalVpnGatewaysFixedSizeCollection(
        List<ListExternalVpnGatewaysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExternalVpnGatewaysFixedSizeCollection createEmptyCollection() {
      return new ListExternalVpnGatewaysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExternalVpnGatewaysFixedSizeCollection createCollection(
        List<ListExternalVpnGatewaysPage> pages, int collectionSize) {
      return new ListExternalVpnGatewaysFixedSizeCollection(pages, collectionSize);
    }
  }
}
