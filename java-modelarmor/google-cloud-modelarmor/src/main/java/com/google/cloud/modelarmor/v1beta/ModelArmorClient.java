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

package com.google.cloud.modelarmor.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.modelarmor.v1beta.stub.ModelArmorStub;
import com.google.cloud.modelarmor.v1beta.stub.ModelArmorStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
 *   TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
 *   Template response = modelArmorClient.getTemplate(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ModelArmorClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListTemplates</td>
 *      <td><p> Lists Templates in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTemplates(ListTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTemplates(LocationName parent)
 *           <li><p> listTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTemplatesPagedCallable()
 *           <li><p> listTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTemplate</td>
 *      <td><p> Gets details of a single Template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTemplate(GetTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTemplate(TemplateName name)
 *           <li><p> getTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTemplate</td>
 *      <td><p> Creates a new Template in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTemplate(CreateTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTemplate(LocationName parent, Template template, String templateId)
 *           <li><p> createTemplate(String parent, Template template, String templateId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTemplate</td>
 *      <td><p> Updates the parameters of a single Template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTemplate(UpdateTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTemplate(Template template, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTemplate</td>
 *      <td><p> Deletes a single Template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTemplate(DeleteTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTemplate(TemplateName name)
 *           <li><p> deleteTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFloorSetting</td>
 *      <td><p> Gets details of a single floor setting of a project</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFloorSetting(GetFloorSettingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFloorSetting(FloorSettingName name)
 *           <li><p> getFloorSetting(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFloorSettingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFloorSetting</td>
 *      <td><p> Updates the parameters of a single floor setting of a project</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFloorSetting(UpdateFloorSettingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateFloorSetting(FloorSetting floorSetting, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFloorSettingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SanitizeUserPrompt</td>
 *      <td><p> Sanitizes User Prompt.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> sanitizeUserPrompt(SanitizeUserPromptRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> sanitizeUserPromptCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SanitizeModelResponse</td>
 *      <td><p> Sanitizes Model Response.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> sanitizeModelResponse(SanitizeModelResponseRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> sanitizeModelResponseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of ModelArmorSettings to
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
 * ModelArmorSettings modelArmorSettings =
 *     ModelArmorSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ModelArmorClient modelArmorClient = ModelArmorClient.create(modelArmorSettings);
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
 * ModelArmorSettings modelArmorSettings =
 *     ModelArmorSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ModelArmorClient modelArmorClient = ModelArmorClient.create(modelArmorSettings);
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
 * ModelArmorSettings modelArmorSettings = ModelArmorSettings.newHttpJsonBuilder().build();
 * ModelArmorClient modelArmorClient = ModelArmorClient.create(modelArmorSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelArmorClient implements BackgroundResource {
  private final ModelArmorSettings settings;
  private final ModelArmorStub stub;

  /** Constructs an instance of ModelArmorClient with default settings. */
  public static final ModelArmorClient create() throws IOException {
    return create(ModelArmorSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ModelArmorClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ModelArmorClient create(ModelArmorSettings settings) throws IOException {
    return new ModelArmorClient(settings);
  }

  /**
   * Constructs an instance of ModelArmorClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ModelArmorSettings).
   */
  public static final ModelArmorClient create(ModelArmorStub stub) {
    return new ModelArmorClient(stub);
  }

  /**
   * Constructs an instance of ModelArmorClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ModelArmorClient(ModelArmorSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ModelArmorStubSettings) settings.getStubSettings()).createStub();
  }

  protected ModelArmorClient(ModelArmorStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ModelArmorSettings getSettings() {
    return settings;
  }

  public ModelArmorStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Templates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Template element : modelArmorClient.listTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListTemplatesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTemplatesPagedResponse listTemplates(LocationName parent) {
    ListTemplatesRequest request =
        ListTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Templates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Template element : modelArmorClient.listTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListTemplatesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTemplatesPagedResponse listTemplates(String parent) {
    ListTemplatesRequest request = ListTemplatesRequest.newBuilder().setParent(parent).build();
    return listTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Templates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   ListTemplatesRequest request =
   *       ListTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Template element : modelArmorClient.listTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTemplatesPagedResponse listTemplates(ListTemplatesRequest request) {
    return listTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Templates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   ListTemplatesRequest request =
   *       ListTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Template> future =
   *       modelArmorClient.listTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Template element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTemplatesRequest, ListTemplatesPagedResponse>
      listTemplatesPagedCallable() {
    return stub.listTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Templates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   ListTemplatesRequest request =
   *       ListTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTemplatesResponse response = modelArmorClient.listTemplatesCallable().call(request);
   *     for (Template element : response.getTemplatesList()) {
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
  public final UnaryCallable<ListTemplatesRequest, ListTemplatesResponse> listTemplatesCallable() {
    return stub.listTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
   *   Template response = modelArmorClient.getTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template getTemplate(TemplateName name) {
    GetTemplateRequest request =
        GetTemplateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   String name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString();
   *   Template response = modelArmorClient.getTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template getTemplate(String name) {
    GetTemplateRequest request = GetTemplateRequest.newBuilder().setName(name).build();
    return getTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   GetTemplateRequest request =
   *       GetTemplateRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .build();
   *   Template response = modelArmorClient.getTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template getTemplate(GetTemplateRequest request) {
    return getTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   GetTemplateRequest request =
   *       GetTemplateRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<Template> future = modelArmorClient.getTemplateCallable().futureCall(request);
   *   // Do something.
   *   Template response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTemplateRequest, Template> getTemplateCallable() {
    return stub.getTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Template in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Template template = Template.newBuilder().build();
   *   String templateId = "templateId1304010549";
   *   Template response = modelArmorClient.createTemplate(parent, template, templateId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param template Required. The resource being created
   * @param templateId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and template_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template createTemplate(LocationName parent, Template template, String templateId) {
    CreateTemplateRequest request =
        CreateTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTemplate(template)
            .setTemplateId(templateId)
            .build();
    return createTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Template in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Template template = Template.newBuilder().build();
   *   String templateId = "templateId1304010549";
   *   Template response = modelArmorClient.createTemplate(parent, template, templateId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param template Required. The resource being created
   * @param templateId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and template_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template createTemplate(String parent, Template template, String templateId) {
    CreateTemplateRequest request =
        CreateTemplateRequest.newBuilder()
            .setParent(parent)
            .setTemplate(template)
            .setTemplateId(templateId)
            .build();
    return createTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Template in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   CreateTemplateRequest request =
   *       CreateTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTemplateId("templateId1304010549")
   *           .setTemplate(Template.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Template response = modelArmorClient.createTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template createTemplate(CreateTemplateRequest request) {
    return createTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Template in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   CreateTemplateRequest request =
   *       CreateTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTemplateId("templateId1304010549")
   *           .setTemplate(Template.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Template> future = modelArmorClient.createTemplateCallable().futureCall(request);
   *   // Do something.
   *   Template response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTemplateRequest, Template> createTemplateCallable() {
    return stub.createTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   Template template = Template.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Template response = modelArmorClient.updateTemplate(template, updateMask);
   * }
   * }</pre>
   *
   * @param template Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Template resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template updateTemplate(Template template, FieldMask updateMask) {
    UpdateTemplateRequest request =
        UpdateTemplateRequest.newBuilder().setTemplate(template).setUpdateMask(updateMask).build();
    return updateTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   UpdateTemplateRequest request =
   *       UpdateTemplateRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTemplate(Template.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Template response = modelArmorClient.updateTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template updateTemplate(UpdateTemplateRequest request) {
    return updateTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   UpdateTemplateRequest request =
   *       UpdateTemplateRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTemplate(Template.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Template> future = modelArmorClient.updateTemplateCallable().futureCall(request);
   *   // Do something.
   *   Template response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTemplateRequest, Template> updateTemplateCallable() {
    return stub.updateTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
   *   modelArmorClient.deleteTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTemplate(TemplateName name) {
    DeleteTemplateRequest request =
        DeleteTemplateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   String name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString();
   *   modelArmorClient.deleteTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTemplate(String name) {
    DeleteTemplateRequest request = DeleteTemplateRequest.newBuilder().setName(name).build();
    deleteTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   DeleteTemplateRequest request =
   *       DeleteTemplateRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   modelArmorClient.deleteTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTemplate(DeleteTemplateRequest request) {
    deleteTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   DeleteTemplateRequest request =
   *       DeleteTemplateRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = modelArmorClient.deleteTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTemplateRequest, Empty> deleteTemplateCallable() {
    return stub.deleteTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single floor setting of a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   FloorSettingName name = FloorSettingName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
   *   FloorSetting response = modelArmorClient.getFloorSetting(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the floor setting to get, example projects/123/floorsetting.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FloorSetting getFloorSetting(FloorSettingName name) {
    GetFloorSettingRequest request =
        GetFloorSettingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFloorSetting(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single floor setting of a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   String name = FloorSettingName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString();
   *   FloorSetting response = modelArmorClient.getFloorSetting(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the floor setting to get, example projects/123/floorsetting.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FloorSetting getFloorSetting(String name) {
    GetFloorSettingRequest request = GetFloorSettingRequest.newBuilder().setName(name).build();
    return getFloorSetting(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single floor setting of a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   GetFloorSettingRequest request =
   *       GetFloorSettingRequest.newBuilder()
   *           .setName(FloorSettingName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   FloorSetting response = modelArmorClient.getFloorSetting(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FloorSetting getFloorSetting(GetFloorSettingRequest request) {
    return getFloorSettingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single floor setting of a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   GetFloorSettingRequest request =
   *       GetFloorSettingRequest.newBuilder()
   *           .setName(FloorSettingName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<FloorSetting> future =
   *       modelArmorClient.getFloorSettingCallable().futureCall(request);
   *   // Do something.
   *   FloorSetting response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFloorSettingRequest, FloorSetting> getFloorSettingCallable() {
    return stub.getFloorSettingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single floor setting of a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   FloorSetting floorSetting = FloorSetting.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   FloorSetting response = modelArmorClient.updateFloorSetting(floorSetting, updateMask);
   * }
   * }</pre>
   *
   * @param floorSetting Required. The floor setting being updated.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     FloorSetting resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FloorSetting updateFloorSetting(FloorSetting floorSetting, FieldMask updateMask) {
    UpdateFloorSettingRequest request =
        UpdateFloorSettingRequest.newBuilder()
            .setFloorSetting(floorSetting)
            .setUpdateMask(updateMask)
            .build();
    return updateFloorSetting(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single floor setting of a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   UpdateFloorSettingRequest request =
   *       UpdateFloorSettingRequest.newBuilder()
   *           .setFloorSetting(FloorSetting.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   FloorSetting response = modelArmorClient.updateFloorSetting(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FloorSetting updateFloorSetting(UpdateFloorSettingRequest request) {
    return updateFloorSettingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single floor setting of a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   UpdateFloorSettingRequest request =
   *       UpdateFloorSettingRequest.newBuilder()
   *           .setFloorSetting(FloorSetting.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<FloorSetting> future =
   *       modelArmorClient.updateFloorSettingCallable().futureCall(request);
   *   // Do something.
   *   FloorSetting response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFloorSettingRequest, FloorSetting> updateFloorSettingCallable() {
    return stub.updateFloorSettingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sanitizes User Prompt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   SanitizeUserPromptRequest request =
   *       SanitizeUserPromptRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setUserPromptData(DataItem.newBuilder().build())
   *           .build();
   *   SanitizeUserPromptResponse response = modelArmorClient.sanitizeUserPrompt(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SanitizeUserPromptResponse sanitizeUserPrompt(SanitizeUserPromptRequest request) {
    return sanitizeUserPromptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sanitizes User Prompt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   SanitizeUserPromptRequest request =
   *       SanitizeUserPromptRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setUserPromptData(DataItem.newBuilder().build())
   *           .build();
   *   ApiFuture<SanitizeUserPromptResponse> future =
   *       modelArmorClient.sanitizeUserPromptCallable().futureCall(request);
   *   // Do something.
   *   SanitizeUserPromptResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptCallable() {
    return stub.sanitizeUserPromptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sanitizes Model Response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   SanitizeModelResponseRequest request =
   *       SanitizeModelResponseRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setModelResponseData(DataItem.newBuilder().build())
   *           .setUserPrompt("userPrompt1504308495")
   *           .setMultiLanguageDetectionMetadata(
   *               MultiLanguageDetectionMetadata.newBuilder().build())
   *           .build();
   *   SanitizeModelResponseResponse response = modelArmorClient.sanitizeModelResponse(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SanitizeModelResponseResponse sanitizeModelResponse(
      SanitizeModelResponseRequest request) {
    return sanitizeModelResponseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sanitizes Model Response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   SanitizeModelResponseRequest request =
   *       SanitizeModelResponseRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setModelResponseData(DataItem.newBuilder().build())
   *           .setUserPrompt("userPrompt1504308495")
   *           .setMultiLanguageDetectionMetadata(
   *               MultiLanguageDetectionMetadata.newBuilder().build())
   *           .build();
   *   ApiFuture<SanitizeModelResponseResponse> future =
   *       modelArmorClient.sanitizeModelResponseCallable().futureCall(request);
   *   // Do something.
   *   SanitizeModelResponseResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseCallable() {
    return stub.sanitizeModelResponseCallable();
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
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : modelArmorClient.listLocations(request).iterateAll()) {
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
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       modelArmorClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = modelArmorClient.listLocationsCallable().call(request);
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
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = modelArmorClient.getLocation(request);
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
   * try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = modelArmorClient.getLocationCallable().futureCall(request);
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

  public static class ListTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListTemplatesRequest,
          ListTemplatesResponse,
          Template,
          ListTemplatesPage,
          ListTemplatesFixedSizeCollection> {

    public static ApiFuture<ListTemplatesPagedResponse> createAsync(
        PageContext<ListTemplatesRequest, ListTemplatesResponse, Template> context,
        ApiFuture<ListTemplatesResponse> futureResponse) {
      ApiFuture<ListTemplatesPage> futurePage =
          ListTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTemplatesPagedResponse(ListTemplatesPage page) {
      super(page, ListTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTemplatesPage
      extends AbstractPage<
          ListTemplatesRequest, ListTemplatesResponse, Template, ListTemplatesPage> {

    private ListTemplatesPage(
        PageContext<ListTemplatesRequest, ListTemplatesResponse, Template> context,
        ListTemplatesResponse response) {
      super(context, response);
    }

    private static ListTemplatesPage createEmptyPage() {
      return new ListTemplatesPage(null, null);
    }

    @Override
    protected ListTemplatesPage createPage(
        PageContext<ListTemplatesRequest, ListTemplatesResponse, Template> context,
        ListTemplatesResponse response) {
      return new ListTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListTemplatesPage> createPageAsync(
        PageContext<ListTemplatesRequest, ListTemplatesResponse, Template> context,
        ApiFuture<ListTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTemplatesRequest,
          ListTemplatesResponse,
          Template,
          ListTemplatesPage,
          ListTemplatesFixedSizeCollection> {

    private ListTemplatesFixedSizeCollection(List<ListTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTemplatesFixedSizeCollection createCollection(
        List<ListTemplatesPage> pages, int collectionSize) {
      return new ListTemplatesFixedSizeCollection(pages, collectionSize);
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
