/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.ImageStub;
import com.google.cloud.compute.v1.stub.ImageStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ImageClient imageClient = ImageClient.create()) {
 *   ProjectGlobalImageName image = ProjectGlobalImageName.of("[PROJECT]", "[IMAGE]");
 *   Operation response = imageClient.deleteImage(image);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the imageClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of ImageSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ImageSettings imageSettings =
 *     ImageSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ImageClient imageClient =
 *     ImageClient.create(imageSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ImageSettings imageSettings =
 *     ImageSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ImageClient imageClient =
 *     ImageClient.create(imageSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ImageClient implements BackgroundResource {
  private final ImageSettings settings;
  private final ImageStub stub;

  /** Constructs an instance of ImageClient with default settings. */
  public static final ImageClient create() throws IOException {
    return create(ImageSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ImageClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ImageClient create(ImageSettings settings) throws IOException {
    return new ImageClient(settings);
  }

  /**
   * Constructs an instance of ImageClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use ImageSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ImageClient create(ImageStub stub) {
    return new ImageClient(stub);
  }

  /**
   * Constructs an instance of ImageClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ImageClient(ImageSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ImageStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ImageClient(ImageStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ImageSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ImageStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified image.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageName image = ProjectGlobalImageName.of("[PROJECT]", "[IMAGE]");
   *   Operation response = imageClient.deleteImage(image);
   * }
   * </code></pre>
   *
   * @param image Name of the image resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteImage(ProjectGlobalImageName image) {

    DeleteImageHttpRequest request =
        DeleteImageHttpRequest.newBuilder()
            .setImage(image == null ? null : image.toString())
            .build();
    return deleteImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified image.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageName image = ProjectGlobalImageName.of("[PROJECT]", "[IMAGE]");
   *   Operation response = imageClient.deleteImage(image.toString());
   * }
   * </code></pre>
   *
   * @param image Name of the image resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteImage(String image) {

    DeleteImageHttpRequest request = DeleteImageHttpRequest.newBuilder().setImage(image).build();
    return deleteImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified image.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedImage = ProjectGlobalImageName.format("[PROJECT]", "[IMAGE]");
   *   DeleteImageHttpRequest request = DeleteImageHttpRequest.newBuilder()
   *     .setImage(formattedImage)
   *     .build();
   *   Operation response = imageClient.deleteImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteImage(DeleteImageHttpRequest request) {
    return deleteImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified image.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedImage = ProjectGlobalImageName.format("[PROJECT]", "[IMAGE]");
   *   DeleteImageHttpRequest request = DeleteImageHttpRequest.newBuilder()
   *     .setImage(formattedImage)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = imageClient.deleteImageCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteImageHttpRequest, Operation> deleteImageCallable() {
    return stub.deleteImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the deprecation status of an image.
   *
   * <p>If an empty request body is given, clears the deprecation status instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageName image = ProjectGlobalImageName.of("[PROJECT]", "[IMAGE]");
   *   DeprecationStatus deprecationStatusResource = DeprecationStatus.newBuilder().build();
   *   Operation response = imageClient.deprecateImage(image, deprecationStatusResource);
   * }
   * </code></pre>
   *
   * @param image Image name.
   * @param deprecationStatusResource Deprecation status for a public resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deprecateImage(
      ProjectGlobalImageName image, DeprecationStatus deprecationStatusResource) {

    DeprecateImageHttpRequest request =
        DeprecateImageHttpRequest.newBuilder()
            .setImage(image == null ? null : image.toString())
            .setDeprecationStatusResource(deprecationStatusResource)
            .build();
    return deprecateImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the deprecation status of an image.
   *
   * <p>If an empty request body is given, clears the deprecation status instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageName image = ProjectGlobalImageName.of("[PROJECT]", "[IMAGE]");
   *   DeprecationStatus deprecationStatusResource = DeprecationStatus.newBuilder().build();
   *   Operation response = imageClient.deprecateImage(image.toString(), deprecationStatusResource);
   * }
   * </code></pre>
   *
   * @param image Image name.
   * @param deprecationStatusResource Deprecation status for a public resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deprecateImage(String image, DeprecationStatus deprecationStatusResource) {

    DeprecateImageHttpRequest request =
        DeprecateImageHttpRequest.newBuilder()
            .setImage(image)
            .setDeprecationStatusResource(deprecationStatusResource)
            .build();
    return deprecateImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the deprecation status of an image.
   *
   * <p>If an empty request body is given, clears the deprecation status instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedImage = ProjectGlobalImageName.format("[PROJECT]", "[IMAGE]");
   *   DeprecationStatus deprecationStatusResource = DeprecationStatus.newBuilder().build();
   *   DeprecateImageHttpRequest request = DeprecateImageHttpRequest.newBuilder()
   *     .setImage(formattedImage)
   *     .setDeprecationStatusResource(deprecationStatusResource)
   *     .build();
   *   Operation response = imageClient.deprecateImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deprecateImage(DeprecateImageHttpRequest request) {
    return deprecateImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the deprecation status of an image.
   *
   * <p>If an empty request body is given, clears the deprecation status instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedImage = ProjectGlobalImageName.format("[PROJECT]", "[IMAGE]");
   *   DeprecationStatus deprecationStatusResource = DeprecationStatus.newBuilder().build();
   *   DeprecateImageHttpRequest request = DeprecateImageHttpRequest.newBuilder()
   *     .setImage(formattedImage)
   *     .setDeprecationStatusResource(deprecationStatusResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = imageClient.deprecateImageCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeprecateImageHttpRequest, Operation> deprecateImageCallable() {
    return stub.deprecateImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified image. Gets a list of available images by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageName image = ProjectGlobalImageName.of("[PROJECT]", "[IMAGE]");
   *   Image response = imageClient.getImage(image);
   * }
   * </code></pre>
   *
   * @param image Name of the image resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Image getImage(ProjectGlobalImageName image) {

    GetImageHttpRequest request =
        GetImageHttpRequest.newBuilder().setImage(image == null ? null : image.toString()).build();
    return getImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified image. Gets a list of available images by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageName image = ProjectGlobalImageName.of("[PROJECT]", "[IMAGE]");
   *   Image response = imageClient.getImage(image.toString());
   * }
   * </code></pre>
   *
   * @param image Name of the image resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Image getImage(String image) {

    GetImageHttpRequest request = GetImageHttpRequest.newBuilder().setImage(image).build();
    return getImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified image. Gets a list of available images by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedImage = ProjectGlobalImageName.format("[PROJECT]", "[IMAGE]");
   *   GetImageHttpRequest request = GetImageHttpRequest.newBuilder()
   *     .setImage(formattedImage)
   *     .build();
   *   Image response = imageClient.getImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Image getImage(GetImageHttpRequest request) {
    return getImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified image. Gets a list of available images by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedImage = ProjectGlobalImageName.format("[PROJECT]", "[IMAGE]");
   *   GetImageHttpRequest request = GetImageHttpRequest.newBuilder()
   *     .setImage(formattedImage)
   *     .build();
   *   ApiFuture&lt;Image&gt; future = imageClient.getImageCallable().futureCall(request);
   *   // Do something
   *   Image response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetImageHttpRequest, Image> getImageCallable() {
    return stub.getImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the latest image that is part of an image family and is not deprecated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageFamilyName family = ProjectGlobalImageFamilyName.of("[PROJECT]", "[FAMILY]");
   *   Image response = imageClient.getFromFamilyImage(family);
   * }
   * </code></pre>
   *
   * @param family Name of the image family to search for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Image getFromFamilyImage(ProjectGlobalImageFamilyName family) {

    GetFromFamilyImageHttpRequest request =
        GetFromFamilyImageHttpRequest.newBuilder()
            .setFamily(family == null ? null : family.toString())
            .build();
    return getFromFamilyImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the latest image that is part of an image family and is not deprecated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageFamilyName family = ProjectGlobalImageFamilyName.of("[PROJECT]", "[FAMILY]");
   *   Image response = imageClient.getFromFamilyImage(family.toString());
   * }
   * </code></pre>
   *
   * @param family Name of the image family to search for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Image getFromFamilyImage(String family) {

    GetFromFamilyImageHttpRequest request =
        GetFromFamilyImageHttpRequest.newBuilder().setFamily(family).build();
    return getFromFamilyImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the latest image that is part of an image family and is not deprecated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedFamily = ProjectGlobalImageFamilyName.format("[PROJECT]", "[FAMILY]");
   *   GetFromFamilyImageHttpRequest request = GetFromFamilyImageHttpRequest.newBuilder()
   *     .setFamily(formattedFamily)
   *     .build();
   *   Image response = imageClient.getFromFamilyImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Image getFromFamilyImage(GetFromFamilyImageHttpRequest request) {
    return getFromFamilyImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the latest image that is part of an image family and is not deprecated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedFamily = ProjectGlobalImageFamilyName.format("[PROJECT]", "[FAMILY]");
   *   GetFromFamilyImageHttpRequest request = GetFromFamilyImageHttpRequest.newBuilder()
   *     .setFamily(formattedFamily)
   *     .build();
   *   ApiFuture&lt;Image&gt; future = imageClient.getFromFamilyImageCallable().futureCall(request);
   *   // Do something
   *   Image response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetFromFamilyImageHttpRequest, Image> getFromFamilyImageCallable() {
    return stub.getFromFamilyImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageResourceName resource = ProjectGlobalImageResourceName.of("[PROJECT]", "[RESOURCE]");
   *   Policy response = imageClient.getIamPolicyImage(resource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyImage(ProjectGlobalImageResourceName resource) {

    GetIamPolicyImageHttpRequest request =
        GetIamPolicyImageHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicyImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageResourceName resource = ProjectGlobalImageResourceName.of("[PROJECT]", "[RESOURCE]");
   *   Policy response = imageClient.getIamPolicyImage(resource.toString());
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyImage(String resource) {

    GetIamPolicyImageHttpRequest request =
        GetIamPolicyImageHttpRequest.newBuilder().setResource(resource).build();
    return getIamPolicyImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedResource = ProjectGlobalImageResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GetIamPolicyImageHttpRequest request = GetIamPolicyImageHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = imageClient.getIamPolicyImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyImage(GetIamPolicyImageHttpRequest request) {
    return getIamPolicyImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedResource = ProjectGlobalImageResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GetIamPolicyImageHttpRequest request = GetIamPolicyImageHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = imageClient.getIamPolicyImageCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetIamPolicyImageHttpRequest, Policy> getIamPolicyImageCallable() {
    return stub.getIamPolicyImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an image in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   Boolean forceCreate = false;
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Image imageResource = Image.newBuilder().build();
   *   Operation response = imageClient.insertImage(forceCreate, project, imageResource);
   * }
   * </code></pre>
   *
   * @param forceCreate Force image creation if true.
   * @param project Project ID for this request.
   * @param imageResource Represents an Image resource.
   *     <p>You can use images to create boot disks for your VM instances. For more information,
   *     read Images. (== resource_for beta.images ==) (== resource_for v1.images ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertImage(
      Boolean forceCreate, ProjectName project, Image imageResource) {

    InsertImageHttpRequest request =
        InsertImageHttpRequest.newBuilder()
            .setForceCreate(forceCreate)
            .setProject(project == null ? null : project.toString())
            .setImageResource(imageResource)
            .build();
    return insertImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an image in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   Boolean forceCreate = false;
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Image imageResource = Image.newBuilder().build();
   *   Operation response = imageClient.insertImage(forceCreate, project.toString(), imageResource);
   * }
   * </code></pre>
   *
   * @param forceCreate Force image creation if true.
   * @param project Project ID for this request.
   * @param imageResource Represents an Image resource.
   *     <p>You can use images to create boot disks for your VM instances. For more information,
   *     read Images. (== resource_for beta.images ==) (== resource_for v1.images ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertImage(Boolean forceCreate, String project, Image imageResource) {

    InsertImageHttpRequest request =
        InsertImageHttpRequest.newBuilder()
            .setForceCreate(forceCreate)
            .setProject(project)
            .setImageResource(imageResource)
            .build();
    return insertImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an image in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   Boolean forceCreate = false;
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   Image imageResource = Image.newBuilder().build();
   *   InsertImageHttpRequest request = InsertImageHttpRequest.newBuilder()
   *     .setForceCreate(forceCreate)
   *     .setProject(formattedProject)
   *     .setImageResource(imageResource)
   *     .build();
   *   Operation response = imageClient.insertImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertImage(InsertImageHttpRequest request) {
    return insertImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an image in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   Boolean forceCreate = false;
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   Image imageResource = Image.newBuilder().build();
   *   InsertImageHttpRequest request = InsertImageHttpRequest.newBuilder()
   *     .setForceCreate(forceCreate)
   *     .setProject(formattedProject)
   *     .setImageResource(imageResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = imageClient.insertImageCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertImageHttpRequest, Operation> insertImageCallable() {
    return stub.insertImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of custom images available to the specified project. Custom images are
   * images you create that belong to your project. This method does not get any images that belong
   * to other projects, including publicly-available images, like Debian 8. If you want to get a
   * list of publicly-available images, use this method to make a request to the respective image
   * project, such as debian-cloud or windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Image element : imageClient.listImages(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListImagesPagedResponse listImages(ProjectName project) {
    ListImagesHttpRequest request =
        ListImagesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listImages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of custom images available to the specified project. Custom images are
   * images you create that belong to your project. This method does not get any images that belong
   * to other projects, including publicly-available images, like Debian 8. If you want to get a
   * list of publicly-available images, use this method to make a request to the respective image
   * project, such as debian-cloud or windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Image element : imageClient.listImages(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListImagesPagedResponse listImages(String project) {
    ListImagesHttpRequest request = ListImagesHttpRequest.newBuilder().setProject(project).build();
    return listImages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of custom images available to the specified project. Custom images are
   * images you create that belong to your project. This method does not get any images that belong
   * to other projects, including publicly-available images, like Debian 8. If you want to get a
   * list of publicly-available images, use this method to make a request to the respective image
   * project, such as debian-cloud or windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListImagesHttpRequest request = ListImagesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (Image element : imageClient.listImages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListImagesPagedResponse listImages(ListImagesHttpRequest request) {
    return listImagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of custom images available to the specified project. Custom images are
   * images you create that belong to your project. This method does not get any images that belong
   * to other projects, including publicly-available images, like Debian 8. If you want to get a
   * list of publicly-available images, use this method to make a request to the respective image
   * project, such as debian-cloud or windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListImagesHttpRequest request = ListImagesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;ListImagesPagedResponse&gt; future = imageClient.listImagesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Image element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListImagesHttpRequest, ListImagesPagedResponse>
      listImagesPagedCallable() {
    return stub.listImagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of custom images available to the specified project. Custom images are
   * images you create that belong to your project. This method does not get any images that belong
   * to other projects, including publicly-available images, like Debian 8. If you want to get a
   * list of publicly-available images, use this method to make a request to the respective image
   * project, such as debian-cloud or windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListImagesHttpRequest request = ListImagesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     ImageList response = imageClient.listImagesCallable().call(request);
   *     for (Image element : response.getItemsList()) {
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
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListImagesHttpRequest, ImageList> listImagesCallable() {
    return stub.listImagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageResourceName resource = ProjectGlobalImageResourceName.of("[PROJECT]", "[RESOURCE]");
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response = imageClient.setIamPolicyImage(resource, globalSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param globalSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyImage(
      ProjectGlobalImageResourceName resource,
      GlobalSetPolicyRequest globalSetPolicyRequestResource) {

    SetIamPolicyImageHttpRequest request =
        SetIamPolicyImageHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
            .build();
    return setIamPolicyImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageResourceName resource = ProjectGlobalImageResourceName.of("[PROJECT]", "[RESOURCE]");
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response = imageClient.setIamPolicyImage(resource.toString(), globalSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param globalSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyImage(
      String resource, GlobalSetPolicyRequest globalSetPolicyRequestResource) {

    SetIamPolicyImageHttpRequest request =
        SetIamPolicyImageHttpRequest.newBuilder()
            .setResource(resource)
            .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
            .build();
    return setIamPolicyImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedResource = ProjectGlobalImageResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyImageHttpRequest request = SetIamPolicyImageHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
   *     .build();
   *   Policy response = imageClient.setIamPolicyImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyImage(SetIamPolicyImageHttpRequest request) {
    return setIamPolicyImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedResource = ProjectGlobalImageResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyImageHttpRequest request = SetIamPolicyImageHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = imageClient.setIamPolicyImageCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetIamPolicyImageHttpRequest, Policy> setIamPolicyImageCallable() {
    return stub.setIamPolicyImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an image. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageResourceName resource = ProjectGlobalImageResourceName.of("[PROJECT]", "[RESOURCE]");
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   Operation response = imageClient.setLabelsImage(resource, globalSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param globalSetLabelsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsImage(
      ProjectGlobalImageResourceName resource,
      GlobalSetLabelsRequest globalSetLabelsRequestResource) {

    SetLabelsImageHttpRequest request =
        SetLabelsImageHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
            .build();
    return setLabelsImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an image. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageResourceName resource = ProjectGlobalImageResourceName.of("[PROJECT]", "[RESOURCE]");
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   Operation response = imageClient.setLabelsImage(resource.toString(), globalSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param globalSetLabelsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsImage(
      String resource, GlobalSetLabelsRequest globalSetLabelsRequestResource) {

    SetLabelsImageHttpRequest request =
        SetLabelsImageHttpRequest.newBuilder()
            .setResource(resource)
            .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
            .build();
    return setLabelsImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an image. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedResource = ProjectGlobalImageResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   SetLabelsImageHttpRequest request = SetLabelsImageHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
   *     .build();
   *   Operation response = imageClient.setLabelsImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsImage(SetLabelsImageHttpRequest request) {
    return setLabelsImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on an image. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedResource = ProjectGlobalImageResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   SetLabelsImageHttpRequest request = SetLabelsImageHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = imageClient.setLabelsImageCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetLabelsImageHttpRequest, Operation> setLabelsImageCallable() {
    return stub.setLabelsImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageResourceName resource = ProjectGlobalImageResourceName.of("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = imageClient.testIamPermissionsImage(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsImage(
      ProjectGlobalImageResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsImageHttpRequest request =
        TestIamPermissionsImageHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   ProjectGlobalImageResourceName resource = ProjectGlobalImageResourceName.of("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = imageClient.testIamPermissionsImage(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsImage(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsImageHttpRequest request =
        TestIamPermissionsImageHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedResource = ProjectGlobalImageResourceName.format("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsImageHttpRequest request = TestIamPermissionsImageHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = imageClient.testIamPermissionsImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsImage(
      TestIamPermissionsImageHttpRequest request) {
    return testIamPermissionsImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageClient imageClient = ImageClient.create()) {
   *   String formattedResource = ProjectGlobalImageResourceName.format("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsImageHttpRequest request = TestIamPermissionsImageHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = imageClient.testIamPermissionsImageCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<TestIamPermissionsImageHttpRequest, TestPermissionsResponse>
      testIamPermissionsImageCallable() {
    return stub.testIamPermissionsImageCallable();
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

  public static class ListImagesPagedResponse
      extends AbstractPagedListResponse<
          ListImagesHttpRequest, ImageList, Image, ListImagesPage, ListImagesFixedSizeCollection> {

    public static ApiFuture<ListImagesPagedResponse> createAsync(
        PageContext<ListImagesHttpRequest, ImageList, Image> context,
        ApiFuture<ImageList> futureResponse) {
      ApiFuture<ListImagesPage> futurePage =
          ListImagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListImagesPage, ListImagesPagedResponse>() {
            @Override
            public ListImagesPagedResponse apply(ListImagesPage input) {
              return new ListImagesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListImagesPagedResponse(ListImagesPage page) {
      super(page, ListImagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListImagesPage
      extends AbstractPage<ListImagesHttpRequest, ImageList, Image, ListImagesPage> {

    private ListImagesPage(
        PageContext<ListImagesHttpRequest, ImageList, Image> context, ImageList response) {
      super(context, response);
    }

    private static ListImagesPage createEmptyPage() {
      return new ListImagesPage(null, null);
    }

    @Override
    protected ListImagesPage createPage(
        PageContext<ListImagesHttpRequest, ImageList, Image> context, ImageList response) {
      return new ListImagesPage(context, response);
    }

    @Override
    public ApiFuture<ListImagesPage> createPageAsync(
        PageContext<ListImagesHttpRequest, ImageList, Image> context,
        ApiFuture<ImageList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListImagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListImagesHttpRequest, ImageList, Image, ListImagesPage, ListImagesFixedSizeCollection> {

    private ListImagesFixedSizeCollection(List<ListImagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListImagesFixedSizeCollection createEmptyCollection() {
      return new ListImagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListImagesFixedSizeCollection createCollection(
        List<ListImagesPage> pages, int collectionSize) {
      return new ListImagesFixedSizeCollection(pages, collectionSize);
    }
  }
}
