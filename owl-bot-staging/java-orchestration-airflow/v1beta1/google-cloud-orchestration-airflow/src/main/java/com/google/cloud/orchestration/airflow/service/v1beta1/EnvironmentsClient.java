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

package com.google.cloud.orchestration.airflow.service.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.orchestration.airflow.service.v1beta1.stub.EnvironmentsStub;
import com.google.cloud.orchestration.airflow.service.v1beta1.stub.EnvironmentsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Managed Apache Airflow Environments.
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
 * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
 *   String name = "name3373707";
 *   Environment response = environmentsClient.getEnvironment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EnvironmentsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of EnvironmentsSettings to
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
 * EnvironmentsSettings environmentsSettings =
 *     EnvironmentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EnvironmentsClient environmentsClient = EnvironmentsClient.create(environmentsSettings);
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
 * EnvironmentsSettings environmentsSettings =
 *     EnvironmentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EnvironmentsClient environmentsClient = EnvironmentsClient.create(environmentsSettings);
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
 * EnvironmentsSettings environmentsSettings = EnvironmentsSettings.newHttpJsonBuilder().build();
 * EnvironmentsClient environmentsClient = EnvironmentsClient.create(environmentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EnvironmentsClient implements BackgroundResource {
  private final EnvironmentsSettings settings;
  private final EnvironmentsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of EnvironmentsClient with default settings. */
  public static final EnvironmentsClient create() throws IOException {
    return create(EnvironmentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EnvironmentsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EnvironmentsClient create(EnvironmentsSettings settings) throws IOException {
    return new EnvironmentsClient(settings);
  }

  /**
   * Constructs an instance of EnvironmentsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(EnvironmentsSettings).
   */
  public static final EnvironmentsClient create(EnvironmentsStub stub) {
    return new EnvironmentsClient(stub);
  }

  /**
   * Constructs an instance of EnvironmentsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EnvironmentsClient(EnvironmentsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EnvironmentsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected EnvironmentsClient(EnvironmentsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final EnvironmentsSettings getSettings() {
    return settings;
  }

  public EnvironmentsStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String parent = "parent-995424086";
   *   Environment environment = Environment.newBuilder().build();
   *   Environment response = environmentsClient.createEnvironmentAsync(parent, environment).get();
   * }
   * }</pre>
   *
   * @param parent The parent must be of the form "projects/{projectId}/locations/{locationId}".
   * @param environment The environment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> createEnvironmentAsync(
      String parent, Environment environment) {
    CreateEnvironmentRequest request =
        CreateEnvironmentRequest.newBuilder().setParent(parent).setEnvironment(environment).build();
    return createEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .build();
   *   Environment response = environmentsClient.createEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> createEnvironmentAsync(
      CreateEnvironmentRequest request) {
    return createEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .build();
   *   OperationFuture<Environment, OperationMetadata> future =
   *       environmentsClient.createEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable() {
    return stub.createEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       environmentsClient.createEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    return stub.createEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an existing environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String name = "name3373707";
   *   Environment response = environmentsClient.getEnvironment(name);
   * }
   * }</pre>
   *
   * @param name The resource name of the environment to get, in the form:
   *     "projects/{projectId}/locations/{locationId}/environments/{environmentId}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(String name) {
    GetEnvironmentRequest request = GetEnvironmentRequest.newBuilder().setName(name).build();
    return getEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an existing environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   GetEnvironmentRequest request =
   *       GetEnvironmentRequest.newBuilder().setName("name3373707").build();
   *   Environment response = environmentsClient.getEnvironment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(GetEnvironmentRequest request) {
    return getEnvironmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an existing environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   GetEnvironmentRequest request =
   *       GetEnvironmentRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Environment> future =
   *       environmentsClient.getEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return stub.getEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List environments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Environment element : environmentsClient.listEnvironments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent List environments in the given project and location, in the form:
   *     "projects/{projectId}/locations/{locationId}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(String parent) {
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder().setParent(parent).build();
    return listEnvironments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List environments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Environment element : environmentsClient.listEnvironments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(ListEnvironmentsRequest request) {
    return listEnvironmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List environments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Environment> future =
   *       environmentsClient.listEnvironmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Environment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    return stub.listEnvironmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List environments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEnvironmentsResponse response =
   *         environmentsClient.listEnvironmentsCallable().call(request);
   *     for (Environment element : response.getEnvironmentsList()) {
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
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    return stub.listEnvironmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String name = "name3373707";
   *   Environment environment = Environment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Environment response =
   *       environmentsClient.updateEnvironmentAsync(name, environment, updateMask).get();
   * }
   * }</pre>
   *
   * @param name The relative resource name of the environment to update, in the form:
   *     "projects/{projectId}/locations/{locationId}/environments/{environmentId}"
   * @param environment A patch environment. Fields specified by the `updateMask` will be copied
   *     from the patch environment into the environment under update.
   * @param updateMask Required. A comma-separated list of paths, relative to `Environment`, of
   *     fields to update. For example, to set the version of scikit-learn to install in the
   *     environment to 0.19.0 and to remove an existing installation of argparse, the `updateMask`
   *     parameter would include the following two `paths` values:
   *     "config.softwareConfig.pypiPackages.scikit-learn" and
   *     "config.softwareConfig.pypiPackages.argparse". The included patch environment would specify
   *     the scikit-learn version as follows:
   *     <p>{ "config":{ "softwareConfig":{ "pypiPackages":{ "scikit-learn":"==0.19.0" } } } }
   *     <p>Note that in the above example, any existing PyPI packages other than scikit-learn and
   *     argparse will be unaffected.
   *     <p>Only one update type may be included in a single request's `updateMask`. For example,
   *     one cannot update both the PyPI packages and labels in the same request. However, it is
   *     possible to update multiple members of a map field simultaneously in the same request. For
   *     example, to set the labels "label1" and "label2" while clearing "label3" (assuming it
   *     already exists), one can provide the paths "labels.label1", "labels.label2", and
   *     "labels.label3" and populate the patch environment as follows:
   *     <p>{ "labels":{ "label1":"new-label1-value" "label2":"new-label2-value" } }
   *     <p>Note that in the above example, any existing labels that are not included in the
   *     `updateMask` will be unaffected.
   *     <p>It is also possible to replace an entire map field by providing the map field's path in
   *     the `updateMask`. The new value of the field will be that which is provided in the patch
   *     environment. For example, to delete all pre-existing user-specified PyPI packages and
   *     install botocore at version 1.7.14, the `updateMask` would contain the path
   *     "config.softwareConfig.pypiPackages", and the patch environment would be the following:
   *     <p>{ "config":{ "softwareConfig":{ "pypiPackages":{ "botocore":"==1.7.14" } } } }
   *     <p>&#42;&#42;Note:&#42;&#42; Only the following fields can be updated:
   *     <ul>
   *       <li>`config.softwareConfig.pypiPackages` &#42; Replace all custom custom PyPI packages.
   *           If a replacement package map is not included in `environment`, all custom PyPI
   *           packages are cleared. It is an error to provide both this mask and a mask specifying
   *           an individual package.
   *       <li>`config.softwareConfig.pypiPackages.`packagename &#42; Update the custom PyPI package
   *           &#42;packagename&#42;, preserving other packages. To delete the package, include it
   *           in `updateMask`, and omit the mapping for it in
   *           `environment.config.softwareConfig.pypiPackages`. It is an error to provide both a
   *           mask of this form and the `config.softwareConfig.pypiPackages` mask.
   *       <li>`labels` &#42; Replace all environment labels. If a replacement labels map is not
   *           included in `environment`, all labels are cleared. It is an error to provide both
   *           this mask and a mask specifying one or more individual labels.
   *       <li>`labels.`labelName &#42; Set the label named &#42;labelName&#42;, while preserving
   *           other labels. To delete the label, include it in `updateMask` and omit its mapping in
   *           `environment.labels`. It is an error to provide both a mask of this form and the
   *           `labels` mask.
   *       <li>`config.nodeCount` &#42; Horizontally scale the number of nodes in the environment.
   *           An integer greater than or equal to 3 must be provided in the `config.nodeCount`
   *           field. Supported for Cloud Composer environments in versions
   *           composer-1.&#42;.&#42;-airflow-&#42;.&#42;.&#42;.
   *       <li>`config.webServerNetworkAccessControl` &#42; Replace the environment's current
   *           WebServerNetworkAccessControl.
   *       <li>`config.softwareConfig.airflowConfigOverrides` &#42; Replace all Apache Airflow
   *           config overrides. If a replacement config overrides map is not included in
   *           `environment`, all config overrides are cleared. It is an error to provide both this
   *           mask and a mask specifying one or more individual config overrides.
   *       <li>`config.softwareConfig.airflowConfigOverrides.`section-name &#42; Override the Apache
   *           Airflow config property &#42;name&#42; in the section named &#42;section&#42;,
   *           preserving other properties. To delete the property override, include it in
   *           `updateMask` and omit its mapping in
   *           `environment.config.softwareConfig.airflowConfigOverrides`. It is an error to provide
   *           both a mask of this form and the `config.softwareConfig.airflowConfigOverrides` mask.
   *       <li>`config.softwareConfig.envVariables` &#42; Replace all environment variables. If a
   *           replacement environment variable map is not included in `environment`, all custom
   *           environment variables are cleared.
   *       <li>`config.softwareConfig.imageVersion` &#42; Upgrade the version of the environment
   *           in-place. Refer to `SoftwareConfig.image_version` for information on how to format
   *           the new image version. Additionally, the new image version cannot effect a version
   *           downgrade, and must match the current image version's Composer and Airflow major
   *           versions. Consult the [Cloud Composer version
   *           list](/composer/docs/concepts/versioning/composer-versions) for valid values.
   *       <li>`config.softwareConfig.schedulerCount` &#42; Horizontally scale the number of
   *           schedulers in Airflow. A positive integer not greater than the number of nodes must
   *           be provided in the `config.softwareConfig.schedulerCount` field. Supported for Cloud
   *           Composer environments in versions composer-1.&#42;.&#42;-airflow-2.&#42;.&#42;.
   *       <li>`config.softwareConfig.cloudDataLineageIntegration` &#42; Configuration for Cloud
   *           Data Lineage integration.
   *       <li>`config.databaseConfig.machineType` &#42; Cloud SQL machine type used by Airflow
   *           database. It has to be one of: db-n1-standard-2, db-n1-standard-4, db-n1-standard-8
   *           or db-n1-standard-16. Supported for Cloud Composer environments in versions
   *           composer-1.&#42;.&#42;-airflow-&#42;.&#42;.&#42;.
   *       <li>`config.webServerConfig.machineType` &#42; Machine type on which Airflow web server
   *           is running. It has to be one of: composer-n1-webserver-2, composer-n1-webserver-4 or
   *           composer-n1-webserver-8. Supported for Cloud Composer environments in versions
   *           composer-1.&#42;.&#42;-airflow-&#42;.&#42;.&#42;.
   *       <li>`config.maintenanceWindow` &#42; Maintenance window during which Cloud Composer
   *           components may be under maintenance.
   *       <li>`config.workloadsConfig` &#42; The workloads configuration settings for the GKE
   *           cluster associated with the Cloud Composer environment. Supported for Cloud Composer
   *           environments in versions composer-2.&#42;.&#42;-airflow-&#42;.&#42;.&#42; and newer.
   *       <li>`config.environmentSize` &#42; The size of the Cloud Composer environment. Supported
   *           for Cloud Composer environments in versions
   *           composer-2.&#42;.&#42;-airflow-&#42;.&#42;.&#42; and newer.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> updateEnvironmentAsync(
      String name, Environment environment, FieldMask updateMask) {
    UpdateEnvironmentRequest request =
        UpdateEnvironmentRequest.newBuilder()
            .setName(name)
            .setEnvironment(environment)
            .setUpdateMask(updateMask)
            .build();
    return updateEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   UpdateEnvironmentRequest request =
   *       UpdateEnvironmentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Environment response = environmentsClient.updateEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> updateEnvironmentAsync(
      UpdateEnvironmentRequest request) {
    return updateEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   UpdateEnvironmentRequest request =
   *       UpdateEnvironmentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Environment, OperationMetadata> future =
   *       environmentsClient.updateEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationCallable() {
    return stub.updateEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   UpdateEnvironmentRequest request =
   *       UpdateEnvironmentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       environmentsClient.updateEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable() {
    return stub.updateEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String name = "name3373707";
   *   environmentsClient.deleteEnvironmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name The environment to delete, in the form:
   *     "projects/{projectId}/locations/{locationId}/environments/{environmentId}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEnvironmentAsync(String name) {
    DeleteEnvironmentRequest request = DeleteEnvironmentRequest.newBuilder().setName(name).build();
    return deleteEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder().setName("name3373707").build();
   *   environmentsClient.deleteEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEnvironmentAsync(
      DeleteEnvironmentRequest request) {
    return deleteEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       environmentsClient.deleteEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable() {
    return stub.deleteEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       environmentsClient.deleteEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable() {
    return stub.deleteEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart Airflow web server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   RestartWebServerRequest request =
   *       RestartWebServerRequest.newBuilder().setName("name3373707").build();
   *   Environment response = environmentsClient.restartWebServerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> restartWebServerAsync(
      RestartWebServerRequest request) {
    return restartWebServerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart Airflow web server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   RestartWebServerRequest request =
   *       RestartWebServerRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Environment, OperationMetadata> future =
   *       environmentsClient.restartWebServerOperationCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RestartWebServerRequest, Environment, OperationMetadata>
      restartWebServerOperationCallable() {
    return stub.restartWebServerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart Airflow web server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   RestartWebServerRequest request =
   *       RestartWebServerRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       environmentsClient.restartWebServerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestartWebServerRequest, Operation> restartWebServerCallable() {
    return stub.restartWebServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if an upgrade operation on the environment will succeed.
   *
   * <p>In case of problems detailed info can be found in the returned Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   CheckUpgradeRequest request =
   *       CheckUpgradeRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setImageVersion("imageVersion949870333")
   *           .build();
   *   CheckUpgradeResponse response = environmentsClient.checkUpgradeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CheckUpgradeResponse, OperationMetadata> checkUpgradeAsync(
      CheckUpgradeRequest request) {
    return checkUpgradeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if an upgrade operation on the environment will succeed.
   *
   * <p>In case of problems detailed info can be found in the returned Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   CheckUpgradeRequest request =
   *       CheckUpgradeRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setImageVersion("imageVersion949870333")
   *           .build();
   *   OperationFuture<CheckUpgradeResponse, OperationMetadata> future =
   *       environmentsClient.checkUpgradeOperationCallable().futureCall(request);
   *   // Do something.
   *   CheckUpgradeResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
      checkUpgradeOperationCallable() {
    return stub.checkUpgradeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if an upgrade operation on the environment will succeed.
   *
   * <p>In case of problems detailed info can be found in the returned Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   CheckUpgradeRequest request =
   *       CheckUpgradeRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setImageVersion("imageVersion949870333")
   *           .build();
   *   ApiFuture<Operation> future = environmentsClient.checkUpgradeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CheckUpgradeRequest, Operation> checkUpgradeCallable() {
    return stub.checkUpgradeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshots of a Cloud Composer environment.
   *
   * <p>As a result of this operation, snapshot of environment's state is stored in a location
   * specified in the SaveSnapshotRequest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   SaveSnapshotRequest request =
   *       SaveSnapshotRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setSnapshotLocation("snapshotLocation1625609625")
   *           .build();
   *   SaveSnapshotResponse response = environmentsClient.saveSnapshotAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SaveSnapshotResponse, OperationMetadata> saveSnapshotAsync(
      SaveSnapshotRequest request) {
    return saveSnapshotOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshots of a Cloud Composer environment.
   *
   * <p>As a result of this operation, snapshot of environment's state is stored in a location
   * specified in the SaveSnapshotRequest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   SaveSnapshotRequest request =
   *       SaveSnapshotRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setSnapshotLocation("snapshotLocation1625609625")
   *           .build();
   *   OperationFuture<SaveSnapshotResponse, OperationMetadata> future =
   *       environmentsClient.saveSnapshotOperationCallable().futureCall(request);
   *   // Do something.
   *   SaveSnapshotResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SaveSnapshotRequest, SaveSnapshotResponse, OperationMetadata>
      saveSnapshotOperationCallable() {
    return stub.saveSnapshotOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshots of a Cloud Composer environment.
   *
   * <p>As a result of this operation, snapshot of environment's state is stored in a location
   * specified in the SaveSnapshotRequest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   SaveSnapshotRequest request =
   *       SaveSnapshotRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setSnapshotLocation("snapshotLocation1625609625")
   *           .build();
   *   ApiFuture<Operation> future = environmentsClient.saveSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SaveSnapshotRequest, Operation> saveSnapshotCallable() {
    return stub.saveSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Loads a snapshot of a Cloud Composer environment.
   *
   * <p>As a result of this operation, a snapshot of environment's specified in LoadSnapshotRequest
   * is loaded into the environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   LoadSnapshotRequest request =
   *       LoadSnapshotRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setSnapshotPath("snapshotPath-931648503")
   *           .setSkipPypiPackagesInstallation(true)
   *           .setSkipEnvironmentVariablesSetting(true)
   *           .setSkipAirflowOverridesSetting(true)
   *           .setSkipGcsDataCopying(true)
   *           .build();
   *   LoadSnapshotResponse response = environmentsClient.loadSnapshotAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LoadSnapshotResponse, OperationMetadata> loadSnapshotAsync(
      LoadSnapshotRequest request) {
    return loadSnapshotOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Loads a snapshot of a Cloud Composer environment.
   *
   * <p>As a result of this operation, a snapshot of environment's specified in LoadSnapshotRequest
   * is loaded into the environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   LoadSnapshotRequest request =
   *       LoadSnapshotRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setSnapshotPath("snapshotPath-931648503")
   *           .setSkipPypiPackagesInstallation(true)
   *           .setSkipEnvironmentVariablesSetting(true)
   *           .setSkipAirflowOverridesSetting(true)
   *           .setSkipGcsDataCopying(true)
   *           .build();
   *   OperationFuture<LoadSnapshotResponse, OperationMetadata> future =
   *       environmentsClient.loadSnapshotOperationCallable().futureCall(request);
   *   // Do something.
   *   LoadSnapshotResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<LoadSnapshotRequest, LoadSnapshotResponse, OperationMetadata>
      loadSnapshotOperationCallable() {
    return stub.loadSnapshotOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Loads a snapshot of a Cloud Composer environment.
   *
   * <p>As a result of this operation, a snapshot of environment's specified in LoadSnapshotRequest
   * is loaded into the environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   LoadSnapshotRequest request =
   *       LoadSnapshotRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setSnapshotPath("snapshotPath-931648503")
   *           .setSkipPypiPackagesInstallation(true)
   *           .setSkipEnvironmentVariablesSetting(true)
   *           .setSkipAirflowOverridesSetting(true)
   *           .setSkipGcsDataCopying(true)
   *           .build();
   *   ApiFuture<Operation> future = environmentsClient.loadSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LoadSnapshotRequest, Operation> loadSnapshotCallable() {
    return stub.loadSnapshotCallable();
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

  public static class ListEnvironmentsPagedResponse
      extends AbstractPagedListResponse<
          ListEnvironmentsRequest,
          ListEnvironmentsResponse,
          Environment,
          ListEnvironmentsPage,
          ListEnvironmentsFixedSizeCollection> {

    public static ApiFuture<ListEnvironmentsPagedResponse> createAsync(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ApiFuture<ListEnvironmentsResponse> futureResponse) {
      ApiFuture<ListEnvironmentsPage> futurePage =
          ListEnvironmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEnvironmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEnvironmentsPagedResponse(ListEnvironmentsPage page) {
      super(page, ListEnvironmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEnvironmentsPage
      extends AbstractPage<
          ListEnvironmentsRequest, ListEnvironmentsResponse, Environment, ListEnvironmentsPage> {

    private ListEnvironmentsPage(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ListEnvironmentsResponse response) {
      super(context, response);
    }

    private static ListEnvironmentsPage createEmptyPage() {
      return new ListEnvironmentsPage(null, null);
    }

    @Override
    protected ListEnvironmentsPage createPage(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ListEnvironmentsResponse response) {
      return new ListEnvironmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListEnvironmentsPage> createPageAsync(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ApiFuture<ListEnvironmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEnvironmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEnvironmentsRequest,
          ListEnvironmentsResponse,
          Environment,
          ListEnvironmentsPage,
          ListEnvironmentsFixedSizeCollection> {

    private ListEnvironmentsFixedSizeCollection(
        List<ListEnvironmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEnvironmentsFixedSizeCollection createEmptyCollection() {
      return new ListEnvironmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEnvironmentsFixedSizeCollection createCollection(
        List<ListEnvironmentsPage> pages, int collectionSize) {
      return new ListEnvironmentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
