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
import com.google.cloud.dialogflow.v2beta1.stub.KnowledgeBasesStub;
import com.google.cloud.dialogflow.v2beta1.stub.KnowledgeBasesStubSettings;
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
 * Service Description: Service for managing
 * [KnowledgeBases][google.cloud.dialogflow.v2beta1.KnowledgeBase].
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
 * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
 *   KnowledgeBaseName name =
 *       KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");
 *   KnowledgeBase response = knowledgeBasesClient.getKnowledgeBase(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the KnowledgeBasesClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of KnowledgeBasesSettings to
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
 * KnowledgeBasesSettings knowledgeBasesSettings =
 *     KnowledgeBasesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create(knowledgeBasesSettings);
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
 * KnowledgeBasesSettings knowledgeBasesSettings =
 *     KnowledgeBasesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create(knowledgeBasesSettings);
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
 * KnowledgeBasesSettings knowledgeBasesSettings =
 *     KnowledgeBasesSettings.newHttpJsonBuilder().build();
 * KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create(knowledgeBasesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class KnowledgeBasesClient implements BackgroundResource {
  private final KnowledgeBasesSettings settings;
  private final KnowledgeBasesStub stub;

  /** Constructs an instance of KnowledgeBasesClient with default settings. */
  public static final KnowledgeBasesClient create() throws IOException {
    return create(KnowledgeBasesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of KnowledgeBasesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final KnowledgeBasesClient create(KnowledgeBasesSettings settings)
      throws IOException {
    return new KnowledgeBasesClient(settings);
  }

  /**
   * Constructs an instance of KnowledgeBasesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(KnowledgeBasesSettings).
   */
  public static final KnowledgeBasesClient create(KnowledgeBasesStub stub) {
    return new KnowledgeBasesClient(stub);
  }

  /**
   * Constructs an instance of KnowledgeBasesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected KnowledgeBasesClient(KnowledgeBasesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((KnowledgeBasesStubSettings) settings.getStubSettings()).createStub();
  }

  protected KnowledgeBasesClient(KnowledgeBasesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final KnowledgeBasesSettings getSettings() {
    return settings;
  }

  public KnowledgeBasesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (KnowledgeBase element : knowledgeBasesClient.listKnowledgeBases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list of knowledge bases for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKnowledgeBasesPagedResponse listKnowledgeBases(LocationName parent) {
    ListKnowledgeBasesRequest request =
        ListKnowledgeBasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listKnowledgeBases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (KnowledgeBase element : knowledgeBasesClient.listKnowledgeBases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list of knowledge bases for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKnowledgeBasesPagedResponse listKnowledgeBases(ProjectName parent) {
    ListKnowledgeBasesRequest request =
        ListKnowledgeBasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listKnowledgeBases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (KnowledgeBase element : knowledgeBasesClient.listKnowledgeBases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list of knowledge bases for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKnowledgeBasesPagedResponse listKnowledgeBases(String parent) {
    ListKnowledgeBasesRequest request =
        ListKnowledgeBasesRequest.newBuilder().setParent(parent).build();
    return listKnowledgeBases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   ListKnowledgeBasesRequest request =
   *       ListKnowledgeBasesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (KnowledgeBase element : knowledgeBasesClient.listKnowledgeBases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKnowledgeBasesPagedResponse listKnowledgeBases(
      ListKnowledgeBasesRequest request) {
    return listKnowledgeBasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   ListKnowledgeBasesRequest request =
   *       ListKnowledgeBasesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<KnowledgeBase> future =
   *       knowledgeBasesClient.listKnowledgeBasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (KnowledgeBase element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListKnowledgeBasesRequest, ListKnowledgeBasesPagedResponse>
      listKnowledgeBasesPagedCallable() {
    return stub.listKnowledgeBasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   ListKnowledgeBasesRequest request =
   *       ListKnowledgeBasesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListKnowledgeBasesResponse response =
   *         knowledgeBasesClient.listKnowledgeBasesCallable().call(request);
   *     for (KnowledgeBase element : response.getKnowledgeBasesList()) {
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
  public final UnaryCallable<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse>
      listKnowledgeBasesCallable() {
    return stub.listKnowledgeBasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   KnowledgeBaseName name =
   *       KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");
   *   KnowledgeBase response = knowledgeBasesClient.getKnowledgeBase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the knowledge base to retrieve. Format `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase getKnowledgeBase(KnowledgeBaseName name) {
    GetKnowledgeBaseRequest request =
        GetKnowledgeBaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   String name =
   *       KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]").toString();
   *   KnowledgeBase response = knowledgeBasesClient.getKnowledgeBase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the knowledge base to retrieve. Format `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase getKnowledgeBase(String name) {
    GetKnowledgeBaseRequest request = GetKnowledgeBaseRequest.newBuilder().setName(name).build();
    return getKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   GetKnowledgeBaseRequest request =
   *       GetKnowledgeBaseRequest.newBuilder()
   *           .setName(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .build();
   *   KnowledgeBase response = knowledgeBasesClient.getKnowledgeBase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase getKnowledgeBase(GetKnowledgeBaseRequest request) {
    return getKnowledgeBaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   GetKnowledgeBaseRequest request =
   *       GetKnowledgeBaseRequest.newBuilder()
   *           .setName(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<KnowledgeBase> future =
   *       knowledgeBasesClient.getKnowledgeBaseCallable().futureCall(request);
   *   // Do something.
   *   KnowledgeBase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetKnowledgeBaseRequest, KnowledgeBase> getKnowledgeBaseCallable() {
    return stub.getKnowledgeBaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();
   *   KnowledgeBase response = knowledgeBasesClient.createKnowledgeBase(parent, knowledgeBase);
   * }
   * }</pre>
   *
   * @param parent Required. The project to create a knowledge base for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param knowledgeBase Required. The knowledge base to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase createKnowledgeBase(LocationName parent, KnowledgeBase knowledgeBase) {
    CreateKnowledgeBaseRequest request =
        CreateKnowledgeBaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setKnowledgeBase(knowledgeBase)
            .build();
    return createKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();
   *   KnowledgeBase response = knowledgeBasesClient.createKnowledgeBase(parent, knowledgeBase);
   * }
   * }</pre>
   *
   * @param parent Required. The project to create a knowledge base for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param knowledgeBase Required. The knowledge base to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase createKnowledgeBase(ProjectName parent, KnowledgeBase knowledgeBase) {
    CreateKnowledgeBaseRequest request =
        CreateKnowledgeBaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setKnowledgeBase(knowledgeBase)
            .build();
    return createKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();
   *   KnowledgeBase response = knowledgeBasesClient.createKnowledgeBase(parent, knowledgeBase);
   * }
   * }</pre>
   *
   * @param parent Required. The project to create a knowledge base for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param knowledgeBase Required. The knowledge base to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase createKnowledgeBase(String parent, KnowledgeBase knowledgeBase) {
    CreateKnowledgeBaseRequest request =
        CreateKnowledgeBaseRequest.newBuilder()
            .setParent(parent)
            .setKnowledgeBase(knowledgeBase)
            .build();
    return createKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   CreateKnowledgeBaseRequest request =
   *       CreateKnowledgeBaseRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setKnowledgeBase(KnowledgeBase.newBuilder().build())
   *           .build();
   *   KnowledgeBase response = knowledgeBasesClient.createKnowledgeBase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase createKnowledgeBase(CreateKnowledgeBaseRequest request) {
    return createKnowledgeBaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   CreateKnowledgeBaseRequest request =
   *       CreateKnowledgeBaseRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setKnowledgeBase(KnowledgeBase.newBuilder().build())
   *           .build();
   *   ApiFuture<KnowledgeBase> future =
   *       knowledgeBasesClient.createKnowledgeBaseCallable().futureCall(request);
   *   // Do something.
   *   KnowledgeBase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateKnowledgeBaseRequest, KnowledgeBase>
      createKnowledgeBaseCallable() {
    return stub.createKnowledgeBaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   KnowledgeBaseName name =
   *       KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");
   *   knowledgeBasesClient.deleteKnowledgeBase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the knowledge base to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteKnowledgeBase(KnowledgeBaseName name) {
    DeleteKnowledgeBaseRequest request =
        DeleteKnowledgeBaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   String name =
   *       KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]").toString();
   *   knowledgeBasesClient.deleteKnowledgeBase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the knowledge base to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteKnowledgeBase(String name) {
    DeleteKnowledgeBaseRequest request =
        DeleteKnowledgeBaseRequest.newBuilder().setName(name).build();
    deleteKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   DeleteKnowledgeBaseRequest request =
   *       DeleteKnowledgeBaseRequest.newBuilder()
   *           .setName(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   knowledgeBasesClient.deleteKnowledgeBase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteKnowledgeBase(DeleteKnowledgeBaseRequest request) {
    deleteKnowledgeBaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   DeleteKnowledgeBaseRequest request =
   *       DeleteKnowledgeBaseRequest.newBuilder()
   *           .setName(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       knowledgeBasesClient.deleteKnowledgeBaseCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteKnowledgeBaseRequest, Empty> deleteKnowledgeBaseCallable() {
    return stub.deleteKnowledgeBaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();
   *   KnowledgeBase response = knowledgeBasesClient.updateKnowledgeBase(knowledgeBase);
   * }
   * }</pre>
   *
   * @param knowledgeBase Required. The knowledge base to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase updateKnowledgeBase(KnowledgeBase knowledgeBase) {
    UpdateKnowledgeBaseRequest request =
        UpdateKnowledgeBaseRequest.newBuilder().setKnowledgeBase(knowledgeBase).build();
    return updateKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   KnowledgeBase response = knowledgeBasesClient.updateKnowledgeBase(knowledgeBase, updateMask);
   * }
   * }</pre>
   *
   * @param knowledgeBase Required. The knowledge base to update.
   * @param updateMask Optional. Not specified means `update all`. Currently, only `display_name`
   *     can be updated, an InvalidArgument will be returned for attempting to update other fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase updateKnowledgeBase(
      KnowledgeBase knowledgeBase, FieldMask updateMask) {
    UpdateKnowledgeBaseRequest request =
        UpdateKnowledgeBaseRequest.newBuilder()
            .setKnowledgeBase(knowledgeBase)
            .setUpdateMask(updateMask)
            .build();
    return updateKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   UpdateKnowledgeBaseRequest request =
   *       UpdateKnowledgeBaseRequest.newBuilder()
   *           .setKnowledgeBase(KnowledgeBase.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   KnowledgeBase response = knowledgeBasesClient.updateKnowledgeBase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase updateKnowledgeBase(UpdateKnowledgeBaseRequest request) {
    return updateKnowledgeBaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   UpdateKnowledgeBaseRequest request =
   *       UpdateKnowledgeBaseRequest.newBuilder()
   *           .setKnowledgeBase(KnowledgeBase.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<KnowledgeBase> future =
   *       knowledgeBasesClient.updateKnowledgeBaseCallable().futureCall(request);
   *   // Do something.
   *   KnowledgeBase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateKnowledgeBaseRequest, KnowledgeBase>
      updateKnowledgeBaseCallable() {
    return stub.updateKnowledgeBaseCallable();
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
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : knowledgeBasesClient.listLocations(request).iterateAll()) {
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
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       knowledgeBasesClient.listLocationsPagedCallable().futureCall(request);
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
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = knowledgeBasesClient.listLocationsCallable().call(request);
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
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = knowledgeBasesClient.getLocation(request);
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
   * try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = knowledgeBasesClient.getLocationCallable().futureCall(request);
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

  public static class ListKnowledgeBasesPagedResponse
      extends AbstractPagedListResponse<
          ListKnowledgeBasesRequest,
          ListKnowledgeBasesResponse,
          KnowledgeBase,
          ListKnowledgeBasesPage,
          ListKnowledgeBasesFixedSizeCollection> {

    public static ApiFuture<ListKnowledgeBasesPagedResponse> createAsync(
        PageContext<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse, KnowledgeBase> context,
        ApiFuture<ListKnowledgeBasesResponse> futureResponse) {
      ApiFuture<ListKnowledgeBasesPage> futurePage =
          ListKnowledgeBasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListKnowledgeBasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListKnowledgeBasesPagedResponse(ListKnowledgeBasesPage page) {
      super(page, ListKnowledgeBasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListKnowledgeBasesPage
      extends AbstractPage<
          ListKnowledgeBasesRequest,
          ListKnowledgeBasesResponse,
          KnowledgeBase,
          ListKnowledgeBasesPage> {

    private ListKnowledgeBasesPage(
        PageContext<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse, KnowledgeBase> context,
        ListKnowledgeBasesResponse response) {
      super(context, response);
    }

    private static ListKnowledgeBasesPage createEmptyPage() {
      return new ListKnowledgeBasesPage(null, null);
    }

    @Override
    protected ListKnowledgeBasesPage createPage(
        PageContext<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse, KnowledgeBase> context,
        ListKnowledgeBasesResponse response) {
      return new ListKnowledgeBasesPage(context, response);
    }

    @Override
    public ApiFuture<ListKnowledgeBasesPage> createPageAsync(
        PageContext<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse, KnowledgeBase> context,
        ApiFuture<ListKnowledgeBasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListKnowledgeBasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListKnowledgeBasesRequest,
          ListKnowledgeBasesResponse,
          KnowledgeBase,
          ListKnowledgeBasesPage,
          ListKnowledgeBasesFixedSizeCollection> {

    private ListKnowledgeBasesFixedSizeCollection(
        List<ListKnowledgeBasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListKnowledgeBasesFixedSizeCollection createEmptyCollection() {
      return new ListKnowledgeBasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListKnowledgeBasesFixedSizeCollection createCollection(
        List<ListKnowledgeBasesPage> pages, int collectionSize) {
      return new ListKnowledgeBasesFixedSizeCollection(pages, collectionSize);
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
