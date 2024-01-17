/*
 * Copyright 2023 Google LLC
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
import com.google.cloud.dialogflow.cx.v3.stub.GeneratorsStub;
import com.google.cloud.dialogflow.cx.v3.stub.GeneratorsStubSettings;
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
 * Service Description: Service for managing [Generators][google.cloud.dialogflow.cx.v3.Generator]
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
 * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
 *   GeneratorName name = GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]");
 *   Generator response = generatorsClient.getGenerator(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GeneratorsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>ListGenerators</td>
 *      <td><p> Returns the list of all generators in the specified agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listGenerators(ListGeneratorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listGenerators(AgentName parent)
 *           <li>listGenerators(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listGeneratorsPagedCallable()
 *           <li>listGeneratorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetGenerator</td>
 *      <td><p> Retrieves the specified generator.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getGenerator(GetGeneratorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getGenerator(GeneratorName name)
 *           <li>getGenerator(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getGeneratorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateGenerator</td>
 *      <td><p> Creates a generator in the specified agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createGenerator(CreateGeneratorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createGenerator(AgentName parent, Generator generator)
 *           <li>createGenerator(String parent, Generator generator)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createGeneratorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateGenerator</td>
 *      <td><p> Update the specified generator.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateGenerator(UpdateGeneratorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateGenerator(Generator generator, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateGeneratorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteGenerator</td>
 *      <td><p> Deletes the specified generators.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteGenerator(DeleteGeneratorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>deleteGenerator(GeneratorName name)
 *           <li>deleteGenerator(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteGeneratorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listLocationsPagedCallable()
 *           <li>listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of GeneratorsSettings to
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
 * GeneratorsSettings generatorsSettings =
 *     GeneratorsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GeneratorsClient generatorsClient = GeneratorsClient.create(generatorsSettings);
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
 * GeneratorsSettings generatorsSettings =
 *     GeneratorsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GeneratorsClient generatorsClient = GeneratorsClient.create(generatorsSettings);
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
 * GeneratorsSettings generatorsSettings = GeneratorsSettings.newHttpJsonBuilder().build();
 * GeneratorsClient generatorsClient = GeneratorsClient.create(generatorsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GeneratorsClient implements BackgroundResource {
  private final GeneratorsSettings settings;
  private final GeneratorsStub stub;

  /** Constructs an instance of GeneratorsClient with default settings. */
  public static final GeneratorsClient create() throws IOException {
    return create(GeneratorsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GeneratorsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GeneratorsClient create(GeneratorsSettings settings) throws IOException {
    return new GeneratorsClient(settings);
  }

  /**
   * Constructs an instance of GeneratorsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(GeneratorsSettings).
   */
  public static final GeneratorsClient create(GeneratorsStub stub) {
    return new GeneratorsClient(stub);
  }

  /**
   * Constructs an instance of GeneratorsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GeneratorsClient(GeneratorsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GeneratorsStubSettings) settings.getStubSettings()).createStub();
  }

  protected GeneratorsClient(GeneratorsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GeneratorsSettings getSettings() {
    return settings;
  }

  public GeneratorsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all generators in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   for (Generator element : generatorsClient.listGenerators(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent to list all generators for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGeneratorsPagedResponse listGenerators(AgentName parent) {
    ListGeneratorsRequest request =
        ListGeneratorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGenerators(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all generators in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   for (Generator element : generatorsClient.listGenerators(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent to list all generators for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGeneratorsPagedResponse listGenerators(String parent) {
    ListGeneratorsRequest request = ListGeneratorsRequest.newBuilder().setParent(parent).build();
    return listGenerators(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all generators in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   ListGeneratorsRequest request =
   *       ListGeneratorsRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Generator element : generatorsClient.listGenerators(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGeneratorsPagedResponse listGenerators(ListGeneratorsRequest request) {
    return listGeneratorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all generators in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   ListGeneratorsRequest request =
   *       ListGeneratorsRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Generator> future =
   *       generatorsClient.listGeneratorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Generator element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGeneratorsRequest, ListGeneratorsPagedResponse>
      listGeneratorsPagedCallable() {
    return stub.listGeneratorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all generators in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   ListGeneratorsRequest request =
   *       ListGeneratorsRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListGeneratorsResponse response = generatorsClient.listGeneratorsCallable().call(request);
   *     for (Generator element : response.getGeneratorsList()) {
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
  public final UnaryCallable<ListGeneratorsRequest, ListGeneratorsResponse>
      listGeneratorsCallable() {
    return stub.listGeneratorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   GeneratorName name = GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]");
   *   Generator response = generatorsClient.getGenerator(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the generator. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/generators/&lt;Generator
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Generator getGenerator(GeneratorName name) {
    GetGeneratorRequest request =
        GetGeneratorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGenerator(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   String name =
   *       GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString();
   *   Generator response = generatorsClient.getGenerator(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the generator. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/generators/&lt;Generator
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Generator getGenerator(String name) {
    GetGeneratorRequest request = GetGeneratorRequest.newBuilder().setName(name).build();
    return getGenerator(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   GetGeneratorRequest request =
   *       GetGeneratorRequest.newBuilder()
   *           .setName(
   *               GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   Generator response = generatorsClient.getGenerator(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Generator getGenerator(GetGeneratorRequest request) {
    return getGeneratorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   GetGeneratorRequest request =
   *       GetGeneratorRequest.newBuilder()
   *           .setName(
   *               GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Generator> future = generatorsClient.getGeneratorCallable().futureCall(request);
   *   // Do something.
   *   Generator response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGeneratorRequest, Generator> getGeneratorCallable() {
    return stub.getGeneratorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a generator in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   Generator generator = Generator.newBuilder().build();
   *   Generator response = generatorsClient.createGenerator(parent, generator);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create a generator for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param generator Required. The generator to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Generator createGenerator(AgentName parent, Generator generator) {
    CreateGeneratorRequest request =
        CreateGeneratorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGenerator(generator)
            .build();
    return createGenerator(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a generator in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   Generator generator = Generator.newBuilder().build();
   *   Generator response = generatorsClient.createGenerator(parent, generator);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create a generator for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param generator Required. The generator to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Generator createGenerator(String parent, Generator generator) {
    CreateGeneratorRequest request =
        CreateGeneratorRequest.newBuilder().setParent(parent).setGenerator(generator).build();
    return createGenerator(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a generator in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   CreateGeneratorRequest request =
   *       CreateGeneratorRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setGenerator(Generator.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   Generator response = generatorsClient.createGenerator(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Generator createGenerator(CreateGeneratorRequest request) {
    return createGeneratorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a generator in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   CreateGeneratorRequest request =
   *       CreateGeneratorRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setGenerator(Generator.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Generator> future = generatorsClient.createGeneratorCallable().futureCall(request);
   *   // Do something.
   *   Generator response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGeneratorRequest, Generator> createGeneratorCallable() {
    return stub.createGeneratorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the specified generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   Generator generator = Generator.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Generator response = generatorsClient.updateGenerator(generator, updateMask);
   * }
   * }</pre>
   *
   * @param generator Required. The generator to update.
   * @param updateMask The mask to control which fields get updated. If the mask is not present, all
   *     fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Generator updateGenerator(Generator generator, FieldMask updateMask) {
    UpdateGeneratorRequest request =
        UpdateGeneratorRequest.newBuilder()
            .setGenerator(generator)
            .setUpdateMask(updateMask)
            .build();
    return updateGenerator(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the specified generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   UpdateGeneratorRequest request =
   *       UpdateGeneratorRequest.newBuilder()
   *           .setGenerator(Generator.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Generator response = generatorsClient.updateGenerator(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Generator updateGenerator(UpdateGeneratorRequest request) {
    return updateGeneratorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the specified generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   UpdateGeneratorRequest request =
   *       UpdateGeneratorRequest.newBuilder()
   *           .setGenerator(Generator.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Generator> future = generatorsClient.updateGeneratorCallable().futureCall(request);
   *   // Do something.
   *   Generator response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGeneratorRequest, Generator> updateGeneratorCallable() {
    return stub.updateGeneratorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified generators.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   GeneratorName name = GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]");
   *   generatorsClient.deleteGenerator(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the generator to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/generators/&lt;Generator
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGenerator(GeneratorName name) {
    DeleteGeneratorRequest request =
        DeleteGeneratorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteGenerator(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified generators.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   String name =
   *       GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString();
   *   generatorsClient.deleteGenerator(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the generator to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/generators/&lt;Generator
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGenerator(String name) {
    DeleteGeneratorRequest request = DeleteGeneratorRequest.newBuilder().setName(name).build();
    deleteGenerator(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified generators.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   DeleteGeneratorRequest request =
   *       DeleteGeneratorRequest.newBuilder()
   *           .setName(
   *               GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString())
   *           .setForce(true)
   *           .build();
   *   generatorsClient.deleteGenerator(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGenerator(DeleteGeneratorRequest request) {
    deleteGeneratorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified generators.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   DeleteGeneratorRequest request =
   *       DeleteGeneratorRequest.newBuilder()
   *           .setName(
   *               GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = generatorsClient.deleteGeneratorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGeneratorRequest, Empty> deleteGeneratorCallable() {
    return stub.deleteGeneratorCallable();
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
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : generatorsClient.listLocations(request).iterateAll()) {
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
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       generatorsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = generatorsClient.listLocationsCallable().call(request);
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
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = generatorsClient.getLocation(request);
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
   * try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = generatorsClient.getLocationCallable().futureCall(request);
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

  public static class ListGeneratorsPagedResponse
      extends AbstractPagedListResponse<
          ListGeneratorsRequest,
          ListGeneratorsResponse,
          Generator,
          ListGeneratorsPage,
          ListGeneratorsFixedSizeCollection> {

    public static ApiFuture<ListGeneratorsPagedResponse> createAsync(
        PageContext<ListGeneratorsRequest, ListGeneratorsResponse, Generator> context,
        ApiFuture<ListGeneratorsResponse> futureResponse) {
      ApiFuture<ListGeneratorsPage> futurePage =
          ListGeneratorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGeneratorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGeneratorsPagedResponse(ListGeneratorsPage page) {
      super(page, ListGeneratorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGeneratorsPage
      extends AbstractPage<
          ListGeneratorsRequest, ListGeneratorsResponse, Generator, ListGeneratorsPage> {

    private ListGeneratorsPage(
        PageContext<ListGeneratorsRequest, ListGeneratorsResponse, Generator> context,
        ListGeneratorsResponse response) {
      super(context, response);
    }

    private static ListGeneratorsPage createEmptyPage() {
      return new ListGeneratorsPage(null, null);
    }

    @Override
    protected ListGeneratorsPage createPage(
        PageContext<ListGeneratorsRequest, ListGeneratorsResponse, Generator> context,
        ListGeneratorsResponse response) {
      return new ListGeneratorsPage(context, response);
    }

    @Override
    public ApiFuture<ListGeneratorsPage> createPageAsync(
        PageContext<ListGeneratorsRequest, ListGeneratorsResponse, Generator> context,
        ApiFuture<ListGeneratorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGeneratorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGeneratorsRequest,
          ListGeneratorsResponse,
          Generator,
          ListGeneratorsPage,
          ListGeneratorsFixedSizeCollection> {

    private ListGeneratorsFixedSizeCollection(List<ListGeneratorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGeneratorsFixedSizeCollection createEmptyCollection() {
      return new ListGeneratorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGeneratorsFixedSizeCollection createCollection(
        List<ListGeneratorsPage> pages, int collectionSize) {
      return new ListGeneratorsFixedSizeCollection(pages, collectionSize);
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
