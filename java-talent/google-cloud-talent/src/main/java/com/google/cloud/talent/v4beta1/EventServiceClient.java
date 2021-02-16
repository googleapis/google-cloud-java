/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.talent.v4beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4beta1.stub.EventServiceStub;
import com.google.cloud.talent.v4beta1.stub.EventServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service handles client event report.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (EventServiceClient eventServiceClient = EventServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   ClientEvent clientEvent = ClientEvent.newBuilder().build();
 *   ClientEvent response = eventServiceClient.createClientEvent(parent, clientEvent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EventServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of EventServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * EventServiceSettings eventServiceSettings =
 *     EventServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EventServiceClient eventServiceClient = EventServiceClient.create(eventServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * EventServiceSettings eventServiceSettings =
 *     EventServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EventServiceClient eventServiceClient = EventServiceClient.create(eventServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EventServiceClient implements BackgroundResource {
  private final EventServiceSettings settings;
  private final EventServiceStub stub;

  /** Constructs an instance of EventServiceClient with default settings. */
  public static final EventServiceClient create() throws IOException {
    return create(EventServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EventServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EventServiceClient create(EventServiceSettings settings) throws IOException {
    return new EventServiceClient(settings);
  }

  /**
   * Constructs an instance of EventServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(EventServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final EventServiceClient create(EventServiceStub stub) {
    return new EventServiceClient(stub);
  }

  /**
   * Constructs an instance of EventServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EventServiceClient(EventServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EventServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected EventServiceClient(EventServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final EventServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public EventServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report events issued when end user interacts with customer's application that uses Cloud Talent
   * Solution. You may inspect the created events in [self service
   * tools](https://console.cloud.google.com/talent-solution/overview). [Learn
   * more](https://cloud.google.com/talent-solution/docs/management-tools) about self service tools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (EventServiceClient eventServiceClient = EventServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ClientEvent clientEvent = ClientEvent.newBuilder().build();
   *   ClientEvent response = eventServiceClient.createClientEvent(parent, clientEvent);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the tenant under which the event is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}", for example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created, for
   *     example, "projects/foo".
   * @param clientEvent Required. Events issued when end user interacts with customer's application
   *     that uses Cloud Talent Solution.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientEvent createClientEvent(ProjectName parent, ClientEvent clientEvent) {
    CreateClientEventRequest request =
        CreateClientEventRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setClientEvent(clientEvent)
            .build();
    return createClientEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report events issued when end user interacts with customer's application that uses Cloud Talent
   * Solution. You may inspect the created events in [self service
   * tools](https://console.cloud.google.com/talent-solution/overview). [Learn
   * more](https://cloud.google.com/talent-solution/docs/management-tools) about self service tools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (EventServiceClient eventServiceClient = EventServiceClient.create()) {
   *   TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
   *   ClientEvent clientEvent = ClientEvent.newBuilder().build();
   *   ClientEvent response = eventServiceClient.createClientEvent(parent, clientEvent);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the tenant under which the event is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}", for example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created, for
   *     example, "projects/foo".
   * @param clientEvent Required. Events issued when end user interacts with customer's application
   *     that uses Cloud Talent Solution.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientEvent createClientEvent(TenantName parent, ClientEvent clientEvent) {
    CreateClientEventRequest request =
        CreateClientEventRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setClientEvent(clientEvent)
            .build();
    return createClientEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report events issued when end user interacts with customer's application that uses Cloud Talent
   * Solution. You may inspect the created events in [self service
   * tools](https://console.cloud.google.com/talent-solution/overview). [Learn
   * more](https://cloud.google.com/talent-solution/docs/management-tools) about self service tools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (EventServiceClient eventServiceClient = EventServiceClient.create()) {
   *   String parent =
   *       CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]").toString();
   *   ClientEvent clientEvent = ClientEvent.newBuilder().build();
   *   ClientEvent response = eventServiceClient.createClientEvent(parent, clientEvent);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the tenant under which the event is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}", for example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created, for
   *     example, "projects/foo".
   * @param clientEvent Required. Events issued when end user interacts with customer's application
   *     that uses Cloud Talent Solution.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientEvent createClientEvent(String parent, ClientEvent clientEvent) {
    CreateClientEventRequest request =
        CreateClientEventRequest.newBuilder().setParent(parent).setClientEvent(clientEvent).build();
    return createClientEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report events issued when end user interacts with customer's application that uses Cloud Talent
   * Solution. You may inspect the created events in [self service
   * tools](https://console.cloud.google.com/talent-solution/overview). [Learn
   * more](https://cloud.google.com/talent-solution/docs/management-tools) about self service tools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (EventServiceClient eventServiceClient = EventServiceClient.create()) {
   *   CreateClientEventRequest request =
   *       CreateClientEventRequest.newBuilder()
   *           .setParent(
   *               CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
   *                   .toString())
   *           .setClientEvent(ClientEvent.newBuilder().build())
   *           .build();
   *   ClientEvent response = eventServiceClient.createClientEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientEvent createClientEvent(CreateClientEventRequest request) {
    return createClientEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report events issued when end user interacts with customer's application that uses Cloud Talent
   * Solution. You may inspect the created events in [self service
   * tools](https://console.cloud.google.com/talent-solution/overview). [Learn
   * more](https://cloud.google.com/talent-solution/docs/management-tools) about self service tools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (EventServiceClient eventServiceClient = EventServiceClient.create()) {
   *   CreateClientEventRequest request =
   *       CreateClientEventRequest.newBuilder()
   *           .setParent(
   *               CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
   *                   .toString())
   *           .setClientEvent(ClientEvent.newBuilder().build())
   *           .build();
   *   ApiFuture<ClientEvent> future =
   *       eventServiceClient.createClientEventCallable().futureCall(request);
   *   // Do something.
   *   ClientEvent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClientEventRequest, ClientEvent> createClientEventCallable() {
    return stub.createClientEventCallable();
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
