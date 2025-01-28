/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.retail.v2beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.stub.ProjectServiceStub;
import com.google.cloud.retail.v2beta.stub.ProjectServiceStubSettings;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for settings at Project level.
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
 * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
 *   AlertConfigName name = AlertConfigName.of("[PROJECT]");
 *   AlertConfig response = projectServiceClient.getAlertConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProjectServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetAlertConfig</td>
 *      <td><p> Get the [AlertConfig][google.cloud.retail.v2beta.AlertConfig] of the requested project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAlertConfig(GetAlertConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAlertConfig(AlertConfigName name)
 *           <li><p> getAlertConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAlertConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAlertConfig</td>
 *      <td><p> Update the alert config of the requested project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAlertConfig(UpdateAlertConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAlertConfig(AlertConfig alertConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAlertConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ProjectServiceSettings to
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
 * ProjectServiceSettings projectServiceSettings =
 *     ProjectServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProjectServiceClient projectServiceClient = ProjectServiceClient.create(projectServiceSettings);
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
 * ProjectServiceSettings projectServiceSettings =
 *     ProjectServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProjectServiceClient projectServiceClient = ProjectServiceClient.create(projectServiceSettings);
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
 * ProjectServiceSettings projectServiceSettings =
 *     ProjectServiceSettings.newHttpJsonBuilder().build();
 * ProjectServiceClient projectServiceClient = ProjectServiceClient.create(projectServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProjectServiceClient implements BackgroundResource {
  private final ProjectServiceSettings settings;
  private final ProjectServiceStub stub;

  /** Constructs an instance of ProjectServiceClient with default settings. */
  public static final ProjectServiceClient create() throws IOException {
    return create(ProjectServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProjectServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProjectServiceClient create(ProjectServiceSettings settings)
      throws IOException {
    return new ProjectServiceClient(settings);
  }

  /**
   * Constructs an instance of ProjectServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ProjectServiceSettings).
   */
  public static final ProjectServiceClient create(ProjectServiceStub stub) {
    return new ProjectServiceClient(stub);
  }

  /**
   * Constructs an instance of ProjectServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ProjectServiceClient(ProjectServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProjectServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ProjectServiceClient(ProjectServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ProjectServiceSettings getSettings() {
    return settings;
  }

  public ProjectServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the [AlertConfig][google.cloud.retail.v2beta.AlertConfig] of the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   AlertConfigName name = AlertConfigName.of("[PROJECT]");
   *   AlertConfig response = projectServiceClient.getAlertConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full AlertConfig resource name. Format:
   *     projects/{project_number}/alertConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AlertConfig getAlertConfig(AlertConfigName name) {
    GetAlertConfigRequest request =
        GetAlertConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAlertConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the [AlertConfig][google.cloud.retail.v2beta.AlertConfig] of the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   String name = AlertConfigName.of("[PROJECT]").toString();
   *   AlertConfig response = projectServiceClient.getAlertConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full AlertConfig resource name. Format:
   *     projects/{project_number}/alertConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AlertConfig getAlertConfig(String name) {
    GetAlertConfigRequest request = GetAlertConfigRequest.newBuilder().setName(name).build();
    return getAlertConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the [AlertConfig][google.cloud.retail.v2beta.AlertConfig] of the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   GetAlertConfigRequest request =
   *       GetAlertConfigRequest.newBuilder()
   *           .setName(AlertConfigName.of("[PROJECT]").toString())
   *           .build();
   *   AlertConfig response = projectServiceClient.getAlertConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AlertConfig getAlertConfig(GetAlertConfigRequest request) {
    return getAlertConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the [AlertConfig][google.cloud.retail.v2beta.AlertConfig] of the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   GetAlertConfigRequest request =
   *       GetAlertConfigRequest.newBuilder()
   *           .setName(AlertConfigName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<AlertConfig> future =
   *       projectServiceClient.getAlertConfigCallable().futureCall(request);
   *   // Do something.
   *   AlertConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAlertConfigRequest, AlertConfig> getAlertConfigCallable() {
    return stub.getAlertConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the alert config of the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   AlertConfig alertConfig = AlertConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AlertConfig response = projectServiceClient.updateAlertConfig(alertConfig, updateMask);
   * }
   * }</pre>
   *
   * @param alertConfig Required. The [AlertConfig][google.cloud.retail.v2beta.AlertConfig] to
   *     update.
   *     <p>If the caller does not have permission to update the
   *     [AlertConfig][google.cloud.retail.v2beta.AlertConfig], then a PERMISSION_DENIED error is
   *     returned.
   *     <p>If the [AlertConfig][google.cloud.retail.v2beta.AlertConfig] to update does not exist, a
   *     NOT_FOUND error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [AlertConfig][google.cloud.retail.v2beta.AlertConfig] to update. If not set, all supported
   *     fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AlertConfig updateAlertConfig(AlertConfig alertConfig, FieldMask updateMask) {
    UpdateAlertConfigRequest request =
        UpdateAlertConfigRequest.newBuilder()
            .setAlertConfig(alertConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateAlertConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the alert config of the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   UpdateAlertConfigRequest request =
   *       UpdateAlertConfigRequest.newBuilder()
   *           .setAlertConfig(AlertConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AlertConfig response = projectServiceClient.updateAlertConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AlertConfig updateAlertConfig(UpdateAlertConfigRequest request) {
    return updateAlertConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the alert config of the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   UpdateAlertConfigRequest request =
   *       UpdateAlertConfigRequest.newBuilder()
   *           .setAlertConfig(AlertConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AlertConfig> future =
   *       projectServiceClient.updateAlertConfigCallable().futureCall(request);
   *   // Do something.
   *   AlertConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigCallable() {
    return stub.updateAlertConfigCallable();
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
