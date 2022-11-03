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

package com.google.cloud.bigquery.migration.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.migration.v2.stub.MigrationServiceStub;
import com.google.cloud.bigquery.migration.v2.stub.MigrationServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to handle EDW migrations.
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
 * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();
 *   MigrationWorkflow response =
 *       migrationServiceClient.createMigrationWorkflow(parent, migrationWorkflow);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MigrationServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of MigrationServiceSettings to
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
 * MigrationServiceSettings migrationServiceSettings =
 *     MigrationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MigrationServiceClient migrationServiceClient =
 *     MigrationServiceClient.create(migrationServiceSettings);
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
 * MigrationServiceSettings migrationServiceSettings =
 *     MigrationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MigrationServiceClient migrationServiceClient =
 *     MigrationServiceClient.create(migrationServiceSettings);
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
 * MigrationServiceSettings migrationServiceSettings =
 *     MigrationServiceSettings.newHttpJsonBuilder().build();
 * MigrationServiceClient migrationServiceClient =
 *     MigrationServiceClient.create(migrationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MigrationServiceClient implements BackgroundResource {
  private final MigrationServiceSettings settings;
  private final MigrationServiceStub stub;

  /** Constructs an instance of MigrationServiceClient with default settings. */
  public static final MigrationServiceClient create() throws IOException {
    return create(MigrationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MigrationServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MigrationServiceClient create(MigrationServiceSettings settings)
      throws IOException {
    return new MigrationServiceClient(settings);
  }

  /**
   * Constructs an instance of MigrationServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(MigrationServiceSettings).
   */
  public static final MigrationServiceClient create(MigrationServiceStub stub) {
    return new MigrationServiceClient(stub);
  }

  /**
   * Constructs an instance of MigrationServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MigrationServiceClient(MigrationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MigrationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MigrationServiceClient(MigrationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MigrationServiceSettings getSettings() {
    return settings;
  }

  public MigrationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();
   *   MigrationWorkflow response =
   *       migrationServiceClient.createMigrationWorkflow(parent, migrationWorkflow);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project to which this migration workflow belongs.
   *     Example: `projects/foo/locations/bar`
   * @param migrationWorkflow Required. The migration workflow to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationWorkflow createMigrationWorkflow(
      LocationName parent, MigrationWorkflow migrationWorkflow) {
    CreateMigrationWorkflowRequest request =
        CreateMigrationWorkflowRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMigrationWorkflow(migrationWorkflow)
            .build();
    return createMigrationWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();
   *   MigrationWorkflow response =
   *       migrationServiceClient.createMigrationWorkflow(parent, migrationWorkflow);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project to which this migration workflow belongs.
   *     Example: `projects/foo/locations/bar`
   * @param migrationWorkflow Required. The migration workflow to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationWorkflow createMigrationWorkflow(
      String parent, MigrationWorkflow migrationWorkflow) {
    CreateMigrationWorkflowRequest request =
        CreateMigrationWorkflowRequest.newBuilder()
            .setParent(parent)
            .setMigrationWorkflow(migrationWorkflow)
            .build();
    return createMigrationWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   CreateMigrationWorkflowRequest request =
   *       CreateMigrationWorkflowRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMigrationWorkflow(MigrationWorkflow.newBuilder().build())
   *           .build();
   *   MigrationWorkflow response = migrationServiceClient.createMigrationWorkflow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationWorkflow createMigrationWorkflow(CreateMigrationWorkflowRequest request) {
    return createMigrationWorkflowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   CreateMigrationWorkflowRequest request =
   *       CreateMigrationWorkflowRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMigrationWorkflow(MigrationWorkflow.newBuilder().build())
   *           .build();
   *   ApiFuture<MigrationWorkflow> future =
   *       migrationServiceClient.createMigrationWorkflowCallable().futureCall(request);
   *   // Do something.
   *   MigrationWorkflow response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMigrationWorkflowRequest, MigrationWorkflow>
      createMigrationWorkflowCallable() {
    return stub.createMigrationWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a previously created migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   MigrationWorkflowName name =
   *       MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
   *   MigrationWorkflow response = migrationServiceClient.getMigrationWorkflow(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier for the migration workflow. Example:
   *     `projects/123/locations/us/workflows/1234`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationWorkflow getMigrationWorkflow(MigrationWorkflowName name) {
    GetMigrationWorkflowRequest request =
        GetMigrationWorkflowRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMigrationWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a previously created migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   String name = MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString();
   *   MigrationWorkflow response = migrationServiceClient.getMigrationWorkflow(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier for the migration workflow. Example:
   *     `projects/123/locations/us/workflows/1234`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationWorkflow getMigrationWorkflow(String name) {
    GetMigrationWorkflowRequest request =
        GetMigrationWorkflowRequest.newBuilder().setName(name).build();
    return getMigrationWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a previously created migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   GetMigrationWorkflowRequest request =
   *       GetMigrationWorkflowRequest.newBuilder()
   *           .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   MigrationWorkflow response = migrationServiceClient.getMigrationWorkflow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationWorkflow getMigrationWorkflow(GetMigrationWorkflowRequest request) {
    return getMigrationWorkflowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a previously created migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   GetMigrationWorkflowRequest request =
   *       GetMigrationWorkflowRequest.newBuilder()
   *           .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<MigrationWorkflow> future =
   *       migrationServiceClient.getMigrationWorkflowCallable().futureCall(request);
   *   // Do something.
   *   MigrationWorkflow response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMigrationWorkflowRequest, MigrationWorkflow>
      getMigrationWorkflowCallable() {
    return stub.getMigrationWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously created migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MigrationWorkflow element :
   *       migrationServiceClient.listMigrationWorkflows(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location of the migration workflows to list. Example:
   *     `projects/123/locations/us`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigrationWorkflowsPagedResponse listMigrationWorkflows(LocationName parent) {
    ListMigrationWorkflowsRequest request =
        ListMigrationWorkflowsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMigrationWorkflows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously created migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MigrationWorkflow element :
   *       migrationServiceClient.listMigrationWorkflows(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location of the migration workflows to list. Example:
   *     `projects/123/locations/us`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigrationWorkflowsPagedResponse listMigrationWorkflows(String parent) {
    ListMigrationWorkflowsRequest request =
        ListMigrationWorkflowsRequest.newBuilder().setParent(parent).build();
    return listMigrationWorkflows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously created migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   ListMigrationWorkflowsRequest request =
   *       ListMigrationWorkflowsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MigrationWorkflow element :
   *       migrationServiceClient.listMigrationWorkflows(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigrationWorkflowsPagedResponse listMigrationWorkflows(
      ListMigrationWorkflowsRequest request) {
    return listMigrationWorkflowsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously created migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   ListMigrationWorkflowsRequest request =
   *       ListMigrationWorkflowsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MigrationWorkflow> future =
   *       migrationServiceClient.listMigrationWorkflowsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MigrationWorkflow element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsPagedResponse>
      listMigrationWorkflowsPagedCallable() {
    return stub.listMigrationWorkflowsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously created migration workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   ListMigrationWorkflowsRequest request =
   *       ListMigrationWorkflowsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMigrationWorkflowsResponse response =
   *         migrationServiceClient.listMigrationWorkflowsCallable().call(request);
   *     for (MigrationWorkflow element : response.getMigrationWorkflowsList()) {
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
  public final UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>
      listMigrationWorkflowsCallable() {
    return stub.listMigrationWorkflowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a migration workflow by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   MigrationWorkflowName name =
   *       MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
   *   migrationServiceClient.deleteMigrationWorkflow(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier for the migration workflow. Example:
   *     `projects/123/locations/us/workflows/1234`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMigrationWorkflow(MigrationWorkflowName name) {
    DeleteMigrationWorkflowRequest request =
        DeleteMigrationWorkflowRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteMigrationWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a migration workflow by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   String name = MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString();
   *   migrationServiceClient.deleteMigrationWorkflow(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier for the migration workflow. Example:
   *     `projects/123/locations/us/workflows/1234`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMigrationWorkflow(String name) {
    DeleteMigrationWorkflowRequest request =
        DeleteMigrationWorkflowRequest.newBuilder().setName(name).build();
    deleteMigrationWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a migration workflow by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   DeleteMigrationWorkflowRequest request =
   *       DeleteMigrationWorkflowRequest.newBuilder()
   *           .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .build();
   *   migrationServiceClient.deleteMigrationWorkflow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMigrationWorkflow(DeleteMigrationWorkflowRequest request) {
    deleteMigrationWorkflowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a migration workflow by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   DeleteMigrationWorkflowRequest request =
   *       DeleteMigrationWorkflowRequest.newBuilder()
   *           .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       migrationServiceClient.deleteMigrationWorkflowCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMigrationWorkflowRequest, Empty>
      deleteMigrationWorkflowCallable() {
    return stub.deleteMigrationWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a previously created migration workflow. I.e., the state transitions from DRAFT to
   * RUNNING. This is a no-op if the state is already RUNNING. An error will be signaled if the
   * state is anything other than DRAFT or RUNNING.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   MigrationWorkflowName name =
   *       MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
   *   migrationServiceClient.startMigrationWorkflow(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier for the migration workflow. Example:
   *     `projects/123/locations/us/workflows/1234`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void startMigrationWorkflow(MigrationWorkflowName name) {
    StartMigrationWorkflowRequest request =
        StartMigrationWorkflowRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    startMigrationWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a previously created migration workflow. I.e., the state transitions from DRAFT to
   * RUNNING. This is a no-op if the state is already RUNNING. An error will be signaled if the
   * state is anything other than DRAFT or RUNNING.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   String name = MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString();
   *   migrationServiceClient.startMigrationWorkflow(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier for the migration workflow. Example:
   *     `projects/123/locations/us/workflows/1234`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void startMigrationWorkflow(String name) {
    StartMigrationWorkflowRequest request =
        StartMigrationWorkflowRequest.newBuilder().setName(name).build();
    startMigrationWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a previously created migration workflow. I.e., the state transitions from DRAFT to
   * RUNNING. This is a no-op if the state is already RUNNING. An error will be signaled if the
   * state is anything other than DRAFT or RUNNING.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   StartMigrationWorkflowRequest request =
   *       StartMigrationWorkflowRequest.newBuilder()
   *           .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .build();
   *   migrationServiceClient.startMigrationWorkflow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void startMigrationWorkflow(StartMigrationWorkflowRequest request) {
    startMigrationWorkflowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a previously created migration workflow. I.e., the state transitions from DRAFT to
   * RUNNING. This is a no-op if the state is already RUNNING. An error will be signaled if the
   * state is anything other than DRAFT or RUNNING.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   StartMigrationWorkflowRequest request =
   *       StartMigrationWorkflowRequest.newBuilder()
   *           .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       migrationServiceClient.startMigrationWorkflowCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartMigrationWorkflowRequest, Empty>
      startMigrationWorkflowCallable() {
    return stub.startMigrationWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a previously created migration subtask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   MigrationSubtaskName name =
   *       MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]");
   *   MigrationSubtask response = migrationServiceClient.getMigrationSubtask(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier for the migration subtask. Example:
   *     `projects/123/locations/us/workflows/1234/subtasks/543`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationSubtask getMigrationSubtask(MigrationSubtaskName name) {
    GetMigrationSubtaskRequest request =
        GetMigrationSubtaskRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMigrationSubtask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a previously created migration subtask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   String name =
   *       MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]").toString();
   *   MigrationSubtask response = migrationServiceClient.getMigrationSubtask(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier for the migration subtask. Example:
   *     `projects/123/locations/us/workflows/1234/subtasks/543`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationSubtask getMigrationSubtask(String name) {
    GetMigrationSubtaskRequest request =
        GetMigrationSubtaskRequest.newBuilder().setName(name).build();
    return getMigrationSubtask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a previously created migration subtask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   GetMigrationSubtaskRequest request =
   *       GetMigrationSubtaskRequest.newBuilder()
   *           .setName(
   *               MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]")
   *                   .toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   MigrationSubtask response = migrationServiceClient.getMigrationSubtask(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationSubtask getMigrationSubtask(GetMigrationSubtaskRequest request) {
    return getMigrationSubtaskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a previously created migration subtask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   GetMigrationSubtaskRequest request =
   *       GetMigrationSubtaskRequest.newBuilder()
   *           .setName(
   *               MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]")
   *                   .toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<MigrationSubtask> future =
   *       migrationServiceClient.getMigrationSubtaskCallable().futureCall(request);
   *   // Do something.
   *   MigrationSubtask response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMigrationSubtaskRequest, MigrationSubtask>
      getMigrationSubtaskCallable() {
    return stub.getMigrationSubtaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously created migration subtasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   MigrationWorkflowName parent =
   *       MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
   *   for (MigrationSubtask element :
   *       migrationServiceClient.listMigrationSubtasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The migration task of the subtasks to list. Example:
   *     `projects/123/locations/us/workflows/1234`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigrationSubtasksPagedResponse listMigrationSubtasks(
      MigrationWorkflowName parent) {
    ListMigrationSubtasksRequest request =
        ListMigrationSubtasksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMigrationSubtasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously created migration subtasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   String parent = MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString();
   *   for (MigrationSubtask element :
   *       migrationServiceClient.listMigrationSubtasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The migration task of the subtasks to list. Example:
   *     `projects/123/locations/us/workflows/1234`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigrationSubtasksPagedResponse listMigrationSubtasks(String parent) {
    ListMigrationSubtasksRequest request =
        ListMigrationSubtasksRequest.newBuilder().setParent(parent).build();
    return listMigrationSubtasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously created migration subtasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   ListMigrationSubtasksRequest request =
   *       ListMigrationSubtasksRequest.newBuilder()
   *           .setParent(
   *               MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (MigrationSubtask element :
   *       migrationServiceClient.listMigrationSubtasks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigrationSubtasksPagedResponse listMigrationSubtasks(
      ListMigrationSubtasksRequest request) {
    return listMigrationSubtasksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously created migration subtasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   ListMigrationSubtasksRequest request =
   *       ListMigrationSubtasksRequest.newBuilder()
   *           .setParent(
   *               MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<MigrationSubtask> future =
   *       migrationServiceClient.listMigrationSubtasksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MigrationSubtask element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksPagedResponse>
      listMigrationSubtasksPagedCallable() {
    return stub.listMigrationSubtasksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously created migration subtasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   ListMigrationSubtasksRequest request =
   *       ListMigrationSubtasksRequest.newBuilder()
   *           .setParent(
   *               MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListMigrationSubtasksResponse response =
   *         migrationServiceClient.listMigrationSubtasksCallable().call(request);
   *     for (MigrationSubtask element : response.getMigrationSubtasksList()) {
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
  public final UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>
      listMigrationSubtasksCallable() {
    return stub.listMigrationSubtasksCallable();
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

  public static class ListMigrationWorkflowsPagedResponse
      extends AbstractPagedListResponse<
          ListMigrationWorkflowsRequest,
          ListMigrationWorkflowsResponse,
          MigrationWorkflow,
          ListMigrationWorkflowsPage,
          ListMigrationWorkflowsFixedSizeCollection> {

    public static ApiFuture<ListMigrationWorkflowsPagedResponse> createAsync(
        PageContext<
                ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse, MigrationWorkflow>
            context,
        ApiFuture<ListMigrationWorkflowsResponse> futureResponse) {
      ApiFuture<ListMigrationWorkflowsPage> futurePage =
          ListMigrationWorkflowsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMigrationWorkflowsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMigrationWorkflowsPagedResponse(ListMigrationWorkflowsPage page) {
      super(page, ListMigrationWorkflowsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMigrationWorkflowsPage
      extends AbstractPage<
          ListMigrationWorkflowsRequest,
          ListMigrationWorkflowsResponse,
          MigrationWorkflow,
          ListMigrationWorkflowsPage> {

    private ListMigrationWorkflowsPage(
        PageContext<
                ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse, MigrationWorkflow>
            context,
        ListMigrationWorkflowsResponse response) {
      super(context, response);
    }

    private static ListMigrationWorkflowsPage createEmptyPage() {
      return new ListMigrationWorkflowsPage(null, null);
    }

    @Override
    protected ListMigrationWorkflowsPage createPage(
        PageContext<
                ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse, MigrationWorkflow>
            context,
        ListMigrationWorkflowsResponse response) {
      return new ListMigrationWorkflowsPage(context, response);
    }

    @Override
    public ApiFuture<ListMigrationWorkflowsPage> createPageAsync(
        PageContext<
                ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse, MigrationWorkflow>
            context,
        ApiFuture<ListMigrationWorkflowsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMigrationWorkflowsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMigrationWorkflowsRequest,
          ListMigrationWorkflowsResponse,
          MigrationWorkflow,
          ListMigrationWorkflowsPage,
          ListMigrationWorkflowsFixedSizeCollection> {

    private ListMigrationWorkflowsFixedSizeCollection(
        List<ListMigrationWorkflowsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMigrationWorkflowsFixedSizeCollection createEmptyCollection() {
      return new ListMigrationWorkflowsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMigrationWorkflowsFixedSizeCollection createCollection(
        List<ListMigrationWorkflowsPage> pages, int collectionSize) {
      return new ListMigrationWorkflowsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMigrationSubtasksPagedResponse
      extends AbstractPagedListResponse<
          ListMigrationSubtasksRequest,
          ListMigrationSubtasksResponse,
          MigrationSubtask,
          ListMigrationSubtasksPage,
          ListMigrationSubtasksFixedSizeCollection> {

    public static ApiFuture<ListMigrationSubtasksPagedResponse> createAsync(
        PageContext<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse, MigrationSubtask>
            context,
        ApiFuture<ListMigrationSubtasksResponse> futureResponse) {
      ApiFuture<ListMigrationSubtasksPage> futurePage =
          ListMigrationSubtasksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMigrationSubtasksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMigrationSubtasksPagedResponse(ListMigrationSubtasksPage page) {
      super(page, ListMigrationSubtasksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMigrationSubtasksPage
      extends AbstractPage<
          ListMigrationSubtasksRequest,
          ListMigrationSubtasksResponse,
          MigrationSubtask,
          ListMigrationSubtasksPage> {

    private ListMigrationSubtasksPage(
        PageContext<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse, MigrationSubtask>
            context,
        ListMigrationSubtasksResponse response) {
      super(context, response);
    }

    private static ListMigrationSubtasksPage createEmptyPage() {
      return new ListMigrationSubtasksPage(null, null);
    }

    @Override
    protected ListMigrationSubtasksPage createPage(
        PageContext<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse, MigrationSubtask>
            context,
        ListMigrationSubtasksResponse response) {
      return new ListMigrationSubtasksPage(context, response);
    }

    @Override
    public ApiFuture<ListMigrationSubtasksPage> createPageAsync(
        PageContext<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse, MigrationSubtask>
            context,
        ApiFuture<ListMigrationSubtasksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMigrationSubtasksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMigrationSubtasksRequest,
          ListMigrationSubtasksResponse,
          MigrationSubtask,
          ListMigrationSubtasksPage,
          ListMigrationSubtasksFixedSizeCollection> {

    private ListMigrationSubtasksFixedSizeCollection(
        List<ListMigrationSubtasksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMigrationSubtasksFixedSizeCollection createEmptyCollection() {
      return new ListMigrationSubtasksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMigrationSubtasksFixedSizeCollection createCollection(
        List<ListMigrationSubtasksPage> pages, int collectionSize) {
      return new ListMigrationSubtasksFixedSizeCollection(pages, collectionSize);
    }
  }
}
