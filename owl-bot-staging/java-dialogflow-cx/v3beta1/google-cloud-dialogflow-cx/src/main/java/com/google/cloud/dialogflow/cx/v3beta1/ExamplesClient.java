/*
 * Copyright 2024 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.stub.ExamplesStub;
import com.google.cloud.dialogflow.cx.v3beta1.stub.ExamplesStubSettings;
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
 * Service Description: Service for managing [Examples][google.cloud.dialogflow.cx.v3beta1.Example].
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
 * try (ExamplesClient examplesClient = ExamplesClient.create()) {
 *   PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
 *   Example example = Example.newBuilder().build();
 *   Example response = examplesClient.createExample(parent, example);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ExamplesClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateExample</td>
 *      <td><p> Creates an example in the specified playbook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createExample(CreateExampleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createExample(PlaybookName parent, Example example)
 *           <li><p> createExample(String parent, Example example)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createExampleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExample</td>
 *      <td><p> Deletes the specified example.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExample(DeleteExampleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteExample(ExampleName name)
 *           <li><p> deleteExample(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExampleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExamples</td>
 *      <td><p> Returns a list of examples in the specified playbook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExamples(ListExamplesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExamples(PlaybookName parent)
 *           <li><p> listExamples(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExamplesPagedCallable()
 *           <li><p> listExamplesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExample</td>
 *      <td><p> Retrieves the specified example.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExample(GetExampleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExample(ExampleName name)
 *           <li><p> getExample(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExampleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExample</td>
 *      <td><p> Update the specified example.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExample(UpdateExampleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateExample(Example example, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExampleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
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
 * <p>This class can be customized by passing in a custom instance of ExamplesSettings to create().
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
 * ExamplesSettings examplesSettings =
 *     ExamplesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ExamplesClient examplesClient = ExamplesClient.create(examplesSettings);
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
 * ExamplesSettings examplesSettings =
 *     ExamplesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ExamplesClient examplesClient = ExamplesClient.create(examplesSettings);
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
 * ExamplesSettings examplesSettings = ExamplesSettings.newHttpJsonBuilder().build();
 * ExamplesClient examplesClient = ExamplesClient.create(examplesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ExamplesClient implements BackgroundResource {
  private final ExamplesSettings settings;
  private final ExamplesStub stub;

  /** Constructs an instance of ExamplesClient with default settings. */
  public static final ExamplesClient create() throws IOException {
    return create(ExamplesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ExamplesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ExamplesClient create(ExamplesSettings settings) throws IOException {
    return new ExamplesClient(settings);
  }

  /**
   * Constructs an instance of ExamplesClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ExamplesSettings).
   */
  public static final ExamplesClient create(ExamplesStub stub) {
    return new ExamplesClient(stub);
  }

  /**
   * Constructs an instance of ExamplesClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ExamplesClient(ExamplesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ExamplesStubSettings) settings.getStubSettings()).createStub();
  }

  protected ExamplesClient(ExamplesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ExamplesSettings getSettings() {
    return settings;
  }

  public ExamplesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an example in the specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
   *   Example example = Example.newBuilder().build();
   *   Example response = examplesClient.createExample(parent, example);
   * }
   * }</pre>
   *
   * @param parent Required. The playbook to create an example for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @param example Required. The example to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example createExample(PlaybookName parent, Example example) {
    CreateExampleRequest request =
        CreateExampleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExample(example)
            .build();
    return createExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an example in the specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   String parent =
   *       PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString();
   *   Example example = Example.newBuilder().build();
   *   Example response = examplesClient.createExample(parent, example);
   * }
   * }</pre>
   *
   * @param parent Required. The playbook to create an example for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @param example Required. The example to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example createExample(String parent, Example example) {
    CreateExampleRequest request =
        CreateExampleRequest.newBuilder().setParent(parent).setExample(example).build();
    return createExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an example in the specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   CreateExampleRequest request =
   *       CreateExampleRequest.newBuilder()
   *           .setParent(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .setExample(Example.newBuilder().build())
   *           .build();
   *   Example response = examplesClient.createExample(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example createExample(CreateExampleRequest request) {
    return createExampleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an example in the specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   CreateExampleRequest request =
   *       CreateExampleRequest.newBuilder()
   *           .setParent(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .setExample(Example.newBuilder().build())
   *           .build();
   *   ApiFuture<Example> future = examplesClient.createExampleCallable().futureCall(request);
   *   // Do something.
   *   Example response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExampleRequest, Example> createExampleCallable() {
    return stub.createExampleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   ExampleName name =
   *       ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]");
   *   examplesClient.deleteExample(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the example to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;/examples/&lt;Example ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExample(ExampleName name) {
    DeleteExampleRequest request =
        DeleteExampleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   String name =
   *       ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
   *           .toString();
   *   examplesClient.deleteExample(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the example to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;/examples/&lt;Example ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExample(String name) {
    DeleteExampleRequest request = DeleteExampleRequest.newBuilder().setName(name).build();
    deleteExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   DeleteExampleRequest request =
   *       DeleteExampleRequest.newBuilder()
   *           .setName(
   *               ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
   *                   .toString())
   *           .build();
   *   examplesClient.deleteExample(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExample(DeleteExampleRequest request) {
    deleteExampleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   DeleteExampleRequest request =
   *       DeleteExampleRequest.newBuilder()
   *           .setName(
   *               ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = examplesClient.deleteExampleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExampleRequest, Empty> deleteExampleCallable() {
    return stub.deleteExampleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of examples in the specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
   *   for (Example element : examplesClient.listExamples(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The playbook to list the examples from. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(PlaybookName parent) {
    ListExamplesRequest request =
        ListExamplesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExamples(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of examples in the specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   String parent =
   *       PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString();
   *   for (Example element : examplesClient.listExamples(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The playbook to list the examples from. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(String parent) {
    ListExamplesRequest request = ListExamplesRequest.newBuilder().setParent(parent).build();
    return listExamples(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of examples in the specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   ListExamplesRequest request =
   *       ListExamplesRequest.newBuilder()
   *           .setParent(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (Example element : examplesClient.listExamples(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(ListExamplesRequest request) {
    return listExamplesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of examples in the specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   ListExamplesRequest request =
   *       ListExamplesRequest.newBuilder()
   *           .setParent(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Example> future = examplesClient.listExamplesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Example element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse>
      listExamplesPagedCallable() {
    return stub.listExamplesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of examples in the specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   ListExamplesRequest request =
   *       ListExamplesRequest.newBuilder()
   *           .setParent(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   while (true) {
   *     ListExamplesResponse response = examplesClient.listExamplesCallable().call(request);
   *     for (Example element : response.getExamplesList()) {
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
  public final UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable() {
    return stub.listExamplesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   ExampleName name =
   *       ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]");
   *   Example response = examplesClient.getExample(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the example. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;/examples/&lt;Example ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example getExample(ExampleName name) {
    GetExampleRequest request =
        GetExampleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   String name =
   *       ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
   *           .toString();
   *   Example response = examplesClient.getExample(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the example. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;/examples/&lt;Example ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example getExample(String name) {
    GetExampleRequest request = GetExampleRequest.newBuilder().setName(name).build();
    return getExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   GetExampleRequest request =
   *       GetExampleRequest.newBuilder()
   *           .setName(
   *               ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
   *                   .toString())
   *           .build();
   *   Example response = examplesClient.getExample(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example getExample(GetExampleRequest request) {
    return getExampleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   GetExampleRequest request =
   *       GetExampleRequest.newBuilder()
   *           .setName(
   *               ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Example> future = examplesClient.getExampleCallable().futureCall(request);
   *   // Do something.
   *   Example response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExampleRequest, Example> getExampleCallable() {
    return stub.getExampleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   Example example = Example.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Example response = examplesClient.updateExample(example, updateMask);
   * }
   * }</pre>
   *
   * @param example Required. The example to update.
   * @param updateMask Optional. The mask to control which fields get updated. If the mask is not
   *     present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example updateExample(Example example, FieldMask updateMask) {
    UpdateExampleRequest request =
        UpdateExampleRequest.newBuilder().setExample(example).setUpdateMask(updateMask).build();
    return updateExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   UpdateExampleRequest request =
   *       UpdateExampleRequest.newBuilder()
   *           .setExample(Example.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Example response = examplesClient.updateExample(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example updateExample(UpdateExampleRequest request) {
    return updateExampleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   UpdateExampleRequest request =
   *       UpdateExampleRequest.newBuilder()
   *           .setExample(Example.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Example> future = examplesClient.updateExampleCallable().futureCall(request);
   *   // Do something.
   *   Example response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExampleRequest, Example> updateExampleCallable() {
    return stub.updateExampleCallable();
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
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : examplesClient.listLocations(request).iterateAll()) {
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
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = examplesClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = examplesClient.listLocationsCallable().call(request);
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
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = examplesClient.getLocation(request);
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
   * try (ExamplesClient examplesClient = ExamplesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = examplesClient.getLocationCallable().futureCall(request);
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

  public static class ListExamplesPagedResponse
      extends AbstractPagedListResponse<
          ListExamplesRequest,
          ListExamplesResponse,
          Example,
          ListExamplesPage,
          ListExamplesFixedSizeCollection> {

    public static ApiFuture<ListExamplesPagedResponse> createAsync(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ApiFuture<ListExamplesResponse> futureResponse) {
      ApiFuture<ListExamplesPage> futurePage =
          ListExamplesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExamplesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExamplesPagedResponse(ListExamplesPage page) {
      super(page, ListExamplesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExamplesPage
      extends AbstractPage<ListExamplesRequest, ListExamplesResponse, Example, ListExamplesPage> {

    private ListExamplesPage(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ListExamplesResponse response) {
      super(context, response);
    }

    private static ListExamplesPage createEmptyPage() {
      return new ListExamplesPage(null, null);
    }

    @Override
    protected ListExamplesPage createPage(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ListExamplesResponse response) {
      return new ListExamplesPage(context, response);
    }

    @Override
    public ApiFuture<ListExamplesPage> createPageAsync(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ApiFuture<ListExamplesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExamplesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExamplesRequest,
          ListExamplesResponse,
          Example,
          ListExamplesPage,
          ListExamplesFixedSizeCollection> {

    private ListExamplesFixedSizeCollection(List<ListExamplesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExamplesFixedSizeCollection createEmptyCollection() {
      return new ListExamplesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExamplesFixedSizeCollection createCollection(
        List<ListExamplesPage> pages, int collectionSize) {
      return new ListExamplesFixedSizeCollection(pages, collectionSize);
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
