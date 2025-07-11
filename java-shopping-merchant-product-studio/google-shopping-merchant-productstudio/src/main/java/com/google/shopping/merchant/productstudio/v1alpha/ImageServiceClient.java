/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.productstudio.v1alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.productstudio.v1alpha.stub.ImageServiceStub;
import com.google.shopping.merchant.productstudio.v1alpha.stub.ImageServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service that exposes Generative AI (GenAI) endpoints for creating and
 * enhancing product image content.
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
 * try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
 *   String name = "name3373707";
 *   GenerateProductImageBackgroundResponse response =
 *       imageServiceClient.generateProductImageBackground(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ImageServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateProductImageBackground</td>
 *      <td><p> GenerateProductImageBackground generates a new image where the background of the original image is replaced by an AI generated scene based on provided product information and a text prompt.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateProductImageBackground(GenerateProductImageBackgroundRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateProductImageBackground(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateProductImageBackgroundCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveProductImageBackground</td>
 *      <td><p> RemoveProductImageBackground generates a new image where the background of the original image is removed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeProductImageBackground(RemoveProductImageBackgroundRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> removeProductImageBackground(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeProductImageBackgroundCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpscaleProductImage</td>
 *      <td><p> UpscaleProductImage generates a new image where the resolution of the original image is enhanced.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> upscaleProductImage(UpscaleProductImageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> upscaleProductImage(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> upscaleProductImageCallable()
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
 * <p>This class can be customized by passing in a custom instance of ImageServiceSettings to
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
 * ImageServiceSettings imageServiceSettings =
 *     ImageServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ImageServiceClient imageServiceClient = ImageServiceClient.create(imageServiceSettings);
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
 * ImageServiceSettings imageServiceSettings =
 *     ImageServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ImageServiceClient imageServiceClient = ImageServiceClient.create(imageServiceSettings);
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
 * ImageServiceSettings imageServiceSettings = ImageServiceSettings.newHttpJsonBuilder().build();
 * ImageServiceClient imageServiceClient = ImageServiceClient.create(imageServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ImageServiceClient implements BackgroundResource {
  private final ImageServiceSettings settings;
  private final ImageServiceStub stub;

  /** Constructs an instance of ImageServiceClient with default settings. */
  public static final ImageServiceClient create() throws IOException {
    return create(ImageServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ImageServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ImageServiceClient create(ImageServiceSettings settings) throws IOException {
    return new ImageServiceClient(settings);
  }

  /**
   * Constructs an instance of ImageServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ImageServiceSettings).
   */
  public static final ImageServiceClient create(ImageServiceStub stub) {
    return new ImageServiceClient(stub);
  }

  /**
   * Constructs an instance of ImageServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ImageServiceClient(ImageServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ImageServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ImageServiceClient(ImageServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ImageServiceSettings getSettings() {
    return settings;
  }

  public ImageServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GenerateProductImageBackground generates a new image where the background of the original image
   * is replaced by an AI generated scene based on provided product information and a text prompt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
   *   String name = "name3373707";
   *   GenerateProductImageBackgroundResponse response =
   *       imageServiceClient.generateProductImageBackground(name);
   * }
   * }</pre>
   *
   * @param name Required. The account for which to generate an image. This acts as a container for
   *     the request and does not affect the generation itself. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateProductImageBackgroundResponse generateProductImageBackground(String name) {
    GenerateProductImageBackgroundRequest request =
        GenerateProductImageBackgroundRequest.newBuilder().setName(name).build();
    return generateProductImageBackground(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GenerateProductImageBackground generates a new image where the background of the original image
   * is replaced by an AI generated scene based on provided product information and a text prompt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
   *   GenerateProductImageBackgroundRequest request =
   *       GenerateProductImageBackgroundRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOutputConfig(OutputImageConfig.newBuilder().build())
   *           .setInputImage(InputImage.newBuilder().build())
   *           .setConfig(GenerateImageBackgroundConfig.newBuilder().build())
   *           .build();
   *   GenerateProductImageBackgroundResponse response =
   *       imageServiceClient.generateProductImageBackground(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateProductImageBackgroundResponse generateProductImageBackground(
      GenerateProductImageBackgroundRequest request) {
    return generateProductImageBackgroundCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GenerateProductImageBackground generates a new image where the background of the original image
   * is replaced by an AI generated scene based on provided product information and a text prompt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
   *   GenerateProductImageBackgroundRequest request =
   *       GenerateProductImageBackgroundRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOutputConfig(OutputImageConfig.newBuilder().build())
   *           .setInputImage(InputImage.newBuilder().build())
   *           .setConfig(GenerateImageBackgroundConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerateProductImageBackgroundResponse> future =
   *       imageServiceClient.generateProductImageBackgroundCallable().futureCall(request);
   *   // Do something.
   *   GenerateProductImageBackgroundResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
      generateProductImageBackgroundCallable() {
    return stub.generateProductImageBackgroundCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RemoveProductImageBackground generates a new image where the background of the original image
   * is removed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
   *   String name = "name3373707";
   *   RemoveProductImageBackgroundResponse response =
   *       imageServiceClient.removeProductImageBackground(name);
   * }
   * }</pre>
   *
   * @param name Required. The account for which to generate an image. This acts as a container for
   *     the request and does not affect the generation itself. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveProductImageBackgroundResponse removeProductImageBackground(String name) {
    RemoveProductImageBackgroundRequest request =
        RemoveProductImageBackgroundRequest.newBuilder().setName(name).build();
    return removeProductImageBackground(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RemoveProductImageBackground generates a new image where the background of the original image
   * is removed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
   *   RemoveProductImageBackgroundRequest request =
   *       RemoveProductImageBackgroundRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOutputConfig(OutputImageConfig.newBuilder().build())
   *           .setInputImage(InputImage.newBuilder().build())
   *           .setConfig(RemoveImageBackgroundConfig.newBuilder().build())
   *           .build();
   *   RemoveProductImageBackgroundResponse response =
   *       imageServiceClient.removeProductImageBackground(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveProductImageBackgroundResponse removeProductImageBackground(
      RemoveProductImageBackgroundRequest request) {
    return removeProductImageBackgroundCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RemoveProductImageBackground generates a new image where the background of the original image
   * is removed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
   *   RemoveProductImageBackgroundRequest request =
   *       RemoveProductImageBackgroundRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOutputConfig(OutputImageConfig.newBuilder().build())
   *           .setInputImage(InputImage.newBuilder().build())
   *           .setConfig(RemoveImageBackgroundConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<RemoveProductImageBackgroundResponse> future =
   *       imageServiceClient.removeProductImageBackgroundCallable().futureCall(request);
   *   // Do something.
   *   RemoveProductImageBackgroundResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
      removeProductImageBackgroundCallable() {
    return stub.removeProductImageBackgroundCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * UpscaleProductImage generates a new image where the resolution of the original image is
   * enhanced.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
   *   String name = "name3373707";
   *   UpscaleProductImageResponse response = imageServiceClient.upscaleProductImage(name);
   * }
   * }</pre>
   *
   * @param name Required. The account for which to generate an image. This acts as a container for
   *     the request and does not affect the generation itself. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UpscaleProductImageResponse upscaleProductImage(String name) {
    UpscaleProductImageRequest request =
        UpscaleProductImageRequest.newBuilder().setName(name).build();
    return upscaleProductImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * UpscaleProductImage generates a new image where the resolution of the original image is
   * enhanced.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
   *   UpscaleProductImageRequest request =
   *       UpscaleProductImageRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOutputConfig(OutputImageConfig.newBuilder().build())
   *           .setInputImage(InputImage.newBuilder().build())
   *           .build();
   *   UpscaleProductImageResponse response = imageServiceClient.upscaleProductImage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UpscaleProductImageResponse upscaleProductImage(UpscaleProductImageRequest request) {
    return upscaleProductImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * UpscaleProductImage generates a new image where the resolution of the original image is
   * enhanced.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
   *   UpscaleProductImageRequest request =
   *       UpscaleProductImageRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOutputConfig(OutputImageConfig.newBuilder().build())
   *           .setInputImage(InputImage.newBuilder().build())
   *           .build();
   *   ApiFuture<UpscaleProductImageResponse> future =
   *       imageServiceClient.upscaleProductImageCallable().futureCall(request);
   *   // Do something.
   *   UpscaleProductImageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpscaleProductImageRequest, UpscaleProductImageResponse>
      upscaleProductImageCallable() {
    return stub.upscaleProductImageCallable();
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
