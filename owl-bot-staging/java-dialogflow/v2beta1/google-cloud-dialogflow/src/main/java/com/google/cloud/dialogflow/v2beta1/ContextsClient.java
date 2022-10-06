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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.stub.ContextsStub;
import com.google.cloud.dialogflow.v2beta1.stub.ContextsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [Contexts][google.cloud.dialogflow.v2beta1.Context].
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
 * try (ContextsClient contextsClient = ContextsClient.create()) {
 *   ContextName name =
 *       ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]");
 *   Context response = contextsClient.getContext(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContextsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of ContextsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContextsSettings contextsSettings =
 *     ContextsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContextsClient contextsClient = ContextsClient.create(contextsSettings);
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
 * ContextsSettings contextsSettings =
 *     ContextsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContextsClient contextsClient = ContextsClient.create(contextsSettings);
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
 * ContextsSettings contextsSettings =
 *     ContextsSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ContextsSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ContextsClient contextsClient = ContextsClient.create(contextsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ContextsClient implements BackgroundResource {
  private final ContextsSettings settings;
  private final ContextsStub stub;

  /** Constructs an instance of ContextsClient with default settings. */
  public static final ContextsClient create() throws IOException {
    return create(ContextsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContextsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContextsClient create(ContextsSettings settings) throws IOException {
    return new ContextsClient(settings);
  }

  /**
   * Constructs an instance of ContextsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ContextsSettings).
   */
  public static final ContextsClient create(ContextsStub stub) {
    return new ContextsClient(stub);
  }

  /**
   * Constructs an instance of ContextsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ContextsClient(ContextsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContextsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ContextsClient(ContextsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContextsSettings getSettings() {
    return settings;
  }

  public ContextsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
   *   for (Context element : contextsClient.listContexts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The session to list all contexts from. Supported formats: -
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment. If `User ID` is not specified, we
   *     assume default '-' user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContextsPagedResponse listContexts(SessionName parent) {
    ListContextsRequest request =
        ListContextsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContexts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   String parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString();
   *   for (Context element : contextsClient.listContexts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The session to list all contexts from. Supported formats: -
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment. If `User ID` is not specified, we
   *     assume default '-' user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContextsPagedResponse listContexts(String parent) {
    ListContextsRequest request = ListContextsRequest.newBuilder().setParent(parent).build();
    return listContexts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ListContextsRequest request =
   *       ListContextsRequest.newBuilder()
   *           .setParent(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Context element : contextsClient.listContexts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContextsPagedResponse listContexts(ListContextsRequest request) {
    return listContextsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ListContextsRequest request =
   *       ListContextsRequest.newBuilder()
   *           .setParent(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Context> future = contextsClient.listContextsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Context element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListContextsRequest, ListContextsPagedResponse>
      listContextsPagedCallable() {
    return stub.listContextsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ListContextsRequest request =
   *       ListContextsRequest.newBuilder()
   *           .setParent(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListContextsResponse response = contextsClient.listContextsCallable().call(request);
   *     for (Context element : response.getContextsList()) {
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
  public final UnaryCallable<ListContextsRequest, ListContextsResponse> listContextsCallable() {
    return stub.listContextsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ContextName name =
   *       ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]");
   *   Context response = contextsClient.getContext(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the context. Supported formats: - `projects/&lt;Project
   *     ID&gt;/agent/sessions/&lt;Session ID&gt;/contexts/&lt;Context ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session
   *     ID&gt;/contexts/&lt;Context ID&gt;`, - `projects/&lt;Project
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;/contexts/&lt;Context ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;/contexts/&lt;Context ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment. If `User ID` is not specified, we
   *     assume default '-' user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context getContext(ContextName name) {
    GetContextRequest request =
        GetContextRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   String name =
   *       ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]").toString();
   *   Context response = contextsClient.getContext(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the context. Supported formats: - `projects/&lt;Project
   *     ID&gt;/agent/sessions/&lt;Session ID&gt;/contexts/&lt;Context ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session
   *     ID&gt;/contexts/&lt;Context ID&gt;`, - `projects/&lt;Project
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;/contexts/&lt;Context ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;/contexts/&lt;Context ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment. If `User ID` is not specified, we
   *     assume default '-' user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context getContext(String name) {
    GetContextRequest request = GetContextRequest.newBuilder().setName(name).build();
    return getContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   GetContextRequest request =
   *       GetContextRequest.newBuilder()
   *           .setName(
   *               ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]")
   *                   .toString())
   *           .build();
   *   Context response = contextsClient.getContext(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context getContext(GetContextRequest request) {
    return getContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   GetContextRequest request =
   *       GetContextRequest.newBuilder()
   *           .setName(
   *               ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Context> future = contextsClient.getContextCallable().futureCall(request);
   *   // Do something.
   *   Context response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetContextRequest, Context> getContextCallable() {
    return stub.getContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a context.
   *
   * <p>If the specified context already exists, overrides the context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
   *   Context context = Context.newBuilder().build();
   *   Context response = contextsClient.createContext(parent, context);
   * }
   * }</pre>
   *
   * @param parent Required. The session to create a context for. Supported formats: -
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment. If `User ID` is not specified, we
   *     assume default '-' user.
   * @param context Required. The context to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context createContext(SessionName parent, Context context) {
    CreateContextRequest request =
        CreateContextRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setContext(context)
            .build();
    return createContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a context.
   *
   * <p>If the specified context already exists, overrides the context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   String parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString();
   *   Context context = Context.newBuilder().build();
   *   Context response = contextsClient.createContext(parent, context);
   * }
   * }</pre>
   *
   * @param parent Required. The session to create a context for. Supported formats: -
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment. If `User ID` is not specified, we
   *     assume default '-' user.
   * @param context Required. The context to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context createContext(String parent, Context context) {
    CreateContextRequest request =
        CreateContextRequest.newBuilder().setParent(parent).setContext(context).build();
    return createContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a context.
   *
   * <p>If the specified context already exists, overrides the context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   CreateContextRequest request =
   *       CreateContextRequest.newBuilder()
   *           .setParent(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
   *           .setContext(Context.newBuilder().build())
   *           .build();
   *   Context response = contextsClient.createContext(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context createContext(CreateContextRequest request) {
    return createContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a context.
   *
   * <p>If the specified context already exists, overrides the context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   CreateContextRequest request =
   *       CreateContextRequest.newBuilder()
   *           .setParent(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
   *           .setContext(Context.newBuilder().build())
   *           .build();
   *   ApiFuture<Context> future = contextsClient.createContextCallable().futureCall(request);
   *   // Do something.
   *   Context response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateContextRequest, Context> createContextCallable() {
    return stub.createContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   Context context = Context.newBuilder().build();
   *   Context response = contextsClient.updateContext(context);
   * }
   * }</pre>
   *
   * @param context Required. The context to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context updateContext(Context context) {
    UpdateContextRequest request = UpdateContextRequest.newBuilder().setContext(context).build();
    return updateContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   Context context = Context.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Context response = contextsClient.updateContext(context, updateMask);
   * }
   * }</pre>
   *
   * @param context Required. The context to update.
   * @param updateMask Optional. The mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context updateContext(Context context, FieldMask updateMask) {
    UpdateContextRequest request =
        UpdateContextRequest.newBuilder().setContext(context).setUpdateMask(updateMask).build();
    return updateContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   UpdateContextRequest request =
   *       UpdateContextRequest.newBuilder()
   *           .setContext(Context.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Context response = contextsClient.updateContext(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context updateContext(UpdateContextRequest request) {
    return updateContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   UpdateContextRequest request =
   *       UpdateContextRequest.newBuilder()
   *           .setContext(Context.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Context> future = contextsClient.updateContextCallable().futureCall(request);
   *   // Do something.
   *   Context response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateContextRequest, Context> updateContextCallable() {
    return stub.updateContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ContextName name =
   *       ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]");
   *   contextsClient.deleteContext(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the context to delete. Supported formats: -
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;/contexts/&lt;Context
   *     ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/sessions/&lt;Session ID&gt;/contexts/&lt;Context ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;/contexts/&lt;Context ID&gt;`, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/environments/&lt;Environment
   *     ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session ID&gt;/contexts/&lt;Context ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment. If `User ID` is not specified, we
   *     assume default '-' user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteContext(ContextName name) {
    DeleteContextRequest request =
        DeleteContextRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   String name =
   *       ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]").toString();
   *   contextsClient.deleteContext(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the context to delete. Supported formats: -
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;/contexts/&lt;Context
   *     ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/sessions/&lt;Session ID&gt;/contexts/&lt;Context ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;/contexts/&lt;Context ID&gt;`, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/environments/&lt;Environment
   *     ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session ID&gt;/contexts/&lt;Context ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment. If `User ID` is not specified, we
   *     assume default '-' user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteContext(String name) {
    DeleteContextRequest request = DeleteContextRequest.newBuilder().setName(name).build();
    deleteContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   DeleteContextRequest request =
   *       DeleteContextRequest.newBuilder()
   *           .setName(
   *               ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]")
   *                   .toString())
   *           .build();
   *   contextsClient.deleteContext(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteContext(DeleteContextRequest request) {
    deleteContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   DeleteContextRequest request =
   *       DeleteContextRequest.newBuilder()
   *           .setName(
   *               ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = contextsClient.deleteContextCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteContextRequest, Empty> deleteContextCallable() {
    return stub.deleteContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all active contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
   *   contextsClient.deleteAllContexts(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the session to delete all contexts from. Supported formats:
   *     - `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified we assume default 'draft' environment. If `User ID` is not specified, we
   *     assume default '-' user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAllContexts(SessionName parent) {
    DeleteAllContextsRequest request =
        DeleteAllContextsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    deleteAllContexts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all active contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   String parent = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString();
   *   contextsClient.deleteAllContexts(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the session to delete all contexts from. Supported formats:
   *     - `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified we assume default 'draft' environment. If `User ID` is not specified, we
   *     assume default '-' user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAllContexts(String parent) {
    DeleteAllContextsRequest request =
        DeleteAllContextsRequest.newBuilder().setParent(parent).build();
    deleteAllContexts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all active contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   DeleteAllContextsRequest request =
   *       DeleteAllContextsRequest.newBuilder()
   *           .setParent(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
   *           .build();
   *   contextsClient.deleteAllContexts(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAllContexts(DeleteAllContextsRequest request) {
    deleteAllContextsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all active contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   DeleteAllContextsRequest request =
   *       DeleteAllContextsRequest.newBuilder()
   *           .setParent(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
   *           .build();
   *   ApiFuture<Empty> future = contextsClient.deleteAllContextsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAllContextsRequest, Empty> deleteAllContextsCallable() {
    return stub.deleteAllContextsCallable();
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
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : contextsClient.listLocations(request).iterateAll()) {
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
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = contextsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = contextsClient.listLocationsCallable().call(request);
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
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = contextsClient.getLocation(request);
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
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = contextsClient.getLocationCallable().futureCall(request);
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

  public static class ListContextsPagedResponse
      extends AbstractPagedListResponse<
          ListContextsRequest,
          ListContextsResponse,
          Context,
          ListContextsPage,
          ListContextsFixedSizeCollection> {

    public static ApiFuture<ListContextsPagedResponse> createAsync(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ApiFuture<ListContextsResponse> futureResponse) {
      ApiFuture<ListContextsPage> futurePage =
          ListContextsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListContextsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListContextsPagedResponse(ListContextsPage page) {
      super(page, ListContextsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListContextsPage
      extends AbstractPage<ListContextsRequest, ListContextsResponse, Context, ListContextsPage> {

    private ListContextsPage(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ListContextsResponse response) {
      super(context, response);
    }

    private static ListContextsPage createEmptyPage() {
      return new ListContextsPage(null, null);
    }

    @Override
    protected ListContextsPage createPage(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ListContextsResponse response) {
      return new ListContextsPage(context, response);
    }

    @Override
    public ApiFuture<ListContextsPage> createPageAsync(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ApiFuture<ListContextsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListContextsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListContextsRequest,
          ListContextsResponse,
          Context,
          ListContextsPage,
          ListContextsFixedSizeCollection> {

    private ListContextsFixedSizeCollection(List<ListContextsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListContextsFixedSizeCollection createEmptyCollection() {
      return new ListContextsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListContextsFixedSizeCollection createCollection(
        List<ListContextsPage> pages, int collectionSize) {
      return new ListContextsFixedSizeCollection(pages, collectionSize);
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
