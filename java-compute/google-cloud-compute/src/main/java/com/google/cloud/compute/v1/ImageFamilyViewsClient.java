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

package com.google.cloud.compute.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.ImageFamilyViewsStub;
import com.google.cloud.compute.v1.stub.ImageFamilyViewsStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The ImageFamilyViews API.
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
 * try (ImageFamilyViewsClient imageFamilyViewsClient = ImageFamilyViewsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String family = "family-1281860764";
 *   ImageFamilyView response = imageFamilyViewsClient.get(project, zone, family);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ImageFamilyViewsClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ImageFamilyViewsSettings to
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
 * ImageFamilyViewsSettings imageFamilyViewsSettings =
 *     ImageFamilyViewsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ImageFamilyViewsClient imageFamilyViewsClient =
 *     ImageFamilyViewsClient.create(imageFamilyViewsSettings);
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
 * ImageFamilyViewsSettings imageFamilyViewsSettings =
 *     ImageFamilyViewsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ImageFamilyViewsClient imageFamilyViewsClient =
 *     ImageFamilyViewsClient.create(imageFamilyViewsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ImageFamilyViewsClient implements BackgroundResource {
  private final ImageFamilyViewsSettings settings;
  private final ImageFamilyViewsStub stub;

  /** Constructs an instance of ImageFamilyViewsClient with default settings. */
  public static final ImageFamilyViewsClient create() throws IOException {
    return create(ImageFamilyViewsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ImageFamilyViewsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ImageFamilyViewsClient create(ImageFamilyViewsSettings settings)
      throws IOException {
    return new ImageFamilyViewsClient(settings);
  }

  /**
   * Constructs an instance of ImageFamilyViewsClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ImageFamilyViewsSettings).
   */
  public static final ImageFamilyViewsClient create(ImageFamilyViewsStub stub) {
    return new ImageFamilyViewsClient(stub);
  }

  /**
   * Constructs an instance of ImageFamilyViewsClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ImageFamilyViewsClient(ImageFamilyViewsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ImageFamilyViewsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ImageFamilyViewsClient(ImageFamilyViewsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ImageFamilyViewsSettings getSettings() {
    return settings;
  }

  public ImageFamilyViewsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the latest image that is part of an image family, is not deprecated and is rolled out
   * in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageFamilyViewsClient imageFamilyViewsClient = ImageFamilyViewsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String family = "family-1281860764";
   *   ImageFamilyView response = imageFamilyViewsClient.get(project, zone, family);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param family Name of the image family to search for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImageFamilyView get(String project, String zone, String family) {
    GetImageFamilyViewRequest request =
        GetImageFamilyViewRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setFamily(family)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the latest image that is part of an image family, is not deprecated and is rolled out
   * in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageFamilyViewsClient imageFamilyViewsClient = ImageFamilyViewsClient.create()) {
   *   GetImageFamilyViewRequest request =
   *       GetImageFamilyViewRequest.newBuilder()
   *           .setFamily("family-1281860764")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ImageFamilyView response = imageFamilyViewsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImageFamilyView get(GetImageFamilyViewRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the latest image that is part of an image family, is not deprecated and is rolled out
   * in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageFamilyViewsClient imageFamilyViewsClient = ImageFamilyViewsClient.create()) {
   *   GetImageFamilyViewRequest request =
   *       GetImageFamilyViewRequest.newBuilder()
   *           .setFamily("family-1281860764")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<ImageFamilyView> future = imageFamilyViewsClient.getCallable().futureCall(request);
   *   // Do something.
   *   ImageFamilyView response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetImageFamilyViewRequest, ImageFamilyView> getCallable() {
    return stub.getCallable();
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
