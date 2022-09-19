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
import com.google.cloud.dialogflow.v2.stub.ConversationProfilesStub;
import com.google.cloud.dialogflow.v2.stub.ConversationProfilesStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Service Description: Service for managing
 * [ConversationProfiles][google.cloud.dialogflow.v2.ConversationProfile].
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
 * try (ConversationProfilesClient conversationProfilesClient =
 *     ConversationProfilesClient.create()) {
 *   ConversationProfileName name =
 *       ConversationProfileName.ofProjectConversationProfileName(
 *           "[PROJECT]", "[CONVERSATION_PROFILE]");
 *   ConversationProfile response = conversationProfilesClient.getConversationProfile(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConversationProfilesClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of ConversationProfilesSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationProfilesSettings conversationProfilesSettings =
 *     ConversationProfilesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConversationProfilesClient conversationProfilesClient =
 *     ConversationProfilesClient.create(conversationProfilesSettings);
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
 * ConversationProfilesSettings conversationProfilesSettings =
 *     ConversationProfilesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConversationProfilesClient conversationProfilesClient =
 *     ConversationProfilesClient.create(conversationProfilesSettings);
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
 * ConversationProfilesSettings conversationProfilesSettings =
 *     ConversationProfilesSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ConversationProfilesSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ConversationProfilesClient conversationProfilesClient =
 *     ConversationProfilesClient.create(conversationProfilesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ConversationProfilesClient implements BackgroundResource {
  private final ConversationProfilesSettings settings;
  private final ConversationProfilesStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ConversationProfilesClient with default settings. */
  public static final ConversationProfilesClient create() throws IOException {
    return create(ConversationProfilesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConversationProfilesClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConversationProfilesClient create(ConversationProfilesSettings settings)
      throws IOException {
    return new ConversationProfilesClient(settings);
  }

  /**
   * Constructs an instance of ConversationProfilesClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ConversationProfilesSettings).
   */
  public static final ConversationProfilesClient create(ConversationProfilesStub stub) {
    return new ConversationProfilesClient(stub);
  }

  /**
   * Constructs an instance of ConversationProfilesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ConversationProfilesClient(ConversationProfilesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConversationProfilesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ConversationProfilesClient(ConversationProfilesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ConversationProfilesSettings getSettings() {
    return settings;
  }

  public ConversationProfilesStub getStub() {
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
   * Returns the list of all conversation profiles in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ConversationProfile element :
   *       conversationProfilesClient.listConversationProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list all conversation profiles from. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationProfilesPagedResponse listConversationProfiles(LocationName parent) {
    ListConversationProfilesRequest request =
        ListConversationProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConversationProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversation profiles in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (ConversationProfile element :
   *       conversationProfilesClient.listConversationProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list all conversation profiles from. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationProfilesPagedResponse listConversationProfiles(ProjectName parent) {
    ListConversationProfilesRequest request =
        ListConversationProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConversationProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversation profiles in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (ConversationProfile element :
   *       conversationProfilesClient.listConversationProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list all conversation profiles from. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationProfilesPagedResponse listConversationProfiles(String parent) {
    ListConversationProfilesRequest request =
        ListConversationProfilesRequest.newBuilder().setParent(parent).build();
    return listConversationProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversation profiles in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ListConversationProfilesRequest request =
   *       ListConversationProfilesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ConversationProfile element :
   *       conversationProfilesClient.listConversationProfiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationProfilesPagedResponse listConversationProfiles(
      ListConversationProfilesRequest request) {
    return listConversationProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversation profiles in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ListConversationProfilesRequest request =
   *       ListConversationProfilesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ConversationProfile> future =
   *       conversationProfilesClient.listConversationProfilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConversationProfile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConversationProfilesRequest, ListConversationProfilesPagedResponse>
      listConversationProfilesPagedCallable() {
    return stub.listConversationProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversation profiles in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ListConversationProfilesRequest request =
   *       ListConversationProfilesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConversationProfilesResponse response =
   *         conversationProfilesClient.listConversationProfilesCallable().call(request);
   *     for (ConversationProfile element : response.getConversationProfilesList()) {
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
  public final UnaryCallable<ListConversationProfilesRequest, ListConversationProfilesResponse>
      listConversationProfilesCallable() {
    return stub.listConversationProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified conversation profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ConversationProfileName name =
   *       ConversationProfileName.ofProjectConversationProfileName(
   *           "[PROJECT]", "[CONVERSATION_PROFILE]");
   *   ConversationProfile response = conversationProfilesClient.getConversationProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the conversation profile. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/conversationProfiles/&lt;Conversation Profile ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationProfile getConversationProfile(ConversationProfileName name) {
    GetConversationProfileRequest request =
        GetConversationProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getConversationProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified conversation profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   String name =
   *       ConversationProfileName.ofProjectConversationProfileName(
   *               "[PROJECT]", "[CONVERSATION_PROFILE]")
   *           .toString();
   *   ConversationProfile response = conversationProfilesClient.getConversationProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the conversation profile. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/conversationProfiles/&lt;Conversation Profile ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationProfile getConversationProfile(String name) {
    GetConversationProfileRequest request =
        GetConversationProfileRequest.newBuilder().setName(name).build();
    return getConversationProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified conversation profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   GetConversationProfileRequest request =
   *       GetConversationProfileRequest.newBuilder()
   *           .setName(
   *               ConversationProfileName.ofProjectConversationProfileName(
   *                       "[PROJECT]", "[CONVERSATION_PROFILE]")
   *                   .toString())
   *           .build();
   *   ConversationProfile response = conversationProfilesClient.getConversationProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationProfile getConversationProfile(GetConversationProfileRequest request) {
    return getConversationProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified conversation profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   GetConversationProfileRequest request =
   *       GetConversationProfileRequest.newBuilder()
   *           .setName(
   *               ConversationProfileName.ofProjectConversationProfileName(
   *                       "[PROJECT]", "[CONVERSATION_PROFILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ConversationProfile> future =
   *       conversationProfilesClient.getConversationProfileCallable().futureCall(request);
   *   // Do something.
   *   ConversationProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConversationProfileRequest, ConversationProfile>
      getConversationProfileCallable() {
    return stub.getConversationProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation profile in the specified project.
   *
   * <p>[ConversationProfile.CreateTime][] and [ConversationProfile.UpdateTime][] aren't populated
   * in the response. You can retrieve them via
   * [GetConversationProfile][google.cloud.dialogflow.v2.ConversationProfiles.GetConversationProfile]
   * API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();
   *   ConversationProfile response =
   *       conversationProfilesClient.createConversationProfile(parent, conversationProfile);
   * }
   * }</pre>
   *
   * @param parent Required. The project to create a conversation profile for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param conversationProfile Required. The conversation profile to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationProfile createConversationProfile(
      LocationName parent, ConversationProfile conversationProfile) {
    CreateConversationProfileRequest request =
        CreateConversationProfileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConversationProfile(conversationProfile)
            .build();
    return createConversationProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation profile in the specified project.
   *
   * <p>[ConversationProfile.CreateTime][] and [ConversationProfile.UpdateTime][] aren't populated
   * in the response. You can retrieve them via
   * [GetConversationProfile][google.cloud.dialogflow.v2.ConversationProfiles.GetConversationProfile]
   * API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();
   *   ConversationProfile response =
   *       conversationProfilesClient.createConversationProfile(parent, conversationProfile);
   * }
   * }</pre>
   *
   * @param parent Required. The project to create a conversation profile for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param conversationProfile Required. The conversation profile to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationProfile createConversationProfile(
      ProjectName parent, ConversationProfile conversationProfile) {
    CreateConversationProfileRequest request =
        CreateConversationProfileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConversationProfile(conversationProfile)
            .build();
    return createConversationProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation profile in the specified project.
   *
   * <p>[ConversationProfile.CreateTime][] and [ConversationProfile.UpdateTime][] aren't populated
   * in the response. You can retrieve them via
   * [GetConversationProfile][google.cloud.dialogflow.v2.ConversationProfiles.GetConversationProfile]
   * API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();
   *   ConversationProfile response =
   *       conversationProfilesClient.createConversationProfile(parent, conversationProfile);
   * }
   * }</pre>
   *
   * @param parent Required. The project to create a conversation profile for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param conversationProfile Required. The conversation profile to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationProfile createConversationProfile(
      String parent, ConversationProfile conversationProfile) {
    CreateConversationProfileRequest request =
        CreateConversationProfileRequest.newBuilder()
            .setParent(parent)
            .setConversationProfile(conversationProfile)
            .build();
    return createConversationProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation profile in the specified project.
   *
   * <p>[ConversationProfile.CreateTime][] and [ConversationProfile.UpdateTime][] aren't populated
   * in the response. You can retrieve them via
   * [GetConversationProfile][google.cloud.dialogflow.v2.ConversationProfiles.GetConversationProfile]
   * API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   CreateConversationProfileRequest request =
   *       CreateConversationProfileRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setConversationProfile(ConversationProfile.newBuilder().build())
   *           .build();
   *   ConversationProfile response = conversationProfilesClient.createConversationProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationProfile createConversationProfile(
      CreateConversationProfileRequest request) {
    return createConversationProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation profile in the specified project.
   *
   * <p>[ConversationProfile.CreateTime][] and [ConversationProfile.UpdateTime][] aren't populated
   * in the response. You can retrieve them via
   * [GetConversationProfile][google.cloud.dialogflow.v2.ConversationProfiles.GetConversationProfile]
   * API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   CreateConversationProfileRequest request =
   *       CreateConversationProfileRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setConversationProfile(ConversationProfile.newBuilder().build())
   *           .build();
   *   ApiFuture<ConversationProfile> future =
   *       conversationProfilesClient.createConversationProfileCallable().futureCall(request);
   *   // Do something.
   *   ConversationProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConversationProfileRequest, ConversationProfile>
      createConversationProfileCallable() {
    return stub.createConversationProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified conversation profile.
   *
   * <p>[ConversationProfile.CreateTime][] and [ConversationProfile.UpdateTime][] aren't populated
   * in the response. You can retrieve them via
   * [GetConversationProfile][google.cloud.dialogflow.v2.ConversationProfiles.GetConversationProfile]
   * API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ConversationProfile response =
   *       conversationProfilesClient.updateConversationProfile(conversationProfile, updateMask);
   * }
   * }</pre>
   *
   * @param conversationProfile Required. The conversation profile to update.
   * @param updateMask Required. The mask to control which fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationProfile updateConversationProfile(
      ConversationProfile conversationProfile, FieldMask updateMask) {
    UpdateConversationProfileRequest request =
        UpdateConversationProfileRequest.newBuilder()
            .setConversationProfile(conversationProfile)
            .setUpdateMask(updateMask)
            .build();
    return updateConversationProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified conversation profile.
   *
   * <p>[ConversationProfile.CreateTime][] and [ConversationProfile.UpdateTime][] aren't populated
   * in the response. You can retrieve them via
   * [GetConversationProfile][google.cloud.dialogflow.v2.ConversationProfiles.GetConversationProfile]
   * API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   UpdateConversationProfileRequest request =
   *       UpdateConversationProfileRequest.newBuilder()
   *           .setConversationProfile(ConversationProfile.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ConversationProfile response = conversationProfilesClient.updateConversationProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationProfile updateConversationProfile(
      UpdateConversationProfileRequest request) {
    return updateConversationProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified conversation profile.
   *
   * <p>[ConversationProfile.CreateTime][] and [ConversationProfile.UpdateTime][] aren't populated
   * in the response. You can retrieve them via
   * [GetConversationProfile][google.cloud.dialogflow.v2.ConversationProfiles.GetConversationProfile]
   * API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   UpdateConversationProfileRequest request =
   *       UpdateConversationProfileRequest.newBuilder()
   *           .setConversationProfile(ConversationProfile.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ConversationProfile> future =
   *       conversationProfilesClient.updateConversationProfileCallable().futureCall(request);
   *   // Do something.
   *   ConversationProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConversationProfileRequest, ConversationProfile>
      updateConversationProfileCallable() {
    return stub.updateConversationProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ConversationProfileName name =
   *       ConversationProfileName.ofProjectConversationProfileName(
   *           "[PROJECT]", "[CONVERSATION_PROFILE]");
   *   conversationProfilesClient.deleteConversationProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation profile to delete. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/conversationProfiles/&lt;Conversation Profile ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversationProfile(ConversationProfileName name) {
    DeleteConversationProfileRequest request =
        DeleteConversationProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteConversationProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   String name =
   *       ConversationProfileName.ofProjectConversationProfileName(
   *               "[PROJECT]", "[CONVERSATION_PROFILE]")
   *           .toString();
   *   conversationProfilesClient.deleteConversationProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation profile to delete. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/conversationProfiles/&lt;Conversation Profile ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversationProfile(String name) {
    DeleteConversationProfileRequest request =
        DeleteConversationProfileRequest.newBuilder().setName(name).build();
    deleteConversationProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   DeleteConversationProfileRequest request =
   *       DeleteConversationProfileRequest.newBuilder()
   *           .setName(
   *               ConversationProfileName.ofProjectConversationProfileName(
   *                       "[PROJECT]", "[CONVERSATION_PROFILE]")
   *                   .toString())
   *           .build();
   *   conversationProfilesClient.deleteConversationProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversationProfile(DeleteConversationProfileRequest request) {
    deleteConversationProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   DeleteConversationProfileRequest request =
   *       DeleteConversationProfileRequest.newBuilder()
   *           .setName(
   *               ConversationProfileName.ofProjectConversationProfileName(
   *                       "[PROJECT]", "[CONVERSATION_PROFILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       conversationProfilesClient.deleteConversationProfileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConversationProfileRequest, Empty>
      deleteConversationProfileCallable() {
    return stub.deleteConversationProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds or updates a suggestion feature in a conversation profile. If the conversation profile
   * contains the type of suggestion feature for the participant role, it will update it. Otherwise
   * it will insert the suggestion feature.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [SetSuggestionFeatureConfigOperationMetadata][google.cloud.dialogflow.v2.SetSuggestionFeatureConfigOperationMetadata]
   * - `response`: [ConversationProfile][google.cloud.dialogflow.v2.ConversationProfile]
   *
   * <p>If a long running operation to add or update suggestion feature config for the same
   * conversation profile, participant role and suggestion feature type exists, please cancel the
   * existing long running operation before sending such request, otherwise the request will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   String conversationProfile = "conversationProfile1691597734";
   *   ConversationProfile response =
   *       conversationProfilesClient.setSuggestionFeatureConfigAsync(conversationProfile).get();
   * }
   * }</pre>
   *
   * @param conversationProfile Required. The Conversation Profile to add or update the suggestion
   *     feature config. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/conversationProfiles/&lt;Conversation Profile ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConversationProfile, SetSuggestionFeatureConfigOperationMetadata>
      setSuggestionFeatureConfigAsync(String conversationProfile) {
    SetSuggestionFeatureConfigRequest request =
        SetSuggestionFeatureConfigRequest.newBuilder()
            .setConversationProfile(conversationProfile)
            .build();
    return setSuggestionFeatureConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds or updates a suggestion feature in a conversation profile. If the conversation profile
   * contains the type of suggestion feature for the participant role, it will update it. Otherwise
   * it will insert the suggestion feature.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [SetSuggestionFeatureConfigOperationMetadata][google.cloud.dialogflow.v2.SetSuggestionFeatureConfigOperationMetadata]
   * - `response`: [ConversationProfile][google.cloud.dialogflow.v2.ConversationProfile]
   *
   * <p>If a long running operation to add or update suggestion feature config for the same
   * conversation profile, participant role and suggestion feature type exists, please cancel the
   * existing long running operation before sending such request, otherwise the request will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   SetSuggestionFeatureConfigRequest request =
   *       SetSuggestionFeatureConfigRequest.newBuilder()
   *           .setConversationProfile("conversationProfile1691597734")
   *           .setSuggestionFeatureConfig(
   *               HumanAgentAssistantConfig.SuggestionFeatureConfig.newBuilder().build())
   *           .build();
   *   ConversationProfile response =
   *       conversationProfilesClient.setSuggestionFeatureConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConversationProfile, SetSuggestionFeatureConfigOperationMetadata>
      setSuggestionFeatureConfigAsync(SetSuggestionFeatureConfigRequest request) {
    return setSuggestionFeatureConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds or updates a suggestion feature in a conversation profile. If the conversation profile
   * contains the type of suggestion feature for the participant role, it will update it. Otherwise
   * it will insert the suggestion feature.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [SetSuggestionFeatureConfigOperationMetadata][google.cloud.dialogflow.v2.SetSuggestionFeatureConfigOperationMetadata]
   * - `response`: [ConversationProfile][google.cloud.dialogflow.v2.ConversationProfile]
   *
   * <p>If a long running operation to add or update suggestion feature config for the same
   * conversation profile, participant role and suggestion feature type exists, please cancel the
   * existing long running operation before sending such request, otherwise the request will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   SetSuggestionFeatureConfigRequest request =
   *       SetSuggestionFeatureConfigRequest.newBuilder()
   *           .setConversationProfile("conversationProfile1691597734")
   *           .setSuggestionFeatureConfig(
   *               HumanAgentAssistantConfig.SuggestionFeatureConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ConversationProfile, SetSuggestionFeatureConfigOperationMetadata> future =
   *       conversationProfilesClient
   *           .setSuggestionFeatureConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ConversationProfile response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          SetSuggestionFeatureConfigRequest,
          ConversationProfile,
          SetSuggestionFeatureConfigOperationMetadata>
      setSuggestionFeatureConfigOperationCallable() {
    return stub.setSuggestionFeatureConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds or updates a suggestion feature in a conversation profile. If the conversation profile
   * contains the type of suggestion feature for the participant role, it will update it. Otherwise
   * it will insert the suggestion feature.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [SetSuggestionFeatureConfigOperationMetadata][google.cloud.dialogflow.v2.SetSuggestionFeatureConfigOperationMetadata]
   * - `response`: [ConversationProfile][google.cloud.dialogflow.v2.ConversationProfile]
   *
   * <p>If a long running operation to add or update suggestion feature config for the same
   * conversation profile, participant role and suggestion feature type exists, please cancel the
   * existing long running operation before sending such request, otherwise the request will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   SetSuggestionFeatureConfigRequest request =
   *       SetSuggestionFeatureConfigRequest.newBuilder()
   *           .setConversationProfile("conversationProfile1691597734")
   *           .setSuggestionFeatureConfig(
   *               HumanAgentAssistantConfig.SuggestionFeatureConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       conversationProfilesClient.setSuggestionFeatureConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetSuggestionFeatureConfigRequest, Operation>
      setSuggestionFeatureConfigCallable() {
    return stub.setSuggestionFeatureConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clears a suggestion feature from a conversation profile for the given participant role.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ClearSuggestionFeatureConfigOperationMetadata][google.cloud.dialogflow.v2.ClearSuggestionFeatureConfigOperationMetadata]
   * - `response`: [ConversationProfile][google.cloud.dialogflow.v2.ConversationProfile]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   String conversationProfile = "conversationProfile1691597734";
   *   ConversationProfile response =
   *       conversationProfilesClient.clearSuggestionFeatureConfigAsync(conversationProfile).get();
   * }
   * }</pre>
   *
   * @param conversationProfile Required. The Conversation Profile to add or update the suggestion
   *     feature config. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/conversationProfiles/&lt;Conversation Profile ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConversationProfile, ClearSuggestionFeatureConfigOperationMetadata>
      clearSuggestionFeatureConfigAsync(String conversationProfile) {
    ClearSuggestionFeatureConfigRequest request =
        ClearSuggestionFeatureConfigRequest.newBuilder()
            .setConversationProfile(conversationProfile)
            .build();
    return clearSuggestionFeatureConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clears a suggestion feature from a conversation profile for the given participant role.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ClearSuggestionFeatureConfigOperationMetadata][google.cloud.dialogflow.v2.ClearSuggestionFeatureConfigOperationMetadata]
   * - `response`: [ConversationProfile][google.cloud.dialogflow.v2.ConversationProfile]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ClearSuggestionFeatureConfigRequest request =
   *       ClearSuggestionFeatureConfigRequest.newBuilder()
   *           .setConversationProfile("conversationProfile1691597734")
   *           .build();
   *   ConversationProfile response =
   *       conversationProfilesClient.clearSuggestionFeatureConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConversationProfile, ClearSuggestionFeatureConfigOperationMetadata>
      clearSuggestionFeatureConfigAsync(ClearSuggestionFeatureConfigRequest request) {
    return clearSuggestionFeatureConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clears a suggestion feature from a conversation profile for the given participant role.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ClearSuggestionFeatureConfigOperationMetadata][google.cloud.dialogflow.v2.ClearSuggestionFeatureConfigOperationMetadata]
   * - `response`: [ConversationProfile][google.cloud.dialogflow.v2.ConversationProfile]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ClearSuggestionFeatureConfigRequest request =
   *       ClearSuggestionFeatureConfigRequest.newBuilder()
   *           .setConversationProfile("conversationProfile1691597734")
   *           .build();
   *   OperationFuture<ConversationProfile, ClearSuggestionFeatureConfigOperationMetadata> future =
   *       conversationProfilesClient
   *           .clearSuggestionFeatureConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ConversationProfile response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ClearSuggestionFeatureConfigRequest,
          ConversationProfile,
          ClearSuggestionFeatureConfigOperationMetadata>
      clearSuggestionFeatureConfigOperationCallable() {
    return stub.clearSuggestionFeatureConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clears a suggestion feature from a conversation profile for the given participant role.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ClearSuggestionFeatureConfigOperationMetadata][google.cloud.dialogflow.v2.ClearSuggestionFeatureConfigOperationMetadata]
   * - `response`: [ConversationProfile][google.cloud.dialogflow.v2.ConversationProfile]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ClearSuggestionFeatureConfigRequest request =
   *       ClearSuggestionFeatureConfigRequest.newBuilder()
   *           .setConversationProfile("conversationProfile1691597734")
   *           .build();
   *   ApiFuture<Operation> future =
   *       conversationProfilesClient.clearSuggestionFeatureConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ClearSuggestionFeatureConfigRequest, Operation>
      clearSuggestionFeatureConfigCallable() {
    return stub.clearSuggestionFeatureConfigCallable();
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
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : conversationProfilesClient.listLocations(request).iterateAll()) {
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
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       conversationProfilesClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         conversationProfilesClient.listLocationsCallable().call(request);
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
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = conversationProfilesClient.getLocation(request);
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
   * try (ConversationProfilesClient conversationProfilesClient =
   *     ConversationProfilesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       conversationProfilesClient.getLocationCallable().futureCall(request);
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

  public static class ListConversationProfilesPagedResponse
      extends AbstractPagedListResponse<
          ListConversationProfilesRequest,
          ListConversationProfilesResponse,
          ConversationProfile,
          ListConversationProfilesPage,
          ListConversationProfilesFixedSizeCollection> {

    public static ApiFuture<ListConversationProfilesPagedResponse> createAsync(
        PageContext<
                ListConversationProfilesRequest,
                ListConversationProfilesResponse,
                ConversationProfile>
            context,
        ApiFuture<ListConversationProfilesResponse> futureResponse) {
      ApiFuture<ListConversationProfilesPage> futurePage =
          ListConversationProfilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConversationProfilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConversationProfilesPagedResponse(ListConversationProfilesPage page) {
      super(page, ListConversationProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConversationProfilesPage
      extends AbstractPage<
          ListConversationProfilesRequest,
          ListConversationProfilesResponse,
          ConversationProfile,
          ListConversationProfilesPage> {

    private ListConversationProfilesPage(
        PageContext<
                ListConversationProfilesRequest,
                ListConversationProfilesResponse,
                ConversationProfile>
            context,
        ListConversationProfilesResponse response) {
      super(context, response);
    }

    private static ListConversationProfilesPage createEmptyPage() {
      return new ListConversationProfilesPage(null, null);
    }

    @Override
    protected ListConversationProfilesPage createPage(
        PageContext<
                ListConversationProfilesRequest,
                ListConversationProfilesResponse,
                ConversationProfile>
            context,
        ListConversationProfilesResponse response) {
      return new ListConversationProfilesPage(context, response);
    }

    @Override
    public ApiFuture<ListConversationProfilesPage> createPageAsync(
        PageContext<
                ListConversationProfilesRequest,
                ListConversationProfilesResponse,
                ConversationProfile>
            context,
        ApiFuture<ListConversationProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConversationProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConversationProfilesRequest,
          ListConversationProfilesResponse,
          ConversationProfile,
          ListConversationProfilesPage,
          ListConversationProfilesFixedSizeCollection> {

    private ListConversationProfilesFixedSizeCollection(
        List<ListConversationProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConversationProfilesFixedSizeCollection createEmptyCollection() {
      return new ListConversationProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConversationProfilesFixedSizeCollection createCollection(
        List<ListConversationProfilesPage> pages, int collectionSize) {
      return new ListConversationProfilesFixedSizeCollection(pages, collectionSize);
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
