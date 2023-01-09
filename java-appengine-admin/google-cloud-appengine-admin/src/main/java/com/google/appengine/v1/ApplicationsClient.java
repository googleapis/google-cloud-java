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

package com.google.appengine.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.stub.ApplicationsStub;
import com.google.appengine.v1.stub.ApplicationsStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages App Engine applications.
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
 * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
 *   String name = "name3373707";
 *   Application response = applicationsClient.getApplication(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ApplicationsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ApplicationsSettings to
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
 * ApplicationsSettings applicationsSettings =
 *     ApplicationsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ApplicationsClient applicationsClient = ApplicationsClient.create(applicationsSettings);
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
 * ApplicationsSettings applicationsSettings =
 *     ApplicationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ApplicationsClient applicationsClient = ApplicationsClient.create(applicationsSettings);
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
 * ApplicationsSettings applicationsSettings = ApplicationsSettings.newHttpJsonBuilder().build();
 * ApplicationsClient applicationsClient = ApplicationsClient.create(applicationsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ApplicationsClient implements BackgroundResource {
  private final ApplicationsSettings settings;
  private final ApplicationsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ApplicationsClient with default settings. */
  public static final ApplicationsClient create() throws IOException {
    return create(ApplicationsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ApplicationsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ApplicationsClient create(ApplicationsSettings settings) throws IOException {
    return new ApplicationsClient(settings);
  }

  /**
   * Constructs an instance of ApplicationsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ApplicationsSettings).
   */
  public static final ApplicationsClient create(ApplicationsStub stub) {
    return new ApplicationsClient(stub);
  }

  /**
   * Constructs an instance of ApplicationsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ApplicationsClient(ApplicationsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ApplicationsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ApplicationsClient(ApplicationsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ApplicationsSettings getSettings() {
    return settings;
  }

  public ApplicationsStub getStub() {
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
   * Gets information about an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   String name = "name3373707";
   *   Application response = applicationsClient.getApplication(name);
   * }
   * }</pre>
   *
   * @param name Name of the Application resource to get. Example: `apps/myapp`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(String name) {
    GetApplicationRequest request = GetApplicationRequest.newBuilder().setName(name).build();
    return getApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   GetApplicationRequest request =
   *       GetApplicationRequest.newBuilder().setName("name3373707").build();
   *   Application response = applicationsClient.getApplication(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(GetApplicationRequest request) {
    return getApplicationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   GetApplicationRequest request =
   *       GetApplicationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Application> future =
   *       applicationsClient.getApplicationCallable().futureCall(request);
   *   // Do something.
   *   Application response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return stub.getApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an App Engine application for a Google Cloud Platform project. Required fields:
   *
   * <ul>
   *   <li>`id` - The ID of the target Cloud Platform project.
   *   <li>&#42;location&#42; - The [region](https://cloud.google.com/appengine/docs/locations)
   *       where you want the App Engine application located.
   * </ul>
   *
   * <p>For more information about App Engine applications, see [Managing Projects, Applications,
   * and Billing](https://cloud.google.com/appengine/docs/standard/python/console/).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setApplication(Application.newBuilder().build())
   *           .build();
   *   Application response = applicationsClient.createApplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Application, OperationMetadataV1> createApplicationAsync(
      CreateApplicationRequest request) {
    return createApplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an App Engine application for a Google Cloud Platform project. Required fields:
   *
   * <ul>
   *   <li>`id` - The ID of the target Cloud Platform project.
   *   <li>&#42;location&#42; - The [region](https://cloud.google.com/appengine/docs/locations)
   *       where you want the App Engine application located.
   * </ul>
   *
   * <p>For more information about App Engine applications, see [Managing Projects, Applications,
   * and Billing](https://cloud.google.com/appengine/docs/standard/python/console/).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setApplication(Application.newBuilder().build())
   *           .build();
   *   OperationFuture<Application, OperationMetadataV1> future =
   *       applicationsClient.createApplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   Application response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateApplicationRequest, Application, OperationMetadataV1>
      createApplicationOperationCallable() {
    return stub.createApplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an App Engine application for a Google Cloud Platform project. Required fields:
   *
   * <ul>
   *   <li>`id` - The ID of the target Cloud Platform project.
   *   <li>&#42;location&#42; - The [region](https://cloud.google.com/appengine/docs/locations)
   *       where you want the App Engine application located.
   * </ul>
   *
   * <p>For more information about App Engine applications, see [Managing Projects, Applications,
   * and Billing](https://cloud.google.com/appengine/docs/standard/python/console/).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setApplication(Application.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       applicationsClient.createApplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable() {
    return stub.createApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified Application resource. You can update the following fields:
   *
   * <ul>
   *   <li>`auth_domain` - Google authentication domain for controlling user access to the
   *       application.
   *   <li>`default_cookie_expiration` - Cookie expiration policy for the application.
   *   <li>`iap` - Identity-Aware Proxy properties for the application.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setName("name3373707")
   *           .setApplication(Application.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Application response = applicationsClient.updateApplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Application, OperationMetadataV1> updateApplicationAsync(
      UpdateApplicationRequest request) {
    return updateApplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified Application resource. You can update the following fields:
   *
   * <ul>
   *   <li>`auth_domain` - Google authentication domain for controlling user access to the
   *       application.
   *   <li>`default_cookie_expiration` - Cookie expiration policy for the application.
   *   <li>`iap` - Identity-Aware Proxy properties for the application.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setName("name3373707")
   *           .setApplication(Application.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Application, OperationMetadataV1> future =
   *       applicationsClient.updateApplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   Application response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateApplicationRequest, Application, OperationMetadataV1>
      updateApplicationOperationCallable() {
    return stub.updateApplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified Application resource. You can update the following fields:
   *
   * <ul>
   *   <li>`auth_domain` - Google authentication domain for controlling user access to the
   *       application.
   *   <li>`default_cookie_expiration` - Cookie expiration policy for the application.
   *   <li>`iap` - Identity-Aware Proxy properties for the application.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setName("name3373707")
   *           .setApplication(Application.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       applicationsClient.updateApplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable() {
    return stub.updateApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Recreates the required App Engine features for the specified App Engine application, for
   * example a Cloud Storage bucket or App Engine service account. Use this method if you receive an
   * error message about a missing feature, for example, &#42;Error retrieving the App Engine
   * service account&#42;. If you have deleted your App Engine service account, this will not be
   * able to recreate it. Instead, you should attempt to use the IAM undelete API if possible at
   * https://cloud.google.com/iam/reference/rest/v1/projects.serviceAccounts/undelete?apix_params=%7B"name"%3A"projects%2F-%2FserviceAccounts%2Funique_id"%2C"resource"%3A%7B%7D%7D
   * . If the deletion was recent, the numeric ID can be found in the Cloud Console Activity Log.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   RepairApplicationRequest request =
   *       RepairApplicationRequest.newBuilder().setName("name3373707").build();
   *   Application response = applicationsClient.repairApplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Application, OperationMetadataV1> repairApplicationAsync(
      RepairApplicationRequest request) {
    return repairApplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Recreates the required App Engine features for the specified App Engine application, for
   * example a Cloud Storage bucket or App Engine service account. Use this method if you receive an
   * error message about a missing feature, for example, &#42;Error retrieving the App Engine
   * service account&#42;. If you have deleted your App Engine service account, this will not be
   * able to recreate it. Instead, you should attempt to use the IAM undelete API if possible at
   * https://cloud.google.com/iam/reference/rest/v1/projects.serviceAccounts/undelete?apix_params=%7B"name"%3A"projects%2F-%2FserviceAccounts%2Funique_id"%2C"resource"%3A%7B%7D%7D
   * . If the deletion was recent, the numeric ID can be found in the Cloud Console Activity Log.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   RepairApplicationRequest request =
   *       RepairApplicationRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Application, OperationMetadataV1> future =
   *       applicationsClient.repairApplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   Application response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RepairApplicationRequest, Application, OperationMetadataV1>
      repairApplicationOperationCallable() {
    return stub.repairApplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Recreates the required App Engine features for the specified App Engine application, for
   * example a Cloud Storage bucket or App Engine service account. Use this method if you receive an
   * error message about a missing feature, for example, &#42;Error retrieving the App Engine
   * service account&#42;. If you have deleted your App Engine service account, this will not be
   * able to recreate it. Instead, you should attempt to use the IAM undelete API if possible at
   * https://cloud.google.com/iam/reference/rest/v1/projects.serviceAccounts/undelete?apix_params=%7B"name"%3A"projects%2F-%2FserviceAccounts%2Funique_id"%2C"resource"%3A%7B%7D%7D
   * . If the deletion was recent, the numeric ID can be found in the Cloud Console Activity Log.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
   *   RepairApplicationRequest request =
   *       RepairApplicationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       applicationsClient.repairApplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RepairApplicationRequest, Operation> repairApplicationCallable() {
    return stub.repairApplicationCallable();
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
}
