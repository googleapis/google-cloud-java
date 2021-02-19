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
import com.google.cloud.dialogflow.cx.v3beta1.stub.IntentsStub;
import com.google.cloud.dialogflow.cx.v3beta1.stub.IntentsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [Intents][google.cloud.dialogflow.cx.v3beta1.Intent].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (IntentsClient intentsClient = IntentsClient.create()) {
 *   IntentName name = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]");
 *   Intent response = intentsClient.getIntent(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IntentsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of IntentsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * IntentsSettings intentsSettings =
 *     IntentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IntentsClient intentsClient = IntentsClient.create(intentsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * IntentsSettings intentsSettings = IntentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IntentsClient intentsClient = IntentsClient.create(intentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class IntentsClient implements BackgroundResource {
  private final IntentsSettings settings;
  private final IntentsStub stub;

  /** Constructs an instance of IntentsClient with default settings. */
  public static final IntentsClient create() throws IOException {
    return create(IntentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IntentsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IntentsClient create(IntentsSettings settings) throws IOException {
    return new IntentsClient(settings);
  }

  /**
   * Constructs an instance of IntentsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(IntentsSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final IntentsClient create(IntentsStub stub) {
    return new IntentsClient(stub);
  }

  /**
   * Constructs an instance of IntentsClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected IntentsClient(IntentsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IntentsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected IntentsClient(IntentsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IntentsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public IntentsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all intents in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   for (Intent element : intentsClient.listIntents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent to list all intents for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIntentsPagedResponse listIntents(AgentName parent) {
    ListIntentsRequest request =
        ListIntentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIntents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all intents in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   String parent = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString();
   *   for (Intent element : intentsClient.listIntents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent to list all intents for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIntentsPagedResponse listIntents(String parent) {
    ListIntentsRequest request = ListIntentsRequest.newBuilder().setParent(parent).build();
    return listIntents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all intents in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   ListIntentsRequest request =
   *       ListIntentsRequest.newBuilder()
   *           .setParent(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setIntentView(IntentView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Intent element : intentsClient.listIntents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIntentsPagedResponse listIntents(ListIntentsRequest request) {
    return listIntentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all intents in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   ListIntentsRequest request =
   *       ListIntentsRequest.newBuilder()
   *           .setParent(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setIntentView(IntentView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Intent> future = intentsClient.listIntentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Intent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIntentsRequest, ListIntentsPagedResponse>
      listIntentsPagedCallable() {
    return stub.listIntentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all intents in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   while (true) {
   *     ListIntentsResponse response = intentsClient.listIntentsCallable().call(request);
   *     for (Intent element : response.getResponsesList()) {
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
  public final UnaryCallable<ListIntentsRequest, ListIntentsResponse> listIntentsCallable() {
    return stub.listIntentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   IntentName name = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]");
   *   Intent response = intentsClient.getIntent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the intent. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/intents/&lt;Intent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Intent getIntent(IntentName name) {
    GetIntentRequest request =
        GetIntentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIntent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   String name = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString();
   *   Intent response = intentsClient.getIntent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the intent. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/intents/&lt;Intent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Intent getIntent(String name) {
    GetIntentRequest request = GetIntentRequest.newBuilder().setName(name).build();
    return getIntent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   GetIntentRequest request =
   *       GetIntentRequest.newBuilder()
   *           .setName(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   Intent response = intentsClient.getIntent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Intent getIntent(GetIntentRequest request) {
    return getIntentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   GetIntentRequest request =
   *       GetIntentRequest.newBuilder()
   *           .setName(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Intent> future = intentsClient.getIntentCallable().futureCall(request);
   *   // Do something.
   *   Intent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIntentRequest, Intent> getIntentCallable() {
    return stub.getIntentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an intent in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   Intent intent = Intent.newBuilder().build();
   *   Intent response = intentsClient.createIntent(parent, intent);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create an intent for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param intent Required. The intent to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Intent createIntent(AgentName parent, Intent intent) {
    CreateIntentRequest request =
        CreateIntentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIntent(intent)
            .build();
    return createIntent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an intent in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   String parent = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString();
   *   Intent intent = Intent.newBuilder().build();
   *   Intent response = intentsClient.createIntent(parent, intent);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create an intent for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param intent Required. The intent to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Intent createIntent(String parent, Intent intent) {
    CreateIntentRequest request =
        CreateIntentRequest.newBuilder().setParent(parent).setIntent(intent).build();
    return createIntent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an intent in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   CreateIntentRequest request =
   *       CreateIntentRequest.newBuilder()
   *           .setParent(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
   *           .setIntent(Intent.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   Intent response = intentsClient.createIntent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Intent createIntent(CreateIntentRequest request) {
    return createIntentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an intent in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   CreateIntentRequest request =
   *       CreateIntentRequest.newBuilder()
   *           .setParent(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
   *           .setIntent(Intent.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Intent> future = intentsClient.createIntentCallable().futureCall(request);
   *   // Do something.
   *   Intent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIntentRequest, Intent> createIntentCallable() {
    return stub.createIntentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   Intent intent = Intent.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Intent response = intentsClient.updateIntent(intent, updateMask);
   * }
   * }</pre>
   *
   * @param intent Required. The intent to update.
   * @param updateMask The mask to control which fields get updated. If the mask is not present, all
   *     fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Intent updateIntent(Intent intent, FieldMask updateMask) {
    UpdateIntentRequest request =
        UpdateIntentRequest.newBuilder().setIntent(intent).setUpdateMask(updateMask).build();
    return updateIntent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   UpdateIntentRequest request =
   *       UpdateIntentRequest.newBuilder()
   *           .setIntent(Intent.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Intent response = intentsClient.updateIntent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Intent updateIntent(UpdateIntentRequest request) {
    return updateIntentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   UpdateIntentRequest request =
   *       UpdateIntentRequest.newBuilder()
   *           .setIntent(Intent.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Intent> future = intentsClient.updateIntentCallable().futureCall(request);
   *   // Do something.
   *   Intent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIntentRequest, Intent> updateIntentCallable() {
    return stub.updateIntentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   IntentName name = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]");
   *   intentsClient.deleteIntent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the intent to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/intents/&lt;Intent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIntent(IntentName name) {
    DeleteIntentRequest request =
        DeleteIntentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteIntent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   String name = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString();
   *   intentsClient.deleteIntent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the intent to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/intents/&lt;Intent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIntent(String name) {
    DeleteIntentRequest request = DeleteIntentRequest.newBuilder().setName(name).build();
    deleteIntent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   DeleteIntentRequest request =
   *       DeleteIntentRequest.newBuilder()
   *           .setName(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
   *           .build();
   *   intentsClient.deleteIntent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIntent(DeleteIntentRequest request) {
    deleteIntentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified intent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IntentsClient intentsClient = IntentsClient.create()) {
   *   DeleteIntentRequest request =
   *       DeleteIntentRequest.newBuilder()
   *           .setName(IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]").toString())
   *           .build();
   *   ApiFuture<Empty> future = intentsClient.deleteIntentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIntentRequest, Empty> deleteIntentCallable() {
    return stub.deleteIntentCallable();
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

  public static class ListIntentsPagedResponse
      extends AbstractPagedListResponse<
          ListIntentsRequest,
          ListIntentsResponse,
          Intent,
          ListIntentsPage,
          ListIntentsFixedSizeCollection> {

    public static ApiFuture<ListIntentsPagedResponse> createAsync(
        PageContext<ListIntentsRequest, ListIntentsResponse, Intent> context,
        ApiFuture<ListIntentsResponse> futureResponse) {
      ApiFuture<ListIntentsPage> futurePage =
          ListIntentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListIntentsPage, ListIntentsPagedResponse>() {
            @Override
            public ListIntentsPagedResponse apply(ListIntentsPage input) {
              return new ListIntentsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListIntentsPagedResponse(ListIntentsPage page) {
      super(page, ListIntentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIntentsPage
      extends AbstractPage<ListIntentsRequest, ListIntentsResponse, Intent, ListIntentsPage> {

    private ListIntentsPage(
        PageContext<ListIntentsRequest, ListIntentsResponse, Intent> context,
        ListIntentsResponse response) {
      super(context, response);
    }

    private static ListIntentsPage createEmptyPage() {
      return new ListIntentsPage(null, null);
    }

    @Override
    protected ListIntentsPage createPage(
        PageContext<ListIntentsRequest, ListIntentsResponse, Intent> context,
        ListIntentsResponse response) {
      return new ListIntentsPage(context, response);
    }

    @Override
    public ApiFuture<ListIntentsPage> createPageAsync(
        PageContext<ListIntentsRequest, ListIntentsResponse, Intent> context,
        ApiFuture<ListIntentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIntentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIntentsRequest,
          ListIntentsResponse,
          Intent,
          ListIntentsPage,
          ListIntentsFixedSizeCollection> {

    private ListIntentsFixedSizeCollection(List<ListIntentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIntentsFixedSizeCollection createEmptyCollection() {
      return new ListIntentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIntentsFixedSizeCollection createCollection(
        List<ListIntentsPage> pages, int collectionSize) {
      return new ListIntentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
