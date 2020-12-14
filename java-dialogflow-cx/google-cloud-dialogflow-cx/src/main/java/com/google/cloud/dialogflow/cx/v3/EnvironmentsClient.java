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

package com.google.cloud.dialogflow.cx.v3;

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
import com.google.cloud.dialogflow.cx.v3.stub.EnvironmentsStub;
import com.google.cloud.dialogflow.cx.v3.stub.EnvironmentsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [Environments][google.cloud.dialogflow.cx.v3.Environment].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
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
 * EnvironmentsSettings environmentsSettings =
 *     EnvironmentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EnvironmentsClient environmentsClient = EnvironmentsClient.create(environmentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class EnvironmentsClient implements BackgroundResource {
  private final EnvironmentsSettings settings;
  private final EnvironmentsStub stub;
  private final OperationsClient operationsClient;

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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected EnvironmentsClient(EnvironmentsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final EnvironmentsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public EnvironmentsStub getStub() {
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
   * Returns the list of all environments in the specified
   * [Agent][google.cloud.dialogflow.cx.v3.Agent].
   *
   * @param parent Required. The [Agent][google.cloud.dialogflow.cx.v3.Agent] to list all
   *     environments for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(AgentName parent) {
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEnvironments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all environments in the specified
   * [Agent][google.cloud.dialogflow.cx.v3.Agent].
   *
   * @param parent Required. The [Agent][google.cloud.dialogflow.cx.v3.Agent] to list all
   *     environments for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(String parent) {
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder().setParent(parent).build();
    return listEnvironments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all environments in the specified
   * [Agent][google.cloud.dialogflow.cx.v3.Agent].
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(ListEnvironmentsRequest request) {
    return listEnvironmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all environments in the specified
   * [Agent][google.cloud.dialogflow.cx.v3.Agent].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    return stub.listEnvironmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all environments in the specified
   * [Agent][google.cloud.dialogflow.cx.v3.Agent].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    return stub.listEnvironmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param name Required. The name of the [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(EnvironmentName name) {
    GetEnvironmentRequest request =
        GetEnvironmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param name Required. The name of the [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(String name) {
    GetEnvironmentRequest request = GetEnvironmentRequest.newBuilder().setName(name).build();
    return getEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(GetEnvironmentRequest request) {
    return getEnvironmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return stub.getEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Environment][google.cloud.dialogflow.cx.v3.Environment] in the specified
   * [Agent][google.cloud.dialogflow.cx.v3.Agent].
   *
   * @param parent Required. The [Agent][google.cloud.dialogflow.cx.v3.Agent] to create an
   *     [Environment][google.cloud.dialogflow.cx.v3.Environment] for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param environment Required. The environment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, Struct> createEnvironmentAsync(
      AgentName parent, Environment environment) {
    CreateEnvironmentRequest request =
        CreateEnvironmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEnvironment(environment)
            .build();
    return createEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Environment][google.cloud.dialogflow.cx.v3.Environment] in the specified
   * [Agent][google.cloud.dialogflow.cx.v3.Agent].
   *
   * @param parent Required. The [Agent][google.cloud.dialogflow.cx.v3.Agent] to create an
   *     [Environment][google.cloud.dialogflow.cx.v3.Environment] for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param environment Required. The environment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, Struct> createEnvironmentAsync(
      String parent, Environment environment) {
    CreateEnvironmentRequest request =
        CreateEnvironmentRequest.newBuilder().setParent(parent).setEnvironment(environment).build();
    return createEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Environment][google.cloud.dialogflow.cx.v3.Environment] in the specified
   * [Agent][google.cloud.dialogflow.cx.v3.Agent].
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, Struct> createEnvironmentAsync(
      CreateEnvironmentRequest request) {
    return createEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Environment][google.cloud.dialogflow.cx.v3.Environment] in the specified
   * [Agent][google.cloud.dialogflow.cx.v3.Agent].
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateEnvironmentRequest, Environment, Struct>
      createEnvironmentOperationCallable() {
    return stub.createEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Environment][google.cloud.dialogflow.cx.v3.Environment] in the specified
   * [Agent][google.cloud.dialogflow.cx.v3.Agent].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    return stub.createEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param environment Required. The environment to update.
   * @param updateMask Required. The mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, Struct> updateEnvironmentAsync(
      Environment environment, FieldMask updateMask) {
    UpdateEnvironmentRequest request =
        UpdateEnvironmentRequest.newBuilder()
            .setEnvironment(environment)
            .setUpdateMask(updateMask)
            .build();
    return updateEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, Struct> updateEnvironmentAsync(
      UpdateEnvironmentRequest request) {
    return updateEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   */
  public final OperationCallable<UpdateEnvironmentRequest, Environment, Struct>
      updateEnvironmentOperationCallable() {
    return stub.updateEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable() {
    return stub.updateEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param name Required. The name of the [Environment][google.cloud.dialogflow.cx.v3.Environment]
   *     to delete. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEnvironment(EnvironmentName name) {
    DeleteEnvironmentRequest request =
        DeleteEnvironmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param name Required. The name of the [Environment][google.cloud.dialogflow.cx.v3.Environment]
   *     to delete. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEnvironment(String name) {
    DeleteEnvironmentRequest request = DeleteEnvironmentRequest.newBuilder().setName(name).build();
    deleteEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEnvironment(DeleteEnvironmentRequest request) {
    deleteEnvironmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteEnvironmentRequest, Empty> deleteEnvironmentCallable() {
    return stub.deleteEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up the history of the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param name Required. Resource name of the environment to look up the history for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupEnvironmentHistoryPagedResponse lookupEnvironmentHistory(
      EnvironmentName name) {
    LookupEnvironmentHistoryRequest request =
        LookupEnvironmentHistoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return lookupEnvironmentHistory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up the history of the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param name Required. Resource name of the environment to look up the history for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupEnvironmentHistoryPagedResponse lookupEnvironmentHistory(String name) {
    LookupEnvironmentHistoryRequest request =
        LookupEnvironmentHistoryRequest.newBuilder().setName(name).build();
    return lookupEnvironmentHistory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up the history of the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupEnvironmentHistoryPagedResponse lookupEnvironmentHistory(
      LookupEnvironmentHistoryRequest request) {
    return lookupEnvironmentHistoryPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up the history of the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryPagedResponse>
      lookupEnvironmentHistoryPagedCallable() {
    return stub.lookupEnvironmentHistoryPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up the history of the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>
      lookupEnvironmentHistoryCallable() {
    return stub.lookupEnvironmentHistoryCallable();
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

  public static class LookupEnvironmentHistoryPagedResponse
      extends AbstractPagedListResponse<
          LookupEnvironmentHistoryRequest,
          LookupEnvironmentHistoryResponse,
          Environment,
          LookupEnvironmentHistoryPage,
          LookupEnvironmentHistoryFixedSizeCollection> {

    public static ApiFuture<LookupEnvironmentHistoryPagedResponse> createAsync(
        PageContext<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse, Environment>
            context,
        ApiFuture<LookupEnvironmentHistoryResponse> futureResponse) {
      ApiFuture<LookupEnvironmentHistoryPage> futurePage =
          LookupEnvironmentHistoryPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<LookupEnvironmentHistoryPage, LookupEnvironmentHistoryPagedResponse>() {
            @Override
            public LookupEnvironmentHistoryPagedResponse apply(LookupEnvironmentHistoryPage input) {
              return new LookupEnvironmentHistoryPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private LookupEnvironmentHistoryPagedResponse(LookupEnvironmentHistoryPage page) {
      super(page, LookupEnvironmentHistoryFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class LookupEnvironmentHistoryPage
      extends AbstractPage<
          LookupEnvironmentHistoryRequest,
          LookupEnvironmentHistoryResponse,
          Environment,
          LookupEnvironmentHistoryPage> {

    private LookupEnvironmentHistoryPage(
        PageContext<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse, Environment>
            context,
        LookupEnvironmentHistoryResponse response) {
      super(context, response);
    }

    private static LookupEnvironmentHistoryPage createEmptyPage() {
      return new LookupEnvironmentHistoryPage(null, null);
    }

    @Override
    protected LookupEnvironmentHistoryPage createPage(
        PageContext<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse, Environment>
            context,
        LookupEnvironmentHistoryResponse response) {
      return new LookupEnvironmentHistoryPage(context, response);
    }

    @Override
    public ApiFuture<LookupEnvironmentHistoryPage> createPageAsync(
        PageContext<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse, Environment>
            context,
        ApiFuture<LookupEnvironmentHistoryResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class LookupEnvironmentHistoryFixedSizeCollection
      extends AbstractFixedSizeCollection<
          LookupEnvironmentHistoryRequest,
          LookupEnvironmentHistoryResponse,
          Environment,
          LookupEnvironmentHistoryPage,
          LookupEnvironmentHistoryFixedSizeCollection> {

    private LookupEnvironmentHistoryFixedSizeCollection(
        List<LookupEnvironmentHistoryPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static LookupEnvironmentHistoryFixedSizeCollection createEmptyCollection() {
      return new LookupEnvironmentHistoryFixedSizeCollection(null, 0);
    }

    @Override
    protected LookupEnvironmentHistoryFixedSizeCollection createCollection(
        List<LookupEnvironmentHistoryPage> pages, int collectionSize) {
      return new LookupEnvironmentHistoryFixedSizeCollection(pages, collectionSize);
    }
  }
}
