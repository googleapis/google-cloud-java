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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.stub.AssistantServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.AssistantServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing Assistant configuration and assisting users.
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
 *   CreateAssistantRequest request =
 *       CreateAssistantRequest.newBuilder()
 *           .setParent(
 *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
 *           .setAssistant(Assistant.newBuilder().build())
 *           .setAssistantId("assistantId-324518759")
 *           .build();
 *   Assistant response = assistantServiceClient.createAssistant(request);
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
 *      <td><p> StreamAssist</td>
 *      <td><p> Assists the user with a query in a streaming fashion.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamAssistCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAssistant</td>
 *      <td><p> Creates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAssistant(CreateAssistantRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAssistantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAssistant</td>
 *      <td><p> Deletes an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAssistant(DeleteAssistantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAssistant(AssistantName name)
 *           <li><p> deleteAssistant(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAssistantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAssistant</td>
 *      <td><p> Updates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant]</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAssistant(UpdateAssistantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAssistant(Assistant assistant, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAssistantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAssistant</td>
 *      <td><p> Gets an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAssistant(GetAssistantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAssistant(AssistantName name)
 *           <li><p> getAssistant(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAssistantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAssistants</td>
 *      <td><p> Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under an [Engine][google.cloud.discoveryengine.v1beta.Engine].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAssistants(ListAssistantsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAssistants(EngineName parent)
 *           <li><p> listAssistants(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAssistantsPagedCallable()
 *           <li><p> listAssistantsCallable()
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
  private final AssistantServiceSettings settings;
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

  public final AssistantServiceSettings getSettings() {
    return settings;
  }

  public AssistantServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assists the user with a query in a streaming fashion.
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
   *   StreamAssistRequest request =
   *       StreamAssistRequest.newBuilder()
   *           .setName(
   *               AssistantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
   *                   .toString())
   *           .setQuery(Query.newBuilder().build())
   *           .setSession(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setUserMetadata(AssistUserMetadata.newBuilder().build())
   *           .setToolsSpec(StreamAssistRequest.ToolsSpec.newBuilder().build())
   *           .setGenerationSpec(StreamAssistRequest.GenerationSpec.newBuilder().build())
   *           .build();
   *   ServerStream<StreamAssistResponse> stream =
   *       assistantServiceClient.streamAssistCallable().call(request);
   *   for (StreamAssistResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<StreamAssistRequest, StreamAssistResponse>
      streamAssistCallable() {
    return stub.streamAssistCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
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
   *   CreateAssistantRequest request =
   *       CreateAssistantRequest.newBuilder()
   *           .setParent(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .setAssistant(Assistant.newBuilder().build())
   *           .setAssistantId("assistantId-324518759")
   *           .build();
   *   Assistant response = assistantServiceClient.createAssistant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assistant createAssistant(CreateAssistantRequest request) {
    return createAssistantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
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
   *   CreateAssistantRequest request =
   *       CreateAssistantRequest.newBuilder()
   *           .setParent(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .setAssistant(Assistant.newBuilder().build())
   *           .setAssistantId("assistantId-324518759")
   *           .build();
   *   ApiFuture<Assistant> future =
   *       assistantServiceClient.createAssistantCallable().futureCall(request);
   *   // Do something.
   *   Assistant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAssistantRequest, Assistant> createAssistantCallable() {
    return stub.createAssistantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
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
   *   AssistantName name =
   *       AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]");
   *   assistantServiceClient.deleteAssistant(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of
   *     [Assistant][google.cloud.discoveryengine.v1beta.Assistant]. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/assistants/{assistant}`
   *     <p>If the caller does not have permission to delete the
   *     [Assistant][google.cloud.discoveryengine.v1beta.Assistant], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [Assistant][google.cloud.discoveryengine.v1beta.Assistant] to delete does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssistant(AssistantName name) {
    DeleteAssistantRequest request =
        DeleteAssistantRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAssistant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
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
   *       AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
   *           .toString();
   *   assistantServiceClient.deleteAssistant(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of
   *     [Assistant][google.cloud.discoveryengine.v1beta.Assistant]. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/assistants/{assistant}`
   *     <p>If the caller does not have permission to delete the
   *     [Assistant][google.cloud.discoveryengine.v1beta.Assistant], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [Assistant][google.cloud.discoveryengine.v1beta.Assistant] to delete does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssistant(String name) {
    DeleteAssistantRequest request = DeleteAssistantRequest.newBuilder().setName(name).build();
    deleteAssistant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
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
   *   DeleteAssistantRequest request =
   *       DeleteAssistantRequest.newBuilder()
   *           .setName(
   *               AssistantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
   *                   .toString())
   *           .build();
   *   assistantServiceClient.deleteAssistant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssistant(DeleteAssistantRequest request) {
    deleteAssistantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
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
   *   DeleteAssistantRequest request =
   *       DeleteAssistantRequest.newBuilder()
   *           .setName(
   *               AssistantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       assistantServiceClient.deleteAssistantCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAssistantRequest, Empty> deleteAssistantCallable() {
    return stub.deleteAssistantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant]
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
   *   Assistant assistant = Assistant.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Assistant response = assistantServiceClient.updateAssistant(assistant, updateMask);
   * }
   * }</pre>
   *
   * @param assistant Required. The [Assistant][google.cloud.discoveryengine.v1beta.Assistant] to
   *     update.
   *     <p>The [Assistant][google.cloud.discoveryengine.v1beta.Assistant]'s `name` field is used to
   *     identify the [Assistant][google.cloud.discoveryengine.v1beta.Assistant] to update. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/assistants/{assistant}`
   *     <p>If the caller does not have permission to update the
   *     [Assistant][google.cloud.discoveryengine.v1beta.Assistant], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [Assistant][google.cloud.discoveryengine.v1beta.Assistant] to update does not
   *     exist, a NOT_FOUND error is returned.
   * @param updateMask The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assistant updateAssistant(Assistant assistant, FieldMask updateMask) {
    UpdateAssistantRequest request =
        UpdateAssistantRequest.newBuilder()
            .setAssistant(assistant)
            .setUpdateMask(updateMask)
            .build();
    return updateAssistant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant]
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
   *   UpdateAssistantRequest request =
   *       UpdateAssistantRequest.newBuilder()
   *           .setAssistant(Assistant.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Assistant response = assistantServiceClient.updateAssistant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assistant updateAssistant(UpdateAssistantRequest request) {
    return updateAssistantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant]
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
   *   UpdateAssistantRequest request =
   *       UpdateAssistantRequest.newBuilder()
   *           .setAssistant(Assistant.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Assistant> future =
   *       assistantServiceClient.updateAssistantCallable().futureCall(request);
   *   // Do something.
   *   Assistant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAssistantRequest, Assistant> updateAssistantCallable() {
    return stub.updateAssistantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
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
   *   AssistantName name =
   *       AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]");
   *   Assistant response = assistantServiceClient.getAssistant(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of
   *     [Assistant][google.cloud.discoveryengine.v1beta.Assistant]. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/assistants/{assistant}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assistant getAssistant(AssistantName name) {
    GetAssistantRequest request =
        GetAssistantRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAssistant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
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
   *       AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
   *           .toString();
   *   Assistant response = assistantServiceClient.getAssistant(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of
   *     [Assistant][google.cloud.discoveryengine.v1beta.Assistant]. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/assistants/{assistant}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assistant getAssistant(String name) {
    GetAssistantRequest request = GetAssistantRequest.newBuilder().setName(name).build();
    return getAssistant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
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
   *   GetAssistantRequest request =
   *       GetAssistantRequest.newBuilder()
   *           .setName(
   *               AssistantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
   *                   .toString())
   *           .build();
   *   Assistant response = assistantServiceClient.getAssistant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assistant getAssistant(GetAssistantRequest request) {
    return getAssistantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
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
   *   GetAssistantRequest request =
   *       GetAssistantRequest.newBuilder()
   *           .setName(
   *               AssistantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Assistant> future =
   *       assistantServiceClient.getAssistantCallable().futureCall(request);
   *   // Do something.
   *   Assistant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAssistantRequest, Assistant> getAssistantCallable() {
    return stub.getAssistantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under an
   * [Engine][google.cloud.discoveryengine.v1beta.Engine].
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
   *   EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
   *   for (Assistant element : assistantServiceClient.listAssistants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/engines/{engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssistantsPagedResponse listAssistants(EngineName parent) {
    ListAssistantsRequest request =
        ListAssistantsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAssistants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under an
   * [Engine][google.cloud.discoveryengine.v1beta.Engine].
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
   *   String parent =
   *       EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString();
   *   for (Assistant element : assistantServiceClient.listAssistants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/engines/{engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssistantsPagedResponse listAssistants(String parent) {
    ListAssistantsRequest request = ListAssistantsRequest.newBuilder().setParent(parent).build();
    return listAssistants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under an
   * [Engine][google.cloud.discoveryengine.v1beta.Engine].
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
   *   ListAssistantsRequest request =
   *       ListAssistantsRequest.newBuilder()
   *           .setParent(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Assistant element : assistantServiceClient.listAssistants(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssistantsPagedResponse listAssistants(ListAssistantsRequest request) {
    return listAssistantsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under an
   * [Engine][google.cloud.discoveryengine.v1beta.Engine].
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
   *   ListAssistantsRequest request =
   *       ListAssistantsRequest.newBuilder()
   *           .setParent(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Assistant> future =
   *       assistantServiceClient.listAssistantsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Assistant element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAssistantsRequest, ListAssistantsPagedResponse>
      listAssistantsPagedCallable() {
    return stub.listAssistantsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under an
   * [Engine][google.cloud.discoveryengine.v1beta.Engine].
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
   *   ListAssistantsRequest request =
   *       ListAssistantsRequest.newBuilder()
   *           .setParent(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAssistantsResponse response =
   *         assistantServiceClient.listAssistantsCallable().call(request);
   *     for (Assistant element : response.getAssistantsList()) {
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
  public final UnaryCallable<ListAssistantsRequest, ListAssistantsResponse>
      listAssistantsCallable() {
    return stub.listAssistantsCallable();
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

  public static class ListAssistantsPagedResponse
      extends AbstractPagedListResponse<
          ListAssistantsRequest,
          ListAssistantsResponse,
          Assistant,
          ListAssistantsPage,
          ListAssistantsFixedSizeCollection> {

    public static ApiFuture<ListAssistantsPagedResponse> createAsync(
        PageContext<ListAssistantsRequest, ListAssistantsResponse, Assistant> context,
        ApiFuture<ListAssistantsResponse> futureResponse) {
      ApiFuture<ListAssistantsPage> futurePage =
          ListAssistantsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAssistantsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAssistantsPagedResponse(ListAssistantsPage page) {
      super(page, ListAssistantsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAssistantsPage
      extends AbstractPage<
          ListAssistantsRequest, ListAssistantsResponse, Assistant, ListAssistantsPage> {

    private ListAssistantsPage(
        PageContext<ListAssistantsRequest, ListAssistantsResponse, Assistant> context,
        ListAssistantsResponse response) {
      super(context, response);
    }

    private static ListAssistantsPage createEmptyPage() {
      return new ListAssistantsPage(null, null);
    }

    @Override
    protected ListAssistantsPage createPage(
        PageContext<ListAssistantsRequest, ListAssistantsResponse, Assistant> context,
        ListAssistantsResponse response) {
      return new ListAssistantsPage(context, response);
    }

    @Override
    public ApiFuture<ListAssistantsPage> createPageAsync(
        PageContext<ListAssistantsRequest, ListAssistantsResponse, Assistant> context,
        ApiFuture<ListAssistantsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssistantsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAssistantsRequest,
          ListAssistantsResponse,
          Assistant,
          ListAssistantsPage,
          ListAssistantsFixedSizeCollection> {

    private ListAssistantsFixedSizeCollection(List<ListAssistantsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAssistantsFixedSizeCollection createEmptyCollection() {
      return new ListAssistantsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAssistantsFixedSizeCollection createCollection(
        List<ListAssistantsPage> pages, int collectionSize) {
      return new ListAssistantsFixedSizeCollection(pages, collectionSize);
    }
  }
}
