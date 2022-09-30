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

package com.google.cloud.gkebackup.v1;

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
import com.google.cloud.gkebackup.v1.stub.BackupForGKEStub;
import com.google.cloud.gkebackup.v1.stub.BackupForGKEStubSettings;
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
 * Service Description: BackupForGKE allows Kubernetes administrators to configure, execute, and
 * manage backup and restore operations for their GKE clusters.
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
 * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
 *   BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
 *   BackupPlan response = backupForGKEClient.getBackupPlan(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BackupForGKEClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of BackupForGKESettings to
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
 * BackupForGKESettings backupForGKESettings =
 *     BackupForGKESettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BackupForGKEClient backupForGKEClient = BackupForGKEClient.create(backupForGKESettings);
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
 * BackupForGKESettings backupForGKESettings =
 *     BackupForGKESettings.newBuilder().setEndpoint(myEndpoint).build();
 * BackupForGKEClient backupForGKEClient = BackupForGKEClient.create(backupForGKESettings);
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
 * BackupForGKESettings backupForGKESettings =
 *     BackupForGKESettings.newBuilder()
 *         .setTransportChannelProvider(
 *             BackupForGKESettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * BackupForGKEClient backupForGKEClient = BackupForGKEClient.create(backupForGKESettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BackupForGKEClient implements BackgroundResource {
  private final BackupForGKESettings settings;
  private final BackupForGKEStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of BackupForGKEClient with default settings. */
  public static final BackupForGKEClient create() throws IOException {
    return create(BackupForGKESettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BackupForGKEClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BackupForGKEClient create(BackupForGKESettings settings) throws IOException {
    return new BackupForGKEClient(settings);
  }

  /**
   * Constructs an instance of BackupForGKEClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(BackupForGKESettings).
   */
  public static final BackupForGKEClient create(BackupForGKEStub stub) {
    return new BackupForGKEClient(stub);
  }

  /**
   * Constructs an instance of BackupForGKEClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BackupForGKEClient(BackupForGKESettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BackupForGKEStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected BackupForGKEClient(BackupForGKEStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final BackupForGKESettings getSettings() {
    return settings;
  }

  public BackupForGKEStub getStub() {
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
   * Creates a new BackupPlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BackupPlan backupPlan = BackupPlan.newBuilder().build();
   *   String backupPlanId = "backupPlanId-84871546";
   *   BackupPlan response =
   *       backupForGKEClient.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the BackupPlan. Format:
   *     projects/&#42;/locations/&#42;
   * @param backupPlan Required. The BackupPlan resource object to create.
   * @param backupPlanId Required. The client-provided short name for the BackupPlan resource. This
   *     name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of BackupPlans in this location
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlan, OperationMetadata> createBackupPlanAsync(
      LocationName parent, BackupPlan backupPlan, String backupPlanId) {
    CreateBackupPlanRequest request =
        CreateBackupPlanRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackupPlan(backupPlan)
            .setBackupPlanId(backupPlanId)
            .build();
    return createBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupPlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BackupPlan backupPlan = BackupPlan.newBuilder().build();
   *   String backupPlanId = "backupPlanId-84871546";
   *   BackupPlan response =
   *       backupForGKEClient.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the BackupPlan. Format:
   *     projects/&#42;/locations/&#42;
   * @param backupPlan Required. The BackupPlan resource object to create.
   * @param backupPlanId Required. The client-provided short name for the BackupPlan resource. This
   *     name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of BackupPlans in this location
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlan, OperationMetadata> createBackupPlanAsync(
      String parent, BackupPlan backupPlan, String backupPlanId) {
    CreateBackupPlanRequest request =
        CreateBackupPlanRequest.newBuilder()
            .setParent(parent)
            .setBackupPlan(backupPlan)
            .setBackupPlanId(backupPlanId)
            .build();
    return createBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupPlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupPlanRequest request =
   *       CreateBackupPlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setBackupPlanId("backupPlanId-84871546")
   *           .build();
   *   BackupPlan response = backupForGKEClient.createBackupPlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlan, OperationMetadata> createBackupPlanAsync(
      CreateBackupPlanRequest request) {
    return createBackupPlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupPlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupPlanRequest request =
   *       CreateBackupPlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setBackupPlanId("backupPlanId-84871546")
   *           .build();
   *   OperationFuture<BackupPlan, OperationMetadata> future =
   *       backupForGKEClient.createBackupPlanOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupPlan response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable() {
    return stub.createBackupPlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupPlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupPlanRequest request =
   *       CreateBackupPlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setBackupPlanId("backupPlanId-84871546")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.createBackupPlanCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable() {
    return stub.createBackupPlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BackupPlan element : backupForGKEClient.listBackupPlans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the BackupPlans to list. Format:
   *     projects/&#42;/locations/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlansPagedResponse listBackupPlans(LocationName parent) {
    ListBackupPlansRequest request =
        ListBackupPlansRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupPlans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BackupPlan element : backupForGKEClient.listBackupPlans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the BackupPlans to list. Format:
   *     projects/&#42;/locations/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlansPagedResponse listBackupPlans(String parent) {
    ListBackupPlansRequest request = ListBackupPlansRequest.newBuilder().setParent(parent).build();
    return listBackupPlans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupPlansRequest request =
   *       ListBackupPlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (BackupPlan element : backupForGKEClient.listBackupPlans(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlansPagedResponse listBackupPlans(ListBackupPlansRequest request) {
    return listBackupPlansPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupPlansRequest request =
   *       ListBackupPlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<BackupPlan> future =
   *       backupForGKEClient.listBackupPlansPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupPlan element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable() {
    return stub.listBackupPlansPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupPlansRequest request =
   *       ListBackupPlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBackupPlansResponse response =
   *         backupForGKEClient.listBackupPlansCallable().call(request);
   *     for (BackupPlan element : response.getBackupPlansList()) {
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
  public final UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansCallable() {
    return stub.listBackupPlansCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   BackupPlan response = backupForGKEClient.getBackupPlan(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupPlan name. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlan getBackupPlan(BackupPlanName name) {
    GetBackupPlanRequest request =
        GetBackupPlanRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackupPlan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   BackupPlan response = backupForGKEClient.getBackupPlan(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupPlan name. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlan getBackupPlan(String name) {
    GetBackupPlanRequest request = GetBackupPlanRequest.newBuilder().setName(name).build();
    return getBackupPlan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupPlanRequest request =
   *       GetBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .build();
   *   BackupPlan response = backupForGKEClient.getBackupPlan(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlan getBackupPlan(GetBackupPlanRequest request) {
    return getBackupPlanCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupPlanRequest request =
   *       GetBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .build();
   *   ApiFuture<BackupPlan> future = backupForGKEClient.getBackupPlanCallable().futureCall(request);
   *   // Do something.
   *   BackupPlan response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable() {
    return stub.getBackupPlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlan backupPlan = BackupPlan.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BackupPlan response = backupForGKEClient.updateBackupPlanAsync(backupPlan, updateMask).get();
   * }
   * }</pre>
   *
   * @param backupPlan Required. A new version of the BackupPlan resource that contains updated
   *     fields. This may be sparsely populated if an `update_mask` is provided.
   * @param updateMask This is used to specify the fields to be overwritten in the BackupPlan
   *     targeted for update. The values for each of these updated fields will be taken from the
   *     `backup_plan` provided with this request. Field names are relative to the root of the
   *     resource (e.g., `description`, `backup_config.include_volume_data`, etc.) If no
   *     `update_mask` is provided, all fields in `backup_plan` will be written to the target
   *     BackupPlan resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `backup_plan` are
   *     ignored and are not used to update the target BackupPlan.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlan, OperationMetadata> updateBackupPlanAsync(
      BackupPlan backupPlan, FieldMask updateMask) {
    UpdateBackupPlanRequest request =
        UpdateBackupPlanRequest.newBuilder()
            .setBackupPlan(backupPlan)
            .setUpdateMask(updateMask)
            .build();
    return updateBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupPlanRequest request =
   *       UpdateBackupPlanRequest.newBuilder()
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BackupPlan response = backupForGKEClient.updateBackupPlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlan, OperationMetadata> updateBackupPlanAsync(
      UpdateBackupPlanRequest request) {
    return updateBackupPlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupPlanRequest request =
   *       UpdateBackupPlanRequest.newBuilder()
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<BackupPlan, OperationMetadata> future =
   *       backupForGKEClient.updateBackupPlanOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupPlan response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationCallable() {
    return stub.updateBackupPlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupPlanRequest request =
   *       UpdateBackupPlanRequest.newBuilder()
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.updateBackupPlanCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackupPlanRequest, Operation> updateBackupPlanCallable() {
    return stub.updateBackupPlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   backupForGKEClient.deleteBackupPlanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupPlan name. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupPlanAsync(
      BackupPlanName name) {
    DeleteBackupPlanRequest request =
        DeleteBackupPlanRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   backupForGKEClient.deleteBackupPlanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupPlan name. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupPlanAsync(String name) {
    DeleteBackupPlanRequest request = DeleteBackupPlanRequest.newBuilder().setName(name).build();
    return deleteBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupPlanRequest request =
   *       DeleteBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   backupForGKEClient.deleteBackupPlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupPlanAsync(
      DeleteBackupPlanRequest request) {
    return deleteBackupPlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupPlanRequest request =
   *       DeleteBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupForGKEClient.deleteBackupPlanOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable() {
    return stub.deleteBackupPlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupPlanRequest request =
   *       DeleteBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.deleteBackupPlanCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable() {
    return stub.deleteBackupPlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Backup for the given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   Backup backup = Backup.newBuilder().build();
   *   String backupId = "backupId2121930365";
   *   Backup response = backupForGKEClient.createBackupAsync(parent, backup, backupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The BackupPlan within which to create the Backup. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;
   * @param backup The Backup resource to create.
   * @param backupId The client-provided short name for the Backup resource. This name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of Backups in this BackupPlan
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      BackupPlanName parent, Backup backup, String backupId) {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackup(backup)
            .setBackupId(backupId)
            .build();
    return createBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Backup for the given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   Backup backup = Backup.newBuilder().build();
   *   String backupId = "backupId2121930365";
   *   Backup response = backupForGKEClient.createBackupAsync(parent, backup, backupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The BackupPlan within which to create the Backup. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;
   * @param backup The Backup resource to create.
   * @param backupId The client-provided short name for the Backup resource. This name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of Backups in this BackupPlan
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      String parent, Backup backup, String backupId) {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(parent)
            .setBackup(backup)
            .setBackupId(backupId)
            .build();
    return createBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Backup for the given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setBackup(Backup.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   Backup response = backupForGKEClient.createBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      CreateBackupRequest request) {
    return createBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Backup for the given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setBackup(Backup.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   OperationFuture<Backup, OperationMetadata> future =
   *       backupForGKEClient.createBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    return stub.createBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Backup for the given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setBackup(Backup.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.createBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return stub.createBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Backups for a given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   for (Backup element : backupForGKEClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The BackupPlan that contains the Backups to list. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(BackupPlanName parent) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Backups for a given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   for (Backup element : backupForGKEClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The BackupPlan that contains the Backups to list. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(String parent) {
    ListBackupsRequest request = ListBackupsRequest.newBuilder().setParent(parent).build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Backups for a given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Backup element : backupForGKEClient.listBackups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(ListBackupsRequest request) {
    return listBackupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Backups for a given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Backup> future = backupForGKEClient.listBackupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Backup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable() {
    return stub.listBackupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Backups for a given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBackupsResponse response = backupForGKEClient.listBackupsCallable().call(request);
   *     for (Backup element : response.getBackupsList()) {
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
  public final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return stub.listBackupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
   *   Backup response = backupForGKEClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the Backup resource. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(BackupName name) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString();
   *   Backup response = backupForGKEClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the Backup resource. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {
    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .build();
   *   Backup response = backupForGKEClient.getBackup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(GetBackupRequest request) {
    return getBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .build();
   *   ApiFuture<Backup> future = backupForGKEClient.getBackupCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return stub.getBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Backup response = backupForGKEClient.updateBackupAsync(backup, updateMask).get();
   * }
   * }</pre>
   *
   * @param backup Required. A new version of the Backup resource that contains updated fields. This
   *     may be sparsely populated if an `update_mask` is provided.
   * @param updateMask This is used to specify the fields to be overwritten in the Backup targeted
   *     for update. The values for each of these updated fields will be taken from the
   *     `backup_plan` provided with this request. Field names are relative to the root of the
   *     resource. If no `update_mask` is provided, all fields in `backup` will be written to the
   *     target Backup resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `backup` are ignored
   *     and are not used to update the target Backup.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> updateBackupAsync(
      Backup backup, FieldMask updateMask) {
    UpdateBackupRequest request =
        UpdateBackupRequest.newBuilder().setBackup(backup).setUpdateMask(updateMask).build();
    return updateBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setBackup(Backup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Backup response = backupForGKEClient.updateBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> updateBackupAsync(
      UpdateBackupRequest request) {
    return updateBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setBackup(Backup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Backup, OperationMetadata> future =
   *       backupForGKEClient.updateBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable() {
    return stub.updateBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setBackup(Backup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.updateBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    return stub.updateBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
   *   backupForGKEClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the Backup resource. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(BackupName name) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString();
   *   backupForGKEClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the Backup resource. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(String name) {
    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   backupForGKEClient.deleteBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(
      DeleteBackupRequest request) {
    return deleteBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupForGKEClient.deleteBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    return stub.deleteBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.deleteBackupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return stub.deleteBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeBackups for a given Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupName parent = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
   *   for (VolumeBackup element : backupForGKEClient.listVolumeBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Backup that contains the VolumeBackups to list. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeBackupsPagedResponse listVolumeBackups(BackupName parent) {
    ListVolumeBackupsRequest request =
        ListVolumeBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVolumeBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeBackups for a given Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString();
   *   for (VolumeBackup element : backupForGKEClient.listVolumeBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Backup that contains the VolumeBackups to list. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeBackupsPagedResponse listVolumeBackups(String parent) {
    ListVolumeBackupsRequest request =
        ListVolumeBackupsRequest.newBuilder().setParent(parent).build();
    return listVolumeBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeBackups for a given Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeBackupsRequest request =
   *       ListVolumeBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (VolumeBackup element : backupForGKEClient.listVolumeBackups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeBackupsPagedResponse listVolumeBackups(ListVolumeBackupsRequest request) {
    return listVolumeBackupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeBackups for a given Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeBackupsRequest request =
   *       ListVolumeBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<VolumeBackup> future =
   *       backupForGKEClient.listVolumeBackupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VolumeBackup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsPagedResponse>
      listVolumeBackupsPagedCallable() {
    return stub.listVolumeBackupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeBackups for a given Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeBackupsRequest request =
   *       ListVolumeBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListVolumeBackupsResponse response =
   *         backupForGKEClient.listVolumeBackupsCallable().call(request);
   *     for (VolumeBackup element : response.getVolumeBackupsList()) {
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
  public final UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
      listVolumeBackupsCallable() {
    return stub.listVolumeBackupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeBackup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   VolumeBackupName name =
   *       VolumeBackupName.of(
   *           "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]");
   *   VolumeBackup response = backupForGKEClient.getVolumeBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the VolumeBackup resource. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;/volumeBackups/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeBackup getVolumeBackup(VolumeBackupName name) {
    GetVolumeBackupRequest request =
        GetVolumeBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVolumeBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeBackup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       VolumeBackupName.of(
   *               "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]")
   *           .toString();
   *   VolumeBackup response = backupForGKEClient.getVolumeBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the VolumeBackup resource. Format:
   *     projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;/volumeBackups/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeBackup getVolumeBackup(String name) {
    GetVolumeBackupRequest request = GetVolumeBackupRequest.newBuilder().setName(name).build();
    return getVolumeBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeBackup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetVolumeBackupRequest request =
   *       GetVolumeBackupRequest.newBuilder()
   *           .setName(
   *               VolumeBackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]")
   *                   .toString())
   *           .build();
   *   VolumeBackup response = backupForGKEClient.getVolumeBackup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeBackup getVolumeBackup(GetVolumeBackupRequest request) {
    return getVolumeBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeBackup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetVolumeBackupRequest request =
   *       GetVolumeBackupRequest.newBuilder()
   *           .setName(
   *               VolumeBackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VolumeBackup> future =
   *       backupForGKEClient.getVolumeBackupCallable().futureCall(request);
   *   // Do something.
   *   VolumeBackup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupCallable() {
    return stub.getVolumeBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestorePlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RestorePlan restorePlan = RestorePlan.newBuilder().build();
   *   String restorePlanId = "restorePlanId-857896366";
   *   RestorePlan response =
   *       backupForGKEClient.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the RestorePlan. Format:
   *     projects/&#42;/locations/&#42;
   * @param restorePlan Required. The RestorePlan resource object to create.
   * @param restorePlanId Required. The client-provided short name for the RestorePlan resource.
   *     This name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of RestorePlans in this location
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestorePlan, OperationMetadata> createRestorePlanAsync(
      LocationName parent, RestorePlan restorePlan, String restorePlanId) {
    CreateRestorePlanRequest request =
        CreateRestorePlanRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRestorePlan(restorePlan)
            .setRestorePlanId(restorePlanId)
            .build();
    return createRestorePlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestorePlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   RestorePlan restorePlan = RestorePlan.newBuilder().build();
   *   String restorePlanId = "restorePlanId-857896366";
   *   RestorePlan response =
   *       backupForGKEClient.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the RestorePlan. Format:
   *     projects/&#42;/locations/&#42;
   * @param restorePlan Required. The RestorePlan resource object to create.
   * @param restorePlanId Required. The client-provided short name for the RestorePlan resource.
   *     This name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of RestorePlans in this location
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestorePlan, OperationMetadata> createRestorePlanAsync(
      String parent, RestorePlan restorePlan, String restorePlanId) {
    CreateRestorePlanRequest request =
        CreateRestorePlanRequest.newBuilder()
            .setParent(parent)
            .setRestorePlan(restorePlan)
            .setRestorePlanId(restorePlanId)
            .build();
    return createRestorePlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestorePlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestorePlanRequest request =
   *       CreateRestorePlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setRestorePlanId("restorePlanId-857896366")
   *           .build();
   *   RestorePlan response = backupForGKEClient.createRestorePlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestorePlan, OperationMetadata> createRestorePlanAsync(
      CreateRestorePlanRequest request) {
    return createRestorePlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestorePlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestorePlanRequest request =
   *       CreateRestorePlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setRestorePlanId("restorePlanId-857896366")
   *           .build();
   *   OperationFuture<RestorePlan, OperationMetadata> future =
   *       backupForGKEClient.createRestorePlanOperationCallable().futureCall(request);
   *   // Do something.
   *   RestorePlan response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
      createRestorePlanOperationCallable() {
    return stub.createRestorePlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestorePlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestorePlanRequest request =
   *       CreateRestorePlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setRestorePlanId("restorePlanId-857896366")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.createRestorePlanCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRestorePlanRequest, Operation> createRestorePlanCallable() {
    return stub.createRestorePlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (RestorePlan element : backupForGKEClient.listRestorePlans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the RestorePlans to list. Format:
   *     projects/&#42;/locations/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestorePlansPagedResponse listRestorePlans(LocationName parent) {
    ListRestorePlansRequest request =
        ListRestorePlansRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRestorePlans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (RestorePlan element : backupForGKEClient.listRestorePlans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the RestorePlans to list. Format:
   *     projects/&#42;/locations/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestorePlansPagedResponse listRestorePlans(String parent) {
    ListRestorePlansRequest request =
        ListRestorePlansRequest.newBuilder().setParent(parent).build();
    return listRestorePlans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestorePlansRequest request =
   *       ListRestorePlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (RestorePlan element : backupForGKEClient.listRestorePlans(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestorePlansPagedResponse listRestorePlans(ListRestorePlansRequest request) {
    return listRestorePlansPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestorePlansRequest request =
   *       ListRestorePlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<RestorePlan> future =
   *       backupForGKEClient.listRestorePlansPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RestorePlan element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRestorePlansRequest, ListRestorePlansPagedResponse>
      listRestorePlansPagedCallable() {
    return stub.listRestorePlansPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestorePlansRequest request =
   *       ListRestorePlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRestorePlansResponse response =
   *         backupForGKEClient.listRestorePlansCallable().call(request);
   *     for (RestorePlan element : response.getRestorePlansList()) {
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
  public final UnaryCallable<ListRestorePlansRequest, ListRestorePlansResponse>
      listRestorePlansCallable() {
    return stub.listRestorePlansCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
   *   RestorePlan response = backupForGKEClient.getRestorePlan(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestorePlan name. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestorePlan getRestorePlan(RestorePlanName name) {
    GetRestorePlanRequest request =
        GetRestorePlanRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRestorePlan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString();
   *   RestorePlan response = backupForGKEClient.getRestorePlan(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestorePlan name. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestorePlan getRestorePlan(String name) {
    GetRestorePlanRequest request = GetRestorePlanRequest.newBuilder().setName(name).build();
    return getRestorePlan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestorePlanRequest request =
   *       GetRestorePlanRequest.newBuilder()
   *           .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .build();
   *   RestorePlan response = backupForGKEClient.getRestorePlan(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestorePlan getRestorePlan(GetRestorePlanRequest request) {
    return getRestorePlanCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestorePlanRequest request =
   *       GetRestorePlanRequest.newBuilder()
   *           .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .build();
   *   ApiFuture<RestorePlan> future =
   *       backupForGKEClient.getRestorePlanCallable().futureCall(request);
   *   // Do something.
   *   RestorePlan response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRestorePlanRequest, RestorePlan> getRestorePlanCallable() {
    return stub.getRestorePlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlan restorePlan = RestorePlan.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   RestorePlan response =
   *       backupForGKEClient.updateRestorePlanAsync(restorePlan, updateMask).get();
   * }
   * }</pre>
   *
   * @param restorePlan Required. A new version of the RestorePlan resource that contains updated
   *     fields. This may be sparsely populated if an `update_mask` is provided.
   * @param updateMask This is used to specify the fields to be overwritten in the RestorePlan
   *     targeted for update. The values for each of these updated fields will be taken from the
   *     `restore_plan` provided with this request. Field names are relative to the root of the
   *     resource. If no `update_mask` is provided, all fields in `restore_plan` will be written to
   *     the target RestorePlan resource. Note that OUTPUT_ONLY and IMMUTABLE fields in
   *     `restore_plan` are ignored and are not used to update the target RestorePlan.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestorePlan, OperationMetadata> updateRestorePlanAsync(
      RestorePlan restorePlan, FieldMask updateMask) {
    UpdateRestorePlanRequest request =
        UpdateRestorePlanRequest.newBuilder()
            .setRestorePlan(restorePlan)
            .setUpdateMask(updateMask)
            .build();
    return updateRestorePlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestorePlanRequest request =
   *       UpdateRestorePlanRequest.newBuilder()
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   RestorePlan response = backupForGKEClient.updateRestorePlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestorePlan, OperationMetadata> updateRestorePlanAsync(
      UpdateRestorePlanRequest request) {
    return updateRestorePlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestorePlanRequest request =
   *       UpdateRestorePlanRequest.newBuilder()
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<RestorePlan, OperationMetadata> future =
   *       backupForGKEClient.updateRestorePlanOperationCallable().futureCall(request);
   *   // Do something.
   *   RestorePlan response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
      updateRestorePlanOperationCallable() {
    return stub.updateRestorePlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestorePlanRequest request =
   *       UpdateRestorePlanRequest.newBuilder()
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.updateRestorePlanCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRestorePlanRequest, Operation> updateRestorePlanCallable() {
    return stub.updateRestorePlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
   *   backupForGKEClient.deleteRestorePlanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestorePlan name. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestorePlanAsync(
      RestorePlanName name) {
    DeleteRestorePlanRequest request =
        DeleteRestorePlanRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteRestorePlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString();
   *   backupForGKEClient.deleteRestorePlanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestorePlan name. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestorePlanAsync(String name) {
    DeleteRestorePlanRequest request = DeleteRestorePlanRequest.newBuilder().setName(name).build();
    return deleteRestorePlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestorePlanRequest request =
   *       DeleteRestorePlanRequest.newBuilder()
   *           .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   backupForGKEClient.deleteRestorePlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestorePlanAsync(
      DeleteRestorePlanRequest request) {
    return deleteRestorePlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestorePlanRequest request =
   *       DeleteRestorePlanRequest.newBuilder()
   *           .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupForGKEClient.deleteRestorePlanOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRestorePlanRequest, Empty, OperationMetadata>
      deleteRestorePlanOperationCallable() {
    return stub.deleteRestorePlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestorePlanRequest request =
   *       DeleteRestorePlanRequest.newBuilder()
   *           .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.deleteRestorePlanCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRestorePlanRequest, Operation> deleteRestorePlanCallable() {
    return stub.deleteRestorePlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Restore for the given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
   *   Restore restore = Restore.newBuilder().build();
   *   String restoreId = "restoreId-1845465015";
   *   Restore response = backupForGKEClient.createRestoreAsync(parent, restore, restoreId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The RestorePlan within which to create the Restore. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;
   * @param restore Required. The restore resource to create.
   * @param restoreId Required. The client-provided short name for the Restore resource. This name
   *     must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of Restores in this RestorePlan.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> createRestoreAsync(
      RestorePlanName parent, Restore restore, String restoreId) {
    CreateRestoreRequest request =
        CreateRestoreRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRestore(restore)
            .setRestoreId(restoreId)
            .build();
    return createRestoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Restore for the given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString();
   *   Restore restore = Restore.newBuilder().build();
   *   String restoreId = "restoreId-1845465015";
   *   Restore response = backupForGKEClient.createRestoreAsync(parent, restore, restoreId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The RestorePlan within which to create the Restore. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;
   * @param restore Required. The restore resource to create.
   * @param restoreId Required. The client-provided short name for the Restore resource. This name
   *     must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of Restores in this RestorePlan.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> createRestoreAsync(
      String parent, Restore restore, String restoreId) {
    CreateRestoreRequest request =
        CreateRestoreRequest.newBuilder()
            .setParent(parent)
            .setRestore(restore)
            .setRestoreId(restoreId)
            .build();
    return createRestoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Restore for the given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestoreRequest request =
   *       CreateRestoreRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setRestore(Restore.newBuilder().build())
   *           .setRestoreId("restoreId-1845465015")
   *           .build();
   *   Restore response = backupForGKEClient.createRestoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> createRestoreAsync(
      CreateRestoreRequest request) {
    return createRestoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Restore for the given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestoreRequest request =
   *       CreateRestoreRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setRestore(Restore.newBuilder().build())
   *           .setRestoreId("restoreId-1845465015")
   *           .build();
   *   OperationFuture<Restore, OperationMetadata> future =
   *       backupForGKEClient.createRestoreOperationCallable().futureCall(request);
   *   // Do something.
   *   Restore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRestoreRequest, Restore, OperationMetadata>
      createRestoreOperationCallable() {
    return stub.createRestoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Restore for the given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestoreRequest request =
   *       CreateRestoreRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setRestore(Restore.newBuilder().build())
   *           .setRestoreId("restoreId-1845465015")
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.createRestoreCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRestoreRequest, Operation> createRestoreCallable() {
    return stub.createRestoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Restores for a given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
   *   for (Restore element : backupForGKEClient.listRestores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The RestorePlan that contains the Restores to list. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestoresPagedResponse listRestores(RestorePlanName parent) {
    ListRestoresRequest request =
        ListRestoresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRestores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Restores for a given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString();
   *   for (Restore element : backupForGKEClient.listRestores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The RestorePlan that contains the Restores to list. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestoresPagedResponse listRestores(String parent) {
    ListRestoresRequest request = ListRestoresRequest.newBuilder().setParent(parent).build();
    return listRestores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Restores for a given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestoresRequest request =
   *       ListRestoresRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Restore element : backupForGKEClient.listRestores(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestoresPagedResponse listRestores(ListRestoresRequest request) {
    return listRestoresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Restores for a given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestoresRequest request =
   *       ListRestoresRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Restore> future =
   *       backupForGKEClient.listRestoresPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Restore element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRestoresRequest, ListRestoresPagedResponse>
      listRestoresPagedCallable() {
    return stub.listRestoresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Restores for a given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestoresRequest request =
   *       ListRestoresRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRestoresResponse response = backupForGKEClient.listRestoresCallable().call(request);
   *     for (Restore element : response.getRestoresList()) {
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
  public final UnaryCallable<ListRestoresRequest, ListRestoresResponse> listRestoresCallable() {
    return stub.listRestoresCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a single Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");
   *   Restore response = backupForGKEClient.getRestore(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the restore resource. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Restore getRestore(RestoreName name) {
    GetRestoreRequest request =
        GetRestoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRestore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a single Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString();
   *   Restore response = backupForGKEClient.getRestore(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the restore resource. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Restore getRestore(String name) {
    GetRestoreRequest request = GetRestoreRequest.newBuilder().setName(name).build();
    return getRestore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a single Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestoreRequest request =
   *       GetRestoreRequest.newBuilder()
   *           .setName(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .build();
   *   Restore response = backupForGKEClient.getRestore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Restore getRestore(GetRestoreRequest request) {
    return getRestoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a single Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestoreRequest request =
   *       GetRestoreRequest.newBuilder()
   *           .setName(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Restore> future = backupForGKEClient.getRestoreCallable().futureCall(request);
   *   // Do something.
   *   Restore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRestoreRequest, Restore> getRestoreCallable() {
    return stub.getRestoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   Restore restore = Restore.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Restore response = backupForGKEClient.updateRestoreAsync(restore, updateMask).get();
   * }
   * }</pre>
   *
   * @param restore Required. A new version of the Restore resource that contains updated fields.
   *     This may be sparsely populated if an `update_mask` is provided.
   * @param updateMask This is used to specify the fields to be overwritten in the Restore targeted
   *     for update. The values for each of these updated fields will be taken from the `restore`
   *     provided with this request. Field names are relative to the root of the resource. If no
   *     `update_mask` is provided, all fields in `restore` will be written to the target Restore
   *     resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `restore` are ignored and are not
   *     used to update the target Restore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> updateRestoreAsync(
      Restore restore, FieldMask updateMask) {
    UpdateRestoreRequest request =
        UpdateRestoreRequest.newBuilder().setRestore(restore).setUpdateMask(updateMask).build();
    return updateRestoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestoreRequest request =
   *       UpdateRestoreRequest.newBuilder()
   *           .setRestore(Restore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Restore response = backupForGKEClient.updateRestoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> updateRestoreAsync(
      UpdateRestoreRequest request) {
    return updateRestoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestoreRequest request =
   *       UpdateRestoreRequest.newBuilder()
   *           .setRestore(Restore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Restore, OperationMetadata> future =
   *       backupForGKEClient.updateRestoreOperationCallable().futureCall(request);
   *   // Do something.
   *   Restore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRestoreRequest, Restore, OperationMetadata>
      updateRestoreOperationCallable() {
    return stub.updateRestoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestoreRequest request =
   *       UpdateRestoreRequest.newBuilder()
   *           .setRestore(Restore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.updateRestoreCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRestoreRequest, Operation> updateRestoreCallable() {
    return stub.updateRestoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");
   *   backupForGKEClient.deleteRestoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full name of the Restore Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestoreAsync(RestoreName name) {
    DeleteRestoreRequest request =
        DeleteRestoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRestoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString();
   *   backupForGKEClient.deleteRestoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full name of the Restore Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestoreAsync(String name) {
    DeleteRestoreRequest request = DeleteRestoreRequest.newBuilder().setName(name).build();
    return deleteRestoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestoreRequest request =
   *       DeleteRestoreRequest.newBuilder()
   *           .setName(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   backupForGKEClient.deleteRestoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestoreAsync(
      DeleteRestoreRequest request) {
    return deleteRestoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestoreRequest request =
   *       DeleteRestoreRequest.newBuilder()
   *           .setName(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupForGKEClient.deleteRestoreOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRestoreRequest, Empty, OperationMetadata>
      deleteRestoreOperationCallable() {
    return stub.deleteRestoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestoreRequest request =
   *       DeleteRestoreRequest.newBuilder()
   *           .setName(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.deleteRestoreCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRestoreRequest, Operation> deleteRestoreCallable() {
    return stub.deleteRestoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeRestores for a given Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestoreName parent = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");
   *   for (VolumeRestore element : backupForGKEClient.listVolumeRestores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Restore that contains the VolumeRestores to list. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeRestoresPagedResponse listVolumeRestores(RestoreName parent) {
    ListVolumeRestoresRequest request =
        ListVolumeRestoresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVolumeRestores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeRestores for a given Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent =
   *       RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString();
   *   for (VolumeRestore element : backupForGKEClient.listVolumeRestores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Restore that contains the VolumeRestores to list. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeRestoresPagedResponse listVolumeRestores(String parent) {
    ListVolumeRestoresRequest request =
        ListVolumeRestoresRequest.newBuilder().setParent(parent).build();
    return listVolumeRestores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeRestores for a given Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeRestoresRequest request =
   *       ListVolumeRestoresRequest.newBuilder()
   *           .setParent(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (VolumeRestore element : backupForGKEClient.listVolumeRestores(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeRestoresPagedResponse listVolumeRestores(
      ListVolumeRestoresRequest request) {
    return listVolumeRestoresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeRestores for a given Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeRestoresRequest request =
   *       ListVolumeRestoresRequest.newBuilder()
   *           .setParent(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<VolumeRestore> future =
   *       backupForGKEClient.listVolumeRestoresPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VolumeRestore element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresPagedResponse>
      listVolumeRestoresPagedCallable() {
    return stub.listVolumeRestoresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeRestores for a given Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeRestoresRequest request =
   *       ListVolumeRestoresRequest.newBuilder()
   *           .setParent(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListVolumeRestoresResponse response =
   *         backupForGKEClient.listVolumeRestoresCallable().call(request);
   *     for (VolumeRestore element : response.getVolumeRestoresList()) {
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
  public final UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
      listVolumeRestoresCallable() {
    return stub.listVolumeRestoresCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeRestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   VolumeRestoreName name =
   *       VolumeRestoreName.of(
   *           "[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]", "[VOLUME_RESTORE]");
   *   VolumeRestore response = backupForGKEClient.getVolumeRestore(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the VolumeRestore resource. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;/volumeRestores/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeRestore getVolumeRestore(VolumeRestoreName name) {
    GetVolumeRestoreRequest request =
        GetVolumeRestoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVolumeRestore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeRestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       VolumeRestoreName.of(
   *               "[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]", "[VOLUME_RESTORE]")
   *           .toString();
   *   VolumeRestore response = backupForGKEClient.getVolumeRestore(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the VolumeRestore resource. Format:
   *     projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;/volumeRestores/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeRestore getVolumeRestore(String name) {
    GetVolumeRestoreRequest request = GetVolumeRestoreRequest.newBuilder().setName(name).build();
    return getVolumeRestore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeRestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetVolumeRestoreRequest request =
   *       GetVolumeRestoreRequest.newBuilder()
   *           .setName(
   *               VolumeRestoreName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[RESTORE_PLAN]",
   *                       "[RESTORE]",
   *                       "[VOLUME_RESTORE]")
   *                   .toString())
   *           .build();
   *   VolumeRestore response = backupForGKEClient.getVolumeRestore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeRestore getVolumeRestore(GetVolumeRestoreRequest request) {
    return getVolumeRestoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeRestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetVolumeRestoreRequest request =
   *       GetVolumeRestoreRequest.newBuilder()
   *           .setName(
   *               VolumeRestoreName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[RESTORE_PLAN]",
   *                       "[RESTORE]",
   *                       "[VOLUME_RESTORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VolumeRestore> future =
   *       backupForGKEClient.getVolumeRestoreCallable().futureCall(request);
   *   // Do something.
   *   VolumeRestore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreCallable() {
    return stub.getVolumeRestoreCallable();
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

  public static class ListBackupPlansPagedResponse
      extends AbstractPagedListResponse<
          ListBackupPlansRequest,
          ListBackupPlansResponse,
          BackupPlan,
          ListBackupPlansPage,
          ListBackupPlansFixedSizeCollection> {

    public static ApiFuture<ListBackupPlansPagedResponse> createAsync(
        PageContext<ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan> context,
        ApiFuture<ListBackupPlansResponse> futureResponse) {
      ApiFuture<ListBackupPlansPage> futurePage =
          ListBackupPlansPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupPlansPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupPlansPagedResponse(ListBackupPlansPage page) {
      super(page, ListBackupPlansFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupPlansPage
      extends AbstractPage<
          ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan, ListBackupPlansPage> {

    private ListBackupPlansPage(
        PageContext<ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan> context,
        ListBackupPlansResponse response) {
      super(context, response);
    }

    private static ListBackupPlansPage createEmptyPage() {
      return new ListBackupPlansPage(null, null);
    }

    @Override
    protected ListBackupPlansPage createPage(
        PageContext<ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan> context,
        ListBackupPlansResponse response) {
      return new ListBackupPlansPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupPlansPage> createPageAsync(
        PageContext<ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan> context,
        ApiFuture<ListBackupPlansResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupPlansFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupPlansRequest,
          ListBackupPlansResponse,
          BackupPlan,
          ListBackupPlansPage,
          ListBackupPlansFixedSizeCollection> {

    private ListBackupPlansFixedSizeCollection(
        List<ListBackupPlansPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupPlansFixedSizeCollection createEmptyCollection() {
      return new ListBackupPlansFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupPlansFixedSizeCollection createCollection(
        List<ListBackupPlansPage> pages, int collectionSize) {
      return new ListBackupPlansFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    public static ApiFuture<ListBackupsPagedResponse> createAsync(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      ApiFuture<ListBackupsPage> futurePage =
          ListBackupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListBackupsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListBackupsPagedResponse(ListBackupsPage page) {
      super(page, ListBackupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupsPage
      extends AbstractPage<ListBackupsRequest, ListBackupsResponse, Backup, ListBackupsPage> {

    private ListBackupsPage(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ListBackupsResponse response) {
      super(context, response);
    }

    private static ListBackupsPage createEmptyPage() {
      return new ListBackupsPage(null, null);
    }

    @Override
    protected ListBackupsPage createPage(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ListBackupsResponse response) {
      return new ListBackupsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupsPage> createPageAsync(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    private ListBackupsFixedSizeCollection(List<ListBackupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupsFixedSizeCollection createEmptyCollection() {
      return new ListBackupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupsFixedSizeCollection createCollection(
        List<ListBackupsPage> pages, int collectionSize) {
      return new ListBackupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVolumeBackupsPagedResponse
      extends AbstractPagedListResponse<
          ListVolumeBackupsRequest,
          ListVolumeBackupsResponse,
          VolumeBackup,
          ListVolumeBackupsPage,
          ListVolumeBackupsFixedSizeCollection> {

    public static ApiFuture<ListVolumeBackupsPagedResponse> createAsync(
        PageContext<ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup> context,
        ApiFuture<ListVolumeBackupsResponse> futureResponse) {
      ApiFuture<ListVolumeBackupsPage> futurePage =
          ListVolumeBackupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVolumeBackupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVolumeBackupsPagedResponse(ListVolumeBackupsPage page) {
      super(page, ListVolumeBackupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVolumeBackupsPage
      extends AbstractPage<
          ListVolumeBackupsRequest,
          ListVolumeBackupsResponse,
          VolumeBackup,
          ListVolumeBackupsPage> {

    private ListVolumeBackupsPage(
        PageContext<ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup> context,
        ListVolumeBackupsResponse response) {
      super(context, response);
    }

    private static ListVolumeBackupsPage createEmptyPage() {
      return new ListVolumeBackupsPage(null, null);
    }

    @Override
    protected ListVolumeBackupsPage createPage(
        PageContext<ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup> context,
        ListVolumeBackupsResponse response) {
      return new ListVolumeBackupsPage(context, response);
    }

    @Override
    public ApiFuture<ListVolumeBackupsPage> createPageAsync(
        PageContext<ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup> context,
        ApiFuture<ListVolumeBackupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVolumeBackupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVolumeBackupsRequest,
          ListVolumeBackupsResponse,
          VolumeBackup,
          ListVolumeBackupsPage,
          ListVolumeBackupsFixedSizeCollection> {

    private ListVolumeBackupsFixedSizeCollection(
        List<ListVolumeBackupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVolumeBackupsFixedSizeCollection createEmptyCollection() {
      return new ListVolumeBackupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVolumeBackupsFixedSizeCollection createCollection(
        List<ListVolumeBackupsPage> pages, int collectionSize) {
      return new ListVolumeBackupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRestorePlansPagedResponse
      extends AbstractPagedListResponse<
          ListRestorePlansRequest,
          ListRestorePlansResponse,
          RestorePlan,
          ListRestorePlansPage,
          ListRestorePlansFixedSizeCollection> {

    public static ApiFuture<ListRestorePlansPagedResponse> createAsync(
        PageContext<ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan> context,
        ApiFuture<ListRestorePlansResponse> futureResponse) {
      ApiFuture<ListRestorePlansPage> futurePage =
          ListRestorePlansPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRestorePlansPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRestorePlansPagedResponse(ListRestorePlansPage page) {
      super(page, ListRestorePlansFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRestorePlansPage
      extends AbstractPage<
          ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan, ListRestorePlansPage> {

    private ListRestorePlansPage(
        PageContext<ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan> context,
        ListRestorePlansResponse response) {
      super(context, response);
    }

    private static ListRestorePlansPage createEmptyPage() {
      return new ListRestorePlansPage(null, null);
    }

    @Override
    protected ListRestorePlansPage createPage(
        PageContext<ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan> context,
        ListRestorePlansResponse response) {
      return new ListRestorePlansPage(context, response);
    }

    @Override
    public ApiFuture<ListRestorePlansPage> createPageAsync(
        PageContext<ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan> context,
        ApiFuture<ListRestorePlansResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRestorePlansFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRestorePlansRequest,
          ListRestorePlansResponse,
          RestorePlan,
          ListRestorePlansPage,
          ListRestorePlansFixedSizeCollection> {

    private ListRestorePlansFixedSizeCollection(
        List<ListRestorePlansPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRestorePlansFixedSizeCollection createEmptyCollection() {
      return new ListRestorePlansFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRestorePlansFixedSizeCollection createCollection(
        List<ListRestorePlansPage> pages, int collectionSize) {
      return new ListRestorePlansFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRestoresPagedResponse
      extends AbstractPagedListResponse<
          ListRestoresRequest,
          ListRestoresResponse,
          Restore,
          ListRestoresPage,
          ListRestoresFixedSizeCollection> {

    public static ApiFuture<ListRestoresPagedResponse> createAsync(
        PageContext<ListRestoresRequest, ListRestoresResponse, Restore> context,
        ApiFuture<ListRestoresResponse> futureResponse) {
      ApiFuture<ListRestoresPage> futurePage =
          ListRestoresPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRestoresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRestoresPagedResponse(ListRestoresPage page) {
      super(page, ListRestoresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRestoresPage
      extends AbstractPage<ListRestoresRequest, ListRestoresResponse, Restore, ListRestoresPage> {

    private ListRestoresPage(
        PageContext<ListRestoresRequest, ListRestoresResponse, Restore> context,
        ListRestoresResponse response) {
      super(context, response);
    }

    private static ListRestoresPage createEmptyPage() {
      return new ListRestoresPage(null, null);
    }

    @Override
    protected ListRestoresPage createPage(
        PageContext<ListRestoresRequest, ListRestoresResponse, Restore> context,
        ListRestoresResponse response) {
      return new ListRestoresPage(context, response);
    }

    @Override
    public ApiFuture<ListRestoresPage> createPageAsync(
        PageContext<ListRestoresRequest, ListRestoresResponse, Restore> context,
        ApiFuture<ListRestoresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRestoresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRestoresRequest,
          ListRestoresResponse,
          Restore,
          ListRestoresPage,
          ListRestoresFixedSizeCollection> {

    private ListRestoresFixedSizeCollection(List<ListRestoresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRestoresFixedSizeCollection createEmptyCollection() {
      return new ListRestoresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRestoresFixedSizeCollection createCollection(
        List<ListRestoresPage> pages, int collectionSize) {
      return new ListRestoresFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVolumeRestoresPagedResponse
      extends AbstractPagedListResponse<
          ListVolumeRestoresRequest,
          ListVolumeRestoresResponse,
          VolumeRestore,
          ListVolumeRestoresPage,
          ListVolumeRestoresFixedSizeCollection> {

    public static ApiFuture<ListVolumeRestoresPagedResponse> createAsync(
        PageContext<ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore> context,
        ApiFuture<ListVolumeRestoresResponse> futureResponse) {
      ApiFuture<ListVolumeRestoresPage> futurePage =
          ListVolumeRestoresPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVolumeRestoresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVolumeRestoresPagedResponse(ListVolumeRestoresPage page) {
      super(page, ListVolumeRestoresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVolumeRestoresPage
      extends AbstractPage<
          ListVolumeRestoresRequest,
          ListVolumeRestoresResponse,
          VolumeRestore,
          ListVolumeRestoresPage> {

    private ListVolumeRestoresPage(
        PageContext<ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore> context,
        ListVolumeRestoresResponse response) {
      super(context, response);
    }

    private static ListVolumeRestoresPage createEmptyPage() {
      return new ListVolumeRestoresPage(null, null);
    }

    @Override
    protected ListVolumeRestoresPage createPage(
        PageContext<ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore> context,
        ListVolumeRestoresResponse response) {
      return new ListVolumeRestoresPage(context, response);
    }

    @Override
    public ApiFuture<ListVolumeRestoresPage> createPageAsync(
        PageContext<ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore> context,
        ApiFuture<ListVolumeRestoresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVolumeRestoresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVolumeRestoresRequest,
          ListVolumeRestoresResponse,
          VolumeRestore,
          ListVolumeRestoresPage,
          ListVolumeRestoresFixedSizeCollection> {

    private ListVolumeRestoresFixedSizeCollection(
        List<ListVolumeRestoresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVolumeRestoresFixedSizeCollection createEmptyCollection() {
      return new ListVolumeRestoresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVolumeRestoresFixedSizeCollection createCollection(
        List<ListVolumeRestoresPage> pages, int collectionSize) {
      return new ListVolumeRestoresFixedSizeCollection(pages, collectionSize);
    }
  }
}
