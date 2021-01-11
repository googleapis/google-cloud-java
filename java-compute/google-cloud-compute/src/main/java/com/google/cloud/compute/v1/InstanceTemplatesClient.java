/*
 * Copyright 2020 Google LLC
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
import com.google.cloud.compute.v1.stub.InstanceTemplatesStub;
import com.google.cloud.compute.v1.stub.InstanceTemplatesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The InstanceTemplates API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
 *   String project = "";
 *   String instanceTemplate = "";
 *   Operation response = instanceTemplatesClient.delete(project, instanceTemplate);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the instanceTemplatesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of InstanceTemplatesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InstanceTemplatesSettings instanceTemplatesSettings =
 *     InstanceTemplatesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstanceTemplatesClient instanceTemplatesClient =
 *     InstanceTemplatesClient.create(instanceTemplatesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InstanceTemplatesSettings instanceTemplatesSettings =
 *     InstanceTemplatesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstanceTemplatesClient instanceTemplatesClient =
 *     InstanceTemplatesClient.create(instanceTemplatesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstanceTemplatesClient implements BackgroundResource {
  private final InstanceTemplatesSettings settings;
  private final InstanceTemplatesStub stub;

  /** Constructs an instance of InstanceTemplatesClient with default settings. */
  public static final InstanceTemplatesClient create() throws IOException {
    return create(InstanceTemplatesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstanceTemplatesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InstanceTemplatesClient create(InstanceTemplatesSettings settings)
      throws IOException {
    return new InstanceTemplatesClient(settings);
  }

  /**
   * Constructs an instance of InstanceTemplatesClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use InstanceTemplatesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InstanceTemplatesClient create(InstanceTemplatesStub stub) {
    return new InstanceTemplatesClient(stub);
  }

  /**
   * Constructs an instance of InstanceTemplatesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected InstanceTemplatesClient(InstanceTemplatesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InstanceTemplatesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InstanceTemplatesClient(InstanceTemplatesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstanceTemplatesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstanceTemplatesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified instance template. Deleting an instance template is permanent and cannot
   * be undone. It is not possible to delete templates that are already in use by a managed instance
   * group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   String instanceTemplate = "";
   *   Operation response = instanceTemplatesClient.delete(project, instanceTemplate);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param instanceTemplate The name of the instance template to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String instanceTemplate) {
    DeleteInstanceTemplateRequest request =
        DeleteInstanceTemplateRequest.newBuilder()
            .setProject(project)
            .setInstanceTemplate(instanceTemplate)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified instance template. Deleting an instance template is permanent and cannot
   * be undone. It is not possible to delete templates that are already in use by a managed instance
   * group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String instanceTemplate = "";
   *   String project = "";
   *   DeleteInstanceTemplateRequest request = DeleteInstanceTemplateRequest.newBuilder()
   *     .setInstanceTemplate(instanceTemplate)
   *     .setProject(project)
   *     .build();
   *   Operation response = instanceTemplatesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteInstanceTemplateRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified instance template. Deleting an instance template is permanent and cannot
   * be undone. It is not possible to delete templates that are already in use by a managed instance
   * group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String instanceTemplate = "";
   *   String project = "";
   *   DeleteInstanceTemplateRequest request = DeleteInstanceTemplateRequest.newBuilder()
   *     .setInstanceTemplate(instanceTemplate)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceTemplatesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInstanceTemplateRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance template. Gets a list of available instance templates by making
   * a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   String instanceTemplate = "";
   *   InstanceTemplate response = instanceTemplatesClient.get(project, instanceTemplate);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param instanceTemplate The name of the instance template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceTemplate get(String project, String instanceTemplate) {
    GetInstanceTemplateRequest request =
        GetInstanceTemplateRequest.newBuilder()
            .setProject(project)
            .setInstanceTemplate(instanceTemplate)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance template. Gets a list of available instance templates by making
   * a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String instanceTemplate = "";
   *   String project = "";
   *   GetInstanceTemplateRequest request = GetInstanceTemplateRequest.newBuilder()
   *     .setInstanceTemplate(instanceTemplate)
   *     .setProject(project)
   *     .build();
   *   InstanceTemplate response = instanceTemplatesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceTemplate get(GetInstanceTemplateRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance template. Gets a list of available instance templates by making
   * a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String instanceTemplate = "";
   *   String project = "";
   *   GetInstanceTemplateRequest request = GetInstanceTemplateRequest.newBuilder()
   *     .setInstanceTemplate(instanceTemplate)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;InstanceTemplate&gt; future = instanceTemplatesClient.getCallable().futureCall(request);
   *   // Do something
   *   InstanceTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetInstanceTemplateRequest, InstanceTemplate> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   Policy response = instanceTemplatesClient.getIamPolicy(project, resource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String resource) {
    GetIamPolicyInstanceTemplateRequest request =
        GetIamPolicyInstanceTemplateRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   GetIamPolicyInstanceTemplateRequest request = GetIamPolicyInstanceTemplateRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   Policy response = instanceTemplatesClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyInstanceTemplateRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   GetIamPolicyInstanceTemplateRequest request = GetIamPolicyInstanceTemplateRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = instanceTemplatesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyInstanceTemplateRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance template in the specified project using the data that is included in the
   * request. If you are creating a new template to update an existing instance group, your new
   * instance template must use the same network or, if applicable, the same subnetwork as the
   * original template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   InstanceTemplate instanceTemplateResource = InstanceTemplate.newBuilder().build();
   *   Operation response = instanceTemplatesClient.insert(project, instanceTemplateResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param instanceTemplateResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, InstanceTemplate instanceTemplateResource) {
    InsertInstanceTemplateRequest request =
        InsertInstanceTemplateRequest.newBuilder()
            .setProject(project)
            .setInstanceTemplateResource(instanceTemplateResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance template in the specified project using the data that is included in the
   * request. If you are creating a new template to update an existing instance group, your new
   * instance template must use the same network or, if applicable, the same subnetwork as the
   * original template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   InstanceTemplate instanceTemplateResource = InstanceTemplate.newBuilder().build();
   *   String project = "";
   *   InsertInstanceTemplateRequest request = InsertInstanceTemplateRequest.newBuilder()
   *     .setInstanceTemplateResource(instanceTemplateResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = instanceTemplatesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertInstanceTemplateRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance template in the specified project using the data that is included in the
   * request. If you are creating a new template to update an existing instance group, your new
   * instance template must use the same network or, if applicable, the same subnetwork as the
   * original template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   InstanceTemplate instanceTemplateResource = InstanceTemplate.newBuilder().build();
   *   String project = "";
   *   InsertInstanceTemplateRequest request = InsertInstanceTemplateRequest.newBuilder()
   *     .setInstanceTemplateResource(instanceTemplateResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceTemplatesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertInstanceTemplateRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of instance templates that are contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   for (InstanceTemplate element : instanceTemplatesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListInstanceTemplatesRequest request =
        ListInstanceTemplatesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of instance templates that are contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   ListInstanceTemplatesRequest request = ListInstanceTemplatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (InstanceTemplate element : instanceTemplatesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListInstanceTemplatesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of instance templates that are contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   ListInstanceTemplatesRequest request = ListInstanceTemplatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = instanceTemplatesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInstanceTemplatesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of instance templates that are contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   ListInstanceTemplatesRequest request = ListInstanceTemplatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     InstanceTemplateList response = instanceTemplatesClient.listCallable().call(request);
   *     for (InstanceTemplate element : response.getItemsList()) {
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
  public final UnaryCallable<ListInstanceTemplatesRequest, InstanceTemplateList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response = instanceTemplatesClient.setIamPolicy(project, resource, globalSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project, String resource, GlobalSetPolicyRequest globalSetPolicyRequestResource) {
    SetIamPolicyInstanceTemplateRequest request =
        SetIamPolicyInstanceTemplateRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   String project = "";
   *   String resource = "";
   *   SetIamPolicyInstanceTemplateRequest request = SetIamPolicyInstanceTemplateRequest.newBuilder()
   *     .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   Policy response = instanceTemplatesClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyInstanceTemplateRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   String project = "";
   *   String resource = "";
   *   SetIamPolicyInstanceTemplateRequest request = SetIamPolicyInstanceTemplateRequest.newBuilder()
   *     .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = instanceTemplatesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyInstanceTemplateRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = instanceTemplatesClient.testIamPermissions(project, resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project, String resource, TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsInstanceTemplateRequest request =
        TestIamPermissionsInstanceTemplateRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsInstanceTemplateRequest request = TestIamPermissionsInstanceTemplateRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = instanceTemplatesClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsInstanceTemplateRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsInstanceTemplateRequest request = TestIamPermissionsInstanceTemplateRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = instanceTemplatesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsInstanceTemplateRequest, TestPermissionsResponse>
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
          ListInstanceTemplatesRequest,
          InstanceTemplateList,
          InstanceTemplate,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListInstanceTemplatesRequest, InstanceTemplateList, InstanceTemplate> context,
        ApiFuture<InstanceTemplateList> futureResponse) {
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

  public static class ListPage
      extends AbstractPage<
          ListInstanceTemplatesRequest, InstanceTemplateList, InstanceTemplate, ListPage> {

    private ListPage(
        PageContext<ListInstanceTemplatesRequest, InstanceTemplateList, InstanceTemplate> context,
        InstanceTemplateList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListInstanceTemplatesRequest, InstanceTemplateList, InstanceTemplate> context,
        InstanceTemplateList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListInstanceTemplatesRequest, InstanceTemplateList, InstanceTemplate> context,
        ApiFuture<InstanceTemplateList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstanceTemplatesRequest,
          InstanceTemplateList,
          InstanceTemplate,
          ListPage,
          ListFixedSizeCollection> {

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
