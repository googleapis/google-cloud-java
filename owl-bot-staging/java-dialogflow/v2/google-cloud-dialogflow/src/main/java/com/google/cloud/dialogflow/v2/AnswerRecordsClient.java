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

package com.google.cloud.dialogflow.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.stub.AnswerRecordsStub;
import com.google.cloud.dialogflow.v2.stub.AnswerRecordsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [AnswerRecords][google.cloud.dialogflow.v2.AnswerRecord].
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
 * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
 *   AnswerRecord answerRecord = AnswerRecord.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   AnswerRecord response = answerRecordsClient.updateAnswerRecord(answerRecord, updateMask);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AnswerRecordsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of AnswerRecordsSettings to
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
 * AnswerRecordsSettings answerRecordsSettings =
 *     AnswerRecordsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create(answerRecordsSettings);
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
 * AnswerRecordsSettings answerRecordsSettings =
 *     AnswerRecordsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create(answerRecordsSettings);
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
 * AnswerRecordsSettings answerRecordsSettings =
 *     AnswerRecordsSettings.newHttpJsonBuilder().build();
 * AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create(answerRecordsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AnswerRecordsClient implements BackgroundResource {
  private final AnswerRecordsSettings settings;
  private final AnswerRecordsStub stub;

  /** Constructs an instance of AnswerRecordsClient with default settings. */
  public static final AnswerRecordsClient create() throws IOException {
    return create(AnswerRecordsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AnswerRecordsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AnswerRecordsClient create(AnswerRecordsSettings settings)
      throws IOException {
    return new AnswerRecordsClient(settings);
  }

  /**
   * Constructs an instance of AnswerRecordsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AnswerRecordsSettings).
   */
  public static final AnswerRecordsClient create(AnswerRecordsStub stub) {
    return new AnswerRecordsClient(stub);
  }

  /**
   * Constructs an instance of AnswerRecordsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AnswerRecordsClient(AnswerRecordsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AnswerRecordsStubSettings) settings.getStubSettings()).createStub();
  }

  protected AnswerRecordsClient(AnswerRecordsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AnswerRecordsSettings getSettings() {
    return settings;
  }

  public AnswerRecordsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all answer records in the specified project in reverse chronological order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AnswerRecord element : answerRecordsClient.listAnswerRecords(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list all answer records for in reverse chronological
   *     order. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnswerRecordsPagedResponse listAnswerRecords(LocationName parent) {
    ListAnswerRecordsRequest request =
        ListAnswerRecordsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnswerRecords(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all answer records in the specified project in reverse chronological order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (AnswerRecord element : answerRecordsClient.listAnswerRecords(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list all answer records for in reverse chronological
   *     order. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnswerRecordsPagedResponse listAnswerRecords(ProjectName parent) {
    ListAnswerRecordsRequest request =
        ListAnswerRecordsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnswerRecords(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all answer records in the specified project in reverse chronological order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (AnswerRecord element : answerRecordsClient.listAnswerRecords(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list all answer records for in reverse chronological
   *     order. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnswerRecordsPagedResponse listAnswerRecords(String parent) {
    ListAnswerRecordsRequest request =
        ListAnswerRecordsRequest.newBuilder().setParent(parent).build();
    return listAnswerRecords(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all answer records in the specified project in reverse chronological order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   ListAnswerRecordsRequest request =
   *       ListAnswerRecordsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AnswerRecord element : answerRecordsClient.listAnswerRecords(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnswerRecordsPagedResponse listAnswerRecords(ListAnswerRecordsRequest request) {
    return listAnswerRecordsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all answer records in the specified project in reverse chronological order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   ListAnswerRecordsRequest request =
   *       ListAnswerRecordsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AnswerRecord> future =
   *       answerRecordsClient.listAnswerRecordsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AnswerRecord element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnswerRecordsRequest, ListAnswerRecordsPagedResponse>
      listAnswerRecordsPagedCallable() {
    return stub.listAnswerRecordsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all answer records in the specified project in reverse chronological order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   ListAnswerRecordsRequest request =
   *       ListAnswerRecordsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAnswerRecordsResponse response =
   *         answerRecordsClient.listAnswerRecordsCallable().call(request);
   *     for (AnswerRecord element : response.getAnswerRecordsList()) {
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
  public final UnaryCallable<ListAnswerRecordsRequest, ListAnswerRecordsResponse>
      listAnswerRecordsCallable() {
    return stub.listAnswerRecordsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified answer record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   AnswerRecord answerRecord = AnswerRecord.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AnswerRecord response = answerRecordsClient.updateAnswerRecord(answerRecord, updateMask);
   * }
   * }</pre>
   *
   * @param answerRecord Required. Answer record to update.
   * @param updateMask Required. The mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnswerRecord updateAnswerRecord(AnswerRecord answerRecord, FieldMask updateMask) {
    UpdateAnswerRecordRequest request =
        UpdateAnswerRecordRequest.newBuilder()
            .setAnswerRecord(answerRecord)
            .setUpdateMask(updateMask)
            .build();
    return updateAnswerRecord(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified answer record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   UpdateAnswerRecordRequest request =
   *       UpdateAnswerRecordRequest.newBuilder()
   *           .setAnswerRecord(AnswerRecord.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AnswerRecord response = answerRecordsClient.updateAnswerRecord(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnswerRecord updateAnswerRecord(UpdateAnswerRecordRequest request) {
    return updateAnswerRecordCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified answer record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   UpdateAnswerRecordRequest request =
   *       UpdateAnswerRecordRequest.newBuilder()
   *           .setAnswerRecord(AnswerRecord.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AnswerRecord> future =
   *       answerRecordsClient.updateAnswerRecordCallable().futureCall(request);
   *   // Do something.
   *   AnswerRecord response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAnswerRecordRequest, AnswerRecord> updateAnswerRecordCallable() {
    return stub.updateAnswerRecordCallable();
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
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : answerRecordsClient.listLocations(request).iterateAll()) {
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
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       answerRecordsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = answerRecordsClient.listLocationsCallable().call(request);
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
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = answerRecordsClient.getLocation(request);
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
   * try (AnswerRecordsClient answerRecordsClient = AnswerRecordsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = answerRecordsClient.getLocationCallable().futureCall(request);
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

  public static class ListAnswerRecordsPagedResponse
      extends AbstractPagedListResponse<
          ListAnswerRecordsRequest,
          ListAnswerRecordsResponse,
          AnswerRecord,
          ListAnswerRecordsPage,
          ListAnswerRecordsFixedSizeCollection> {

    public static ApiFuture<ListAnswerRecordsPagedResponse> createAsync(
        PageContext<ListAnswerRecordsRequest, ListAnswerRecordsResponse, AnswerRecord> context,
        ApiFuture<ListAnswerRecordsResponse> futureResponse) {
      ApiFuture<ListAnswerRecordsPage> futurePage =
          ListAnswerRecordsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnswerRecordsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnswerRecordsPagedResponse(ListAnswerRecordsPage page) {
      super(page, ListAnswerRecordsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnswerRecordsPage
      extends AbstractPage<
          ListAnswerRecordsRequest,
          ListAnswerRecordsResponse,
          AnswerRecord,
          ListAnswerRecordsPage> {

    private ListAnswerRecordsPage(
        PageContext<ListAnswerRecordsRequest, ListAnswerRecordsResponse, AnswerRecord> context,
        ListAnswerRecordsResponse response) {
      super(context, response);
    }

    private static ListAnswerRecordsPage createEmptyPage() {
      return new ListAnswerRecordsPage(null, null);
    }

    @Override
    protected ListAnswerRecordsPage createPage(
        PageContext<ListAnswerRecordsRequest, ListAnswerRecordsResponse, AnswerRecord> context,
        ListAnswerRecordsResponse response) {
      return new ListAnswerRecordsPage(context, response);
    }

    @Override
    public ApiFuture<ListAnswerRecordsPage> createPageAsync(
        PageContext<ListAnswerRecordsRequest, ListAnswerRecordsResponse, AnswerRecord> context,
        ApiFuture<ListAnswerRecordsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnswerRecordsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnswerRecordsRequest,
          ListAnswerRecordsResponse,
          AnswerRecord,
          ListAnswerRecordsPage,
          ListAnswerRecordsFixedSizeCollection> {

    private ListAnswerRecordsFixedSizeCollection(
        List<ListAnswerRecordsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnswerRecordsFixedSizeCollection createEmptyCollection() {
      return new ListAnswerRecordsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnswerRecordsFixedSizeCollection createCollection(
        List<ListAnswerRecordsPage> pages, int collectionSize) {
      return new ListAnswerRecordsFixedSizeCollection(pages, collectionSize);
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
