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

package com.google.cloud.contentwarehouse.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.stub.SynonymSetServiceStub;
import com.google.cloud.contentwarehouse.v1.stub.SynonymSetServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A Service that manage/custom customer specified SynonymSets.
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
 * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   SynonymSet synonymSet = SynonymSet.newBuilder().build();
 *   SynonymSet response = synonymSetServiceClient.createSynonymSet(parent, synonymSet);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SynonymSetServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of SynonymSetServiceSettings to
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
 * SynonymSetServiceSettings synonymSetServiceSettings =
 *     SynonymSetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SynonymSetServiceClient synonymSetServiceClient =
 *     SynonymSetServiceClient.create(synonymSetServiceSettings);
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
 * SynonymSetServiceSettings synonymSetServiceSettings =
 *     SynonymSetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SynonymSetServiceClient synonymSetServiceClient =
 *     SynonymSetServiceClient.create(synonymSetServiceSettings);
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
 * SynonymSetServiceSettings synonymSetServiceSettings =
 *     SynonymSetServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             SynonymSetServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * SynonymSetServiceClient synonymSetServiceClient =
 *     SynonymSetServiceClient.create(synonymSetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SynonymSetServiceClient implements BackgroundResource {
  private final SynonymSetServiceSettings settings;
  private final SynonymSetServiceStub stub;

  /** Constructs an instance of SynonymSetServiceClient with default settings. */
  public static final SynonymSetServiceClient create() throws IOException {
    return create(SynonymSetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SynonymSetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SynonymSetServiceClient create(SynonymSetServiceSettings settings)
      throws IOException {
    return new SynonymSetServiceClient(settings);
  }

  /**
   * Constructs an instance of SynonymSetServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(SynonymSetServiceSettings).
   */
  public static final SynonymSetServiceClient create(SynonymSetServiceStub stub) {
    return new SynonymSetServiceClient(stub);
  }

  /**
   * Constructs an instance of SynonymSetServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SynonymSetServiceClient(SynonymSetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SynonymSetServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SynonymSetServiceClient(SynonymSetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SynonymSetServiceSettings getSettings() {
    return settings;
  }

  public SynonymSetServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SynonymSet for a single context. Throws an ALREADY_EXISTS exception if a synonymset
   * already exists for the context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SynonymSet synonymSet = SynonymSet.newBuilder().build();
   *   SynonymSet response = synonymSetServiceClient.createSynonymSet(parent, synonymSet);
   * }
   * }</pre>
   *
   * @param parent Required. The parent name. Format:
   *     projects/{project_number}/locations/{location}.
   * @param synonymSet Required. The synonymSet to be created for a context
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynonymSet createSynonymSet(LocationName parent, SynonymSet synonymSet) {
    CreateSynonymSetRequest request =
        CreateSynonymSetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSynonymSet(synonymSet)
            .build();
    return createSynonymSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SynonymSet for a single context. Throws an ALREADY_EXISTS exception if a synonymset
   * already exists for the context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   SynonymSet synonymSet = SynonymSet.newBuilder().build();
   *   SynonymSet response = synonymSetServiceClient.createSynonymSet(parent, synonymSet);
   * }
   * }</pre>
   *
   * @param parent Required. The parent name. Format:
   *     projects/{project_number}/locations/{location}.
   * @param synonymSet Required. The synonymSet to be created for a context
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynonymSet createSynonymSet(String parent, SynonymSet synonymSet) {
    CreateSynonymSetRequest request =
        CreateSynonymSetRequest.newBuilder().setParent(parent).setSynonymSet(synonymSet).build();
    return createSynonymSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SynonymSet for a single context. Throws an ALREADY_EXISTS exception if a synonymset
   * already exists for the context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   CreateSynonymSetRequest request =
   *       CreateSynonymSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSynonymSet(SynonymSet.newBuilder().build())
   *           .build();
   *   SynonymSet response = synonymSetServiceClient.createSynonymSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynonymSet createSynonymSet(CreateSynonymSetRequest request) {
    return createSynonymSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SynonymSet for a single context. Throws an ALREADY_EXISTS exception if a synonymset
   * already exists for the context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   CreateSynonymSetRequest request =
   *       CreateSynonymSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSynonymSet(SynonymSet.newBuilder().build())
   *           .build();
   *   ApiFuture<SynonymSet> future =
   *       synonymSetServiceClient.createSynonymSetCallable().futureCall(request);
   *   // Do something.
   *   SynonymSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSynonymSetRequest, SynonymSet> createSynonymSetCallable() {
    return stub.createSynonymSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SynonymSet for a particular context. Throws a NOT_FOUND exception if the Synonymset does
   * not exist
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   SynonymSetName name = SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]");
   *   SynonymSet response = synonymSetServiceClient.getSynonymSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the synonymSet to retrieve Format:
   *     projects/{project_number}/locations/{location}/synonymSets/{context}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynonymSet getSynonymSet(SynonymSetName name) {
    GetSynonymSetRequest request =
        GetSynonymSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSynonymSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SynonymSet for a particular context. Throws a NOT_FOUND exception if the Synonymset does
   * not exist
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   String name = SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString();
   *   SynonymSet response = synonymSetServiceClient.getSynonymSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the synonymSet to retrieve Format:
   *     projects/{project_number}/locations/{location}/synonymSets/{context}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynonymSet getSynonymSet(String name) {
    GetSynonymSetRequest request = GetSynonymSetRequest.newBuilder().setName(name).build();
    return getSynonymSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SynonymSet for a particular context. Throws a NOT_FOUND exception if the Synonymset does
   * not exist
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   GetSynonymSetRequest request =
   *       GetSynonymSetRequest.newBuilder()
   *           .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
   *           .build();
   *   SynonymSet response = synonymSetServiceClient.getSynonymSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynonymSet getSynonymSet(GetSynonymSetRequest request) {
    return getSynonymSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SynonymSet for a particular context. Throws a NOT_FOUND exception if the Synonymset does
   * not exist
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   GetSynonymSetRequest request =
   *       GetSynonymSetRequest.newBuilder()
   *           .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
   *           .build();
   *   ApiFuture<SynonymSet> future =
   *       synonymSetServiceClient.getSynonymSetCallable().futureCall(request);
   *   // Do something.
   *   SynonymSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSynonymSetRequest, SynonymSet> getSynonymSetCallable() {
    return stub.getSynonymSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove the existing SynonymSet for the context and replaces it with a new one. Throws a
   * NOT_FOUND exception if the SynonymSet is not found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   SynonymSetName name = SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]");
   *   SynonymSet synonymSet = SynonymSet.newBuilder().build();
   *   SynonymSet response = synonymSetServiceClient.updateSynonymSet(name, synonymSet);
   * }
   * }</pre>
   *
   * @param name Required. The name of the synonymSet to update Format:
   *     projects/{project_number}/locations/{location}/synonymSets/{context}.
   * @param synonymSet Required. The synonymSet to be updated for the customer
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynonymSet updateSynonymSet(SynonymSetName name, SynonymSet synonymSet) {
    UpdateSynonymSetRequest request =
        UpdateSynonymSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSynonymSet(synonymSet)
            .build();
    return updateSynonymSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove the existing SynonymSet for the context and replaces it with a new one. Throws a
   * NOT_FOUND exception if the SynonymSet is not found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   String name = SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString();
   *   SynonymSet synonymSet = SynonymSet.newBuilder().build();
   *   SynonymSet response = synonymSetServiceClient.updateSynonymSet(name, synonymSet);
   * }
   * }</pre>
   *
   * @param name Required. The name of the synonymSet to update Format:
   *     projects/{project_number}/locations/{location}/synonymSets/{context}.
   * @param synonymSet Required. The synonymSet to be updated for the customer
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynonymSet updateSynonymSet(String name, SynonymSet synonymSet) {
    UpdateSynonymSetRequest request =
        UpdateSynonymSetRequest.newBuilder().setName(name).setSynonymSet(synonymSet).build();
    return updateSynonymSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove the existing SynonymSet for the context and replaces it with a new one. Throws a
   * NOT_FOUND exception if the SynonymSet is not found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   UpdateSynonymSetRequest request =
   *       UpdateSynonymSetRequest.newBuilder()
   *           .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
   *           .setSynonymSet(SynonymSet.newBuilder().build())
   *           .build();
   *   SynonymSet response = synonymSetServiceClient.updateSynonymSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynonymSet updateSynonymSet(UpdateSynonymSetRequest request) {
    return updateSynonymSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove the existing SynonymSet for the context and replaces it with a new one. Throws a
   * NOT_FOUND exception if the SynonymSet is not found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   UpdateSynonymSetRequest request =
   *       UpdateSynonymSetRequest.newBuilder()
   *           .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
   *           .setSynonymSet(SynonymSet.newBuilder().build())
   *           .build();
   *   ApiFuture<SynonymSet> future =
   *       synonymSetServiceClient.updateSynonymSetCallable().futureCall(request);
   *   // Do something.
   *   SynonymSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSynonymSetRequest, SynonymSet> updateSynonymSetCallable() {
    return stub.updateSynonymSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SynonymSet for a given context. Throws a NOT_FOUND exception if the SynonymSet is not
   * found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   SynonymSetName name = SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]");
   *   synonymSetServiceClient.deleteSynonymSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the synonymSet to delete Format:
   *     projects/{project_number}/locations/{location}/synonymSets/{context}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSynonymSet(SynonymSetName name) {
    DeleteSynonymSetRequest request =
        DeleteSynonymSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSynonymSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SynonymSet for a given context. Throws a NOT_FOUND exception if the SynonymSet is not
   * found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   String name = SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString();
   *   synonymSetServiceClient.deleteSynonymSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the synonymSet to delete Format:
   *     projects/{project_number}/locations/{location}/synonymSets/{context}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSynonymSet(String name) {
    DeleteSynonymSetRequest request = DeleteSynonymSetRequest.newBuilder().setName(name).build();
    deleteSynonymSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SynonymSet for a given context. Throws a NOT_FOUND exception if the SynonymSet is not
   * found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   DeleteSynonymSetRequest request =
   *       DeleteSynonymSetRequest.newBuilder()
   *           .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
   *           .build();
   *   synonymSetServiceClient.deleteSynonymSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSynonymSet(DeleteSynonymSetRequest request) {
    deleteSynonymSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SynonymSet for a given context. Throws a NOT_FOUND exception if the SynonymSet is not
   * found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   DeleteSynonymSetRequest request =
   *       DeleteSynonymSetRequest.newBuilder()
   *           .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       synonymSetServiceClient.deleteSynonymSetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSynonymSetRequest, Empty> deleteSynonymSetCallable() {
    return stub.deleteSynonymSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all SynonymSets (for all contexts) for the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SynonymSet element : synonymSetServiceClient.listSynonymSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent name. Format:
   *     projects/{project_number}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSynonymSetsPagedResponse listSynonymSets(LocationName parent) {
    ListSynonymSetsRequest request =
        ListSynonymSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSynonymSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all SynonymSets (for all contexts) for the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SynonymSet element : synonymSetServiceClient.listSynonymSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent name. Format:
   *     projects/{project_number}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSynonymSetsPagedResponse listSynonymSets(String parent) {
    ListSynonymSetsRequest request = ListSynonymSetsRequest.newBuilder().setParent(parent).build();
    return listSynonymSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all SynonymSets (for all contexts) for the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   ListSynonymSetsRequest request =
   *       ListSynonymSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SynonymSet element : synonymSetServiceClient.listSynonymSets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSynonymSetsPagedResponse listSynonymSets(ListSynonymSetsRequest request) {
    return listSynonymSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all SynonymSets (for all contexts) for the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   ListSynonymSetsRequest request =
   *       ListSynonymSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SynonymSet> future =
   *       synonymSetServiceClient.listSynonymSetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SynonymSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsPagedResponse>
      listSynonymSetsPagedCallable() {
    return stub.listSynonymSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all SynonymSets (for all contexts) for the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
   *   ListSynonymSetsRequest request =
   *       ListSynonymSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSynonymSetsResponse response =
   *         synonymSetServiceClient.listSynonymSetsCallable().call(request);
   *     for (SynonymSet element : response.getSynonymSetsList()) {
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
  public final UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsResponse>
      listSynonymSetsCallable() {
    return stub.listSynonymSetsCallable();
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

  public static class ListSynonymSetsPagedResponse
      extends AbstractPagedListResponse<
          ListSynonymSetsRequest,
          ListSynonymSetsResponse,
          SynonymSet,
          ListSynonymSetsPage,
          ListSynonymSetsFixedSizeCollection> {

    public static ApiFuture<ListSynonymSetsPagedResponse> createAsync(
        PageContext<ListSynonymSetsRequest, ListSynonymSetsResponse, SynonymSet> context,
        ApiFuture<ListSynonymSetsResponse> futureResponse) {
      ApiFuture<ListSynonymSetsPage> futurePage =
          ListSynonymSetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSynonymSetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSynonymSetsPagedResponse(ListSynonymSetsPage page) {
      super(page, ListSynonymSetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSynonymSetsPage
      extends AbstractPage<
          ListSynonymSetsRequest, ListSynonymSetsResponse, SynonymSet, ListSynonymSetsPage> {

    private ListSynonymSetsPage(
        PageContext<ListSynonymSetsRequest, ListSynonymSetsResponse, SynonymSet> context,
        ListSynonymSetsResponse response) {
      super(context, response);
    }

    private static ListSynonymSetsPage createEmptyPage() {
      return new ListSynonymSetsPage(null, null);
    }

    @Override
    protected ListSynonymSetsPage createPage(
        PageContext<ListSynonymSetsRequest, ListSynonymSetsResponse, SynonymSet> context,
        ListSynonymSetsResponse response) {
      return new ListSynonymSetsPage(context, response);
    }

    @Override
    public ApiFuture<ListSynonymSetsPage> createPageAsync(
        PageContext<ListSynonymSetsRequest, ListSynonymSetsResponse, SynonymSet> context,
        ApiFuture<ListSynonymSetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSynonymSetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSynonymSetsRequest,
          ListSynonymSetsResponse,
          SynonymSet,
          ListSynonymSetsPage,
          ListSynonymSetsFixedSizeCollection> {

    private ListSynonymSetsFixedSizeCollection(
        List<ListSynonymSetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSynonymSetsFixedSizeCollection createEmptyCollection() {
      return new ListSynonymSetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSynonymSetsFixedSizeCollection createCollection(
        List<ListSynonymSetsPage> pages, int collectionSize) {
      return new ListSynonymSetsFixedSizeCollection(pages, collectionSize);
    }
  }
}
