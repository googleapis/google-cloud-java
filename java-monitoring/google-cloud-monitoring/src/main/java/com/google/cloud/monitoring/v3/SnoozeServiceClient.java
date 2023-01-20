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

package com.google.cloud.monitoring.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.monitoring.v3.stub.SnoozeServiceStub;
import com.google.cloud.monitoring.v3.stub.SnoozeServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.monitoring.v3.CreateSnoozeRequest;
import com.google.monitoring.v3.GetSnoozeRequest;
import com.google.monitoring.v3.ListSnoozesRequest;
import com.google.monitoring.v3.ListSnoozesResponse;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.Snooze;
import com.google.monitoring.v3.SnoozeName;
import com.google.monitoring.v3.UpdateSnoozeRequest;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The SnoozeService API is used to temporarily prevent an alert policy from
 * generating alerts. A Snooze is a description of the criteria under which one or more alert
 * policies should not fire alerts for the specified duration.
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
 * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Snooze snooze = Snooze.newBuilder().build();
 *   Snooze response = snoozeServiceClient.createSnooze(parent, snooze);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SnoozeServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of SnoozeServiceSettings to
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
 * SnoozeServiceSettings snoozeServiceSettings =
 *     SnoozeServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create(snoozeServiceSettings);
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
 * SnoozeServiceSettings snoozeServiceSettings =
 *     SnoozeServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create(snoozeServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SnoozeServiceClient implements BackgroundResource {
  private final SnoozeServiceSettings settings;
  private final SnoozeServiceStub stub;

  /** Constructs an instance of SnoozeServiceClient with default settings. */
  public static final SnoozeServiceClient create() throws IOException {
    return create(SnoozeServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SnoozeServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SnoozeServiceClient create(SnoozeServiceSettings settings)
      throws IOException {
    return new SnoozeServiceClient(settings);
  }

  /**
   * Constructs an instance of SnoozeServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SnoozeServiceSettings).
   */
  public static final SnoozeServiceClient create(SnoozeServiceStub stub) {
    return new SnoozeServiceClient(stub);
  }

  /**
   * Constructs an instance of SnoozeServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SnoozeServiceClient(SnoozeServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SnoozeServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SnoozeServiceClient(SnoozeServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SnoozeServiceSettings getSettings() {
    return settings;
  }

  public SnoozeServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Snooze` that will prevent alerts, which match the provided criteria, from being
   * opened. The `Snooze` applies for a specific time interval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Snooze snooze = Snooze.newBuilder().build();
   *   Snooze response = snoozeServiceClient.createSnooze(parent, snooze);
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     in which a `Snooze` should be created. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @param snooze Required. The `Snooze` to create. Omit the `name` field, as it will be filled in
   *     by the API.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snooze createSnooze(ProjectName parent, Snooze snooze) {
    CreateSnoozeRequest request =
        CreateSnoozeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSnooze(snooze)
            .build();
    return createSnooze(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Snooze` that will prevent alerts, which match the provided criteria, from being
   * opened. The `Snooze` applies for a specific time interval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Snooze snooze = Snooze.newBuilder().build();
   *   Snooze response = snoozeServiceClient.createSnooze(parent, snooze);
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     in which a `Snooze` should be created. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @param snooze Required. The `Snooze` to create. Omit the `name` field, as it will be filled in
   *     by the API.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snooze createSnooze(String parent, Snooze snooze) {
    CreateSnoozeRequest request =
        CreateSnoozeRequest.newBuilder().setParent(parent).setSnooze(snooze).build();
    return createSnooze(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Snooze` that will prevent alerts, which match the provided criteria, from being
   * opened. The `Snooze` applies for a specific time interval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   CreateSnoozeRequest request =
   *       CreateSnoozeRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSnooze(Snooze.newBuilder().build())
   *           .build();
   *   Snooze response = snoozeServiceClient.createSnooze(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snooze createSnooze(CreateSnoozeRequest request) {
    return createSnoozeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Snooze` that will prevent alerts, which match the provided criteria, from being
   * opened. The `Snooze` applies for a specific time interval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   CreateSnoozeRequest request =
   *       CreateSnoozeRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSnooze(Snooze.newBuilder().build())
   *           .build();
   *   ApiFuture<Snooze> future = snoozeServiceClient.createSnoozeCallable().futureCall(request);
   *   // Do something.
   *   Snooze response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSnoozeRequest, Snooze> createSnoozeCallable() {
    return stub.createSnoozeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Snooze`s associated with a project. Can optionally pass in `filter`, which specifies
   * predicates to match `Snooze`s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Snooze element : snoozeServiceClient.listSnoozes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     whose `Snooze`s should be listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnoozesPagedResponse listSnoozes(ProjectName parent) {
    ListSnoozesRequest request =
        ListSnoozesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSnoozes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Snooze`s associated with a project. Can optionally pass in `filter`, which specifies
   * predicates to match `Snooze`s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Snooze element : snoozeServiceClient.listSnoozes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     whose `Snooze`s should be listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnoozesPagedResponse listSnoozes(String parent) {
    ListSnoozesRequest request = ListSnoozesRequest.newBuilder().setParent(parent).build();
    return listSnoozes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Snooze`s associated with a project. Can optionally pass in `filter`, which specifies
   * predicates to match `Snooze`s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   ListSnoozesRequest request =
   *       ListSnoozesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Snooze element : snoozeServiceClient.listSnoozes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnoozesPagedResponse listSnoozes(ListSnoozesRequest request) {
    return listSnoozesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Snooze`s associated with a project. Can optionally pass in `filter`, which specifies
   * predicates to match `Snooze`s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   ListSnoozesRequest request =
   *       ListSnoozesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Snooze> future = snoozeServiceClient.listSnoozesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Snooze element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSnoozesRequest, ListSnoozesPagedResponse>
      listSnoozesPagedCallable() {
    return stub.listSnoozesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Snooze`s associated with a project. Can optionally pass in `filter`, which specifies
   * predicates to match `Snooze`s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   ListSnoozesRequest request =
   *       ListSnoozesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSnoozesResponse response = snoozeServiceClient.listSnoozesCallable().call(request);
   *     for (Snooze element : response.getSnoozesList()) {
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
  public final UnaryCallable<ListSnoozesRequest, ListSnoozesResponse> listSnoozesCallable() {
    return stub.listSnoozesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Snooze` by `name`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   SnoozeName name = SnoozeName.of("[PROJECT]", "[SNOOZE]");
   *   Snooze response = snoozeServiceClient.getSnooze(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the `Snooze` to retrieve. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/snoozes/[SNOOZE_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snooze getSnooze(SnoozeName name) {
    GetSnoozeRequest request =
        GetSnoozeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSnooze(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Snooze` by `name`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   String name = SnoozeName.of("[PROJECT]", "[SNOOZE]").toString();
   *   Snooze response = snoozeServiceClient.getSnooze(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the `Snooze` to retrieve. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/snoozes/[SNOOZE_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snooze getSnooze(String name) {
    GetSnoozeRequest request = GetSnoozeRequest.newBuilder().setName(name).build();
    return getSnooze(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Snooze` by `name`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   GetSnoozeRequest request =
   *       GetSnoozeRequest.newBuilder()
   *           .setName(SnoozeName.of("[PROJECT]", "[SNOOZE]").toString())
   *           .build();
   *   Snooze response = snoozeServiceClient.getSnooze(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snooze getSnooze(GetSnoozeRequest request) {
    return getSnoozeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Snooze` by `name`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   GetSnoozeRequest request =
   *       GetSnoozeRequest.newBuilder()
   *           .setName(SnoozeName.of("[PROJECT]", "[SNOOZE]").toString())
   *           .build();
   *   ApiFuture<Snooze> future = snoozeServiceClient.getSnoozeCallable().futureCall(request);
   *   // Do something.
   *   Snooze response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSnoozeRequest, Snooze> getSnoozeCallable() {
    return stub.getSnoozeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Snooze`, identified by its `name`, with the parameters in the given `Snooze` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   Snooze snooze = Snooze.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Snooze response = snoozeServiceClient.updateSnooze(snooze, updateMask);
   * }
   * }</pre>
   *
   * @param snooze Required. The `Snooze` to update. Must have the name field present.
   * @param updateMask Required. The fields to update.
   *     <p>For each field listed in `update_mask`:
   *     <p>&#42; If the `Snooze` object supplied in the `UpdateSnoozeRequest` has a value for that
   *     field, the value of the field in the existing `Snooze` will be set to the value of the
   *     field in the supplied `Snooze`. &#42; If the field does not have a value in the supplied
   *     `Snooze`, the field in the existing `Snooze` is set to its default value.
   *     <p>Fields not listed retain their existing value.
   *     <p>The following are the field names that are accepted in `update_mask`:
   *     <p>&#42; `display_name` &#42; `interval.start_time` &#42; `interval.end_time`
   *     <p>That said, the start time and end time of the `Snooze` determines which fields can
   *     legally be updated. Before attempting an update, users should consult the documentation for
   *     `UpdateSnoozeRequest`, which talks about which fields can be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snooze updateSnooze(Snooze snooze, FieldMask updateMask) {
    UpdateSnoozeRequest request =
        UpdateSnoozeRequest.newBuilder().setSnooze(snooze).setUpdateMask(updateMask).build();
    return updateSnooze(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Snooze`, identified by its `name`, with the parameters in the given `Snooze` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   UpdateSnoozeRequest request =
   *       UpdateSnoozeRequest.newBuilder()
   *           .setSnooze(Snooze.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Snooze response = snoozeServiceClient.updateSnooze(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snooze updateSnooze(UpdateSnoozeRequest request) {
    return updateSnoozeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Snooze`, identified by its `name`, with the parameters in the given `Snooze` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
   *   UpdateSnoozeRequest request =
   *       UpdateSnoozeRequest.newBuilder()
   *           .setSnooze(Snooze.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Snooze> future = snoozeServiceClient.updateSnoozeCallable().futureCall(request);
   *   // Do something.
   *   Snooze response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSnoozeRequest, Snooze> updateSnoozeCallable() {
    return stub.updateSnoozeCallable();
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

  public static class ListSnoozesPagedResponse
      extends AbstractPagedListResponse<
          ListSnoozesRequest,
          ListSnoozesResponse,
          Snooze,
          ListSnoozesPage,
          ListSnoozesFixedSizeCollection> {

    public static ApiFuture<ListSnoozesPagedResponse> createAsync(
        PageContext<ListSnoozesRequest, ListSnoozesResponse, Snooze> context,
        ApiFuture<ListSnoozesResponse> futureResponse) {
      ApiFuture<ListSnoozesPage> futurePage =
          ListSnoozesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSnoozesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSnoozesPagedResponse(ListSnoozesPage page) {
      super(page, ListSnoozesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSnoozesPage
      extends AbstractPage<ListSnoozesRequest, ListSnoozesResponse, Snooze, ListSnoozesPage> {

    private ListSnoozesPage(
        PageContext<ListSnoozesRequest, ListSnoozesResponse, Snooze> context,
        ListSnoozesResponse response) {
      super(context, response);
    }

    private static ListSnoozesPage createEmptyPage() {
      return new ListSnoozesPage(null, null);
    }

    @Override
    protected ListSnoozesPage createPage(
        PageContext<ListSnoozesRequest, ListSnoozesResponse, Snooze> context,
        ListSnoozesResponse response) {
      return new ListSnoozesPage(context, response);
    }

    @Override
    public ApiFuture<ListSnoozesPage> createPageAsync(
        PageContext<ListSnoozesRequest, ListSnoozesResponse, Snooze> context,
        ApiFuture<ListSnoozesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSnoozesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSnoozesRequest,
          ListSnoozesResponse,
          Snooze,
          ListSnoozesPage,
          ListSnoozesFixedSizeCollection> {

    private ListSnoozesFixedSizeCollection(List<ListSnoozesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSnoozesFixedSizeCollection createEmptyCollection() {
      return new ListSnoozesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSnoozesFixedSizeCollection createCollection(
        List<ListSnoozesPage> pages, int collectionSize) {
      return new ListSnoozesFixedSizeCollection(pages, collectionSize);
    }
  }
}
