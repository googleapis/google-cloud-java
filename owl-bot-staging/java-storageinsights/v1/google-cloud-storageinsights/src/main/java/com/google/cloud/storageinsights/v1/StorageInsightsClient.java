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

package com.google.cloud.storageinsights.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.storageinsights.v1.stub.StorageInsightsStub;
import com.google.cloud.storageinsights.v1.stub.StorageInsightsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
 *   ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
 *   ReportConfig response = storageInsightsClient.getReportConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the StorageInsightsClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of StorageInsightsSettings to
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
 * StorageInsightsSettings storageInsightsSettings =
 *     StorageInsightsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * StorageInsightsClient storageInsightsClient =
 *     StorageInsightsClient.create(storageInsightsSettings);
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
 * StorageInsightsSettings storageInsightsSettings =
 *     StorageInsightsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * StorageInsightsClient storageInsightsClient =
 *     StorageInsightsClient.create(storageInsightsSettings);
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
 * StorageInsightsSettings storageInsightsSettings =
 *     StorageInsightsSettings.newHttpJsonBuilder().build();
 * StorageInsightsClient storageInsightsClient =
 *     StorageInsightsClient.create(storageInsightsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class StorageInsightsClient implements BackgroundResource {
  private final StorageInsightsSettings settings;
  private final StorageInsightsStub stub;

  /** Constructs an instance of StorageInsightsClient with default settings. */
  public static final StorageInsightsClient create() throws IOException {
    return create(StorageInsightsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of StorageInsightsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final StorageInsightsClient create(StorageInsightsSettings settings)
      throws IOException {
    return new StorageInsightsClient(settings);
  }

  /**
   * Constructs an instance of StorageInsightsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(StorageInsightsSettings).
   */
  public static final StorageInsightsClient create(StorageInsightsStub stub) {
    return new StorageInsightsClient(stub);
  }

  /**
   * Constructs an instance of StorageInsightsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected StorageInsightsClient(StorageInsightsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((StorageInsightsStubSettings) settings.getStubSettings()).createStub();
  }

  protected StorageInsightsClient(StorageInsightsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final StorageInsightsSettings getSettings() {
    return settings;
  }

  public StorageInsightsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ReportConfig element : storageInsightsClient.listReportConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListReportConfigsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportConfigsPagedResponse listReportConfigs(LocationName parent) {
    ListReportConfigsRequest request =
        ListReportConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReportConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ReportConfig element : storageInsightsClient.listReportConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListReportConfigsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportConfigsPagedResponse listReportConfigs(String parent) {
    ListReportConfigsRequest request =
        ListReportConfigsRequest.newBuilder().setParent(parent).build();
    return listReportConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ListReportConfigsRequest request =
   *       ListReportConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ReportConfig element : storageInsightsClient.listReportConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportConfigsPagedResponse listReportConfigs(ListReportConfigsRequest request) {
    return listReportConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ListReportConfigsRequest request =
   *       ListReportConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ReportConfig> future =
   *       storageInsightsClient.listReportConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReportConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable() {
    return stub.listReportConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ListReportConfigsRequest request =
   *       ListReportConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListReportConfigsResponse response =
   *         storageInsightsClient.listReportConfigsCallable().call(request);
   *     for (ReportConfig element : response.getReportConfigsList()) {
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
  public final UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable() {
    return stub.listReportConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
   *   ReportConfig response = storageInsightsClient.getReportConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig getReportConfig(ReportConfigName name) {
    GetReportConfigRequest request =
        GetReportConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReportConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   String name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString();
   *   ReportConfig response = storageInsightsClient.getReportConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig getReportConfig(String name) {
    GetReportConfigRequest request = GetReportConfigRequest.newBuilder().setName(name).build();
    return getReportConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   GetReportConfigRequest request =
   *       GetReportConfigRequest.newBuilder()
   *           .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .build();
   *   ReportConfig response = storageInsightsClient.getReportConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig getReportConfig(GetReportConfigRequest request) {
    return getReportConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   GetReportConfigRequest request =
   *       GetReportConfigRequest.newBuilder()
   *           .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .build();
   *   ApiFuture<ReportConfig> future =
   *       storageInsightsClient.getReportConfigCallable().futureCall(request);
   *   // Do something.
   *   ReportConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable() {
    return stub.getReportConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ReportConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ReportConfig reportConfig = ReportConfig.newBuilder().build();
   *   ReportConfig response = storageInsightsClient.createReportConfig(parent, reportConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param reportConfig Required. The resource being created
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig createReportConfig(LocationName parent, ReportConfig reportConfig) {
    CreateReportConfigRequest request =
        CreateReportConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReportConfig(reportConfig)
            .build();
    return createReportConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ReportConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ReportConfig reportConfig = ReportConfig.newBuilder().build();
   *   ReportConfig response = storageInsightsClient.createReportConfig(parent, reportConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param reportConfig Required. The resource being created
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig createReportConfig(String parent, ReportConfig reportConfig) {
    CreateReportConfigRequest request =
        CreateReportConfigRequest.newBuilder()
            .setParent(parent)
            .setReportConfig(reportConfig)
            .build();
    return createReportConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ReportConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   CreateReportConfigRequest request =
   *       CreateReportConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReportConfig(ReportConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ReportConfig response = storageInsightsClient.createReportConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig createReportConfig(CreateReportConfigRequest request) {
    return createReportConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ReportConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   CreateReportConfigRequest request =
   *       CreateReportConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReportConfig(ReportConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<ReportConfig> future =
   *       storageInsightsClient.createReportConfigCallable().futureCall(request);
   *   // Do something.
   *   ReportConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReportConfigRequest, ReportConfig> createReportConfigCallable() {
    return stub.createReportConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ReportConfig reportConfig = ReportConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ReportConfig response = storageInsightsClient.updateReportConfig(reportConfig, updateMask);
   * }
   * }</pre>
   *
   * @param reportConfig Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     ReportConfig resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig updateReportConfig(ReportConfig reportConfig, FieldMask updateMask) {
    UpdateReportConfigRequest request =
        UpdateReportConfigRequest.newBuilder()
            .setReportConfig(reportConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateReportConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   UpdateReportConfigRequest request =
   *       UpdateReportConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setReportConfig(ReportConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ReportConfig response = storageInsightsClient.updateReportConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig updateReportConfig(UpdateReportConfigRequest request) {
    return updateReportConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   UpdateReportConfigRequest request =
   *       UpdateReportConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setReportConfig(ReportConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<ReportConfig> future =
   *       storageInsightsClient.updateReportConfigCallable().futureCall(request);
   *   // Do something.
   *   ReportConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateReportConfigRequest, ReportConfig> updateReportConfigCallable() {
    return stub.updateReportConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
   *   storageInsightsClient.deleteReportConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReportConfig(ReportConfigName name) {
    DeleteReportConfigRequest request =
        DeleteReportConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteReportConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   String name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString();
   *   storageInsightsClient.deleteReportConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReportConfig(String name) {
    DeleteReportConfigRequest request =
        DeleteReportConfigRequest.newBuilder().setName(name).build();
    deleteReportConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   DeleteReportConfigRequest request =
   *       DeleteReportConfigRequest.newBuilder()
   *           .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setForce(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   storageInsightsClient.deleteReportConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReportConfig(DeleteReportConfigRequest request) {
    deleteReportConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   DeleteReportConfigRequest request =
   *       DeleteReportConfigRequest.newBuilder()
   *           .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setForce(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future =
   *       storageInsightsClient.deleteReportConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReportConfigRequest, Empty> deleteReportConfigCallable() {
    return stub.deleteReportConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportDetails in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ReportConfigName parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
   *   for (ReportDetail element : storageInsightsClient.listReportDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListReportDetailsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportDetailsPagedResponse listReportDetails(ReportConfigName parent) {
    ListReportDetailsRequest request =
        ListReportDetailsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReportDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportDetails in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   String parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString();
   *   for (ReportDetail element : storageInsightsClient.listReportDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListReportDetailsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportDetailsPagedResponse listReportDetails(String parent) {
    ListReportDetailsRequest request =
        ListReportDetailsRequest.newBuilder().setParent(parent).build();
    return listReportDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportDetails in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ListReportDetailsRequest request =
   *       ListReportDetailsRequest.newBuilder()
   *           .setParent(
   *               ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ReportDetail element : storageInsightsClient.listReportDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportDetailsPagedResponse listReportDetails(ListReportDetailsRequest request) {
    return listReportDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportDetails in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ListReportDetailsRequest request =
   *       ListReportDetailsRequest.newBuilder()
   *           .setParent(
   *               ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ReportDetail> future =
   *       storageInsightsClient.listReportDetailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReportDetail element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReportDetailsRequest, ListReportDetailsPagedResponse>
      listReportDetailsPagedCallable() {
    return stub.listReportDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportDetails in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ListReportDetailsRequest request =
   *       ListReportDetailsRequest.newBuilder()
   *           .setParent(
   *               ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListReportDetailsResponse response =
   *         storageInsightsClient.listReportDetailsCallable().call(request);
   *     for (ReportDetail element : response.getReportDetailsList()) {
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
  public final UnaryCallable<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsCallable() {
    return stub.listReportDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportDetail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ReportDetailName name =
   *       ReportDetailName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT_DETAIL]");
   *   ReportDetail response = storageInsightsClient.getReportDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportDetail getReportDetail(ReportDetailName name) {
    GetReportDetailRequest request =
        GetReportDetailRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReportDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportDetail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   String name =
   *       ReportDetailName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT_DETAIL]")
   *           .toString();
   *   ReportDetail response = storageInsightsClient.getReportDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportDetail getReportDetail(String name) {
    GetReportDetailRequest request = GetReportDetailRequest.newBuilder().setName(name).build();
    return getReportDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportDetail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   GetReportDetailRequest request =
   *       GetReportDetailRequest.newBuilder()
   *           .setName(
   *               ReportDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT_DETAIL]")
   *                   .toString())
   *           .build();
   *   ReportDetail response = storageInsightsClient.getReportDetail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportDetail getReportDetail(GetReportDetailRequest request) {
    return getReportDetailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportDetail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   GetReportDetailRequest request =
   *       GetReportDetailRequest.newBuilder()
   *           .setName(
   *               ReportDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT_DETAIL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ReportDetail> future =
   *       storageInsightsClient.getReportDetailCallable().futureCall(request);
   *   // Do something.
   *   ReportDetail response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReportDetailRequest, ReportDetail> getReportDetailCallable() {
    return stub.getReportDetailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : storageInsightsClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       storageInsightsClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         storageInsightsClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = storageInsightsClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = storageInsightsClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListReportConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListReportConfigsRequest,
          ListReportConfigsResponse,
          ReportConfig,
          ListReportConfigsPage,
          ListReportConfigsFixedSizeCollection> {

    public static ApiFuture<ListReportConfigsPagedResponse> createAsync(
        PageContext<ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig> context,
        ApiFuture<ListReportConfigsResponse> futureResponse) {
      ApiFuture<ListReportConfigsPage> futurePage =
          ListReportConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReportConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReportConfigsPagedResponse(ListReportConfigsPage page) {
      super(page, ListReportConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReportConfigsPage
      extends AbstractPage<
          ListReportConfigsRequest,
          ListReportConfigsResponse,
          ReportConfig,
          ListReportConfigsPage> {

    private ListReportConfigsPage(
        PageContext<ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig> context,
        ListReportConfigsResponse response) {
      super(context, response);
    }

    private static ListReportConfigsPage createEmptyPage() {
      return new ListReportConfigsPage(null, null);
    }

    @Override
    protected ListReportConfigsPage createPage(
        PageContext<ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig> context,
        ListReportConfigsResponse response) {
      return new ListReportConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListReportConfigsPage> createPageAsync(
        PageContext<ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig> context,
        ApiFuture<ListReportConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReportConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReportConfigsRequest,
          ListReportConfigsResponse,
          ReportConfig,
          ListReportConfigsPage,
          ListReportConfigsFixedSizeCollection> {

    private ListReportConfigsFixedSizeCollection(
        List<ListReportConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReportConfigsFixedSizeCollection createEmptyCollection() {
      return new ListReportConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReportConfigsFixedSizeCollection createCollection(
        List<ListReportConfigsPage> pages, int collectionSize) {
      return new ListReportConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReportDetailsPagedResponse
      extends AbstractPagedListResponse<
          ListReportDetailsRequest,
          ListReportDetailsResponse,
          ReportDetail,
          ListReportDetailsPage,
          ListReportDetailsFixedSizeCollection> {

    public static ApiFuture<ListReportDetailsPagedResponse> createAsync(
        PageContext<ListReportDetailsRequest, ListReportDetailsResponse, ReportDetail> context,
        ApiFuture<ListReportDetailsResponse> futureResponse) {
      ApiFuture<ListReportDetailsPage> futurePage =
          ListReportDetailsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReportDetailsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReportDetailsPagedResponse(ListReportDetailsPage page) {
      super(page, ListReportDetailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReportDetailsPage
      extends AbstractPage<
          ListReportDetailsRequest,
          ListReportDetailsResponse,
          ReportDetail,
          ListReportDetailsPage> {

    private ListReportDetailsPage(
        PageContext<ListReportDetailsRequest, ListReportDetailsResponse, ReportDetail> context,
        ListReportDetailsResponse response) {
      super(context, response);
    }

    private static ListReportDetailsPage createEmptyPage() {
      return new ListReportDetailsPage(null, null);
    }

    @Override
    protected ListReportDetailsPage createPage(
        PageContext<ListReportDetailsRequest, ListReportDetailsResponse, ReportDetail> context,
        ListReportDetailsResponse response) {
      return new ListReportDetailsPage(context, response);
    }

    @Override
    public ApiFuture<ListReportDetailsPage> createPageAsync(
        PageContext<ListReportDetailsRequest, ListReportDetailsResponse, ReportDetail> context,
        ApiFuture<ListReportDetailsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReportDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReportDetailsRequest,
          ListReportDetailsResponse,
          ReportDetail,
          ListReportDetailsPage,
          ListReportDetailsFixedSizeCollection> {

    private ListReportDetailsFixedSizeCollection(
        List<ListReportDetailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReportDetailsFixedSizeCollection createEmptyCollection() {
      return new ListReportDetailsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReportDetailsFixedSizeCollection createCollection(
        List<ListReportDetailsPage> pages, int collectionSize) {
      return new ListReportDetailsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
