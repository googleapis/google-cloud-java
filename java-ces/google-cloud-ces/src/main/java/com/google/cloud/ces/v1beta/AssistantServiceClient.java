/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ces.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ces.v1beta.stub.AssistantServiceStub;
import com.google.cloud.ces.v1beta.stub.AssistantServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The service that manages assistant-related resources in Customer Engagement
 * Suite (CES). The assistant, Arc, is a conversational agent embedded in CES applications to help
 * users with building their agents.
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
 * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
 *   AssistantSessionName name =
 *       AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]");
 *   AssistantSession response = assistantServiceClient.getAssistantSession(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AssistantServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListAssistantSessions</td>
 *      <td><p> Lists all assistant sessions in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAssistantSessions(ListAssistantSessionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAssistantSessions(AppName parent)
 *           <li><p> listAssistantSessions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAssistantSessionsPagedCallable()
 *           <li><p> listAssistantSessionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAssistantSession</td>
 *      <td><p> Gets details of the specified assistant session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAssistantSession(GetAssistantSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAssistantSession(AssistantSessionName name)
 *           <li><p> getAssistantSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAssistantSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAssistantSession</td>
 *      <td><p> Creates a new assistant session in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAssistantSession(CreateAssistantSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAssistantSession(AppName parent, String assistantSessionId)
 *           <li><p> createAssistantSession(String parent, String assistantSessionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAssistantSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAssistantSession</td>
 *      <td><p> Deletes the specified assistant session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAssistantSession(DeleteAssistantSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAssistantSession(AssistantSessionName name)
 *           <li><p> deleteAssistantSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAssistantSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunAssistant</td>
 *      <td><p> Runs the assistant agent for the specified assistant session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runAssistant(RunAssistantRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runAssistantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ChatAiAssistant</td>
 *      <td><p> Runs Arc, the AI assistant, for the specified assistant session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> chatAiAssistant(ChatAiAssistantRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> chatAiAssistantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of AssistantServiceSettings to
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
 * AssistantServiceSettings assistantServiceSettings =
 *     AssistantServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AssistantServiceClient assistantServiceClient =
 *     AssistantServiceClient.create(assistantServiceSettings);
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
 * AssistantServiceSettings assistantServiceSettings =
 *     AssistantServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AssistantServiceClient assistantServiceClient =
 *     AssistantServiceClient.create(assistantServiceSettings);
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
 * AssistantServiceSettings assistantServiceSettings =
 *     AssistantServiceSettings.newHttpJsonBuilder().build();
 * AssistantServiceClient assistantServiceClient =
 *     AssistantServiceClient.create(assistantServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class AssistantServiceClient implements BackgroundResource {
  private final @Nullable AssistantServiceSettings settings;
  private final AssistantServiceStub stub;

  /** Constructs an instance of AssistantServiceClient with default settings. */
  public static final AssistantServiceClient create() throws IOException {
    return create(AssistantServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AssistantServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AssistantServiceClient create(AssistantServiceSettings settings)
      throws IOException {
    return new AssistantServiceClient(settings);
  }

  /**
   * Constructs an instance of AssistantServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AssistantServiceSettings).
   */
  public static final AssistantServiceClient create(AssistantServiceStub stub) {
    return new AssistantServiceClient(stub);
  }

  /**
   * Constructs an instance of AssistantServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AssistantServiceClient(AssistantServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AssistantServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AssistantServiceClient(AssistantServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable AssistantServiceSettings getSettings() {
    return settings;
  }

  public AssistantServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all assistant sessions in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (AssistantSession element :
   *       assistantServiceClient.listAssistantSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The app to list assistant sessions from. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssistantSessionsPagedResponse listAssistantSessions(@Nullable AppName parent) {
    ListAssistantSessionsRequest request =
        ListAssistantSessionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAssistantSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all assistant sessions in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (AssistantSession element :
   *       assistantServiceClient.listAssistantSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The app to list assistant sessions from. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssistantSessionsPagedResponse listAssistantSessions(String parent) {
    ListAssistantSessionsRequest request =
        ListAssistantSessionsRequest.newBuilder().setParent(parent).build();
    return listAssistantSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all assistant sessions in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   ListAssistantSessionsRequest request =
   *       ListAssistantSessionsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (AssistantSession element :
   *       assistantServiceClient.listAssistantSessions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssistantSessionsPagedResponse listAssistantSessions(
      ListAssistantSessionsRequest request) {
    return listAssistantSessionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all assistant sessions in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   ListAssistantSessionsRequest request =
   *       ListAssistantSessionsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<AssistantSession> future =
   *       assistantServiceClient.listAssistantSessionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AssistantSession element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAssistantSessionsRequest, ListAssistantSessionsPagedResponse>
      listAssistantSessionsPagedCallable() {
    return stub.listAssistantSessionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all assistant sessions in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   ListAssistantSessionsRequest request =
   *       ListAssistantSessionsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAssistantSessionsResponse response =
   *         assistantServiceClient.listAssistantSessionsCallable().call(request);
   *     for (AssistantSession element : response.getAssistantSessionsList()) {
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
  public final UnaryCallable<ListAssistantSessionsRequest, ListAssistantSessionsResponse>
      listAssistantSessionsCallable() {
    return stub.listAssistantSessionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   AssistantSessionName name =
   *       AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]");
   *   AssistantSession response = assistantServiceClient.getAssistantSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the assistant session to retrieve. Format:
   *     `projects/{project}/locations/{location}/apps/{app}/assistantSessions/{assistant_session}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AssistantSession getAssistantSession(@Nullable AssistantSessionName name) {
    GetAssistantSessionRequest request =
        GetAssistantSessionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAssistantSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   String name =
   *       AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
   *           .toString();
   *   AssistantSession response = assistantServiceClient.getAssistantSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the assistant session to retrieve. Format:
   *     `projects/{project}/locations/{location}/apps/{app}/assistantSessions/{assistant_session}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AssistantSession getAssistantSession(String name) {
    GetAssistantSessionRequest request =
        GetAssistantSessionRequest.newBuilder().setName(name).build();
    return getAssistantSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   GetAssistantSessionRequest request =
   *       GetAssistantSessionRequest.newBuilder()
   *           .setName(
   *               AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
   *                   .toString())
   *           .build();
   *   AssistantSession response = assistantServiceClient.getAssistantSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AssistantSession getAssistantSession(GetAssistantSessionRequest request) {
    return getAssistantSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   GetAssistantSessionRequest request =
   *       GetAssistantSessionRequest.newBuilder()
   *           .setName(
   *               AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AssistantSession> future =
   *       assistantServiceClient.getAssistantSessionCallable().futureCall(request);
   *   // Do something.
   *   AssistantSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAssistantSessionRequest, AssistantSession>
      getAssistantSessionCallable() {
    return stub.getAssistantSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new assistant session in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   String assistantSessionId = "assistantSessionId-1566358253";
   *   AssistantSession response =
   *       assistantServiceClient.createAssistantSession(parent, assistantSessionId);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the assistant session in Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param assistantSessionId Optional. The ID to use for the assistant session, which will become
   *     the final component of the assistant session's resource name. If not provided, a unique ID
   *     will be automatically assigned for the assistant session.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AssistantSession createAssistantSession(
      @Nullable AppName parent, String assistantSessionId) {
    CreateAssistantSessionRequest request =
        CreateAssistantSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAssistantSessionId(assistantSessionId)
            .build();
    return createAssistantSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new assistant session in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   String assistantSessionId = "assistantSessionId-1566358253";
   *   AssistantSession response =
   *       assistantServiceClient.createAssistantSession(parent, assistantSessionId);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the assistant session in Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param assistantSessionId Optional. The ID to use for the assistant session, which will become
   *     the final component of the assistant session's resource name. If not provided, a unique ID
   *     will be automatically assigned for the assistant session.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AssistantSession createAssistantSession(String parent, String assistantSessionId) {
    CreateAssistantSessionRequest request =
        CreateAssistantSessionRequest.newBuilder()
            .setParent(parent)
            .setAssistantSessionId(assistantSessionId)
            .build();
    return createAssistantSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new assistant session in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   CreateAssistantSessionRequest request =
   *       CreateAssistantSessionRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAssistantSessionId("assistantSessionId-1566358253")
   *           .addAllAssistantSessionMessages(new ArrayList<AssistantMessage>())
   *           .build();
   *   AssistantSession response = assistantServiceClient.createAssistantSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AssistantSession createAssistantSession(CreateAssistantSessionRequest request) {
    return createAssistantSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new assistant session in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   CreateAssistantSessionRequest request =
   *       CreateAssistantSessionRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAssistantSessionId("assistantSessionId-1566358253")
   *           .addAllAssistantSessionMessages(new ArrayList<AssistantMessage>())
   *           .build();
   *   ApiFuture<AssistantSession> future =
   *       assistantServiceClient.createAssistantSessionCallable().futureCall(request);
   *   // Do something.
   *   AssistantSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAssistantSessionRequest, AssistantSession>
      createAssistantSessionCallable() {
    return stub.createAssistantSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   AssistantSessionName name =
   *       AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]");
   *   assistantServiceClient.deleteAssistantSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the assistant session to delete. Format:
   *     `projects/{project}/locations/{location}/apps/{app}/assistantSessions/{assistant_session}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssistantSession(@Nullable AssistantSessionName name) {
    DeleteAssistantSessionRequest request =
        DeleteAssistantSessionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAssistantSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   String name =
   *       AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
   *           .toString();
   *   assistantServiceClient.deleteAssistantSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the assistant session to delete. Format:
   *     `projects/{project}/locations/{location}/apps/{app}/assistantSessions/{assistant_session}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssistantSession(String name) {
    DeleteAssistantSessionRequest request =
        DeleteAssistantSessionRequest.newBuilder().setName(name).build();
    deleteAssistantSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   DeleteAssistantSessionRequest request =
   *       DeleteAssistantSessionRequest.newBuilder()
   *           .setName(
   *               AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
   *                   .toString())
   *           .build();
   *   assistantServiceClient.deleteAssistantSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssistantSession(DeleteAssistantSessionRequest request) {
    deleteAssistantSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   DeleteAssistantSessionRequest request =
   *       DeleteAssistantSessionRequest.newBuilder()
   *           .setName(
   *               AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       assistantServiceClient.deleteAssistantSessionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAssistantSessionRequest, Empty>
      deleteAssistantSessionCallable() {
    return stub.deleteAssistantSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs the assistant agent for the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   RunAssistantRequest request =
   *       RunAssistantRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAssistantSession(
   *               AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
   *                   .toString())
   *           .setMessage(AssistantMessage.newBuilder().build())
   *           .build();
   *   RunAssistantResponse response = assistantServiceClient.runAssistant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunAssistantResponse runAssistant(RunAssistantRequest request) {
    return runAssistantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs the assistant agent for the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   RunAssistantRequest request =
   *       RunAssistantRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAssistantSession(
   *               AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
   *                   .toString())
   *           .setMessage(AssistantMessage.newBuilder().build())
   *           .build();
   *   ApiFuture<RunAssistantResponse> future =
   *       assistantServiceClient.runAssistantCallable().futureCall(request);
   *   // Do something.
   *   RunAssistantResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunAssistantRequest, RunAssistantResponse> runAssistantCallable() {
    return stub.runAssistantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs Arc, the AI assistant, for the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   ChatAiAssistantRequest request =
   *       ChatAiAssistantRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAssistantSession(
   *               AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
   *                   .toString())
   *           .setMessage("message954925063")
   *           .addAllAttachedGcsUris(new ArrayList<String>())
   *           .setContextToken("contextToken1106626954")
   *           .build();
   *   ChatAiAssistantResponse response = assistantServiceClient.chatAiAssistant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChatAiAssistantResponse chatAiAssistant(ChatAiAssistantRequest request) {
    return chatAiAssistantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs Arc, the AI assistant, for the specified assistant session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   ChatAiAssistantRequest request =
   *       ChatAiAssistantRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAssistantSession(
   *               AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
   *                   .toString())
   *           .setMessage("message954925063")
   *           .addAllAttachedGcsUris(new ArrayList<String>())
   *           .setContextToken("contextToken1106626954")
   *           .build();
   *   ApiFuture<ChatAiAssistantResponse> future =
   *       assistantServiceClient.chatAiAssistantCallable().futureCall(request);
   *   // Do something.
   *   ChatAiAssistantResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ChatAiAssistantRequest, ChatAiAssistantResponse>
      chatAiAssistantCallable() {
    return stub.chatAiAssistantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : assistantServiceClient.listLocations(request).iterateAll()) {
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       assistantServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         assistantServiceClient.listLocationsCallable().call(request);
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
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = assistantServiceClient.getLocation(request);
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
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = assistantServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListAssistantSessionsPagedResponse
      extends AbstractPagedListResponse<
          ListAssistantSessionsRequest,
          ListAssistantSessionsResponse,
          AssistantSession,
          ListAssistantSessionsPage,
          ListAssistantSessionsFixedSizeCollection> {

    public static ApiFuture<ListAssistantSessionsPagedResponse> createAsync(
        PageContext<ListAssistantSessionsRequest, ListAssistantSessionsResponse, AssistantSession>
            context,
        ApiFuture<ListAssistantSessionsResponse> futureResponse) {
      ApiFuture<ListAssistantSessionsPage> futurePage =
          ListAssistantSessionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAssistantSessionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAssistantSessionsPagedResponse(ListAssistantSessionsPage page) {
      super(page, ListAssistantSessionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAssistantSessionsPage
      extends AbstractPage<
          ListAssistantSessionsRequest,
          ListAssistantSessionsResponse,
          AssistantSession,
          ListAssistantSessionsPage> {

    private ListAssistantSessionsPage(
        @Nullable
            PageContext<
                ListAssistantSessionsRequest, ListAssistantSessionsResponse, AssistantSession>
            context,
        @Nullable ListAssistantSessionsResponse response) {
      super(context, response);
    }

    private static ListAssistantSessionsPage createEmptyPage() {
      return new ListAssistantSessionsPage(null, null);
    }

    @Override
    protected ListAssistantSessionsPage createPage(
        @Nullable
            PageContext<
                ListAssistantSessionsRequest, ListAssistantSessionsResponse, AssistantSession>
            context,
        @Nullable ListAssistantSessionsResponse response) {
      return new ListAssistantSessionsPage(context, response);
    }

    @Override
    public ApiFuture<ListAssistantSessionsPage> createPageAsync(
        @Nullable
            PageContext<
                ListAssistantSessionsRequest, ListAssistantSessionsResponse, AssistantSession>
            context,
        ApiFuture<ListAssistantSessionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssistantSessionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAssistantSessionsRequest,
          ListAssistantSessionsResponse,
          AssistantSession,
          ListAssistantSessionsPage,
          ListAssistantSessionsFixedSizeCollection> {

    private ListAssistantSessionsFixedSizeCollection(
        @Nullable List<ListAssistantSessionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAssistantSessionsFixedSizeCollection createEmptyCollection() {
      return new ListAssistantSessionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAssistantSessionsFixedSizeCollection createCollection(
        @Nullable List<ListAssistantSessionsPage> pages, int collectionSize) {
      return new ListAssistantSessionsFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
