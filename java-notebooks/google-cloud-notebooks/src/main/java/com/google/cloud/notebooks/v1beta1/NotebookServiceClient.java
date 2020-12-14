/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.notebooks.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.notebooks.v1beta1.stub.NotebookServiceStub;
import com.google.cloud.notebooks.v1beta1.stub.NotebookServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: API v1beta1 service for Cloud AI Platform Notebooks.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the NotebookServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of NotebookServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * NotebookServiceSettings notebookServiceSettings =
 *     NotebookServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NotebookServiceClient notebookServiceClient =
 *     NotebookServiceClient.create(notebookServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * NotebookServiceSettings notebookServiceSettings =
 *     NotebookServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NotebookServiceClient notebookServiceClient =
 *     NotebookServiceClient.create(notebookServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class NotebookServiceClient implements BackgroundResource {
  private final NotebookServiceSettings settings;
  private final NotebookServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of NotebookServiceClient with default settings. */
  public static final NotebookServiceClient create() throws IOException {
    return create(NotebookServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NotebookServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NotebookServiceClient create(NotebookServiceSettings settings)
      throws IOException {
    return new NotebookServiceClient(settings);
  }

  /**
   * Constructs an instance of NotebookServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(NotebookServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final NotebookServiceClient create(NotebookServiceStub stub) {
    return new NotebookServiceClient(stub);
  }

  /**
   * Constructs an instance of NotebookServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NotebookServiceClient(NotebookServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NotebookServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NotebookServiceClient(NotebookServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final NotebookServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NotebookServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instances in a given project and location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instances in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instances in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Instance in a given project and location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers an existing legacy notebook instance to the Notebooks API server. Legacy instances
   * are instances created with the legacy Compute Engine calls. They are not manageable by the
   * Notebooks API out of the box. This call makes these instances manageable by the Notebooks API.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> registerInstanceAsync(
      RegisterInstanceRequest request) {
    return registerInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers an existing legacy notebook instance to the Notebooks API server. Legacy instances
   * are instances created with the legacy Compute Engine calls. They are not manageable by the
   * Notebooks API out of the box. This call makes these instances manageable by the Notebooks API.
   *
   * <p>Sample code:
   */
  public final OperationCallable<RegisterInstanceRequest, Instance, OperationMetadata>
      registerInstanceOperationCallable() {
    return stub.registerInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers an existing legacy notebook instance to the Notebooks API server. Legacy instances
   * are instances created with the legacy Compute Engine calls. They are not manageable by the
   * Notebooks API out of the box. This call makes these instances manageable by the Notebooks API.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<RegisterInstanceRequest, Operation> registerInstanceCallable() {
    return stub.registerInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the guest accelerators of a single Instance.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> setInstanceAcceleratorAsync(
      SetInstanceAcceleratorRequest request) {
    return setInstanceAcceleratorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the guest accelerators of a single Instance.
   *
   * <p>Sample code:
   */
  public final OperationCallable<SetInstanceAcceleratorRequest, Instance, OperationMetadata>
      setInstanceAcceleratorOperationCallable() {
    return stub.setInstanceAcceleratorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the guest accelerators of a single Instance.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetInstanceAcceleratorRequest, Operation>
      setInstanceAcceleratorCallable() {
    return stub.setInstanceAcceleratorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the machine type of a single Instance.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> setInstanceMachineTypeAsync(
      SetInstanceMachineTypeRequest request) {
    return setInstanceMachineTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the machine type of a single Instance.
   *
   * <p>Sample code:
   */
  public final OperationCallable<SetInstanceMachineTypeRequest, Instance, OperationMetadata>
      setInstanceMachineTypeOperationCallable() {
    return stub.setInstanceMachineTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the machine type of a single Instance.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetInstanceMachineTypeRequest, Operation>
      setInstanceMachineTypeCallable() {
    return stub.setInstanceMachineTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the labels of an Instance.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> setInstanceLabelsAsync(
      SetInstanceLabelsRequest request) {
    return setInstanceLabelsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the labels of an Instance.
   *
   * <p>Sample code:
   */
  public final OperationCallable<SetInstanceLabelsRequest, Instance, OperationMetadata>
      setInstanceLabelsOperationCallable() {
    return stub.setInstanceLabelsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the labels of an Instance.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetInstanceLabelsRequest, Operation> setInstanceLabelsCallable() {
    return stub.setInstanceLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(
      DeleteInstanceRequest request) {
    return deleteInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a notebook instance.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> startInstanceAsync(
      StartInstanceRequest request) {
    return startInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a notebook instance.
   *
   * <p>Sample code:
   */
  public final OperationCallable<StartInstanceRequest, Instance, OperationMetadata>
      startInstanceOperationCallable() {
    return stub.startInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a notebook instance.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<StartInstanceRequest, Operation> startInstanceCallable() {
    return stub.startInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a notebook instance.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> stopInstanceAsync(
      StopInstanceRequest request) {
    return stopInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a notebook instance.
   *
   * <p>Sample code:
   */
  public final OperationCallable<StopInstanceRequest, Instance, OperationMetadata>
      stopInstanceOperationCallable() {
    return stub.stopInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a notebook instance.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<StopInstanceRequest, Operation> stopInstanceCallable() {
    return stub.stopInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a notebook instance.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> resetInstanceAsync(
      ResetInstanceRequest request) {
    return resetInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a notebook instance.
   *
   * <p>Sample code:
   */
  public final OperationCallable<ResetInstanceRequest, Instance, OperationMetadata>
      resetInstanceOperationCallable() {
    return stub.resetInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a notebook instance.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable() {
    return stub.resetInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to report their latest instance information to the Notebooks API
   * server. The server will merge the reported information to the instance metadata store. Do not
   * use this method directly.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> reportInstanceInfoAsync(
      ReportInstanceInfoRequest request) {
    return reportInstanceInfoOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to report their latest instance information to the Notebooks API
   * server. The server will merge the reported information to the instance metadata store. Do not
   * use this method directly.
   *
   * <p>Sample code:
   */
  public final OperationCallable<ReportInstanceInfoRequest, Instance, OperationMetadata>
      reportInstanceInfoOperationCallable() {
    return stub.reportInstanceInfoOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to report their latest instance information to the Notebooks API
   * server. The server will merge the reported information to the instance metadata store. Do not
   * use this method directly.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ReportInstanceInfoRequest, Operation> reportInstanceInfoCallable() {
    return stub.reportInstanceInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if a notebook instance is upgradable.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IsInstanceUpgradeableResponse isInstanceUpgradeable(
      IsInstanceUpgradeableRequest request) {
    return isInstanceUpgradeableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if a notebook instance is upgradable.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
      isInstanceUpgradeableCallable() {
    return stub.isInstanceUpgradeableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a notebook instance to the latest version.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> upgradeInstanceAsync(
      UpgradeInstanceRequest request) {
    return upgradeInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a notebook instance to the latest version.
   *
   * <p>Sample code:
   */
  public final OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable() {
    return stub.upgradeInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a notebook instance to the latest version.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable() {
    return stub.upgradeInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to call this endpoint to upgrade themselves. Do not use this method
   * directly.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> upgradeInstanceInternalAsync(
      UpgradeInstanceInternalRequest request) {
    return upgradeInstanceInternalOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to call this endpoint to upgrade themselves. Do not use this method
   * directly.
   *
   * <p>Sample code:
   */
  public final OperationCallable<UpgradeInstanceInternalRequest, Instance, OperationMetadata>
      upgradeInstanceInternalOperationCallable() {
    return stub.upgradeInstanceInternalOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to call this endpoint to upgrade themselves. Do not use this method
   * directly.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpgradeInstanceInternalRequest, Operation>
      upgradeInstanceInternalCallable() {
    return stub.upgradeInstanceInternalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments in a project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(ListEnvironmentsRequest request) {
    return listEnvironmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments in a project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    return stub.listEnvironmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments in a project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    return stub.listEnvironmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Environment.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(GetEnvironmentRequest request) {
    return getEnvironmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Environment.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return stub.getEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Environment.
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
   * Creates a new Environment.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable() {
    return stub.createEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Environment.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    return stub.createEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Environment.
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
   * Deletes a single Environment.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable() {
    return stub.deleteEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Environment.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable() {
    return stub.deleteEnvironmentCallable();
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

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInstancesPage, ListInstancesPagedResponse>() {
            @Override
            public ListInstancesPagedResponse apply(ListInstancesPage input) {
              return new ListInstancesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
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
          new ApiFunction<ListEnvironmentsPage, ListEnvironmentsPagedResponse>() {
            @Override
            public ListEnvironmentsPagedResponse apply(ListEnvironmentsPage input) {
              return new ListEnvironmentsPagedResponse(input);
            }
          },
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
