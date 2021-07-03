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
import com.google.cloud.compute.v1.stub.ImagesStub;
import com.google.cloud.compute.v1.stub.ImagesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Images API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (ImagesClient imagesClient = ImagesClient.create()) {
 *   String project = "project-309310695";
 *   String image = "image100313435";
 *   Operation response = imagesClient.delete(project, image);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ImagesClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of ImagesSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * ImagesSettings imagesSettings =
 *     ImagesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ImagesClient imagesClient = ImagesClient.create(imagesSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * ImagesSettings imagesSettings = ImagesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ImagesClient imagesClient = ImagesClient.create(imagesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ImagesClient implements BackgroundResource {
  private final ImagesSettings settings;
  private final ImagesStub stub;

  /** Constructs an instance of ImagesClient with default settings. */
  public static final ImagesClient create() throws IOException {
    return create(ImagesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ImagesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ImagesClient create(ImagesSettings settings) throws IOException {
    return new ImagesClient(settings);
  }

  /**
   * Constructs an instance of ImagesClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ImagesSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ImagesClient create(ImagesStub stub) {
    return new ImagesClient(stub);
  }

  /**
   * Constructs an instance of ImagesClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ImagesClient(ImagesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ImagesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ImagesClient(ImagesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ImagesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ImagesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified image.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   String image = "image100313435";
   *   Operation response = imagesClient.delete(project, image);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param image Name of the image resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String image) {
    DeleteImageRequest request =
        DeleteImageRequest.newBuilder().setProject(project).setImage(image).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified image.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   DeleteImageRequest request =
   *       DeleteImageRequest.newBuilder()
   *           .setImage("image100313435")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = imagesClient.delete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteImageRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified image.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   DeleteImageRequest request =
   *       DeleteImageRequest.newBuilder()
   *           .setImage("image100313435")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = imagesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteImageRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the deprecation status of an image.
   *
   * <p>If an empty request body is given, clears the deprecation status instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   String image = "image100313435";
   *   DeprecationStatus deprecationStatusResource = DeprecationStatus.newBuilder().build();
   *   Operation response = imagesClient.deprecate(project, image, deprecationStatusResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param image Image name.
   * @param deprecationStatusResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deprecate(
      String project, String image, DeprecationStatus deprecationStatusResource) {
    DeprecateImageRequest request =
        DeprecateImageRequest.newBuilder()
            .setProject(project)
            .setImage(image)
            .setDeprecationStatusResource(deprecationStatusResource)
            .build();
    return deprecate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the deprecation status of an image.
   *
   * <p>If an empty request body is given, clears the deprecation status instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   DeprecateImageRequest request =
   *       DeprecateImageRequest.newBuilder()
   *           .setDeprecationStatusResource(DeprecationStatus.newBuilder().build())
   *           .setImage("image100313435")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = imagesClient.deprecate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deprecate(DeprecateImageRequest request) {
    return deprecateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the deprecation status of an image.
   *
   * <p>If an empty request body is given, clears the deprecation status instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   DeprecateImageRequest request =
   *       DeprecateImageRequest.newBuilder()
   *           .setDeprecationStatusResource(DeprecationStatus.newBuilder().build())
   *           .setImage("image100313435")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = imagesClient.deprecateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeprecateImageRequest, Operation> deprecateCallable() {
    return stub.deprecateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified image. Gets a list of available images by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   String image = "image100313435";
   *   Image response = imagesClient.get(project, image);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param image Name of the image resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Image get(String project, String image) {
    GetImageRequest request =
        GetImageRequest.newBuilder().setProject(project).setImage(image).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified image. Gets a list of available images by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   GetImageRequest request =
   *       GetImageRequest.newBuilder()
   *           .setImage("image100313435")
   *           .setProject("project-309310695")
   *           .build();
   *   Image response = imagesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Image get(GetImageRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified image. Gets a list of available images by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   GetImageRequest request =
   *       GetImageRequest.newBuilder()
   *           .setImage("image100313435")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Image> future = imagesClient.getCallable().futureCall(request);
   *   // Do something.
   *   Image response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetImageRequest, Image> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the latest image that is part of an image family and is not deprecated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   String family = "family-1281860764";
   *   Image response = imagesClient.getFromFamily(project, family);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param family Name of the image family to search for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Image getFromFamily(String project, String family) {
    GetFromFamilyImageRequest request =
        GetFromFamilyImageRequest.newBuilder().setProject(project).setFamily(family).build();
    return getFromFamily(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the latest image that is part of an image family and is not deprecated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   GetFromFamilyImageRequest request =
   *       GetFromFamilyImageRequest.newBuilder()
   *           .setFamily("family-1281860764")
   *           .setProject("project-309310695")
   *           .build();
   *   Image response = imagesClient.getFromFamily(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Image getFromFamily(GetFromFamilyImageRequest request) {
    return getFromFamilyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the latest image that is part of an image family and is not deprecated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   GetFromFamilyImageRequest request =
   *       GetFromFamilyImageRequest.newBuilder()
   *           .setFamily("family-1281860764")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Image> future = imagesClient.getFromFamilyCallable().futureCall(request);
   *   // Do something.
   *   Image response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFromFamilyImageRequest, Image> getFromFamilyCallable() {
    return stub.getFromFamilyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   Policy response = imagesClient.getIamPolicy(project, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String resource) {
    GetIamPolicyImageRequest request =
        GetIamPolicyImageRequest.newBuilder().setProject(project).setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   GetIamPolicyImageRequest request =
   *       GetIamPolicyImageRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = imagesClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyImageRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   GetIamPolicyImageRequest request =
   *       GetIamPolicyImageRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future = imagesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyImageRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an image in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   Image imageResource = Image.newBuilder().build();
   *   Operation response = imagesClient.insert(project, imageResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param imageResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, Image imageResource) {
    InsertImageRequest request =
        InsertImageRequest.newBuilder().setProject(project).setImageResource(imageResource).build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an image in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   InsertImageRequest request =
   *       InsertImageRequest.newBuilder()
   *           .setForceCreate(true)
   *           .setImageResource(Image.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = imagesClient.insert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertImageRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an image in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   InsertImageRequest request =
   *       InsertImageRequest.newBuilder()
   *           .setForceCreate(true)
   *           .setImageResource(Image.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = imagesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertImageRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of custom images available to the specified project. Custom images are
   * images you create that belong to your project. This method does not get any images that belong
   * to other projects, including publicly-available images, like Debian 8. If you want to get a
   * list of publicly-available images, use this method to make a request to the respective image
   * project, such as debian-cloud or windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   for (Image element : imagesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListImagesRequest request = ListImagesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of custom images available to the specified project. Custom images are
   * images you create that belong to your project. This method does not get any images that belong
   * to other projects, including publicly-available images, like Debian 8. If you want to get a
   * list of publicly-available images, use this method to make a request to the respective image
   * project, such as debian-cloud or windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   ListImagesRequest request =
   *       ListImagesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Image element : imagesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListImagesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of custom images available to the specified project. Custom images are
   * images you create that belong to your project. This method does not get any images that belong
   * to other projects, including publicly-available images, like Debian 8. If you want to get a
   * list of publicly-available images, use this method to make a request to the respective image
   * project, such as debian-cloud or windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   ListImagesRequest request =
   *       ListImagesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Image> future = imagesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Image element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListImagesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of custom images available to the specified project. Custom images are
   * images you create that belong to your project. This method does not get any images that belong
   * to other projects, including publicly-available images, like Debian 8. If you want to get a
   * list of publicly-available images, use this method to make a request to the respective image
   * project, such as debian-cloud or windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   ListImagesRequest request =
   *       ListImagesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ImageList response = imagesClient.listCallable().call(request);
   *     for (Image element : response.getResponsesList()) {
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
  public final UnaryCallable<ListImagesRequest, ImageList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified image with the data included in the request. Only the following fields
   * can be modified: family, description, deprecation status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   String image = "image100313435";
   *   Image imageResource = Image.newBuilder().build();
   *   Operation response = imagesClient.patch(project, image, imageResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param image Name of the image resource to patch.
   * @param imageResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(String project, String image, Image imageResource) {
    PatchImageRequest request =
        PatchImageRequest.newBuilder()
            .setProject(project)
            .setImage(image)
            .setImageResource(imageResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified image with the data included in the request. Only the following fields
   * can be modified: family, description, deprecation status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   PatchImageRequest request =
   *       PatchImageRequest.newBuilder()
   *           .setImage("image100313435")
   *           .setImageResource(Image.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = imagesClient.patch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchImageRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified image with the data included in the request. Only the following fields
   * can be modified: family, description, deprecation status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   PatchImageRequest request =
   *       PatchImageRequest.newBuilder()
   *           .setImage("image100313435")
   *           .setImageResource(Image.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = imagesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchImageRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource =
   *       GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       imagesClient.setIamPolicy(project, resource, globalSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project, String resource, GlobalSetPolicyRequest globalSetPolicyRequestResource) {
    SetIamPolicyImageRequest request =
        SetIamPolicyImageRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   SetIamPolicyImageRequest request =
   *       SetIamPolicyImageRequest.newBuilder()
   *           .setGlobalSetPolicyRequestResource(GlobalSetPolicyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = imagesClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyImageRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   SetIamPolicyImageRequest request =
   *       SetIamPolicyImageRequest.newBuilder()
   *           .setGlobalSetPolicyRequestResource(GlobalSetPolicyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future = imagesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyImageRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on an image. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource =
   *       GlobalSetLabelsRequest.newBuilder().build();
   *   Operation response =
   *       imagesClient.setLabels(project, resource, globalSetLabelsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(
      String project, String resource, GlobalSetLabelsRequest globalSetLabelsRequestResource) {
    SetLabelsImageRequest request =
        SetLabelsImageRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
            .build();
    return setLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on an image. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   SetLabelsImageRequest request =
   *       SetLabelsImageRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Operation response = imagesClient.setLabels(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(SetLabelsImageRequest request) {
    return setLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on an image. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   SetLabelsImageRequest request =
   *       SetLabelsImageRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Operation> future = imagesClient.setLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetLabelsImageRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       imagesClient.testIamPermissions(project, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project, String resource, TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsImageRequest request =
        TestIamPermissionsImageRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   TestIamPermissionsImageRequest request =
   *       TestIamPermissionsImageRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response = imagesClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(TestIamPermissionsImageRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ImagesClient imagesClient = ImagesClient.create()) {
   *   TestIamPermissionsImageRequest request =
   *       TestIamPermissionsImageRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       imagesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsImageRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListImagesRequest, ImageList, Image, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListImagesRequest, ImageList, Image> context,
        ApiFuture<ImageList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage extends AbstractPage<ListImagesRequest, ImageList, Image, ListPage> {

    private ListPage(PageContext<ListImagesRequest, ImageList, Image> context, ImageList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListImagesRequest, ImageList, Image> context, ImageList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListImagesRequest, ImageList, Image> context,
        ApiFuture<ImageList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListImagesRequest, ImageList, Image, ListPage, ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
