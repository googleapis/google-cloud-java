/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.v2;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.stub.FulfillmentsStub;
import com.google.cloud.dialogflow.v2.stub.FulfillmentsStubSettings;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [Fulfillments][google.cloud.dialogflow.v2.Fulfillment].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (FulfillmentsClient fulfillmentsClient = FulfillmentsClient.create()) {
 *   FulfillmentName name = FulfillmentName.ofProjectName("[PROJECT]");
 *   Fulfillment response = fulfillmentsClient.getFulfillment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FulfillmentsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of FulfillmentsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * FulfillmentsSettings fulfillmentsSettings =
 *     FulfillmentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FulfillmentsClient fulfillmentsClient = FulfillmentsClient.create(fulfillmentsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * FulfillmentsSettings fulfillmentsSettings =
 *     FulfillmentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FulfillmentsClient fulfillmentsClient = FulfillmentsClient.create(fulfillmentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FulfillmentsClient implements BackgroundResource {
  private final FulfillmentsSettings settings;
  private final FulfillmentsStub stub;

  /** Constructs an instance of FulfillmentsClient with default settings. */
  public static final FulfillmentsClient create() throws IOException {
    return create(FulfillmentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FulfillmentsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FulfillmentsClient create(FulfillmentsSettings settings) throws IOException {
    return new FulfillmentsClient(settings);
  }

  /**
   * Constructs an instance of FulfillmentsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(FulfillmentsSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final FulfillmentsClient create(FulfillmentsStub stub) {
    return new FulfillmentsClient(stub);
  }

  /**
   * Constructs an instance of FulfillmentsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected FulfillmentsClient(FulfillmentsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FulfillmentsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected FulfillmentsClient(FulfillmentsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FulfillmentsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FulfillmentsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the fulfillment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FulfillmentsClient fulfillmentsClient = FulfillmentsClient.create()) {
   *   FulfillmentName name = FulfillmentName.ofProjectName("[PROJECT]");
   *   Fulfillment response = fulfillmentsClient.getFulfillment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the fulfillment. Format: `projects/&lt;Project
   *     ID&gt;/agent/fulfillment`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Fulfillment getFulfillment(FulfillmentName name) {
    GetFulfillmentRequest request =
        GetFulfillmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFulfillment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the fulfillment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FulfillmentsClient fulfillmentsClient = FulfillmentsClient.create()) {
   *   String name = FulfillmentName.ofProjectName("[PROJECT]").toString();
   *   Fulfillment response = fulfillmentsClient.getFulfillment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the fulfillment. Format: `projects/&lt;Project
   *     ID&gt;/agent/fulfillment`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Fulfillment getFulfillment(String name) {
    GetFulfillmentRequest request = GetFulfillmentRequest.newBuilder().setName(name).build();
    return getFulfillment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the fulfillment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FulfillmentsClient fulfillmentsClient = FulfillmentsClient.create()) {
   *   GetFulfillmentRequest request =
   *       GetFulfillmentRequest.newBuilder()
   *           .setName(FulfillmentName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   Fulfillment response = fulfillmentsClient.getFulfillment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Fulfillment getFulfillment(GetFulfillmentRequest request) {
    return getFulfillmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the fulfillment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FulfillmentsClient fulfillmentsClient = FulfillmentsClient.create()) {
   *   GetFulfillmentRequest request =
   *       GetFulfillmentRequest.newBuilder()
   *           .setName(FulfillmentName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Fulfillment> future =
   *       fulfillmentsClient.getFulfillmentCallable().futureCall(request);
   *   // Do something.
   *   Fulfillment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFulfillmentRequest, Fulfillment> getFulfillmentCallable() {
    return stub.getFulfillmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the fulfillment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FulfillmentsClient fulfillmentsClient = FulfillmentsClient.create()) {
   *   Fulfillment fulfillment = Fulfillment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Fulfillment response = fulfillmentsClient.updateFulfillment(fulfillment, updateMask);
   * }
   * }</pre>
   *
   * @param fulfillment Required. The fulfillment to update.
   * @param updateMask Required. The mask to control which fields get updated. If the mask is not
   *     present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Fulfillment updateFulfillment(Fulfillment fulfillment, FieldMask updateMask) {
    UpdateFulfillmentRequest request =
        UpdateFulfillmentRequest.newBuilder()
            .setFulfillment(fulfillment)
            .setUpdateMask(updateMask)
            .build();
    return updateFulfillment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the fulfillment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FulfillmentsClient fulfillmentsClient = FulfillmentsClient.create()) {
   *   UpdateFulfillmentRequest request =
   *       UpdateFulfillmentRequest.newBuilder()
   *           .setFulfillment(Fulfillment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Fulfillment response = fulfillmentsClient.updateFulfillment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Fulfillment updateFulfillment(UpdateFulfillmentRequest request) {
    return updateFulfillmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the fulfillment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FulfillmentsClient fulfillmentsClient = FulfillmentsClient.create()) {
   *   UpdateFulfillmentRequest request =
   *       UpdateFulfillmentRequest.newBuilder()
   *           .setFulfillment(Fulfillment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Fulfillment> future =
   *       fulfillmentsClient.updateFulfillmentCallable().futureCall(request);
   *   // Do something.
   *   Fulfillment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFulfillmentRequest, Fulfillment> updateFulfillmentCallable() {
    return stub.updateFulfillmentCallable();
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
}
