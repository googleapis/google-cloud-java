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

package com.google.cloud.speech.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v1.stub.AdaptationStub;
import com.google.cloud.speech.v1.stub.AdaptationStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service that implements Google Cloud Speech Adaptation API.
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
 * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   PhraseSet phraseSet = PhraseSet.newBuilder().build();
 *   String phraseSetId = "phraseSetId959902180";
 *   PhraseSet response = adaptationClient.createPhraseSet(parent, phraseSet, phraseSetId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AdaptationClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of AdaptationSettings to
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
 * AdaptationSettings adaptationSettings =
 *     AdaptationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AdaptationClient adaptationClient = AdaptationClient.create(adaptationSettings);
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
 * AdaptationSettings adaptationSettings =
 *     AdaptationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AdaptationClient adaptationClient = AdaptationClient.create(adaptationSettings);
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
 * AdaptationSettings adaptationSettings =
 *     AdaptationSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             AdaptationSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * AdaptationClient adaptationClient = AdaptationClient.create(adaptationSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AdaptationClient implements BackgroundResource {
  private final AdaptationSettings settings;
  private final AdaptationStub stub;

  /** Constructs an instance of AdaptationClient with default settings. */
  public static final AdaptationClient create() throws IOException {
    return create(AdaptationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AdaptationClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AdaptationClient create(AdaptationSettings settings) throws IOException {
    return new AdaptationClient(settings);
  }

  /**
   * Constructs an instance of AdaptationClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AdaptationSettings).
   */
  public static final AdaptationClient create(AdaptationStub stub) {
    return new AdaptationClient(stub);
  }

  /**
   * Constructs an instance of AdaptationClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected AdaptationClient(AdaptationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AdaptationStubSettings) settings.getStubSettings()).createStub();
  }

  protected AdaptationClient(AdaptationStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AdaptationSettings getSettings() {
    return settings;
  }

  public AdaptationStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a set of phrase hints. Each item in the set can be a single word or a multi-word phrase.
   * The items in the PhraseSet are favored by the recognition model when you send a call that
   * includes the PhraseSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PhraseSet phraseSet = PhraseSet.newBuilder().build();
   *   String phraseSetId = "phraseSetId959902180";
   *   PhraseSet response = adaptationClient.createPhraseSet(parent, phraseSet, phraseSetId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this phrase set will be created. Format:
   *     <p>`projects/{project}/locations/{location}/phraseSets`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @param phraseSet Required. The phrase set to create.
   * @param phraseSetId Required. The ID to use for the phrase set, which will become the final
   *     component of the phrase set's resource name.
   *     <p>This value should restrict to letters, numbers, and hyphens, with the first character a
   *     letter, the last a letter or a number, and be 4-63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseSet createPhraseSet(
      LocationName parent, PhraseSet phraseSet, String phraseSetId) {
    CreatePhraseSetRequest request =
        CreatePhraseSetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPhraseSet(phraseSet)
            .setPhraseSetId(phraseSetId)
            .build();
    return createPhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a set of phrase hints. Each item in the set can be a single word or a multi-word phrase.
   * The items in the PhraseSet are favored by the recognition model when you send a call that
   * includes the PhraseSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PhraseSet phraseSet = PhraseSet.newBuilder().build();
   *   String phraseSetId = "phraseSetId959902180";
   *   PhraseSet response = adaptationClient.createPhraseSet(parent, phraseSet, phraseSetId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this phrase set will be created. Format:
   *     <p>`projects/{project}/locations/{location}/phraseSets`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @param phraseSet Required. The phrase set to create.
   * @param phraseSetId Required. The ID to use for the phrase set, which will become the final
   *     component of the phrase set's resource name.
   *     <p>This value should restrict to letters, numbers, and hyphens, with the first character a
   *     letter, the last a letter or a number, and be 4-63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseSet createPhraseSet(String parent, PhraseSet phraseSet, String phraseSetId) {
    CreatePhraseSetRequest request =
        CreatePhraseSetRequest.newBuilder()
            .setParent(parent)
            .setPhraseSet(phraseSet)
            .setPhraseSetId(phraseSetId)
            .build();
    return createPhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a set of phrase hints. Each item in the set can be a single word or a multi-word phrase.
   * The items in the PhraseSet are favored by the recognition model when you send a call that
   * includes the PhraseSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   CreatePhraseSetRequest request =
   *       CreatePhraseSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPhraseSetId("phraseSetId959902180")
   *           .setPhraseSet(PhraseSet.newBuilder().build())
   *           .build();
   *   PhraseSet response = adaptationClient.createPhraseSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseSet createPhraseSet(CreatePhraseSetRequest request) {
    return createPhraseSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a set of phrase hints. Each item in the set can be a single word or a multi-word phrase.
   * The items in the PhraseSet are favored by the recognition model when you send a call that
   * includes the PhraseSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   CreatePhraseSetRequest request =
   *       CreatePhraseSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPhraseSetId("phraseSetId959902180")
   *           .setPhraseSet(PhraseSet.newBuilder().build())
   *           .build();
   *   ApiFuture<PhraseSet> future = adaptationClient.createPhraseSetCallable().futureCall(request);
   *   // Do something.
   *   PhraseSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePhraseSetRequest, PhraseSet> createPhraseSetCallable() {
    return stub.createPhraseSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
   *   PhraseSet response = adaptationClient.getPhraseSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase set to retrieve. Format:
   *     <p>`projects/{project}/locations/{location}/phraseSets/{phrase_set}`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseSet getPhraseSet(PhraseSetName name) {
    GetPhraseSetRequest request =
        GetPhraseSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   String name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString();
   *   PhraseSet response = adaptationClient.getPhraseSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase set to retrieve. Format:
   *     <p>`projects/{project}/locations/{location}/phraseSets/{phrase_set}`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseSet getPhraseSet(String name) {
    GetPhraseSetRequest request = GetPhraseSetRequest.newBuilder().setName(name).build();
    return getPhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   GetPhraseSetRequest request =
   *       GetPhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .build();
   *   PhraseSet response = adaptationClient.getPhraseSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseSet getPhraseSet(GetPhraseSetRequest request) {
    return getPhraseSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   GetPhraseSetRequest request =
   *       GetPhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .build();
   *   ApiFuture<PhraseSet> future = adaptationClient.getPhraseSetCallable().futureCall(request);
   *   // Do something.
   *   PhraseSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPhraseSetRequest, PhraseSet> getPhraseSetCallable() {
    return stub.getPhraseSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List phrase sets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PhraseSet element : adaptationClient.listPhraseSet(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of phrase set. Format:
   *     <p>`projects/{project}/locations/{location}`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseSetPagedResponse listPhraseSet(LocationName parent) {
    ListPhraseSetRequest request =
        ListPhraseSetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List phrase sets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PhraseSet element : adaptationClient.listPhraseSet(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of phrase set. Format:
   *     <p>`projects/{project}/locations/{location}`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseSetPagedResponse listPhraseSet(String parent) {
    ListPhraseSetRequest request = ListPhraseSetRequest.newBuilder().setParent(parent).build();
    return listPhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List phrase sets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   ListPhraseSetRequest request =
   *       ListPhraseSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PhraseSet element : adaptationClient.listPhraseSet(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseSetPagedResponse listPhraseSet(ListPhraseSetRequest request) {
    return listPhraseSetPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List phrase sets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   ListPhraseSetRequest request =
   *       ListPhraseSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PhraseSet> future =
   *       adaptationClient.listPhraseSetPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PhraseSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPhraseSetRequest, ListPhraseSetPagedResponse>
      listPhraseSetPagedCallable() {
    return stub.listPhraseSetPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List phrase sets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   ListPhraseSetRequest request =
   *       ListPhraseSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPhraseSetResponse response = adaptationClient.listPhraseSetCallable().call(request);
   *     for (PhraseSet element : response.getPhraseSetsList()) {
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
  public final UnaryCallable<ListPhraseSetRequest, ListPhraseSetResponse> listPhraseSetCallable() {
    return stub.listPhraseSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   PhraseSet phraseSet = PhraseSet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PhraseSet response = adaptationClient.updatePhraseSet(phraseSet, updateMask);
   * }
   * }</pre>
   *
   * @param phraseSet Required. The phrase set to update.
   *     <p>The phrase set's `name` field is used to identify the set to be updated. Format:
   *     <p>`projects/{project}/locations/{location}/phraseSets/{phrase_set}`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseSet updatePhraseSet(PhraseSet phraseSet, FieldMask updateMask) {
    UpdatePhraseSetRequest request =
        UpdatePhraseSetRequest.newBuilder()
            .setPhraseSet(phraseSet)
            .setUpdateMask(updateMask)
            .build();
    return updatePhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   UpdatePhraseSetRequest request =
   *       UpdatePhraseSetRequest.newBuilder()
   *           .setPhraseSet(PhraseSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PhraseSet response = adaptationClient.updatePhraseSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseSet updatePhraseSet(UpdatePhraseSetRequest request) {
    return updatePhraseSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   UpdatePhraseSetRequest request =
   *       UpdatePhraseSetRequest.newBuilder()
   *           .setPhraseSet(PhraseSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<PhraseSet> future = adaptationClient.updatePhraseSetCallable().futureCall(request);
   *   // Do something.
   *   PhraseSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetCallable() {
    return stub.updatePhraseSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
   *   adaptationClient.deletePhraseSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase set to delete. Format:
   *     <p>`projects/{project}/locations/{location}/phraseSets/{phrase_set}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePhraseSet(PhraseSetName name) {
    DeletePhraseSetRequest request =
        DeletePhraseSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deletePhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   String name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString();
   *   adaptationClient.deletePhraseSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase set to delete. Format:
   *     <p>`projects/{project}/locations/{location}/phraseSets/{phrase_set}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePhraseSet(String name) {
    DeletePhraseSetRequest request = DeletePhraseSetRequest.newBuilder().setName(name).build();
    deletePhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   DeletePhraseSetRequest request =
   *       DeletePhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .build();
   *   adaptationClient.deletePhraseSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePhraseSet(DeletePhraseSetRequest request) {
    deletePhraseSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a phrase set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   DeletePhraseSetRequest request =
   *       DeletePhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .build();
   *   ApiFuture<Empty> future = adaptationClient.deletePhraseSetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePhraseSetRequest, Empty> deletePhraseSetCallable() {
    return stub.deletePhraseSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CustomClass customClass = CustomClass.newBuilder().build();
   *   String customClassId = "customClassId1871032322";
   *   CustomClass response = adaptationClient.createCustomClass(parent, customClass, customClassId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this custom class will be created. Format:
   *     <p>`projects/{project}/locations/{location}/customClasses`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @param customClass Required. The custom class to create.
   * @param customClassId Required. The ID to use for the custom class, which will become the final
   *     component of the custom class' resource name.
   *     <p>This value should restrict to letters, numbers, and hyphens, with the first character a
   *     letter, the last a letter or a number, and be 4-63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomClass createCustomClass(
      LocationName parent, CustomClass customClass, String customClassId) {
    CreateCustomClassRequest request =
        CreateCustomClassRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomClass(customClass)
            .setCustomClassId(customClassId)
            .build();
    return createCustomClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CustomClass customClass = CustomClass.newBuilder().build();
   *   String customClassId = "customClassId1871032322";
   *   CustomClass response = adaptationClient.createCustomClass(parent, customClass, customClassId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this custom class will be created. Format:
   *     <p>`projects/{project}/locations/{location}/customClasses`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @param customClass Required. The custom class to create.
   * @param customClassId Required. The ID to use for the custom class, which will become the final
   *     component of the custom class' resource name.
   *     <p>This value should restrict to letters, numbers, and hyphens, with the first character a
   *     letter, the last a letter or a number, and be 4-63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomClass createCustomClass(
      String parent, CustomClass customClass, String customClassId) {
    CreateCustomClassRequest request =
        CreateCustomClassRequest.newBuilder()
            .setParent(parent)
            .setCustomClass(customClass)
            .setCustomClassId(customClassId)
            .build();
    return createCustomClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   CreateCustomClassRequest request =
   *       CreateCustomClassRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCustomClassId("customClassId1871032322")
   *           .setCustomClass(CustomClass.newBuilder().build())
   *           .build();
   *   CustomClass response = adaptationClient.createCustomClass(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomClass createCustomClass(CreateCustomClassRequest request) {
    return createCustomClassCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   CreateCustomClassRequest request =
   *       CreateCustomClassRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCustomClassId("customClassId1871032322")
   *           .setCustomClass(CustomClass.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomClass> future =
   *       adaptationClient.createCustomClassCallable().futureCall(request);
   *   // Do something.
   *   CustomClass response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomClassRequest, CustomClass> createCustomClassCallable() {
    return stub.createCustomClassCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
   *   CustomClass response = adaptationClient.getCustomClass(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the custom class to retrieve. Format:
   *     <p>`projects/{project}/locations/{location}/customClasses/{custom_class}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomClass getCustomClass(CustomClassName name) {
    GetCustomClassRequest request =
        GetCustomClassRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCustomClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   String name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString();
   *   CustomClass response = adaptationClient.getCustomClass(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the custom class to retrieve. Format:
   *     <p>`projects/{project}/locations/{location}/customClasses/{custom_class}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomClass getCustomClass(String name) {
    GetCustomClassRequest request = GetCustomClassRequest.newBuilder().setName(name).build();
    return getCustomClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   GetCustomClassRequest request =
   *       GetCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .build();
   *   CustomClass response = adaptationClient.getCustomClass(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomClass getCustomClass(GetCustomClassRequest request) {
    return getCustomClassCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   GetCustomClassRequest request =
   *       GetCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .build();
   *   ApiFuture<CustomClass> future = adaptationClient.getCustomClassCallable().futureCall(request);
   *   // Do something.
   *   CustomClass response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomClassRequest, CustomClass> getCustomClassCallable() {
    return stub.getCustomClassCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List custom classes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CustomClass element : adaptationClient.listCustomClasses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of custom classes. Format:
   *     <p>`projects/{project}/locations/{location}/customClasses`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomClassesPagedResponse listCustomClasses(LocationName parent) {
    ListCustomClassesRequest request =
        ListCustomClassesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomClasses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List custom classes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CustomClass element : adaptationClient.listCustomClasses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of custom classes. Format:
   *     <p>`projects/{project}/locations/{location}/customClasses`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomClassesPagedResponse listCustomClasses(String parent) {
    ListCustomClassesRequest request =
        ListCustomClassesRequest.newBuilder().setParent(parent).build();
    return listCustomClasses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List custom classes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   ListCustomClassesRequest request =
   *       ListCustomClassesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CustomClass element : adaptationClient.listCustomClasses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomClassesPagedResponse listCustomClasses(ListCustomClassesRequest request) {
    return listCustomClassesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List custom classes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   ListCustomClassesRequest request =
   *       ListCustomClassesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CustomClass> future =
   *       adaptationClient.listCustomClassesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CustomClass element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomClassesRequest, ListCustomClassesPagedResponse>
      listCustomClassesPagedCallable() {
    return stub.listCustomClassesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List custom classes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   ListCustomClassesRequest request =
   *       ListCustomClassesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCustomClassesResponse response =
   *         adaptationClient.listCustomClassesCallable().call(request);
   *     for (CustomClass element : response.getCustomClassesList()) {
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
  public final UnaryCallable<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesCallable() {
    return stub.listCustomClassesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   CustomClass customClass = CustomClass.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CustomClass response = adaptationClient.updateCustomClass(customClass, updateMask);
   * }
   * }</pre>
   *
   * @param customClass Required. The custom class to update.
   *     <p>The custom class's `name` field is used to identify the custom class to be updated.
   *     Format:
   *     <p>`projects/{project}/locations/{location}/customClasses/{custom_class}`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomClass updateCustomClass(CustomClass customClass, FieldMask updateMask) {
    UpdateCustomClassRequest request =
        UpdateCustomClassRequest.newBuilder()
            .setCustomClass(customClass)
            .setUpdateMask(updateMask)
            .build();
    return updateCustomClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   UpdateCustomClassRequest request =
   *       UpdateCustomClassRequest.newBuilder()
   *           .setCustomClass(CustomClass.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CustomClass response = adaptationClient.updateCustomClass(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomClass updateCustomClass(UpdateCustomClassRequest request) {
    return updateCustomClassCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   UpdateCustomClassRequest request =
   *       UpdateCustomClassRequest.newBuilder()
   *           .setCustomClass(CustomClass.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomClass> future =
   *       adaptationClient.updateCustomClassCallable().futureCall(request);
   *   // Do something.
   *   CustomClass response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomClassRequest, CustomClass> updateCustomClassCallable() {
    return stub.updateCustomClassCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
   *   adaptationClient.deleteCustomClass(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the custom class to delete. Format:
   *     <p>`projects/{project}/locations/{location}/customClasses/{custom_class}`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomClass(CustomClassName name) {
    DeleteCustomClassRequest request =
        DeleteCustomClassRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCustomClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   String name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString();
   *   adaptationClient.deleteCustomClass(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the custom class to delete. Format:
   *     <p>`projects/{project}/locations/{location}/customClasses/{custom_class}`
   *     <p>Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu`
   *     (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global`
   *     location. To specify a region, use a [regional
   *     endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or
   *     `eu` location value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomClass(String name) {
    DeleteCustomClassRequest request = DeleteCustomClassRequest.newBuilder().setName(name).build();
    deleteCustomClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   DeleteCustomClassRequest request =
   *       DeleteCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .build();
   *   adaptationClient.deleteCustomClass(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomClass(DeleteCustomClassRequest request) {
    deleteCustomClassCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a custom class.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
   *   DeleteCustomClassRequest request =
   *       DeleteCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .build();
   *   ApiFuture<Empty> future = adaptationClient.deleteCustomClassCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCustomClassRequest, Empty> deleteCustomClassCallable() {
    return stub.deleteCustomClassCallable();
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

  public static class ListPhraseSetPagedResponse
      extends AbstractPagedListResponse<
          ListPhraseSetRequest,
          ListPhraseSetResponse,
          PhraseSet,
          ListPhraseSetPage,
          ListPhraseSetFixedSizeCollection> {

    public static ApiFuture<ListPhraseSetPagedResponse> createAsync(
        PageContext<ListPhraseSetRequest, ListPhraseSetResponse, PhraseSet> context,
        ApiFuture<ListPhraseSetResponse> futureResponse) {
      ApiFuture<ListPhraseSetPage> futurePage =
          ListPhraseSetPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPhraseSetPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPhraseSetPagedResponse(ListPhraseSetPage page) {
      super(page, ListPhraseSetFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPhraseSetPage
      extends AbstractPage<
          ListPhraseSetRequest, ListPhraseSetResponse, PhraseSet, ListPhraseSetPage> {

    private ListPhraseSetPage(
        PageContext<ListPhraseSetRequest, ListPhraseSetResponse, PhraseSet> context,
        ListPhraseSetResponse response) {
      super(context, response);
    }

    private static ListPhraseSetPage createEmptyPage() {
      return new ListPhraseSetPage(null, null);
    }

    @Override
    protected ListPhraseSetPage createPage(
        PageContext<ListPhraseSetRequest, ListPhraseSetResponse, PhraseSet> context,
        ListPhraseSetResponse response) {
      return new ListPhraseSetPage(context, response);
    }

    @Override
    public ApiFuture<ListPhraseSetPage> createPageAsync(
        PageContext<ListPhraseSetRequest, ListPhraseSetResponse, PhraseSet> context,
        ApiFuture<ListPhraseSetResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPhraseSetFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPhraseSetRequest,
          ListPhraseSetResponse,
          PhraseSet,
          ListPhraseSetPage,
          ListPhraseSetFixedSizeCollection> {

    private ListPhraseSetFixedSizeCollection(List<ListPhraseSetPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPhraseSetFixedSizeCollection createEmptyCollection() {
      return new ListPhraseSetFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPhraseSetFixedSizeCollection createCollection(
        List<ListPhraseSetPage> pages, int collectionSize) {
      return new ListPhraseSetFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCustomClassesPagedResponse
      extends AbstractPagedListResponse<
          ListCustomClassesRequest,
          ListCustomClassesResponse,
          CustomClass,
          ListCustomClassesPage,
          ListCustomClassesFixedSizeCollection> {

    public static ApiFuture<ListCustomClassesPagedResponse> createAsync(
        PageContext<ListCustomClassesRequest, ListCustomClassesResponse, CustomClass> context,
        ApiFuture<ListCustomClassesResponse> futureResponse) {
      ApiFuture<ListCustomClassesPage> futurePage =
          ListCustomClassesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomClassesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomClassesPagedResponse(ListCustomClassesPage page) {
      super(page, ListCustomClassesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomClassesPage
      extends AbstractPage<
          ListCustomClassesRequest, ListCustomClassesResponse, CustomClass, ListCustomClassesPage> {

    private ListCustomClassesPage(
        PageContext<ListCustomClassesRequest, ListCustomClassesResponse, CustomClass> context,
        ListCustomClassesResponse response) {
      super(context, response);
    }

    private static ListCustomClassesPage createEmptyPage() {
      return new ListCustomClassesPage(null, null);
    }

    @Override
    protected ListCustomClassesPage createPage(
        PageContext<ListCustomClassesRequest, ListCustomClassesResponse, CustomClass> context,
        ListCustomClassesResponse response) {
      return new ListCustomClassesPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomClassesPage> createPageAsync(
        PageContext<ListCustomClassesRequest, ListCustomClassesResponse, CustomClass> context,
        ApiFuture<ListCustomClassesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomClassesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomClassesRequest,
          ListCustomClassesResponse,
          CustomClass,
          ListCustomClassesPage,
          ListCustomClassesFixedSizeCollection> {

    private ListCustomClassesFixedSizeCollection(
        List<ListCustomClassesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomClassesFixedSizeCollection createEmptyCollection() {
      return new ListCustomClassesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomClassesFixedSizeCollection createCollection(
        List<ListCustomClassesPage> pages, int collectionSize) {
      return new ListCustomClassesFixedSizeCollection(pages, collectionSize);
    }
  }
}
