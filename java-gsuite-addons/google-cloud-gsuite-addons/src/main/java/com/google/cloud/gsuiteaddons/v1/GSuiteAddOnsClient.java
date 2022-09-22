/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.gsuiteaddons.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gsuiteaddons.v1.stub.GSuiteAddOnsStub;
import com.google.cloud.gsuiteaddons.v1.stub.GSuiteAddOnsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for managing Google Workspace Add-ons deployments.
 *
 * <p>A Google Workspace Add-on is a third-party embedded component that can be installed in Google
 * Workspace Applications like Gmail, Calendar, Drive, and the Google Docs, Sheets, and Slides
 * editors. Google Workspace Add-ons can display UI cards, receive contextual information from the
 * host application, and perform actions in the host application (See:
 * https://developers.google.com/gsuite/add-ons/overview for more information).
 *
 * <p>A Google Workspace Add-on deployment resource specifies metadata about the add-on, including a
 * specification of the entry points in the host application that trigger add-on executions (see:
 * https://developers.google.com/gsuite/add-ons/concepts/gsuite-manifests). Add-on deployments
 * defined via the Google Workspace Add-ons API define their entrypoints using HTTPS URLs (See:
 * https://developers.google.com/gsuite/add-ons/guides/alternate-runtimes),
 *
 * <p>A Google Workspace Add-on deployment can be installed in developer mode, which allows an
 * add-on developer to test the experience an end-user would see when installing and running the
 * add-on in their G Suite applications. When running in developer mode, more detailed error
 * messages are exposed in the add-on UI to aid in debugging.
 *
 * <p>A Google Workspace Add-on deployment can be published to Google Workspace Marketplace, which
 * allows other Google Workspace users to discover and install the add-on. See:
 * https://developers.google.com/gsuite/add-ons/how-tos/publish-add-on-overview for details.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
 *   AuthorizationName name = AuthorizationName.of("[PROJECT]");
 *   Authorization response = gSuiteAddOnsClient.getAuthorization(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GSuiteAddOnsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of GSuiteAddOnsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GSuiteAddOnsSettings gSuiteAddOnsSettings =
 *     GSuiteAddOnsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create(gSuiteAddOnsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GSuiteAddOnsSettings gSuiteAddOnsSettings =
 *     GSuiteAddOnsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create(gSuiteAddOnsSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GSuiteAddOnsSettings gSuiteAddOnsSettings =
 *     GSuiteAddOnsSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             GSuiteAddOnsSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create(gSuiteAddOnsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GSuiteAddOnsClient implements BackgroundResource {
  private final GSuiteAddOnsSettings settings;
  private final GSuiteAddOnsStub stub;

  /** Constructs an instance of GSuiteAddOnsClient with default settings. */
  public static final GSuiteAddOnsClient create() throws IOException {
    return create(GSuiteAddOnsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GSuiteAddOnsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GSuiteAddOnsClient create(GSuiteAddOnsSettings settings) throws IOException {
    return new GSuiteAddOnsClient(settings);
  }

  /**
   * Constructs an instance of GSuiteAddOnsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(GSuiteAddOnsSettings).
   */
  public static final GSuiteAddOnsClient create(GSuiteAddOnsStub stub) {
    return new GSuiteAddOnsClient(stub);
  }

  /**
   * Constructs an instance of GSuiteAddOnsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GSuiteAddOnsClient(GSuiteAddOnsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GSuiteAddOnsStubSettings) settings.getStubSettings()).createStub();
  }

  protected GSuiteAddOnsClient(GSuiteAddOnsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GSuiteAddOnsSettings getSettings() {
    return settings;
  }

  public GSuiteAddOnsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the authorization information for deployments in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   AuthorizationName name = AuthorizationName.of("[PROJECT]");
   *   Authorization response = gSuiteAddOnsClient.getAuthorization(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the project for which to get the Google Workspace Add-ons
   *     authorization information.
   *     <p>Example: `projects/my_project/authorization`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Authorization getAuthorization(AuthorizationName name) {
    GetAuthorizationRequest request =
        GetAuthorizationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAuthorization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the authorization information for deployments in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   String name = AuthorizationName.of("[PROJECT]").toString();
   *   Authorization response = gSuiteAddOnsClient.getAuthorization(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the project for which to get the Google Workspace Add-ons
   *     authorization information.
   *     <p>Example: `projects/my_project/authorization`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Authorization getAuthorization(String name) {
    GetAuthorizationRequest request = GetAuthorizationRequest.newBuilder().setName(name).build();
    return getAuthorization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the authorization information for deployments in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   GetAuthorizationRequest request =
   *       GetAuthorizationRequest.newBuilder()
   *           .setName(AuthorizationName.of("[PROJECT]").toString())
   *           .build();
   *   Authorization response = gSuiteAddOnsClient.getAuthorization(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Authorization getAuthorization(GetAuthorizationRequest request) {
    return getAuthorizationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the authorization information for deployments in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   GetAuthorizationRequest request =
   *       GetAuthorizationRequest.newBuilder()
   *           .setName(AuthorizationName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Authorization> future =
   *       gSuiteAddOnsClient.getAuthorizationCallable().futureCall(request);
   *   // Do something.
   *   Authorization response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable() {
    return stub.getAuthorizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment with the specified name and configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response = gSuiteAddOnsClient.createDeployment(parent, deployment, deploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the project in which to create the deployment.
   *     <p>Example: `projects/my_project`.
   * @param deployment Required. The deployment to create (deployment.name cannot be set).
   * @param deploymentId Required. The id to use for this deployment. The full name of the created
   *     resource will be `projects/&lt;project_number&gt;/deployments/&lt;deployment_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(
      ProjectName parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment with the specified name and configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response = gSuiteAddOnsClient.createDeployment(parent, deployment, deploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the project in which to create the deployment.
   *     <p>Example: `projects/my_project`.
   * @param deployment Required. The deployment to create (deployment.name cannot be set).
   * @param deploymentId Required. The id to use for this deployment. The full name of the created
   *     resource will be `projects/&lt;project_number&gt;/deployments/&lt;deployment_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(
      String parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent)
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment with the specified name and configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .build();
   *   Deployment response = gSuiteAddOnsClient.createDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(CreateDeploymentRequest request) {
    return createDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment with the specified name and configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .build();
   *   ApiFuture<Deployment> future =
   *       gSuiteAddOnsClient.createDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return stub.createDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or replaces a deployment with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   Deployment deployment = Deployment.newBuilder().build();
   *   Deployment response = gSuiteAddOnsClient.replaceDeployment(deployment);
   * }
   * }</pre>
   *
   * @param deployment Required. The deployment to create or replace.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment replaceDeployment(Deployment deployment) {
    ReplaceDeploymentRequest request =
        ReplaceDeploymentRequest.newBuilder().setDeployment(deployment).build();
    return replaceDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or replaces a deployment with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   ReplaceDeploymentRequest request =
   *       ReplaceDeploymentRequest.newBuilder()
   *           .setDeployment(Deployment.newBuilder().build())
   *           .build();
   *   Deployment response = gSuiteAddOnsClient.replaceDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment replaceDeployment(ReplaceDeploymentRequest request) {
    return replaceDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or replaces a deployment with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   ReplaceDeploymentRequest request =
   *       ReplaceDeploymentRequest.newBuilder()
   *           .setDeployment(Deployment.newBuilder().build())
   *           .build();
   *   ApiFuture<Deployment> future =
   *       gSuiteAddOnsClient.replaceDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReplaceDeploymentRequest, Deployment> replaceDeploymentCallable() {
    return stub.replaceDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the deployment with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");
   *   Deployment response = gSuiteAddOnsClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the deployment to get.
   *     <p>Example: `projects/my_project/deployments/my_deployment`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(DeploymentName name) {
    GetDeploymentRequest request =
        GetDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the deployment with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString();
   *   Deployment response = gSuiteAddOnsClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the deployment to get.
   *     <p>Example: `projects/my_project/deployments/my_deployment`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(String name) {
    GetDeploymentRequest request = GetDeploymentRequest.newBuilder().setName(name).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the deployment with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
   *           .build();
   *   Deployment response = gSuiteAddOnsClient.getDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(GetDeploymentRequest request) {
    return getDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the deployment with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Deployment> future = gSuiteAddOnsClient.getDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return stub.getDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all deployments in a particular project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Deployment element : gSuiteAddOnsClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the project in which to create the deployment.
   *     <p>Example: `projects/my_project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(ProjectName parent) {
    ListDeploymentsRequest request =
        ListDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all deployments in a particular project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Deployment element : gSuiteAddOnsClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the project in which to create the deployment.
   *     <p>Example: `projects/my_project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(String parent) {
    ListDeploymentsRequest request = ListDeploymentsRequest.newBuilder().setParent(parent).build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all deployments in a particular project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Deployment element : gSuiteAddOnsClient.listDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(ListDeploymentsRequest request) {
    return listDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all deployments in a particular project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Deployment> future =
   *       gSuiteAddOnsClient.listDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Deployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return stub.listDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all deployments in a particular project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDeploymentsResponse response =
   *         gSuiteAddOnsClient.listDeploymentsCallable().call(request);
   *     for (Deployment element : response.getDeploymentsList()) {
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
   * }</pre>
   */
  public final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable() {
    return stub.listDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the deployment with the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");
   *   gSuiteAddOnsClient.deleteDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the deployment to delete.
   *     <p>Example: `projects/my_project/deployments/my_deployment`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeployment(DeploymentName name) {
    DeleteDeploymentRequest request =
        DeleteDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the deployment with the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString();
   *   gSuiteAddOnsClient.deleteDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the deployment to delete.
   *     <p>Example: `projects/my_project/deployments/my_deployment`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeployment(String name) {
    DeleteDeploymentRequest request = DeleteDeploymentRequest.newBuilder().setName(name).build();
    deleteDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the deployment with the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   gSuiteAddOnsClient.deleteDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeployment(DeleteDeploymentRequest request) {
    deleteDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the deployment with the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = gSuiteAddOnsClient.deleteDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    return stub.deleteDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Installs a deployment in developer mode. See:
   * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");
   *   gSuiteAddOnsClient.installDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the deployment to install.
   *     <p>Example: `projects/my_project/deployments/my_deployment`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void installDeployment(DeploymentName name) {
    InstallDeploymentRequest request =
        InstallDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    installDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Installs a deployment in developer mode. See:
   * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString();
   *   gSuiteAddOnsClient.installDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the deployment to install.
   *     <p>Example: `projects/my_project/deployments/my_deployment`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void installDeployment(String name) {
    InstallDeploymentRequest request = InstallDeploymentRequest.newBuilder().setName(name).build();
    installDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Installs a deployment in developer mode. See:
   * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   InstallDeploymentRequest request =
   *       InstallDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
   *           .build();
   *   gSuiteAddOnsClient.installDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void installDeployment(InstallDeploymentRequest request) {
    installDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Installs a deployment in developer mode. See:
   * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   InstallDeploymentRequest request =
   *       InstallDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Empty> future = gSuiteAddOnsClient.installDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InstallDeploymentRequest, Empty> installDeploymentCallable() {
    return stub.installDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uninstalls a developer mode deployment. See:
   * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");
   *   gSuiteAddOnsClient.uninstallDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the deployment to install.
   *     <p>Example: `projects/my_project/deployments/my_deployment`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void uninstallDeployment(DeploymentName name) {
    UninstallDeploymentRequest request =
        UninstallDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    uninstallDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uninstalls a developer mode deployment. See:
   * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString();
   *   gSuiteAddOnsClient.uninstallDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the deployment to install.
   *     <p>Example: `projects/my_project/deployments/my_deployment`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void uninstallDeployment(String name) {
    UninstallDeploymentRequest request =
        UninstallDeploymentRequest.newBuilder().setName(name).build();
    uninstallDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uninstalls a developer mode deployment. See:
   * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   UninstallDeploymentRequest request =
   *       UninstallDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
   *           .build();
   *   gSuiteAddOnsClient.uninstallDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void uninstallDeployment(UninstallDeploymentRequest request) {
    uninstallDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uninstalls a developer mode deployment. See:
   * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   UninstallDeploymentRequest request =
   *       UninstallDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       gSuiteAddOnsClient.uninstallDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UninstallDeploymentRequest, Empty> uninstallDeploymentCallable() {
    return stub.uninstallDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the install status of a developer mode deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   InstallStatusName name = InstallStatusName.of("[PROJECT]", "[DEPLOYMENT]");
   *   InstallStatus response = gSuiteAddOnsClient.getInstallStatus(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the deployment.
   *     <p>Example: `projects/my_project/deployments/my_deployment/installStatus`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstallStatus getInstallStatus(InstallStatusName name) {
    GetInstallStatusRequest request =
        GetInstallStatusRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstallStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the install status of a developer mode deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   String name = InstallStatusName.of("[PROJECT]", "[DEPLOYMENT]").toString();
   *   InstallStatus response = gSuiteAddOnsClient.getInstallStatus(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the deployment.
   *     <p>Example: `projects/my_project/deployments/my_deployment/installStatus`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstallStatus getInstallStatus(String name) {
    GetInstallStatusRequest request = GetInstallStatusRequest.newBuilder().setName(name).build();
    return getInstallStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the install status of a developer mode deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   GetInstallStatusRequest request =
   *       GetInstallStatusRequest.newBuilder()
   *           .setName(InstallStatusName.of("[PROJECT]", "[DEPLOYMENT]").toString())
   *           .build();
   *   InstallStatus response = gSuiteAddOnsClient.getInstallStatus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstallStatus getInstallStatus(GetInstallStatusRequest request) {
    return getInstallStatusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the install status of a developer mode deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
   *   GetInstallStatusRequest request =
   *       GetInstallStatusRequest.newBuilder()
   *           .setName(InstallStatusName.of("[PROJECT]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<InstallStatus> future =
   *       gSuiteAddOnsClient.getInstallStatusCallable().futureCall(request);
   *   // Do something.
   *   InstallStatus response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstallStatusRequest, InstallStatus> getInstallStatusCallable() {
    return stub.getInstallStatusCallable();
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

  public static class ListDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListDeploymentsRequest,
          ListDeploymentsResponse,
          Deployment,
          ListDeploymentsPage,
          ListDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListDeploymentsPagedResponse> createAsync(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ApiFuture<ListDeploymentsResponse> futureResponse) {
      ApiFuture<ListDeploymentsPage> futurePage =
          ListDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeploymentsPagedResponse(ListDeploymentsPage page) {
      super(page, ListDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeploymentsPage
      extends AbstractPage<
          ListDeploymentsRequest, ListDeploymentsResponse, Deployment, ListDeploymentsPage> {

    private ListDeploymentsPage(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ListDeploymentsResponse response) {
      super(context, response);
    }

    private static ListDeploymentsPage createEmptyPage() {
      return new ListDeploymentsPage(null, null);
    }

    @Override
    protected ListDeploymentsPage createPage(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ListDeploymentsResponse response) {
      return new ListDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListDeploymentsPage> createPageAsync(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ApiFuture<ListDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeploymentsRequest,
          ListDeploymentsResponse,
          Deployment,
          ListDeploymentsPage,
          ListDeploymentsFixedSizeCollection> {

    private ListDeploymentsFixedSizeCollection(
        List<ListDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeploymentsFixedSizeCollection createCollection(
        List<ListDeploymentsPage> pages, int collectionSize) {
      return new ListDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
