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

package com.google.cloud.speech.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v2.stub.SpeechStub;
import com.google.cloud.speech.v2.stub.SpeechStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Enables speech transcription and resource management.
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
 * try (SpeechClient speechClient = SpeechClient.create()) {
 *   RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
 *   Recognizer response = speechClient.getRecognizer(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SpeechClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of SpeechSettings to create().
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
 * SpeechSettings speechSettings =
 *     SpeechSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SpeechClient speechClient = SpeechClient.create(speechSettings);
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
 * SpeechSettings speechSettings = SpeechSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SpeechClient speechClient = SpeechClient.create(speechSettings);
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
 * SpeechSettings speechSettings = SpeechSettings.newHttpJsonBuilder().build();
 * SpeechClient speechClient = SpeechClient.create(speechSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SpeechClient implements BackgroundResource {
  private final SpeechSettings settings;
  private final SpeechStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SpeechClient with default settings. */
  public static final SpeechClient create() throws IOException {
    return create(SpeechSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SpeechClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SpeechClient create(SpeechSettings settings) throws IOException {
    return new SpeechClient(settings);
  }

  /**
   * Constructs an instance of SpeechClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(SpeechSettings).
   */
  public static final SpeechClient create(SpeechStub stub) {
    return new SpeechClient(stub);
  }

  /**
   * Constructs an instance of SpeechClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SpeechClient(SpeechSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SpeechStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SpeechClient(SpeechStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SpeechSettings getSettings() {
    return settings;
  }

  public SpeechStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Recognizer recognizer = Recognizer.newBuilder().build();
   *   String recognizerId = "recognizerId771963359";
   *   Recognizer response =
   *       speechClient.createRecognizerAsync(parent, recognizer, recognizerId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location where this Recognizer will be created. The
   *     expected format is `projects/{project}/locations/{location}`.
   * @param recognizer Required. The Recognizer to create.
   * @param recognizerId The ID to use for the Recognizer, which will become the final component of
   *     the Recognizer's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> createRecognizerAsync(
      LocationName parent, Recognizer recognizer, String recognizerId) {
    CreateRecognizerRequest request =
        CreateRecognizerRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRecognizer(recognizer)
            .setRecognizerId(recognizerId)
            .build();
    return createRecognizerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Recognizer recognizer = Recognizer.newBuilder().build();
   *   String recognizerId = "recognizerId771963359";
   *   Recognizer response =
   *       speechClient.createRecognizerAsync(parent, recognizer, recognizerId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location where this Recognizer will be created. The
   *     expected format is `projects/{project}/locations/{location}`.
   * @param recognizer Required. The Recognizer to create.
   * @param recognizerId The ID to use for the Recognizer, which will become the final component of
   *     the Recognizer's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> createRecognizerAsync(
      String parent, Recognizer recognizer, String recognizerId) {
    CreateRecognizerRequest request =
        CreateRecognizerRequest.newBuilder()
            .setParent(parent)
            .setRecognizer(recognizer)
            .setRecognizerId(recognizerId)
            .build();
    return createRecognizerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CreateRecognizerRequest request =
   *       CreateRecognizerRequest.newBuilder()
   *           .setRecognizer(Recognizer.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRecognizerId("recognizerId771963359")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   Recognizer response = speechClient.createRecognizerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> createRecognizerAsync(
      CreateRecognizerRequest request) {
    return createRecognizerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CreateRecognizerRequest request =
   *       CreateRecognizerRequest.newBuilder()
   *           .setRecognizer(Recognizer.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRecognizerId("recognizerId771963359")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   OperationFuture<Recognizer, OperationMetadata> future =
   *       speechClient.createRecognizerOperationCallable().futureCall(request);
   *   // Do something.
   *   Recognizer response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRecognizerRequest, Recognizer, OperationMetadata>
      createRecognizerOperationCallable() {
    return stub.createRecognizerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CreateRecognizerRequest request =
   *       CreateRecognizerRequest.newBuilder()
   *           .setRecognizer(Recognizer.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRecognizerId("recognizerId771963359")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Operation> future = speechClient.createRecognizerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRecognizerRequest, Operation> createRecognizerCallable() {
    return stub.createRecognizerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Recognizers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Recognizer element : speechClient.listRecognizers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location of Recognizers to list. The expected format is
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecognizersPagedResponse listRecognizers(LocationName parent) {
    ListRecognizersRequest request =
        ListRecognizersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRecognizers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Recognizers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Recognizer element : speechClient.listRecognizers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location of Recognizers to list. The expected format is
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecognizersPagedResponse listRecognizers(String parent) {
    ListRecognizersRequest request = ListRecognizersRequest.newBuilder().setParent(parent).build();
    return listRecognizers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Recognizers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ListRecognizersRequest request =
   *       ListRecognizersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Recognizer element : speechClient.listRecognizers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecognizersPagedResponse listRecognizers(ListRecognizersRequest request) {
    return listRecognizersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Recognizers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ListRecognizersRequest request =
   *       ListRecognizersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Recognizer> future =
   *       speechClient.listRecognizersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Recognizer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRecognizersRequest, ListRecognizersPagedResponse>
      listRecognizersPagedCallable() {
    return stub.listRecognizersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Recognizers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ListRecognizersRequest request =
   *       ListRecognizersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListRecognizersResponse response = speechClient.listRecognizersCallable().call(request);
   *     for (Recognizer element : response.getRecognizersList()) {
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
  public final UnaryCallable<ListRecognizersRequest, ListRecognizersResponse>
      listRecognizersCallable() {
    return stub.listRecognizersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Recognizer][google.cloud.speech.v2.Recognizer]. Fails with
   * [NOT_FOUND][google.rpc.Code.NOT_FOUND] if the requested recognizer doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
   *   Recognizer response = speechClient.getRecognizer(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Recognizer to retrieve. The expected format is
   *     `projects/{project}/locations/{location}/recognizers/{recognizer}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recognizer getRecognizer(RecognizerName name) {
    GetRecognizerRequest request =
        GetRecognizerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRecognizer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Recognizer][google.cloud.speech.v2.Recognizer]. Fails with
   * [NOT_FOUND][google.rpc.Code.NOT_FOUND] if the requested recognizer doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString();
   *   Recognizer response = speechClient.getRecognizer(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Recognizer to retrieve. The expected format is
   *     `projects/{project}/locations/{location}/recognizers/{recognizer}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recognizer getRecognizer(String name) {
    GetRecognizerRequest request = GetRecognizerRequest.newBuilder().setName(name).build();
    return getRecognizer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Recognizer][google.cloud.speech.v2.Recognizer]. Fails with
   * [NOT_FOUND][google.rpc.Code.NOT_FOUND] if the requested recognizer doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   GetRecognizerRequest request =
   *       GetRecognizerRequest.newBuilder()
   *           .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .build();
   *   Recognizer response = speechClient.getRecognizer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recognizer getRecognizer(GetRecognizerRequest request) {
    return getRecognizerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Recognizer][google.cloud.speech.v2.Recognizer]. Fails with
   * [NOT_FOUND][google.rpc.Code.NOT_FOUND] if the requested recognizer doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   GetRecognizerRequest request =
   *       GetRecognizerRequest.newBuilder()
   *           .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .build();
   *   ApiFuture<Recognizer> future = speechClient.getRecognizerCallable().futureCall(request);
   *   // Do something.
   *   Recognizer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRecognizerRequest, Recognizer> getRecognizerCallable() {
    return stub.getRecognizerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   Recognizer recognizer = Recognizer.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Recognizer response = speechClient.updateRecognizerAsync(recognizer, updateMask).get();
   * }
   * }</pre>
   *
   * @param recognizer Required. The Recognizer to update.
   *     <p>The Recognizer's `name` field is used to identify the Recognizer to update. Format:
   *     `projects/{project}/locations/{location}/recognizers/{recognizer}`.
   * @param updateMask The list of fields to update. If empty, all non-default valued fields are
   *     considered for update. Use `&#42;` to update the entire Recognizer resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> updateRecognizerAsync(
      Recognizer recognizer, FieldMask updateMask) {
    UpdateRecognizerRequest request =
        UpdateRecognizerRequest.newBuilder()
            .setRecognizer(recognizer)
            .setUpdateMask(updateMask)
            .build();
    return updateRecognizerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdateRecognizerRequest request =
   *       UpdateRecognizerRequest.newBuilder()
   *           .setRecognizer(Recognizer.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Recognizer response = speechClient.updateRecognizerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> updateRecognizerAsync(
      UpdateRecognizerRequest request) {
    return updateRecognizerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdateRecognizerRequest request =
   *       UpdateRecognizerRequest.newBuilder()
   *           .setRecognizer(Recognizer.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Recognizer, OperationMetadata> future =
   *       speechClient.updateRecognizerOperationCallable().futureCall(request);
   *   // Do something.
   *   Recognizer response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRecognizerRequest, Recognizer, OperationMetadata>
      updateRecognizerOperationCallable() {
    return stub.updateRecognizerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdateRecognizerRequest request =
   *       UpdateRecognizerRequest.newBuilder()
   *           .setRecognizer(Recognizer.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = speechClient.updateRecognizerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRecognizerRequest, Operation> updateRecognizerCallable() {
    return stub.updateRecognizerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
   *   Recognizer response = speechClient.deleteRecognizerAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Recognizer to delete. Format:
   *     `projects/{project}/locations/{location}/recognizers/{recognizer}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> deleteRecognizerAsync(
      RecognizerName name) {
    DeleteRecognizerRequest request =
        DeleteRecognizerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRecognizerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString();
   *   Recognizer response = speechClient.deleteRecognizerAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Recognizer to delete. Format:
   *     `projects/{project}/locations/{location}/recognizers/{recognizer}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> deleteRecognizerAsync(String name) {
    DeleteRecognizerRequest request = DeleteRecognizerRequest.newBuilder().setName(name).build();
    return deleteRecognizerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   DeleteRecognizerRequest request =
   *       DeleteRecognizerRequest.newBuilder()
   *           .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   Recognizer response = speechClient.deleteRecognizerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> deleteRecognizerAsync(
      DeleteRecognizerRequest request) {
    return deleteRecognizerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   DeleteRecognizerRequest request =
   *       DeleteRecognizerRequest.newBuilder()
   *           .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Recognizer, OperationMetadata> future =
   *       speechClient.deleteRecognizerOperationCallable().futureCall(request);
   *   // Do something.
   *   Recognizer response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRecognizerRequest, Recognizer, OperationMetadata>
      deleteRecognizerOperationCallable() {
    return stub.deleteRecognizerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   DeleteRecognizerRequest request =
   *       DeleteRecognizerRequest.newBuilder()
   *           .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = speechClient.deleteRecognizerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRecognizerRequest, Operation> deleteRecognizerCallable() {
    return stub.deleteRecognizerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
   *   Recognizer response = speechClient.undeleteRecognizerAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Recognizer to undelete. Format:
   *     `projects/{project}/locations/{location}/recognizers/{recognizer}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> undeleteRecognizerAsync(
      RecognizerName name) {
    UndeleteRecognizerRequest request =
        UndeleteRecognizerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeleteRecognizerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString();
   *   Recognizer response = speechClient.undeleteRecognizerAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Recognizer to undelete. Format:
   *     `projects/{project}/locations/{location}/recognizers/{recognizer}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> undeleteRecognizerAsync(String name) {
    UndeleteRecognizerRequest request =
        UndeleteRecognizerRequest.newBuilder().setName(name).build();
    return undeleteRecognizerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UndeleteRecognizerRequest request =
   *       UndeleteRecognizerRequest.newBuilder()
   *           .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   Recognizer response = speechClient.undeleteRecognizerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Recognizer, OperationMetadata> undeleteRecognizerAsync(
      UndeleteRecognizerRequest request) {
    return undeleteRecognizerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UndeleteRecognizerRequest request =
   *       UndeleteRecognizerRequest.newBuilder()
   *           .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Recognizer, OperationMetadata> future =
   *       speechClient.undeleteRecognizerOperationCallable().futureCall(request);
   *   // Do something.
   *   Recognizer response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeleteRecognizerRequest, Recognizer, OperationMetadata>
      undeleteRecognizerOperationCallable() {
    return stub.undeleteRecognizerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [Recognizer][google.cloud.speech.v2.Recognizer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UndeleteRecognizerRequest request =
   *       UndeleteRecognizerRequest.newBuilder()
   *           .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = speechClient.undeleteRecognizerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteRecognizerRequest, Operation> undeleteRecognizerCallable() {
    return stub.undeleteRecognizerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs synchronous Speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
   *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
   *   FieldMask configMask = FieldMask.newBuilder().build();
   *   ByteString content = ByteString.EMPTY;
   *   RecognizeResponse response = speechClient.recognize(recognizer, config, configMask, content);
   * }
   * }</pre>
   *
   * @param recognizer Required. The name of the Recognizer to use during recognition. The expected
   *     format is `projects/{project}/locations/{location}/recognizers/{recognizer}`.
   * @param config Features and audio metadata to use for the Automatic Speech Recognition. This
   *     field in combination with the
   *     [config_mask][google.cloud.speech.v2.RecognizeRequest.config_mask] field can be used to
   *     override parts of the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the Recognizer resource.
   * @param configMask The list of fields in
   *     [config][google.cloud.speech.v2.RecognizeRequest.config] that override the values in the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the recognizer during this recognition request. If no mask is provided, all non-default
   *     valued fields in [config][google.cloud.speech.v2.RecognizeRequest.config] override the
   *     values in the recognizer for this recognition request. If a mask is provided, only the
   *     fields listed in the mask override the config in the recognizer for this recognition
   *     request. If a wildcard (`&#42;`) is provided,
   *     [config][google.cloud.speech.v2.RecognizeRequest.config] completely overrides and replaces
   *     the config in the recognizer for this recognition request.
   * @param content The audio data bytes encoded as specified in
   *     [RecognitionConfig][google.cloud.speech.v2.RecognitionConfig]. As with all bytes fields,
   *     proto buffers use a pure binary representation, whereas JSON representations use base64.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecognizeResponse recognize(
      RecognizerName recognizer,
      RecognitionConfig config,
      FieldMask configMask,
      ByteString content) {
    RecognizeRequest request =
        RecognizeRequest.newBuilder()
            .setRecognizer(recognizer == null ? null : recognizer.toString())
            .setConfig(config)
            .setConfigMask(configMask)
            .setContent(content)
            .build();
    return recognize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs synchronous Speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
   *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
   *   FieldMask configMask = FieldMask.newBuilder().build();
   *   String uri = "uri116076";
   *   RecognizeResponse response = speechClient.recognize(recognizer, config, configMask, uri);
   * }
   * }</pre>
   *
   * @param recognizer Required. The name of the Recognizer to use during recognition. The expected
   *     format is `projects/{project}/locations/{location}/recognizers/{recognizer}`.
   * @param config Features and audio metadata to use for the Automatic Speech Recognition. This
   *     field in combination with the
   *     [config_mask][google.cloud.speech.v2.RecognizeRequest.config_mask] field can be used to
   *     override parts of the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the Recognizer resource.
   * @param configMask The list of fields in
   *     [config][google.cloud.speech.v2.RecognizeRequest.config] that override the values in the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the recognizer during this recognition request. If no mask is provided, all non-default
   *     valued fields in [config][google.cloud.speech.v2.RecognizeRequest.config] override the
   *     values in the recognizer for this recognition request. If a mask is provided, only the
   *     fields listed in the mask override the config in the recognizer for this recognition
   *     request. If a wildcard (`&#42;`) is provided,
   *     [config][google.cloud.speech.v2.RecognizeRequest.config] completely overrides and replaces
   *     the config in the recognizer for this recognition request.
   * @param uri URI that points to a file that contains audio data bytes as specified in
   *     [RecognitionConfig][google.cloud.speech.v2.RecognitionConfig]. The file must not be
   *     compressed (for example, gzip). Currently, only Google Cloud Storage URIs are supported,
   *     which must be specified in the following format: `gs://bucket_name/object_name` (other URI
   *     formats return [INVALID_ARGUMENT][google.rpc.Code.INVALID_ARGUMENT]). For more information,
   *     see [Request URIs](https://cloud.google.com/storage/docs/reference-uris).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecognizeResponse recognize(
      RecognizerName recognizer, RecognitionConfig config, FieldMask configMask, String uri) {
    RecognizeRequest request =
        RecognizeRequest.newBuilder()
            .setRecognizer(recognizer == null ? null : recognizer.toString())
            .setConfig(config)
            .setConfigMask(configMask)
            .setUri(uri)
            .build();
    return recognize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs synchronous Speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString();
   *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
   *   FieldMask configMask = FieldMask.newBuilder().build();
   *   ByteString content = ByteString.EMPTY;
   *   RecognizeResponse response = speechClient.recognize(recognizer, config, configMask, content);
   * }
   * }</pre>
   *
   * @param recognizer Required. The name of the Recognizer to use during recognition. The expected
   *     format is `projects/{project}/locations/{location}/recognizers/{recognizer}`.
   * @param config Features and audio metadata to use for the Automatic Speech Recognition. This
   *     field in combination with the
   *     [config_mask][google.cloud.speech.v2.RecognizeRequest.config_mask] field can be used to
   *     override parts of the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the Recognizer resource.
   * @param configMask The list of fields in
   *     [config][google.cloud.speech.v2.RecognizeRequest.config] that override the values in the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the recognizer during this recognition request. If no mask is provided, all non-default
   *     valued fields in [config][google.cloud.speech.v2.RecognizeRequest.config] override the
   *     values in the recognizer for this recognition request. If a mask is provided, only the
   *     fields listed in the mask override the config in the recognizer for this recognition
   *     request. If a wildcard (`&#42;`) is provided,
   *     [config][google.cloud.speech.v2.RecognizeRequest.config] completely overrides and replaces
   *     the config in the recognizer for this recognition request.
   * @param content The audio data bytes encoded as specified in
   *     [RecognitionConfig][google.cloud.speech.v2.RecognitionConfig]. As with all bytes fields,
   *     proto buffers use a pure binary representation, whereas JSON representations use base64.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecognizeResponse recognize(
      String recognizer, RecognitionConfig config, FieldMask configMask, ByteString content) {
    RecognizeRequest request =
        RecognizeRequest.newBuilder()
            .setRecognizer(recognizer)
            .setConfig(config)
            .setConfigMask(configMask)
            .setContent(content)
            .build();
    return recognize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs synchronous Speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString();
   *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
   *   FieldMask configMask = FieldMask.newBuilder().build();
   *   String uri = "uri116076";
   *   RecognizeResponse response = speechClient.recognize(recognizer, config, configMask, uri);
   * }
   * }</pre>
   *
   * @param recognizer Required. The name of the Recognizer to use during recognition. The expected
   *     format is `projects/{project}/locations/{location}/recognizers/{recognizer}`.
   * @param config Features and audio metadata to use for the Automatic Speech Recognition. This
   *     field in combination with the
   *     [config_mask][google.cloud.speech.v2.RecognizeRequest.config_mask] field can be used to
   *     override parts of the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the Recognizer resource.
   * @param configMask The list of fields in
   *     [config][google.cloud.speech.v2.RecognizeRequest.config] that override the values in the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the recognizer during this recognition request. If no mask is provided, all non-default
   *     valued fields in [config][google.cloud.speech.v2.RecognizeRequest.config] override the
   *     values in the recognizer for this recognition request. If a mask is provided, only the
   *     fields listed in the mask override the config in the recognizer for this recognition
   *     request. If a wildcard (`&#42;`) is provided,
   *     [config][google.cloud.speech.v2.RecognizeRequest.config] completely overrides and replaces
   *     the config in the recognizer for this recognition request.
   * @param uri URI that points to a file that contains audio data bytes as specified in
   *     [RecognitionConfig][google.cloud.speech.v2.RecognitionConfig]. The file must not be
   *     compressed (for example, gzip). Currently, only Google Cloud Storage URIs are supported,
   *     which must be specified in the following format: `gs://bucket_name/object_name` (other URI
   *     formats return [INVALID_ARGUMENT][google.rpc.Code.INVALID_ARGUMENT]). For more information,
   *     see [Request URIs](https://cloud.google.com/storage/docs/reference-uris).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecognizeResponse recognize(
      String recognizer, RecognitionConfig config, FieldMask configMask, String uri) {
    RecognizeRequest request =
        RecognizeRequest.newBuilder()
            .setRecognizer(recognizer)
            .setConfig(config)
            .setConfigMask(configMask)
            .setUri(uri)
            .build();
    return recognize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs synchronous Speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognizeRequest request =
   *       RecognizeRequest.newBuilder()
   *           .setRecognizer(
   *               RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setConfig(RecognitionConfig.newBuilder().build())
   *           .setConfigMask(FieldMask.newBuilder().build())
   *           .build();
   *   RecognizeResponse response = speechClient.recognize(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecognizeResponse recognize(RecognizeRequest request) {
    return recognizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs synchronous Speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognizeRequest request =
   *       RecognizeRequest.newBuilder()
   *           .setRecognizer(
   *               RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setConfig(RecognitionConfig.newBuilder().build())
   *           .setConfigMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<RecognizeResponse> future = speechClient.recognizeCallable().futureCall(request);
   *   // Do something.
   *   RecognizeResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RecognizeRequest, RecognizeResponse> recognizeCallable() {
    return stub.recognizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs bidirectional streaming speech recognition: receive results while sending audio. This
   * method is only available via the gRPC API (not REST).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   BidiStream<StreamingRecognizeRequest, StreamingRecognizeResponse> bidiStream =
   *       speechClient.streamingRecognizeCallable().call();
   *   StreamingRecognizeRequest request =
   *       StreamingRecognizeRequest.newBuilder()
   *           .setRecognizer(
   *               RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .build();
   *   bidiStream.send(request);
   *   for (StreamingRecognizeResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeCallable() {
    return stub.streamingRecognizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs batch asynchronous speech recognition: send a request with N audio files and receive a
   * long running operation that can be polled to see when the transcriptions are finished.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
   *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
   *   FieldMask configMask = FieldMask.newBuilder().build();
   *   List<BatchRecognizeFileMetadata> files = new ArrayList<>();
   *   BatchRecognizeResponse response =
   *       speechClient.batchRecognizeAsync(recognizer, config, configMask, files).get();
   * }
   * }</pre>
   *
   * @param recognizer Required. Resource name of the recognizer to be used for ASR.
   * @param config Features and audio metadata to use for the Automatic Speech Recognition. This
   *     field in combination with the
   *     [config_mask][google.cloud.speech.v2.BatchRecognizeRequest.config_mask] field can be used
   *     to override parts of the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the Recognizer resource.
   * @param configMask The list of fields in
   *     [config][google.cloud.speech.v2.BatchRecognizeRequest.config] that override the values in
   *     the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the recognizer during this recognition request. If no mask is provided, all given fields
   *     in [config][google.cloud.speech.v2.BatchRecognizeRequest.config] override the values in the
   *     recognizer for this recognition request. If a mask is provided, only the fields listed in
   *     the mask override the config in the recognizer for this recognition request. If a wildcard
   *     (`&#42;`) is provided, [config][google.cloud.speech.v2.BatchRecognizeRequest.config]
   *     completely overrides and replaces the config in the recognizer for this recognition
   *     request.
   * @param files Audio files with file metadata for ASR.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchRecognizeResponse, OperationMetadata> batchRecognizeAsync(
      RecognizerName recognizer,
      RecognitionConfig config,
      FieldMask configMask,
      List<BatchRecognizeFileMetadata> files) {
    BatchRecognizeRequest request =
        BatchRecognizeRequest.newBuilder()
            .setRecognizer(recognizer == null ? null : recognizer.toString())
            .setConfig(config)
            .setConfigMask(configMask)
            .addAllFiles(files)
            .build();
    return batchRecognizeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs batch asynchronous speech recognition: send a request with N audio files and receive a
   * long running operation that can be polled to see when the transcriptions are finished.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString();
   *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
   *   FieldMask configMask = FieldMask.newBuilder().build();
   *   List<BatchRecognizeFileMetadata> files = new ArrayList<>();
   *   BatchRecognizeResponse response =
   *       speechClient.batchRecognizeAsync(recognizer, config, configMask, files).get();
   * }
   * }</pre>
   *
   * @param recognizer Required. Resource name of the recognizer to be used for ASR.
   * @param config Features and audio metadata to use for the Automatic Speech Recognition. This
   *     field in combination with the
   *     [config_mask][google.cloud.speech.v2.BatchRecognizeRequest.config_mask] field can be used
   *     to override parts of the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the Recognizer resource.
   * @param configMask The list of fields in
   *     [config][google.cloud.speech.v2.BatchRecognizeRequest.config] that override the values in
   *     the
   *     [default_recognition_config][google.cloud.speech.v2.Recognizer.default_recognition_config]
   *     of the recognizer during this recognition request. If no mask is provided, all given fields
   *     in [config][google.cloud.speech.v2.BatchRecognizeRequest.config] override the values in the
   *     recognizer for this recognition request. If a mask is provided, only the fields listed in
   *     the mask override the config in the recognizer for this recognition request. If a wildcard
   *     (`&#42;`) is provided, [config][google.cloud.speech.v2.BatchRecognizeRequest.config]
   *     completely overrides and replaces the config in the recognizer for this recognition
   *     request.
   * @param files Audio files with file metadata for ASR.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchRecognizeResponse, OperationMetadata> batchRecognizeAsync(
      String recognizer,
      RecognitionConfig config,
      FieldMask configMask,
      List<BatchRecognizeFileMetadata> files) {
    BatchRecognizeRequest request =
        BatchRecognizeRequest.newBuilder()
            .setRecognizer(recognizer)
            .setConfig(config)
            .setConfigMask(configMask)
            .addAllFiles(files)
            .build();
    return batchRecognizeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs batch asynchronous speech recognition: send a request with N audio files and receive a
   * long running operation that can be polled to see when the transcriptions are finished.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   BatchRecognizeRequest request =
   *       BatchRecognizeRequest.newBuilder()
   *           .setRecognizer(
   *               RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setConfig(RecognitionConfig.newBuilder().build())
   *           .setConfigMask(FieldMask.newBuilder().build())
   *           .addAllFiles(new ArrayList<BatchRecognizeFileMetadata>())
   *           .build();
   *   BatchRecognizeResponse response = speechClient.batchRecognizeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchRecognizeResponse, OperationMetadata> batchRecognizeAsync(
      BatchRecognizeRequest request) {
    return batchRecognizeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs batch asynchronous speech recognition: send a request with N audio files and receive a
   * long running operation that can be polled to see when the transcriptions are finished.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   BatchRecognizeRequest request =
   *       BatchRecognizeRequest.newBuilder()
   *           .setRecognizer(
   *               RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setConfig(RecognitionConfig.newBuilder().build())
   *           .setConfigMask(FieldMask.newBuilder().build())
   *           .addAllFiles(new ArrayList<BatchRecognizeFileMetadata>())
   *           .build();
   *   OperationFuture<BatchRecognizeResponse, OperationMetadata> future =
   *       speechClient.batchRecognizeOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchRecognizeResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BatchRecognizeRequest, BatchRecognizeResponse, OperationMetadata>
      batchRecognizeOperationCallable() {
    return stub.batchRecognizeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs batch asynchronous speech recognition: send a request with N audio files and receive a
   * long running operation that can be polled to see when the transcriptions are finished.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   BatchRecognizeRequest request =
   *       BatchRecognizeRequest.newBuilder()
   *           .setRecognizer(
   *               RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
   *           .setConfig(RecognitionConfig.newBuilder().build())
   *           .setConfigMask(FieldMask.newBuilder().build())
   *           .addAllFiles(new ArrayList<BatchRecognizeFileMetadata>())
   *           .build();
   *   ApiFuture<Operation> future = speechClient.batchRecognizeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchRecognizeRequest, Operation> batchRecognizeCallable() {
    return stub.batchRecognizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Config][google.cloud.speech.v2.Config].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ConfigName name = ConfigName.of("[PROJECT]", "[LOCATION]");
   *   Config response = speechClient.getConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the config to retrieve. There is exactly one config resource
   *     per project per location. The expected format is
   *     `projects/{project}/locations/{location}/config`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(ConfigName name) {
    GetConfigRequest request =
        GetConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Config][google.cloud.speech.v2.Config].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String name = ConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   Config response = speechClient.getConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the config to retrieve. There is exactly one config resource
   *     per project per location. The expected format is
   *     `projects/{project}/locations/{location}/config`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(String name) {
    GetConfigRequest request = GetConfigRequest.newBuilder().setName(name).build();
    return getConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Config][google.cloud.speech.v2.Config].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   GetConfigRequest request =
   *       GetConfigRequest.newBuilder()
   *           .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   Config response = speechClient.getConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(GetConfigRequest request) {
    return getConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Config][google.cloud.speech.v2.Config].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   GetConfigRequest request =
   *       GetConfigRequest.newBuilder()
   *           .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Config> future = speechClient.getConfigCallable().futureCall(request);
   *   // Do something.
   *   Config response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    return stub.getConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Config][google.cloud.speech.v2.Config].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   Config config = Config.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Config response = speechClient.updateConfig(config, updateMask);
   * }
   * }</pre>
   *
   * @param config Required. The config to update.
   *     <p>The config's `name` field is used to identify the config to be updated. The expected
   *     format is `projects/{project}/locations/{location}/config`.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config updateConfig(Config config, FieldMask updateMask) {
    UpdateConfigRequest request =
        UpdateConfigRequest.newBuilder().setConfig(config).setUpdateMask(updateMask).build();
    return updateConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Config][google.cloud.speech.v2.Config].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdateConfigRequest request =
   *       UpdateConfigRequest.newBuilder()
   *           .setConfig(Config.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Config response = speechClient.updateConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config updateConfig(UpdateConfigRequest request) {
    return updateConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Config][google.cloud.speech.v2.Config].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdateConfigRequest request =
   *       UpdateConfigRequest.newBuilder()
   *           .setConfig(Config.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Config> future = speechClient.updateConfigCallable().futureCall(request);
   *   // Do something.
   *   Config response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConfigRequest, Config> updateConfigCallable() {
    return stub.updateConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CustomClass customClass = CustomClass.newBuilder().build();
   *   String customClassId = "customClassId1871032322";
   *   CustomClass response =
   *       speechClient.createCustomClassAsync(parent, customClass, customClassId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location where this CustomClass will be created. The
   *     expected format is `projects/{project}/locations/{location}`.
   * @param customClass Required. The CustomClass to create.
   * @param customClassId The ID to use for the CustomClass, which will become the final component
   *     of the CustomClass's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> createCustomClassAsync(
      LocationName parent, CustomClass customClass, String customClassId) {
    CreateCustomClassRequest request =
        CreateCustomClassRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomClass(customClass)
            .setCustomClassId(customClassId)
            .build();
    return createCustomClassAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CustomClass customClass = CustomClass.newBuilder().build();
   *   String customClassId = "customClassId1871032322";
   *   CustomClass response =
   *       speechClient.createCustomClassAsync(parent, customClass, customClassId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location where this CustomClass will be created. The
   *     expected format is `projects/{project}/locations/{location}`.
   * @param customClass Required. The CustomClass to create.
   * @param customClassId The ID to use for the CustomClass, which will become the final component
   *     of the CustomClass's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> createCustomClassAsync(
      String parent, CustomClass customClass, String customClassId) {
    CreateCustomClassRequest request =
        CreateCustomClassRequest.newBuilder()
            .setParent(parent)
            .setCustomClass(customClass)
            .setCustomClassId(customClassId)
            .build();
    return createCustomClassAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CreateCustomClassRequest request =
   *       CreateCustomClassRequest.newBuilder()
   *           .setCustomClass(CustomClass.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setCustomClassId("customClassId1871032322")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   CustomClass response = speechClient.createCustomClassAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> createCustomClassAsync(
      CreateCustomClassRequest request) {
    return createCustomClassOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CreateCustomClassRequest request =
   *       CreateCustomClassRequest.newBuilder()
   *           .setCustomClass(CustomClass.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setCustomClassId("customClassId1871032322")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   OperationFuture<CustomClass, OperationMetadata> future =
   *       speechClient.createCustomClassOperationCallable().futureCall(request);
   *   // Do something.
   *   CustomClass response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCustomClassRequest, CustomClass, OperationMetadata>
      createCustomClassOperationCallable() {
    return stub.createCustomClassOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CreateCustomClassRequest request =
   *       CreateCustomClassRequest.newBuilder()
   *           .setCustomClass(CustomClass.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setCustomClassId("customClassId1871032322")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Operation> future = speechClient.createCustomClassCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomClassRequest, Operation> createCustomClassCallable() {
    return stub.createCustomClassCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomClasses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CustomClass element : speechClient.listCustomClasses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location of CustomClass resources to list. The expected
   *     format is `projects/{project}/locations/{location}`.
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
   * Lists CustomClasses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CustomClass element : speechClient.listCustomClasses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location of CustomClass resources to list. The expected
   *     format is `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomClassesPagedResponse listCustomClasses(String parent) {
    ListCustomClassesRequest request =
        ListCustomClassesRequest.newBuilder().setParent(parent).build();
    return listCustomClasses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomClasses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ListCustomClassesRequest request =
   *       ListCustomClassesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (CustomClass element : speechClient.listCustomClasses(request).iterateAll()) {
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
   * Lists CustomClasses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ListCustomClassesRequest request =
   *       ListCustomClassesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<CustomClass> future =
   *       speechClient.listCustomClassesPagedCallable().futureCall(request);
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
   * Lists CustomClasses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ListCustomClassesRequest request =
   *       ListCustomClassesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListCustomClassesResponse response = speechClient.listCustomClassesCallable().call(request);
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
   * Returns the requested [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
   *   CustomClass response = speechClient.getCustomClass(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomClass to retrieve. The expected format is
   *     `projects/{project}/locations/{location}/customClasses/{custom_class}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomClass getCustomClass(CustomClassName name) {
    GetCustomClassRequest request =
        GetCustomClassRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCustomClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString();
   *   CustomClass response = speechClient.getCustomClass(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomClass to retrieve. The expected format is
   *     `projects/{project}/locations/{location}/customClasses/{custom_class}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomClass getCustomClass(String name) {
    GetCustomClassRequest request = GetCustomClassRequest.newBuilder().setName(name).build();
    return getCustomClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   GetCustomClassRequest request =
   *       GetCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .build();
   *   CustomClass response = speechClient.getCustomClass(request);
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
   * Returns the requested [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   GetCustomClassRequest request =
   *       GetCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .build();
   *   ApiFuture<CustomClass> future = speechClient.getCustomClassCallable().futureCall(request);
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
   * Updates the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CustomClass customClass = CustomClass.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CustomClass response = speechClient.updateCustomClassAsync(customClass, updateMask).get();
   * }
   * }</pre>
   *
   * @param customClass Required. The CustomClass to update.
   *     <p>The CustomClass's `name` field is used to identify the CustomClass to update. Format:
   *     `projects/{project}/locations/{location}/customClasses/{custom_class}`.
   * @param updateMask The list of fields to be updated. If empty, all fields are considered for
   *     update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> updateCustomClassAsync(
      CustomClass customClass, FieldMask updateMask) {
    UpdateCustomClassRequest request =
        UpdateCustomClassRequest.newBuilder()
            .setCustomClass(customClass)
            .setUpdateMask(updateMask)
            .build();
    return updateCustomClassAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdateCustomClassRequest request =
   *       UpdateCustomClassRequest.newBuilder()
   *           .setCustomClass(CustomClass.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   CustomClass response = speechClient.updateCustomClassAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> updateCustomClassAsync(
      UpdateCustomClassRequest request) {
    return updateCustomClassOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdateCustomClassRequest request =
   *       UpdateCustomClassRequest.newBuilder()
   *           .setCustomClass(CustomClass.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<CustomClass, OperationMetadata> future =
   *       speechClient.updateCustomClassOperationCallable().futureCall(request);
   *   // Do something.
   *   CustomClass response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateCustomClassRequest, CustomClass, OperationMetadata>
      updateCustomClassOperationCallable() {
    return stub.updateCustomClassOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdateCustomClassRequest request =
   *       UpdateCustomClassRequest.newBuilder()
   *           .setCustomClass(CustomClass.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = speechClient.updateCustomClassCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomClassRequest, Operation> updateCustomClassCallable() {
    return stub.updateCustomClassCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
   *   CustomClass response = speechClient.deleteCustomClassAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomClass to delete. Format:
   *     `projects/{project}/locations/{location}/customClasses/{custom_class}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> deleteCustomClassAsync(
      CustomClassName name) {
    DeleteCustomClassRequest request =
        DeleteCustomClassRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCustomClassAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString();
   *   CustomClass response = speechClient.deleteCustomClassAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomClass to delete. Format:
   *     `projects/{project}/locations/{location}/customClasses/{custom_class}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> deleteCustomClassAsync(String name) {
    DeleteCustomClassRequest request = DeleteCustomClassRequest.newBuilder().setName(name).build();
    return deleteCustomClassAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   DeleteCustomClassRequest request =
   *       DeleteCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   CustomClass response = speechClient.deleteCustomClassAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> deleteCustomClassAsync(
      DeleteCustomClassRequest request) {
    return deleteCustomClassOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   DeleteCustomClassRequest request =
   *       DeleteCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<CustomClass, OperationMetadata> future =
   *       speechClient.deleteCustomClassOperationCallable().futureCall(request);
   *   // Do something.
   *   CustomClass response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCustomClassRequest, CustomClass, OperationMetadata>
      deleteCustomClassOperationCallable() {
    return stub.deleteCustomClassOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   DeleteCustomClassRequest request =
   *       DeleteCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = speechClient.deleteCustomClassCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCustomClassRequest, Operation> deleteCustomClassCallable() {
    return stub.deleteCustomClassCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
   *   CustomClass response = speechClient.undeleteCustomClassAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomClass to undelete. Format:
   *     `projects/{project}/locations/{location}/customClasses/{custom_class}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> undeleteCustomClassAsync(
      CustomClassName name) {
    UndeleteCustomClassRequest request =
        UndeleteCustomClassRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeleteCustomClassAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString();
   *   CustomClass response = speechClient.undeleteCustomClassAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomClass to undelete. Format:
   *     `projects/{project}/locations/{location}/customClasses/{custom_class}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> undeleteCustomClassAsync(
      String name) {
    UndeleteCustomClassRequest request =
        UndeleteCustomClassRequest.newBuilder().setName(name).build();
    return undeleteCustomClassAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UndeleteCustomClassRequest request =
   *       UndeleteCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   CustomClass response = speechClient.undeleteCustomClassAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomClass, OperationMetadata> undeleteCustomClassAsync(
      UndeleteCustomClassRequest request) {
    return undeleteCustomClassOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UndeleteCustomClassRequest request =
   *       UndeleteCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<CustomClass, OperationMetadata> future =
   *       speechClient.undeleteCustomClassOperationCallable().futureCall(request);
   *   // Do something.
   *   CustomClass response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeleteCustomClassRequest, CustomClass, OperationMetadata>
      undeleteCustomClassOperationCallable() {
    return stub.undeleteCustomClassOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [CustomClass][google.cloud.speech.v2.CustomClass].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UndeleteCustomClassRequest request =
   *       UndeleteCustomClassRequest.newBuilder()
   *           .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = speechClient.undeleteCustomClassCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteCustomClassRequest, Operation> undeleteCustomClassCallable() {
    return stub.undeleteCustomClassCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PhraseSet phraseSet = PhraseSet.newBuilder().build();
   *   String phraseSetId = "phraseSetId959902180";
   *   PhraseSet response = speechClient.createPhraseSetAsync(parent, phraseSet, phraseSetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location where this PhraseSet will be created. The
   *     expected format is `projects/{project}/locations/{location}`.
   * @param phraseSet Required. The PhraseSet to create.
   * @param phraseSetId The ID to use for the PhraseSet, which will become the final component of
   *     the PhraseSet's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> createPhraseSetAsync(
      LocationName parent, PhraseSet phraseSet, String phraseSetId) {
    CreatePhraseSetRequest request =
        CreatePhraseSetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPhraseSet(phraseSet)
            .setPhraseSetId(phraseSetId)
            .build();
    return createPhraseSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PhraseSet phraseSet = PhraseSet.newBuilder().build();
   *   String phraseSetId = "phraseSetId959902180";
   *   PhraseSet response = speechClient.createPhraseSetAsync(parent, phraseSet, phraseSetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location where this PhraseSet will be created. The
   *     expected format is `projects/{project}/locations/{location}`.
   * @param phraseSet Required. The PhraseSet to create.
   * @param phraseSetId The ID to use for the PhraseSet, which will become the final component of
   *     the PhraseSet's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> createPhraseSetAsync(
      String parent, PhraseSet phraseSet, String phraseSetId) {
    CreatePhraseSetRequest request =
        CreatePhraseSetRequest.newBuilder()
            .setParent(parent)
            .setPhraseSet(phraseSet)
            .setPhraseSetId(phraseSetId)
            .build();
    return createPhraseSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CreatePhraseSetRequest request =
   *       CreatePhraseSetRequest.newBuilder()
   *           .setPhraseSet(PhraseSet.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setPhraseSetId("phraseSetId959902180")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   PhraseSet response = speechClient.createPhraseSetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> createPhraseSetAsync(
      CreatePhraseSetRequest request) {
    return createPhraseSetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CreatePhraseSetRequest request =
   *       CreatePhraseSetRequest.newBuilder()
   *           .setPhraseSet(PhraseSet.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setPhraseSetId("phraseSetId959902180")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   OperationFuture<PhraseSet, OperationMetadata> future =
   *       speechClient.createPhraseSetOperationCallable().futureCall(request);
   *   // Do something.
   *   PhraseSet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePhraseSetRequest, PhraseSet, OperationMetadata>
      createPhraseSetOperationCallable() {
    return stub.createPhraseSetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   CreatePhraseSetRequest request =
   *       CreatePhraseSetRequest.newBuilder()
   *           .setPhraseSet(PhraseSet.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setPhraseSetId("phraseSetId959902180")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Operation> future = speechClient.createPhraseSetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePhraseSetRequest, Operation> createPhraseSetCallable() {
    return stub.createPhraseSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PhraseSets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PhraseSet element : speechClient.listPhraseSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location of PhraseSet resources to list. The expected
   *     format is `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseSetsPagedResponse listPhraseSets(LocationName parent) {
    ListPhraseSetsRequest request =
        ListPhraseSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPhraseSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PhraseSets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PhraseSet element : speechClient.listPhraseSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location of PhraseSet resources to list. The expected
   *     format is `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseSetsPagedResponse listPhraseSets(String parent) {
    ListPhraseSetsRequest request = ListPhraseSetsRequest.newBuilder().setParent(parent).build();
    return listPhraseSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PhraseSets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ListPhraseSetsRequest request =
   *       ListPhraseSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (PhraseSet element : speechClient.listPhraseSets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseSetsPagedResponse listPhraseSets(ListPhraseSetsRequest request) {
    return listPhraseSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PhraseSets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ListPhraseSetsRequest request =
   *       ListPhraseSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<PhraseSet> future = speechClient.listPhraseSetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PhraseSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPhraseSetsRequest, ListPhraseSetsPagedResponse>
      listPhraseSetsPagedCallable() {
    return stub.listPhraseSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PhraseSets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ListPhraseSetsRequest request =
   *       ListPhraseSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListPhraseSetsResponse response = speechClient.listPhraseSetsCallable().call(request);
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
  public final UnaryCallable<ListPhraseSetsRequest, ListPhraseSetsResponse>
      listPhraseSetsCallable() {
    return stub.listPhraseSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
   *   PhraseSet response = speechClient.getPhraseSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PhraseSet to retrieve. The expected format is
   *     `projects/{project}/locations/{location}/phraseSets/{phrase_set}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseSet getPhraseSet(PhraseSetName name) {
    GetPhraseSetRequest request =
        GetPhraseSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString();
   *   PhraseSet response = speechClient.getPhraseSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PhraseSet to retrieve. The expected format is
   *     `projects/{project}/locations/{location}/phraseSets/{phrase_set}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseSet getPhraseSet(String name) {
    GetPhraseSetRequest request = GetPhraseSetRequest.newBuilder().setName(name).build();
    return getPhraseSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   GetPhraseSetRequest request =
   *       GetPhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .build();
   *   PhraseSet response = speechClient.getPhraseSet(request);
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
   * Returns the requested [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   GetPhraseSetRequest request =
   *       GetPhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .build();
   *   ApiFuture<PhraseSet> future = speechClient.getPhraseSetCallable().futureCall(request);
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
   * Updates the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   PhraseSet phraseSet = PhraseSet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PhraseSet response = speechClient.updatePhraseSetAsync(phraseSet, updateMask).get();
   * }
   * }</pre>
   *
   * @param phraseSet Required. The PhraseSet to update.
   *     <p>The PhraseSet's `name` field is used to identify the PhraseSet to update. Format:
   *     `projects/{project}/locations/{location}/phraseSets/{phrase_set}`.
   * @param updateMask The list of fields to update. If empty, all non-default valued fields are
   *     considered for update. Use `&#42;` to update the entire PhraseSet resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> updatePhraseSetAsync(
      PhraseSet phraseSet, FieldMask updateMask) {
    UpdatePhraseSetRequest request =
        UpdatePhraseSetRequest.newBuilder()
            .setPhraseSet(phraseSet)
            .setUpdateMask(updateMask)
            .build();
    return updatePhraseSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdatePhraseSetRequest request =
   *       UpdatePhraseSetRequest.newBuilder()
   *           .setPhraseSet(PhraseSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   PhraseSet response = speechClient.updatePhraseSetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> updatePhraseSetAsync(
      UpdatePhraseSetRequest request) {
    return updatePhraseSetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdatePhraseSetRequest request =
   *       UpdatePhraseSetRequest.newBuilder()
   *           .setPhraseSet(PhraseSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<PhraseSet, OperationMetadata> future =
   *       speechClient.updatePhraseSetOperationCallable().futureCall(request);
   *   // Do something.
   *   PhraseSet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePhraseSetRequest, PhraseSet, OperationMetadata>
      updatePhraseSetOperationCallable() {
    return stub.updatePhraseSetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UpdatePhraseSetRequest request =
   *       UpdatePhraseSetRequest.newBuilder()
   *           .setPhraseSet(PhraseSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = speechClient.updatePhraseSetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePhraseSetRequest, Operation> updatePhraseSetCallable() {
    return stub.updatePhraseSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
   *   PhraseSet response = speechClient.deletePhraseSetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the PhraseSet to delete. Format:
   *     `projects/{project}/locations/{location}/phraseSets/{phrase_set}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> deletePhraseSetAsync(
      PhraseSetName name) {
    DeletePhraseSetRequest request =
        DeletePhraseSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deletePhraseSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString();
   *   PhraseSet response = speechClient.deletePhraseSetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the PhraseSet to delete. Format:
   *     `projects/{project}/locations/{location}/phraseSets/{phrase_set}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> deletePhraseSetAsync(String name) {
    DeletePhraseSetRequest request = DeletePhraseSetRequest.newBuilder().setName(name).build();
    return deletePhraseSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   DeletePhraseSetRequest request =
   *       DeletePhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   PhraseSet response = speechClient.deletePhraseSetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> deletePhraseSetAsync(
      DeletePhraseSetRequest request) {
    return deletePhraseSetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   DeletePhraseSetRequest request =
   *       DeletePhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<PhraseSet, OperationMetadata> future =
   *       speechClient.deletePhraseSetOperationCallable().futureCall(request);
   *   // Do something.
   *   PhraseSet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePhraseSetRequest, PhraseSet, OperationMetadata>
      deletePhraseSetOperationCallable() {
    return stub.deletePhraseSetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   DeletePhraseSetRequest request =
   *       DeletePhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = speechClient.deletePhraseSetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePhraseSetRequest, Operation> deletePhraseSetCallable() {
    return stub.deletePhraseSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
   *   PhraseSet response = speechClient.undeletePhraseSetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the PhraseSet to undelete. Format:
   *     `projects/{project}/locations/{location}/phraseSets/{phrase_set}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> undeletePhraseSetAsync(
      PhraseSetName name) {
    UndeletePhraseSetRequest request =
        UndeletePhraseSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeletePhraseSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   String name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString();
   *   PhraseSet response = speechClient.undeletePhraseSetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the PhraseSet to undelete. Format:
   *     `projects/{project}/locations/{location}/phraseSets/{phrase_set}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> undeletePhraseSetAsync(String name) {
    UndeletePhraseSetRequest request = UndeletePhraseSetRequest.newBuilder().setName(name).build();
    return undeletePhraseSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UndeletePhraseSetRequest request =
   *       UndeletePhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   PhraseSet response = speechClient.undeletePhraseSetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PhraseSet, OperationMetadata> undeletePhraseSetAsync(
      UndeletePhraseSetRequest request) {
    return undeletePhraseSetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UndeletePhraseSetRequest request =
   *       UndeletePhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<PhraseSet, OperationMetadata> future =
   *       speechClient.undeletePhraseSetOperationCallable().futureCall(request);
   *   // Do something.
   *   PhraseSet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeletePhraseSetRequest, PhraseSet, OperationMetadata>
      undeletePhraseSetOperationCallable() {
    return stub.undeletePhraseSetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   UndeletePhraseSetRequest request =
   *       UndeletePhraseSetRequest.newBuilder()
   *           .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = speechClient.undeletePhraseSetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeletePhraseSetRequest, Operation> undeletePhraseSetCallable() {
    return stub.undeletePhraseSetCallable();
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

  public static class ListRecognizersPagedResponse
      extends AbstractPagedListResponse<
          ListRecognizersRequest,
          ListRecognizersResponse,
          Recognizer,
          ListRecognizersPage,
          ListRecognizersFixedSizeCollection> {

    public static ApiFuture<ListRecognizersPagedResponse> createAsync(
        PageContext<ListRecognizersRequest, ListRecognizersResponse, Recognizer> context,
        ApiFuture<ListRecognizersResponse> futureResponse) {
      ApiFuture<ListRecognizersPage> futurePage =
          ListRecognizersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRecognizersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRecognizersPagedResponse(ListRecognizersPage page) {
      super(page, ListRecognizersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRecognizersPage
      extends AbstractPage<
          ListRecognizersRequest, ListRecognizersResponse, Recognizer, ListRecognizersPage> {

    private ListRecognizersPage(
        PageContext<ListRecognizersRequest, ListRecognizersResponse, Recognizer> context,
        ListRecognizersResponse response) {
      super(context, response);
    }

    private static ListRecognizersPage createEmptyPage() {
      return new ListRecognizersPage(null, null);
    }

    @Override
    protected ListRecognizersPage createPage(
        PageContext<ListRecognizersRequest, ListRecognizersResponse, Recognizer> context,
        ListRecognizersResponse response) {
      return new ListRecognizersPage(context, response);
    }

    @Override
    public ApiFuture<ListRecognizersPage> createPageAsync(
        PageContext<ListRecognizersRequest, ListRecognizersResponse, Recognizer> context,
        ApiFuture<ListRecognizersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRecognizersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRecognizersRequest,
          ListRecognizersResponse,
          Recognizer,
          ListRecognizersPage,
          ListRecognizersFixedSizeCollection> {

    private ListRecognizersFixedSizeCollection(
        List<ListRecognizersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRecognizersFixedSizeCollection createEmptyCollection() {
      return new ListRecognizersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRecognizersFixedSizeCollection createCollection(
        List<ListRecognizersPage> pages, int collectionSize) {
      return new ListRecognizersFixedSizeCollection(pages, collectionSize);
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

  public static class ListPhraseSetsPagedResponse
      extends AbstractPagedListResponse<
          ListPhraseSetsRequest,
          ListPhraseSetsResponse,
          PhraseSet,
          ListPhraseSetsPage,
          ListPhraseSetsFixedSizeCollection> {

    public static ApiFuture<ListPhraseSetsPagedResponse> createAsync(
        PageContext<ListPhraseSetsRequest, ListPhraseSetsResponse, PhraseSet> context,
        ApiFuture<ListPhraseSetsResponse> futureResponse) {
      ApiFuture<ListPhraseSetsPage> futurePage =
          ListPhraseSetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPhraseSetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPhraseSetsPagedResponse(ListPhraseSetsPage page) {
      super(page, ListPhraseSetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPhraseSetsPage
      extends AbstractPage<
          ListPhraseSetsRequest, ListPhraseSetsResponse, PhraseSet, ListPhraseSetsPage> {

    private ListPhraseSetsPage(
        PageContext<ListPhraseSetsRequest, ListPhraseSetsResponse, PhraseSet> context,
        ListPhraseSetsResponse response) {
      super(context, response);
    }

    private static ListPhraseSetsPage createEmptyPage() {
      return new ListPhraseSetsPage(null, null);
    }

    @Override
    protected ListPhraseSetsPage createPage(
        PageContext<ListPhraseSetsRequest, ListPhraseSetsResponse, PhraseSet> context,
        ListPhraseSetsResponse response) {
      return new ListPhraseSetsPage(context, response);
    }

    @Override
    public ApiFuture<ListPhraseSetsPage> createPageAsync(
        PageContext<ListPhraseSetsRequest, ListPhraseSetsResponse, PhraseSet> context,
        ApiFuture<ListPhraseSetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPhraseSetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPhraseSetsRequest,
          ListPhraseSetsResponse,
          PhraseSet,
          ListPhraseSetsPage,
          ListPhraseSetsFixedSizeCollection> {

    private ListPhraseSetsFixedSizeCollection(List<ListPhraseSetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPhraseSetsFixedSizeCollection createEmptyCollection() {
      return new ListPhraseSetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPhraseSetsFixedSizeCollection createCollection(
        List<ListPhraseSetsPage> pages, int collectionSize) {
      return new ListPhraseSetsFixedSizeCollection(pages, collectionSize);
    }
  }
}
