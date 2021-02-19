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

package com.google.cloud.dialogflow.cx.v3beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.stub.TransitionRouteGroupsStub;
import com.google.cloud.dialogflow.cx.v3beta1.stub.TransitionRouteGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [TransitionRouteGroups][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
 *     TransitionRouteGroupsClient.create()) {
 *   TransitionRouteGroupName name =
 *       TransitionRouteGroupName.of(
 *           "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");
 *   TransitionRouteGroup response = transitionRouteGroupsClient.getTransitionRouteGroup(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TransitionRouteGroupsClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of TransitionRouteGroupsSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * TransitionRouteGroupsSettings transitionRouteGroupsSettings =
 *     TransitionRouteGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TransitionRouteGroupsClient transitionRouteGroupsClient =
 *     TransitionRouteGroupsClient.create(transitionRouteGroupsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * TransitionRouteGroupsSettings transitionRouteGroupsSettings =
 *     TransitionRouteGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TransitionRouteGroupsClient transitionRouteGroupsClient =
 *     TransitionRouteGroupsClient.create(transitionRouteGroupsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TransitionRouteGroupsClient implements BackgroundResource {
  private final TransitionRouteGroupsSettings settings;
  private final TransitionRouteGroupsStub stub;

  /** Constructs an instance of TransitionRouteGroupsClient with default settings. */
  public static final TransitionRouteGroupsClient create() throws IOException {
    return create(TransitionRouteGroupsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TransitionRouteGroupsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TransitionRouteGroupsClient create(TransitionRouteGroupsSettings settings)
      throws IOException {
    return new TransitionRouteGroupsClient(settings);
  }

  /**
   * Constructs an instance of TransitionRouteGroupsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(TransitionRouteGroupsSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TransitionRouteGroupsClient create(TransitionRouteGroupsStub stub) {
    return new TransitionRouteGroupsClient(stub);
  }

  /**
   * Constructs an instance of TransitionRouteGroupsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected TransitionRouteGroupsClient(TransitionRouteGroupsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TransitionRouteGroupsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TransitionRouteGroupsClient(TransitionRouteGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TransitionRouteGroupsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TransitionRouteGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all transition route groups in the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   FlowName parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
   *   for (TransitionRouteGroup element :
   *       transitionRouteGroupsClient.listTransitionRouteGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The flow to list all transition route groups for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/flows/&lt;Flow ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransitionRouteGroupsPagedResponse listTransitionRouteGroups(FlowName parent) {
    ListTransitionRouteGroupsRequest request =
        ListTransitionRouteGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTransitionRouteGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all transition route groups in the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   String parent =
   *       TransitionRouteGroupName.of(
   *               "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]")
   *           .toString();
   *   for (TransitionRouteGroup element :
   *       transitionRouteGroupsClient.listTransitionRouteGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The flow to list all transition route groups for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/flows/&lt;Flow ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransitionRouteGroupsPagedResponse listTransitionRouteGroups(String parent) {
    ListTransitionRouteGroupsRequest request =
        ListTransitionRouteGroupsRequest.newBuilder().setParent(parent).build();
    return listTransitionRouteGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all transition route groups in the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   ListTransitionRouteGroupsRequest request =
   *       ListTransitionRouteGroupsRequest.newBuilder()
   *           .setParent(
   *               TransitionRouteGroupName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[AGENT]",
   *                       "[FLOW]",
   *                       "[TRANSITION_ROUTE_GROUP]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (TransitionRouteGroup element :
   *       transitionRouteGroupsClient.listTransitionRouteGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransitionRouteGroupsPagedResponse listTransitionRouteGroups(
      ListTransitionRouteGroupsRequest request) {
    return listTransitionRouteGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all transition route groups in the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   ListTransitionRouteGroupsRequest request =
   *       ListTransitionRouteGroupsRequest.newBuilder()
   *           .setParent(
   *               TransitionRouteGroupName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[AGENT]",
   *                       "[FLOW]",
   *                       "[TRANSITION_ROUTE_GROUP]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<TransitionRouteGroup> future =
   *       transitionRouteGroupsClient.listTransitionRouteGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TransitionRouteGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListTransitionRouteGroupsRequest, ListTransitionRouteGroupsPagedResponse>
      listTransitionRouteGroupsPagedCallable() {
    return stub.listTransitionRouteGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all transition route groups in the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   while (true) {
   *     ListTransitionRouteGroupsResponse response =
   *         transitionRouteGroupsClient.listTransitionRouteGroupsCallable().call(request);
   *     for (TransitionRouteGroup element : response.getResponsesList()) {
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
  public final UnaryCallable<ListTransitionRouteGroupsRequest, ListTransitionRouteGroupsResponse>
      listTransitionRouteGroupsCallable() {
    return stub.listTransitionRouteGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   TransitionRouteGroupName name =
   *       TransitionRouteGroupName.of(
   *           "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");
   *   TransitionRouteGroup response = transitionRouteGroupsClient.getTransitionRouteGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup]. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/flows/&lt;Flow ID&gt;/transitionRouteGroups/&lt;Transition Route Group ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransitionRouteGroup getTransitionRouteGroup(TransitionRouteGroupName name) {
    GetTransitionRouteGroupRequest request =
        GetTransitionRouteGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTransitionRouteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   String name =
   *       TransitionRouteGroupName.of(
   *               "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]")
   *           .toString();
   *   TransitionRouteGroup response = transitionRouteGroupsClient.getTransitionRouteGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup]. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/flows/&lt;Flow ID&gt;/transitionRouteGroups/&lt;Transition Route Group ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransitionRouteGroup getTransitionRouteGroup(String name) {
    GetTransitionRouteGroupRequest request =
        GetTransitionRouteGroupRequest.newBuilder().setName(name).build();
    return getTransitionRouteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   GetTransitionRouteGroupRequest request =
   *       GetTransitionRouteGroupRequest.newBuilder()
   *           .setName(
   *               TransitionRouteGroupName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[AGENT]",
   *                       "[FLOW]",
   *                       "[TRANSITION_ROUTE_GROUP]")
   *                   .toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   TransitionRouteGroup response = transitionRouteGroupsClient.getTransitionRouteGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransitionRouteGroup getTransitionRouteGroup(
      GetTransitionRouteGroupRequest request) {
    return getTransitionRouteGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   GetTransitionRouteGroupRequest request =
   *       GetTransitionRouteGroupRequest.newBuilder()
   *           .setName(
   *               TransitionRouteGroupName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[AGENT]",
   *                       "[FLOW]",
   *                       "[TRANSITION_ROUTE_GROUP]")
   *                   .toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<TransitionRouteGroup> future =
   *       transitionRouteGroupsClient.getTransitionRouteGroupCallable().futureCall(request);
   *   // Do something.
   *   TransitionRouteGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTransitionRouteGroupRequest, TransitionRouteGroup>
      getTransitionRouteGroupCallable() {
    return stub.getTransitionRouteGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup] in
   * the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   FlowName parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
   *   TransitionRouteGroup transitionRouteGroup = TransitionRouteGroup.newBuilder().build();
   *   TransitionRouteGroup response =
   *       transitionRouteGroupsClient.createTransitionRouteGroup(parent, transitionRouteGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The flow to create an
   *     [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup] for.
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/flows/&lt;Flow ID&gt;`.
   * @param transitionRouteGroup Required. The transition route group to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransitionRouteGroup createTransitionRouteGroup(
      FlowName parent, TransitionRouteGroup transitionRouteGroup) {
    CreateTransitionRouteGroupRequest request =
        CreateTransitionRouteGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTransitionRouteGroup(transitionRouteGroup)
            .build();
    return createTransitionRouteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup] in
   * the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   String parent =
   *       TransitionRouteGroupName.of(
   *               "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]")
   *           .toString();
   *   TransitionRouteGroup transitionRouteGroup = TransitionRouteGroup.newBuilder().build();
   *   TransitionRouteGroup response =
   *       transitionRouteGroupsClient.createTransitionRouteGroup(parent, transitionRouteGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The flow to create an
   *     [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup] for.
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/flows/&lt;Flow ID&gt;`.
   * @param transitionRouteGroup Required. The transition route group to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransitionRouteGroup createTransitionRouteGroup(
      String parent, TransitionRouteGroup transitionRouteGroup) {
    CreateTransitionRouteGroupRequest request =
        CreateTransitionRouteGroupRequest.newBuilder()
            .setParent(parent)
            .setTransitionRouteGroup(transitionRouteGroup)
            .build();
    return createTransitionRouteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup] in
   * the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   CreateTransitionRouteGroupRequest request =
   *       CreateTransitionRouteGroupRequest.newBuilder()
   *           .setParent(
   *               TransitionRouteGroupName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[AGENT]",
   *                       "[FLOW]",
   *                       "[TRANSITION_ROUTE_GROUP]")
   *                   .toString())
   *           .setTransitionRouteGroup(TransitionRouteGroup.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   TransitionRouteGroup response =
   *       transitionRouteGroupsClient.createTransitionRouteGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransitionRouteGroup createTransitionRouteGroup(
      CreateTransitionRouteGroupRequest request) {
    return createTransitionRouteGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup] in
   * the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   CreateTransitionRouteGroupRequest request =
   *       CreateTransitionRouteGroupRequest.newBuilder()
   *           .setParent(
   *               TransitionRouteGroupName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[AGENT]",
   *                       "[FLOW]",
   *                       "[TRANSITION_ROUTE_GROUP]")
   *                   .toString())
   *           .setTransitionRouteGroup(TransitionRouteGroup.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<TransitionRouteGroup> future =
   *       transitionRouteGroupsClient.createTransitionRouteGroupCallable().futureCall(request);
   *   // Do something.
   *   TransitionRouteGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTransitionRouteGroupRequest, TransitionRouteGroup>
      createTransitionRouteGroupCallable() {
    return stub.createTransitionRouteGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   TransitionRouteGroup transitionRouteGroup = TransitionRouteGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TransitionRouteGroup response =
   *       transitionRouteGroupsClient.updateTransitionRouteGroup(transitionRouteGroup, updateMask);
   * }
   * }</pre>
   *
   * @param transitionRouteGroup Required. The transition route group to update.
   * @param updateMask The mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransitionRouteGroup updateTransitionRouteGroup(
      TransitionRouteGroup transitionRouteGroup, FieldMask updateMask) {
    UpdateTransitionRouteGroupRequest request =
        UpdateTransitionRouteGroupRequest.newBuilder()
            .setTransitionRouteGroup(transitionRouteGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateTransitionRouteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   UpdateTransitionRouteGroupRequest request =
   *       UpdateTransitionRouteGroupRequest.newBuilder()
   *           .setTransitionRouteGroup(TransitionRouteGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   TransitionRouteGroup response =
   *       transitionRouteGroupsClient.updateTransitionRouteGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransitionRouteGroup updateTransitionRouteGroup(
      UpdateTransitionRouteGroupRequest request) {
    return updateTransitionRouteGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   UpdateTransitionRouteGroupRequest request =
   *       UpdateTransitionRouteGroupRequest.newBuilder()
   *           .setTransitionRouteGroup(TransitionRouteGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<TransitionRouteGroup> future =
   *       transitionRouteGroupsClient.updateTransitionRouteGroupCallable().futureCall(request);
   *   // Do something.
   *   TransitionRouteGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTransitionRouteGroupRequest, TransitionRouteGroup>
      updateTransitionRouteGroupCallable() {
    return stub.updateTransitionRouteGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   TransitionRouteGroupName name =
   *       TransitionRouteGroupName.of(
   *           "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");
   *   transitionRouteGroupsClient.deleteTransitionRouteGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup] to delete.
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/flows/&lt;Flow ID&gt;/transitionRouteGroups/&lt;Transition Route Group ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTransitionRouteGroup(TransitionRouteGroupName name) {
    DeleteTransitionRouteGroupRequest request =
        DeleteTransitionRouteGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteTransitionRouteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   String name =
   *       TransitionRouteGroupName.of(
   *               "[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]")
   *           .toString();
   *   transitionRouteGroupsClient.deleteTransitionRouteGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup] to delete.
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/flows/&lt;Flow ID&gt;/transitionRouteGroups/&lt;Transition Route Group ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTransitionRouteGroup(String name) {
    DeleteTransitionRouteGroupRequest request =
        DeleteTransitionRouteGroupRequest.newBuilder().setName(name).build();
    deleteTransitionRouteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   DeleteTransitionRouteGroupRequest request =
   *       DeleteTransitionRouteGroupRequest.newBuilder()
   *           .setName(
   *               TransitionRouteGroupName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[AGENT]",
   *                       "[FLOW]",
   *                       "[TRANSITION_ROUTE_GROUP]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   transitionRouteGroupsClient.deleteTransitionRouteGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTransitionRouteGroup(DeleteTransitionRouteGroupRequest request) {
    deleteTransitionRouteGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified
   * [TransitionRouteGroup][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TransitionRouteGroupsClient transitionRouteGroupsClient =
   *     TransitionRouteGroupsClient.create()) {
   *   DeleteTransitionRouteGroupRequest request =
   *       DeleteTransitionRouteGroupRequest.newBuilder()
   *           .setName(
   *               TransitionRouteGroupName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[AGENT]",
   *                       "[FLOW]",
   *                       "[TRANSITION_ROUTE_GROUP]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       transitionRouteGroupsClient.deleteTransitionRouteGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTransitionRouteGroupRequest, Empty>
      deleteTransitionRouteGroupCallable() {
    return stub.deleteTransitionRouteGroupCallable();
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

  public static class ListTransitionRouteGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListTransitionRouteGroupsRequest,
          ListTransitionRouteGroupsResponse,
          TransitionRouteGroup,
          ListTransitionRouteGroupsPage,
          ListTransitionRouteGroupsFixedSizeCollection> {

    public static ApiFuture<ListTransitionRouteGroupsPagedResponse> createAsync(
        PageContext<
                ListTransitionRouteGroupsRequest,
                ListTransitionRouteGroupsResponse,
                TransitionRouteGroup>
            context,
        ApiFuture<ListTransitionRouteGroupsResponse> futureResponse) {
      ApiFuture<ListTransitionRouteGroupsPage> futurePage =
          ListTransitionRouteGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTransitionRouteGroupsPage, ListTransitionRouteGroupsPagedResponse>() {
            @Override
            public ListTransitionRouteGroupsPagedResponse apply(
                ListTransitionRouteGroupsPage input) {
              return new ListTransitionRouteGroupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListTransitionRouteGroupsPagedResponse(ListTransitionRouteGroupsPage page) {
      super(page, ListTransitionRouteGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransitionRouteGroupsPage
      extends AbstractPage<
          ListTransitionRouteGroupsRequest,
          ListTransitionRouteGroupsResponse,
          TransitionRouteGroup,
          ListTransitionRouteGroupsPage> {

    private ListTransitionRouteGroupsPage(
        PageContext<
                ListTransitionRouteGroupsRequest,
                ListTransitionRouteGroupsResponse,
                TransitionRouteGroup>
            context,
        ListTransitionRouteGroupsResponse response) {
      super(context, response);
    }

    private static ListTransitionRouteGroupsPage createEmptyPage() {
      return new ListTransitionRouteGroupsPage(null, null);
    }

    @Override
    protected ListTransitionRouteGroupsPage createPage(
        PageContext<
                ListTransitionRouteGroupsRequest,
                ListTransitionRouteGroupsResponse,
                TransitionRouteGroup>
            context,
        ListTransitionRouteGroupsResponse response) {
      return new ListTransitionRouteGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListTransitionRouteGroupsPage> createPageAsync(
        PageContext<
                ListTransitionRouteGroupsRequest,
                ListTransitionRouteGroupsResponse,
                TransitionRouteGroup>
            context,
        ApiFuture<ListTransitionRouteGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransitionRouteGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTransitionRouteGroupsRequest,
          ListTransitionRouteGroupsResponse,
          TransitionRouteGroup,
          ListTransitionRouteGroupsPage,
          ListTransitionRouteGroupsFixedSizeCollection> {

    private ListTransitionRouteGroupsFixedSizeCollection(
        List<ListTransitionRouteGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransitionRouteGroupsFixedSizeCollection createEmptyCollection() {
      return new ListTransitionRouteGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransitionRouteGroupsFixedSizeCollection createCollection(
        List<ListTransitionRouteGroupsPage> pages, int collectionSize) {
      return new ListTransitionRouteGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
