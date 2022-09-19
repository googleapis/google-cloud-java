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

package com.google.cloud.dialogflow.cx.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.stub.WebhooksStub;
import com.google.cloud.dialogflow.cx.v3.stub.WebhooksStubSettings;
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
 * Service Description: Service for managing [Webhooks][google.cloud.dialogflow.cx.v3.Webhook].
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
 * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
 *   WebhookName name = WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]");
 *   Webhook response = webhooksClient.getWebhook(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the WebhooksClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of WebhooksSettings to create().
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
 * WebhooksSettings webhooksSettings =
 *     WebhooksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WebhooksClient webhooksClient = WebhooksClient.create(webhooksSettings);
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
 * WebhooksSettings webhooksSettings =
 *     WebhooksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WebhooksClient webhooksClient = WebhooksClient.create(webhooksSettings);
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
 * WebhooksSettings webhooksSettings =
 *     WebhooksSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             WebhooksSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * WebhooksClient webhooksClient = WebhooksClient.create(webhooksSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class WebhooksClient implements BackgroundResource {
  private final WebhooksSettings settings;
  private final WebhooksStub stub;

  /** Constructs an instance of WebhooksClient with default settings. */
  public static final WebhooksClient create() throws IOException {
    return create(WebhooksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WebhooksClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WebhooksClient create(WebhooksSettings settings) throws IOException {
    return new WebhooksClient(settings);
  }

  /**
   * Constructs an instance of WebhooksClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(WebhooksSettings).
   */
  public static final WebhooksClient create(WebhooksStub stub) {
    return new WebhooksClient(stub);
  }

  /**
   * Constructs an instance of WebhooksClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected WebhooksClient(WebhooksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WebhooksStubSettings) settings.getStubSettings()).createStub();
  }

  protected WebhooksClient(WebhooksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final WebhooksSettings getSettings() {
    return settings;
  }

  public WebhooksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all webhooks in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   for (Webhook element : webhooksClient.listWebhooks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent to list all webhooks for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWebhooksPagedResponse listWebhooks(AgentName parent) {
    ListWebhooksRequest request =
        ListWebhooksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWebhooks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all webhooks in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   for (Webhook element : webhooksClient.listWebhooks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent to list all webhooks for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWebhooksPagedResponse listWebhooks(String parent) {
    ListWebhooksRequest request = ListWebhooksRequest.newBuilder().setParent(parent).build();
    return listWebhooks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all webhooks in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   ListWebhooksRequest request =
   *       ListWebhooksRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Webhook element : webhooksClient.listWebhooks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWebhooksPagedResponse listWebhooks(ListWebhooksRequest request) {
    return listWebhooksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all webhooks in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   ListWebhooksRequest request =
   *       ListWebhooksRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Webhook> future = webhooksClient.listWebhooksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Webhook element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWebhooksRequest, ListWebhooksPagedResponse>
      listWebhooksPagedCallable() {
    return stub.listWebhooksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all webhooks in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   ListWebhooksRequest request =
   *       ListWebhooksRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListWebhooksResponse response = webhooksClient.listWebhooksCallable().call(request);
   *     for (Webhook element : response.getWebhooksList()) {
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
  public final UnaryCallable<ListWebhooksRequest, ListWebhooksResponse> listWebhooksCallable() {
    return stub.listWebhooksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   WebhookName name = WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]");
   *   Webhook response = webhooksClient.getWebhook(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the webhook. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/webhooks/&lt;Webhook ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Webhook getWebhook(WebhookName name) {
    GetWebhookRequest request =
        GetWebhookRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWebhook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   String name = WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString();
   *   Webhook response = webhooksClient.getWebhook(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the webhook. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/webhooks/&lt;Webhook ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Webhook getWebhook(String name) {
    GetWebhookRequest request = GetWebhookRequest.newBuilder().setName(name).build();
    return getWebhook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   GetWebhookRequest request =
   *       GetWebhookRequest.newBuilder()
   *           .setName(WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString())
   *           .build();
   *   Webhook response = webhooksClient.getWebhook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Webhook getWebhook(GetWebhookRequest request) {
    return getWebhookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   GetWebhookRequest request =
   *       GetWebhookRequest.newBuilder()
   *           .setName(WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString())
   *           .build();
   *   ApiFuture<Webhook> future = webhooksClient.getWebhookCallable().futureCall(request);
   *   // Do something.
   *   Webhook response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWebhookRequest, Webhook> getWebhookCallable() {
    return stub.getWebhookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a webhook in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   Webhook webhook = Webhook.newBuilder().build();
   *   Webhook response = webhooksClient.createWebhook(parent, webhook);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create a webhook for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param webhook Required. The webhook to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Webhook createWebhook(AgentName parent, Webhook webhook) {
    CreateWebhookRequest request =
        CreateWebhookRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWebhook(webhook)
            .build();
    return createWebhook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a webhook in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   Webhook webhook = Webhook.newBuilder().build();
   *   Webhook response = webhooksClient.createWebhook(parent, webhook);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create a webhook for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param webhook Required. The webhook to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Webhook createWebhook(String parent, Webhook webhook) {
    CreateWebhookRequest request =
        CreateWebhookRequest.newBuilder().setParent(parent).setWebhook(webhook).build();
    return createWebhook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a webhook in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   CreateWebhookRequest request =
   *       CreateWebhookRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setWebhook(Webhook.newBuilder().build())
   *           .build();
   *   Webhook response = webhooksClient.createWebhook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Webhook createWebhook(CreateWebhookRequest request) {
    return createWebhookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a webhook in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   CreateWebhookRequest request =
   *       CreateWebhookRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setWebhook(Webhook.newBuilder().build())
   *           .build();
   *   ApiFuture<Webhook> future = webhooksClient.createWebhookCallable().futureCall(request);
   *   // Do something.
   *   Webhook response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWebhookRequest, Webhook> createWebhookCallable() {
    return stub.createWebhookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   Webhook webhook = Webhook.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Webhook response = webhooksClient.updateWebhook(webhook, updateMask);
   * }
   * }</pre>
   *
   * @param webhook Required. The webhook to update.
   * @param updateMask The mask to control which fields get updated. If the mask is not present, all
   *     fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Webhook updateWebhook(Webhook webhook, FieldMask updateMask) {
    UpdateWebhookRequest request =
        UpdateWebhookRequest.newBuilder().setWebhook(webhook).setUpdateMask(updateMask).build();
    return updateWebhook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   UpdateWebhookRequest request =
   *       UpdateWebhookRequest.newBuilder()
   *           .setWebhook(Webhook.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Webhook response = webhooksClient.updateWebhook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Webhook updateWebhook(UpdateWebhookRequest request) {
    return updateWebhookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   UpdateWebhookRequest request =
   *       UpdateWebhookRequest.newBuilder()
   *           .setWebhook(Webhook.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Webhook> future = webhooksClient.updateWebhookCallable().futureCall(request);
   *   // Do something.
   *   Webhook response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWebhookRequest, Webhook> updateWebhookCallable() {
    return stub.updateWebhookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   WebhookName name = WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]");
   *   webhooksClient.deleteWebhook(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the webhook to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/webhooks/&lt;Webhook ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWebhook(WebhookName name) {
    DeleteWebhookRequest request =
        DeleteWebhookRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteWebhook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   String name = WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString();
   *   webhooksClient.deleteWebhook(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the webhook to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/webhooks/&lt;Webhook ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWebhook(String name) {
    DeleteWebhookRequest request = DeleteWebhookRequest.newBuilder().setName(name).build();
    deleteWebhook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   DeleteWebhookRequest request =
   *       DeleteWebhookRequest.newBuilder()
   *           .setName(WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString())
   *           .setForce(true)
   *           .build();
   *   webhooksClient.deleteWebhook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWebhook(DeleteWebhookRequest request) {
    deleteWebhookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified webhook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   DeleteWebhookRequest request =
   *       DeleteWebhookRequest.newBuilder()
   *           .setName(WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = webhooksClient.deleteWebhookCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWebhookRequest, Empty> deleteWebhookCallable() {
    return stub.deleteWebhookCallable();
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
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : webhooksClient.listLocations(request).iterateAll()) {
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
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = webhooksClient.listLocationsPagedCallable().futureCall(request);
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
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = webhooksClient.listLocationsCallable().call(request);
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
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = webhooksClient.getLocation(request);
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
   * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = webhooksClient.getLocationCallable().futureCall(request);
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

  public static class ListWebhooksPagedResponse
      extends AbstractPagedListResponse<
          ListWebhooksRequest,
          ListWebhooksResponse,
          Webhook,
          ListWebhooksPage,
          ListWebhooksFixedSizeCollection> {

    public static ApiFuture<ListWebhooksPagedResponse> createAsync(
        PageContext<ListWebhooksRequest, ListWebhooksResponse, Webhook> context,
        ApiFuture<ListWebhooksResponse> futureResponse) {
      ApiFuture<ListWebhooksPage> futurePage =
          ListWebhooksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWebhooksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWebhooksPagedResponse(ListWebhooksPage page) {
      super(page, ListWebhooksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWebhooksPage
      extends AbstractPage<ListWebhooksRequest, ListWebhooksResponse, Webhook, ListWebhooksPage> {

    private ListWebhooksPage(
        PageContext<ListWebhooksRequest, ListWebhooksResponse, Webhook> context,
        ListWebhooksResponse response) {
      super(context, response);
    }

    private static ListWebhooksPage createEmptyPage() {
      return new ListWebhooksPage(null, null);
    }

    @Override
    protected ListWebhooksPage createPage(
        PageContext<ListWebhooksRequest, ListWebhooksResponse, Webhook> context,
        ListWebhooksResponse response) {
      return new ListWebhooksPage(context, response);
    }

    @Override
    public ApiFuture<ListWebhooksPage> createPageAsync(
        PageContext<ListWebhooksRequest, ListWebhooksResponse, Webhook> context,
        ApiFuture<ListWebhooksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWebhooksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWebhooksRequest,
          ListWebhooksResponse,
          Webhook,
          ListWebhooksPage,
          ListWebhooksFixedSizeCollection> {

    private ListWebhooksFixedSizeCollection(List<ListWebhooksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWebhooksFixedSizeCollection createEmptyCollection() {
      return new ListWebhooksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWebhooksFixedSizeCollection createCollection(
        List<ListWebhooksPage> pages, int collectionSize) {
      return new ListWebhooksFixedSizeCollection(pages, collectionSize);
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
