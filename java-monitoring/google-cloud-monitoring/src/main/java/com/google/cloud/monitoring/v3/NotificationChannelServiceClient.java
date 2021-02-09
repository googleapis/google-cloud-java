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

package com.google.cloud.monitoring.v3;

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
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.monitoring.v3.stub.NotificationChannelServiceStub;
import com.google.cloud.monitoring.v3.stub.NotificationChannelServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.monitoring.v3.CreateNotificationChannelRequest;
import com.google.monitoring.v3.DeleteNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelDescriptorRequest;
import com.google.monitoring.v3.GetNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse;
import com.google.monitoring.v3.ListNotificationChannelsRequest;
import com.google.monitoring.v3.ListNotificationChannelsResponse;
import com.google.monitoring.v3.NotificationChannel;
import com.google.monitoring.v3.NotificationChannelDescriptor;
import com.google.monitoring.v3.NotificationChannelDescriptorName;
import com.google.monitoring.v3.NotificationChannelName;
import com.google.monitoring.v3.OrganizationName;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.UpdateNotificationChannelRequest;
import com.google.monitoring.v3.VerifyNotificationChannelRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Notification Channel API provides access to configuration that controls
 * how messages related to incidents are sent.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (NotificationChannelServiceClient notificationChannelServiceClient =
 *     NotificationChannelServiceClient.create()) {
 *   NotificationChannelDescriptorName name =
 *       NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
 *           "[PROJECT]", "[CHANNEL_DESCRIPTOR]");
 *   NotificationChannelDescriptor response =
 *       notificationChannelServiceClient.getNotificationChannelDescriptor(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NotificationChannelServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * NotificationChannelServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * NotificationChannelServiceSettings notificationChannelServiceSettings =
 *     NotificationChannelServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NotificationChannelServiceClient notificationChannelServiceClient =
 *     NotificationChannelServiceClient.create(notificationChannelServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * NotificationChannelServiceSettings notificationChannelServiceSettings =
 *     NotificationChannelServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NotificationChannelServiceClient notificationChannelServiceClient =
 *     NotificationChannelServiceClient.create(notificationChannelServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NotificationChannelServiceClient implements BackgroundResource {
  private final NotificationChannelServiceSettings settings;
  private final NotificationChannelServiceStub stub;

  /** Constructs an instance of NotificationChannelServiceClient with default settings. */
  public static final NotificationChannelServiceClient create() throws IOException {
    return create(NotificationChannelServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NotificationChannelServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final NotificationChannelServiceClient create(
      NotificationChannelServiceSettings settings) throws IOException {
    return new NotificationChannelServiceClient(settings);
  }

  /**
   * Constructs an instance of NotificationChannelServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(NotificationChannelServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final NotificationChannelServiceClient create(NotificationChannelServiceStub stub) {
    return new NotificationChannelServiceClient(stub);
  }

  /**
   * Constructs an instance of NotificationChannelServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected NotificationChannelServiceClient(NotificationChannelServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((NotificationChannelServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NotificationChannelServiceClient(NotificationChannelServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NotificationChannelServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NotificationChannelServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the descriptors for supported channel types. The use of descriptors makes it possible for
   * new channel types to be dynamically added.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   ResourceName name = ResourceName.of("[FOLDER]");
   *   for (NotificationChannelDescriptor element :
   *       notificationChannelServiceClient.listNotificationChannelDescriptors(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The REST resource name of the parent from which to retrieve the
   *     notification channel descriptors. The expected syntax is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>Note that this names the parent container in which to look for the descriptors; to
   *     retrieve a single descriptor by name, use the
   *     [GetNotificationChannelDescriptor][google.monitoring.v3.NotificationChannelService.GetNotificationChannelDescriptor]
   *     operation, instead.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationChannelDescriptorsPagedResponse listNotificationChannelDescriptors(
      ResourceName name) {
    ListNotificationChannelDescriptorsRequest request =
        ListNotificationChannelDescriptorsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listNotificationChannelDescriptors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the descriptors for supported channel types. The use of descriptors makes it possible for
   * new channel types to be dynamically added.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   OrganizationName name = OrganizationName.of("[ORGANIZATION]");
   *   for (NotificationChannelDescriptor element :
   *       notificationChannelServiceClient.listNotificationChannelDescriptors(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The REST resource name of the parent from which to retrieve the
   *     notification channel descriptors. The expected syntax is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>Note that this names the parent container in which to look for the descriptors; to
   *     retrieve a single descriptor by name, use the
   *     [GetNotificationChannelDescriptor][google.monitoring.v3.NotificationChannelService.GetNotificationChannelDescriptor]
   *     operation, instead.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationChannelDescriptorsPagedResponse listNotificationChannelDescriptors(
      OrganizationName name) {
    ListNotificationChannelDescriptorsRequest request =
        ListNotificationChannelDescriptorsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listNotificationChannelDescriptors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the descriptors for supported channel types. The use of descriptors makes it possible for
   * new channel types to be dynamically added.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   for (NotificationChannelDescriptor element :
   *       notificationChannelServiceClient.listNotificationChannelDescriptors(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The REST resource name of the parent from which to retrieve the
   *     notification channel descriptors. The expected syntax is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>Note that this names the parent container in which to look for the descriptors; to
   *     retrieve a single descriptor by name, use the
   *     [GetNotificationChannelDescriptor][google.monitoring.v3.NotificationChannelService.GetNotificationChannelDescriptor]
   *     operation, instead.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationChannelDescriptorsPagedResponse listNotificationChannelDescriptors(
      ProjectName name) {
    ListNotificationChannelDescriptorsRequest request =
        ListNotificationChannelDescriptorsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listNotificationChannelDescriptors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the descriptors for supported channel types. The use of descriptors makes it possible for
   * new channel types to be dynamically added.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   String name =
   *       NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
   *               "[PROJECT]", "[CHANNEL_DESCRIPTOR]")
   *           .toString();
   *   for (NotificationChannelDescriptor element :
   *       notificationChannelServiceClient.listNotificationChannelDescriptors(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The REST resource name of the parent from which to retrieve the
   *     notification channel descriptors. The expected syntax is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>Note that this names the parent container in which to look for the descriptors; to
   *     retrieve a single descriptor by name, use the
   *     [GetNotificationChannelDescriptor][google.monitoring.v3.NotificationChannelService.GetNotificationChannelDescriptor]
   *     operation, instead.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationChannelDescriptorsPagedResponse listNotificationChannelDescriptors(
      String name) {
    ListNotificationChannelDescriptorsRequest request =
        ListNotificationChannelDescriptorsRequest.newBuilder().setName(name).build();
    return listNotificationChannelDescriptors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the descriptors for supported channel types. The use of descriptors makes it possible for
   * new channel types to be dynamically added.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   ListNotificationChannelDescriptorsRequest request =
   *       ListNotificationChannelDescriptorsRequest.newBuilder()
   *           .setName(
   *               NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
   *                       "[PROJECT]", "[CHANNEL_DESCRIPTOR]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (NotificationChannelDescriptor element :
   *       notificationChannelServiceClient
   *           .listNotificationChannelDescriptors(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationChannelDescriptorsPagedResponse listNotificationChannelDescriptors(
      ListNotificationChannelDescriptorsRequest request) {
    return listNotificationChannelDescriptorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the descriptors for supported channel types. The use of descriptors makes it possible for
   * new channel types to be dynamically added.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   ListNotificationChannelDescriptorsRequest request =
   *       ListNotificationChannelDescriptorsRequest.newBuilder()
   *           .setName(
   *               NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
   *                       "[PROJECT]", "[CHANNEL_DESCRIPTOR]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<NotificationChannelDescriptor> future =
   *       notificationChannelServiceClient
   *           .listNotificationChannelDescriptorsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (NotificationChannelDescriptor element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsPagedResponse>
      listNotificationChannelDescriptorsPagedCallable() {
    return stub.listNotificationChannelDescriptorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the descriptors for supported channel types. The use of descriptors makes it possible for
   * new channel types to be dynamically added.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   while (true) {
   *     ListNotificationChannelDescriptorsResponse response =
   *         notificationChannelServiceClient
   *             .listNotificationChannelDescriptorsCallable()
   *             .call(request);
   *     for (NotificationChannelDescriptor element : response.getResponsesList()) {
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
  public final UnaryCallable<
          ListNotificationChannelDescriptorsRequest, ListNotificationChannelDescriptorsResponse>
      listNotificationChannelDescriptorsCallable() {
    return stub.listNotificationChannelDescriptorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single channel descriptor. The descriptor indicates which fields are expected /
   * permitted for a notification channel of the given type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   NotificationChannelDescriptorName name =
   *       NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
   *           "[PROJECT]", "[CHANNEL_DESCRIPTOR]");
   *   NotificationChannelDescriptor response =
   *       notificationChannelServiceClient.getNotificationChannelDescriptor(name);
   * }
   * }</pre>
   *
   * @param name Required. The channel type for which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/notificationChannelDescriptors/[CHANNEL_TYPE]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannelDescriptor getNotificationChannelDescriptor(
      NotificationChannelDescriptorName name) {
    GetNotificationChannelDescriptorRequest request =
        GetNotificationChannelDescriptorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getNotificationChannelDescriptor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single channel descriptor. The descriptor indicates which fields are expected /
   * permitted for a notification channel of the given type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   String name =
   *       NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
   *               "[PROJECT]", "[CHANNEL_DESCRIPTOR]")
   *           .toString();
   *   NotificationChannelDescriptor response =
   *       notificationChannelServiceClient.getNotificationChannelDescriptor(name);
   * }
   * }</pre>
   *
   * @param name Required. The channel type for which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/notificationChannelDescriptors/[CHANNEL_TYPE]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannelDescriptor getNotificationChannelDescriptor(String name) {
    GetNotificationChannelDescriptorRequest request =
        GetNotificationChannelDescriptorRequest.newBuilder().setName(name).build();
    return getNotificationChannelDescriptor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single channel descriptor. The descriptor indicates which fields are expected /
   * permitted for a notification channel of the given type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   GetNotificationChannelDescriptorRequest request =
   *       GetNotificationChannelDescriptorRequest.newBuilder()
   *           .setName(
   *               NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
   *                       "[PROJECT]", "[CHANNEL_DESCRIPTOR]")
   *                   .toString())
   *           .build();
   *   NotificationChannelDescriptor response =
   *       notificationChannelServiceClient.getNotificationChannelDescriptor(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannelDescriptor getNotificationChannelDescriptor(
      GetNotificationChannelDescriptorRequest request) {
    return getNotificationChannelDescriptorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single channel descriptor. The descriptor indicates which fields are expected /
   * permitted for a notification channel of the given type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   GetNotificationChannelDescriptorRequest request =
   *       GetNotificationChannelDescriptorRequest.newBuilder()
   *           .setName(
   *               NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
   *                       "[PROJECT]", "[CHANNEL_DESCRIPTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<NotificationChannelDescriptor> future =
   *       notificationChannelServiceClient
   *           .getNotificationChannelDescriptorCallable()
   *           .futureCall(request);
   *   // Do something.
   *   NotificationChannelDescriptor response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
      getNotificationChannelDescriptorCallable() {
    return stub.getNotificationChannelDescriptorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the notification channels that have been created for the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   ResourceName name = ResourceName.of("[FOLDER]");
   *   for (NotificationChannel element :
   *       notificationChannelServiceClient.listNotificationChannels(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The project on which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>This names the container in which to look for the notification channels; it does not
   *     name a specific channel. To query a specific channel by REST resource name, use the
   *     [`GetNotificationChannel`][google.monitoring.v3.NotificationChannelService.GetNotificationChannel]
   *     operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationChannelsPagedResponse listNotificationChannels(ResourceName name) {
    ListNotificationChannelsRequest request =
        ListNotificationChannelsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listNotificationChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the notification channels that have been created for the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   OrganizationName name = OrganizationName.of("[ORGANIZATION]");
   *   for (NotificationChannel element :
   *       notificationChannelServiceClient.listNotificationChannels(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The project on which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>This names the container in which to look for the notification channels; it does not
   *     name a specific channel. To query a specific channel by REST resource name, use the
   *     [`GetNotificationChannel`][google.monitoring.v3.NotificationChannelService.GetNotificationChannel]
   *     operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationChannelsPagedResponse listNotificationChannels(
      OrganizationName name) {
    ListNotificationChannelsRequest request =
        ListNotificationChannelsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listNotificationChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the notification channels that have been created for the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   for (NotificationChannel element :
   *       notificationChannelServiceClient.listNotificationChannels(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The project on which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>This names the container in which to look for the notification channels; it does not
   *     name a specific channel. To query a specific channel by REST resource name, use the
   *     [`GetNotificationChannel`][google.monitoring.v3.NotificationChannelService.GetNotificationChannel]
   *     operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationChannelsPagedResponse listNotificationChannels(ProjectName name) {
    ListNotificationChannelsRequest request =
        ListNotificationChannelsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listNotificationChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the notification channels that have been created for the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   String name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *               "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *           .toString();
   *   for (NotificationChannel element :
   *       notificationChannelServiceClient.listNotificationChannels(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The project on which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>This names the container in which to look for the notification channels; it does not
   *     name a specific channel. To query a specific channel by REST resource name, use the
   *     [`GetNotificationChannel`][google.monitoring.v3.NotificationChannelService.GetNotificationChannel]
   *     operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationChannelsPagedResponse listNotificationChannels(String name) {
    ListNotificationChannelsRequest request =
        ListNotificationChannelsRequest.newBuilder().setName(name).build();
    return listNotificationChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the notification channels that have been created for the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   ListNotificationChannelsRequest request =
   *       ListNotificationChannelsRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (NotificationChannel element :
   *       notificationChannelServiceClient.listNotificationChannels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationChannelsPagedResponse listNotificationChannels(
      ListNotificationChannelsRequest request) {
    return listNotificationChannelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the notification channels that have been created for the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   ListNotificationChannelsRequest request =
   *       ListNotificationChannelsRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<NotificationChannel> future =
   *       notificationChannelServiceClient
   *           .listNotificationChannelsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (NotificationChannel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNotificationChannelsRequest, ListNotificationChannelsPagedResponse>
      listNotificationChannelsPagedCallable() {
    return stub.listNotificationChannelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the notification channels that have been created for the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   while (true) {
   *     ListNotificationChannelsResponse response =
   *         notificationChannelServiceClient.listNotificationChannelsCallable().call(request);
   *     for (NotificationChannel element : response.getResponsesList()) {
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
  public final UnaryCallable<ListNotificationChannelsRequest, ListNotificationChannelsResponse>
      listNotificationChannelsCallable() {
    return stub.listNotificationChannelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single notification channel. The channel includes the relevant configuration details
   * with which the channel was created. However, the response may truncate or omit passwords, API
   * keys, or other private key matter and thus the response may not be 100% identical to the
   * information that was supplied in the call to the create method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   NotificationChannelName name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *           "[PROJECT]", "[NOTIFICATION_CHANNEL]");
   *   NotificationChannel response = notificationChannelServiceClient.getNotificationChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. The channel for which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/notificationChannels/[CHANNEL_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel getNotificationChannel(NotificationChannelName name) {
    GetNotificationChannelRequest request =
        GetNotificationChannelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single notification channel. The channel includes the relevant configuration details
   * with which the channel was created. However, the response may truncate or omit passwords, API
   * keys, or other private key matter and thus the response may not be 100% identical to the
   * information that was supplied in the call to the create method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   String name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *               "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *           .toString();
   *   NotificationChannel response = notificationChannelServiceClient.getNotificationChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. The channel for which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/notificationChannels/[CHANNEL_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel getNotificationChannel(String name) {
    GetNotificationChannelRequest request =
        GetNotificationChannelRequest.newBuilder().setName(name).build();
    return getNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single notification channel. The channel includes the relevant configuration details
   * with which the channel was created. However, the response may truncate or omit passwords, API
   * keys, or other private key matter and thus the response may not be 100% identical to the
   * information that was supplied in the call to the create method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   GetNotificationChannelRequest request =
   *       GetNotificationChannelRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .build();
   *   NotificationChannel response =
   *       notificationChannelServiceClient.getNotificationChannel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel getNotificationChannel(GetNotificationChannelRequest request) {
    return getNotificationChannelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single notification channel. The channel includes the relevant configuration details
   * with which the channel was created. However, the response may truncate or omit passwords, API
   * keys, or other private key matter and thus the response may not be 100% identical to the
   * information that was supplied in the call to the create method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   GetNotificationChannelRequest request =
   *       GetNotificationChannelRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<NotificationChannel> future =
   *       notificationChannelServiceClient.getNotificationChannelCallable().futureCall(request);
   *   // Do something.
   *   NotificationChannel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNotificationChannelRequest, NotificationChannel>
      getNotificationChannelCallable() {
    return stub.getNotificationChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new notification channel, representing a single notification endpoint such as an
   * email address, SMS number, or PagerDuty service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   ResourceName name = ResourceName.of("[FOLDER]");
   *   NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();
   *   NotificationChannel response =
   *       notificationChannelServiceClient.createNotificationChannel(name, notificationChannel);
   * }
   * }</pre>
   *
   * @param name Required. The project on which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>This names the container into which the channel will be written, this does not name the
   *     newly created channel. The resulting channel's name will have a normalized version of this
   *     field as a prefix, but will add `/notificationChannels/[CHANNEL_ID]` to identify the
   *     channel.
   * @param notificationChannel Required. The definition of the `NotificationChannel` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel createNotificationChannel(
      ResourceName name, NotificationChannel notificationChannel) {
    CreateNotificationChannelRequest request =
        CreateNotificationChannelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNotificationChannel(notificationChannel)
            .build();
    return createNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new notification channel, representing a single notification endpoint such as an
   * email address, SMS number, or PagerDuty service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   OrganizationName name = OrganizationName.of("[ORGANIZATION]");
   *   NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();
   *   NotificationChannel response =
   *       notificationChannelServiceClient.createNotificationChannel(name, notificationChannel);
   * }
   * }</pre>
   *
   * @param name Required. The project on which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>This names the container into which the channel will be written, this does not name the
   *     newly created channel. The resulting channel's name will have a normalized version of this
   *     field as a prefix, but will add `/notificationChannels/[CHANNEL_ID]` to identify the
   *     channel.
   * @param notificationChannel Required. The definition of the `NotificationChannel` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel createNotificationChannel(
      OrganizationName name, NotificationChannel notificationChannel) {
    CreateNotificationChannelRequest request =
        CreateNotificationChannelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNotificationChannel(notificationChannel)
            .build();
    return createNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new notification channel, representing a single notification endpoint such as an
   * email address, SMS number, or PagerDuty service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();
   *   NotificationChannel response =
   *       notificationChannelServiceClient.createNotificationChannel(name, notificationChannel);
   * }
   * }</pre>
   *
   * @param name Required. The project on which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>This names the container into which the channel will be written, this does not name the
   *     newly created channel. The resulting channel's name will have a normalized version of this
   *     field as a prefix, but will add `/notificationChannels/[CHANNEL_ID]` to identify the
   *     channel.
   * @param notificationChannel Required. The definition of the `NotificationChannel` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel createNotificationChannel(
      ProjectName name, NotificationChannel notificationChannel) {
    CreateNotificationChannelRequest request =
        CreateNotificationChannelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNotificationChannel(notificationChannel)
            .build();
    return createNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new notification channel, representing a single notification endpoint such as an
   * email address, SMS number, or PagerDuty service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   String name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *               "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *           .toString();
   *   NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();
   *   NotificationChannel response =
   *       notificationChannelServiceClient.createNotificationChannel(name, notificationChannel);
   * }
   * }</pre>
   *
   * @param name Required. The project on which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   *     <p>This names the container into which the channel will be written, this does not name the
   *     newly created channel. The resulting channel's name will have a normalized version of this
   *     field as a prefix, but will add `/notificationChannels/[CHANNEL_ID]` to identify the
   *     channel.
   * @param notificationChannel Required. The definition of the `NotificationChannel` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel createNotificationChannel(
      String name, NotificationChannel notificationChannel) {
    CreateNotificationChannelRequest request =
        CreateNotificationChannelRequest.newBuilder()
            .setName(name)
            .setNotificationChannel(notificationChannel)
            .build();
    return createNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new notification channel, representing a single notification endpoint such as an
   * email address, SMS number, or PagerDuty service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   CreateNotificationChannelRequest request =
   *       CreateNotificationChannelRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .setNotificationChannel(NotificationChannel.newBuilder().build())
   *           .build();
   *   NotificationChannel response =
   *       notificationChannelServiceClient.createNotificationChannel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel createNotificationChannel(
      CreateNotificationChannelRequest request) {
    return createNotificationChannelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new notification channel, representing a single notification endpoint such as an
   * email address, SMS number, or PagerDuty service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   CreateNotificationChannelRequest request =
   *       CreateNotificationChannelRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .setNotificationChannel(NotificationChannel.newBuilder().build())
   *           .build();
   *   ApiFuture<NotificationChannel> future =
   *       notificationChannelServiceClient.createNotificationChannelCallable().futureCall(request);
   *   // Do something.
   *   NotificationChannel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNotificationChannelRequest, NotificationChannel>
      createNotificationChannelCallable() {
    return stub.createNotificationChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a notification channel. Fields not specified in the field mask remain unchanged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   NotificationChannel notificationChannel = NotificationChannel.newBuilder().build();
   *   NotificationChannel response =
   *       notificationChannelServiceClient.updateNotificationChannel(
   *           updateMask, notificationChannel);
   * }
   * }</pre>
   *
   * @param updateMask The fields to update.
   * @param notificationChannel Required. A description of the changes to be applied to the
   *     specified notification channel. The description must provide a definition for fields to be
   *     updated; the names of these fields should also be included in the `update_mask`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel updateNotificationChannel(
      FieldMask updateMask, NotificationChannel notificationChannel) {
    UpdateNotificationChannelRequest request =
        UpdateNotificationChannelRequest.newBuilder()
            .setUpdateMask(updateMask)
            .setNotificationChannel(notificationChannel)
            .build();
    return updateNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a notification channel. Fields not specified in the field mask remain unchanged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   UpdateNotificationChannelRequest request =
   *       UpdateNotificationChannelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setNotificationChannel(NotificationChannel.newBuilder().build())
   *           .build();
   *   NotificationChannel response =
   *       notificationChannelServiceClient.updateNotificationChannel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel updateNotificationChannel(
      UpdateNotificationChannelRequest request) {
    return updateNotificationChannelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a notification channel. Fields not specified in the field mask remain unchanged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   UpdateNotificationChannelRequest request =
   *       UpdateNotificationChannelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setNotificationChannel(NotificationChannel.newBuilder().build())
   *           .build();
   *   ApiFuture<NotificationChannel> future =
   *       notificationChannelServiceClient.updateNotificationChannelCallable().futureCall(request);
   *   // Do something.
   *   NotificationChannel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNotificationChannelRequest, NotificationChannel>
      updateNotificationChannelCallable() {
    return stub.updateNotificationChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   NotificationChannelName name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *           "[PROJECT]", "[NOTIFICATION_CHANNEL]");
   *   boolean force = true;
   *   notificationChannelServiceClient.deleteNotificationChannel(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The channel for which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/notificationChannels/[CHANNEL_ID]
   * @param force If true, the notification channel will be deleted regardless of its use in alert
   *     policies (the policies will be updated to remove the channel). If false, channels that are
   *     still referenced by an existing alerting policy will fail to be deleted in a delete
   *     operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotificationChannel(NotificationChannelName name, boolean force) {
    DeleteNotificationChannelRequest request =
        DeleteNotificationChannelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setForce(force)
            .build();
    deleteNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   String name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *               "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *           .toString();
   *   boolean force = true;
   *   notificationChannelServiceClient.deleteNotificationChannel(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The channel for which to execute the request. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/notificationChannels/[CHANNEL_ID]
   * @param force If true, the notification channel will be deleted regardless of its use in alert
   *     policies (the policies will be updated to remove the channel). If false, channels that are
   *     still referenced by an existing alerting policy will fail to be deleted in a delete
   *     operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotificationChannel(String name, boolean force) {
    DeleteNotificationChannelRequest request =
        DeleteNotificationChannelRequest.newBuilder().setName(name).setForce(force).build();
    deleteNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   DeleteNotificationChannelRequest request =
   *       DeleteNotificationChannelRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   notificationChannelServiceClient.deleteNotificationChannel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotificationChannel(DeleteNotificationChannelRequest request) {
    deleteNotificationChannelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   DeleteNotificationChannelRequest request =
   *       DeleteNotificationChannelRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       notificationChannelServiceClient.deleteNotificationChannelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNotificationChannelRequest, Empty>
      deleteNotificationChannelCallable() {
    return stub.deleteNotificationChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Causes a verification code to be delivered to the channel. The code can then be supplied in
   * `VerifyNotificationChannel` to verify the channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   NotificationChannelName name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *           "[PROJECT]", "[NOTIFICATION_CHANNEL]");
   *   notificationChannelServiceClient.sendNotificationChannelVerificationCode(name);
   * }
   * }</pre>
   *
   * @param name Required. The notification channel to which to send a verification code.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void sendNotificationChannelVerificationCode(NotificationChannelName name) {
    SendNotificationChannelVerificationCodeRequest request =
        SendNotificationChannelVerificationCodeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    sendNotificationChannelVerificationCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Causes a verification code to be delivered to the channel. The code can then be supplied in
   * `VerifyNotificationChannel` to verify the channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   String name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *               "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *           .toString();
   *   notificationChannelServiceClient.sendNotificationChannelVerificationCode(name);
   * }
   * }</pre>
   *
   * @param name Required. The notification channel to which to send a verification code.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void sendNotificationChannelVerificationCode(String name) {
    SendNotificationChannelVerificationCodeRequest request =
        SendNotificationChannelVerificationCodeRequest.newBuilder().setName(name).build();
    sendNotificationChannelVerificationCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Causes a verification code to be delivered to the channel. The code can then be supplied in
   * `VerifyNotificationChannel` to verify the channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   SendNotificationChannelVerificationCodeRequest request =
   *       SendNotificationChannelVerificationCodeRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .build();
   *   notificationChannelServiceClient.sendNotificationChannelVerificationCode(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void sendNotificationChannelVerificationCode(
      SendNotificationChannelVerificationCodeRequest request) {
    sendNotificationChannelVerificationCodeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Causes a verification code to be delivered to the channel. The code can then be supplied in
   * `VerifyNotificationChannel` to verify the channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   SendNotificationChannelVerificationCodeRequest request =
   *       SendNotificationChannelVerificationCodeRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       notificationChannelServiceClient
   *           .sendNotificationChannelVerificationCodeCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SendNotificationChannelVerificationCodeRequest, Empty>
      sendNotificationChannelVerificationCodeCallable() {
    return stub.sendNotificationChannelVerificationCodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests a verification code for an already verified channel that can then be used in a call to
   * VerifyNotificationChannel() on a different channel with an equivalent identity in the same or
   * in a different project. This makes it possible to copy a channel between projects without
   * requiring manual reverification of the channel. If the channel is not in the verified state,
   * this method will fail (in other words, this may only be used if the
   * SendNotificationChannelVerificationCode and VerifyNotificationChannel paths have already been
   * used to put the given channel into the verified state).
   *
   * <p>There is no guarantee that the verification codes returned by this method will be of a
   * similar structure or form as the ones that are delivered to the channel via
   * SendNotificationChannelVerificationCode; while VerifyNotificationChannel() will recognize both
   * the codes delivered via SendNotificationChannelVerificationCode() and returned from
   * GetNotificationChannelVerificationCode(), it is typically the case that the verification codes
   * delivered via SendNotificationChannelVerificationCode() will be shorter and also have a shorter
   * expiration (e.g. codes such as "G-123456") whereas GetVerificationCode() will typically return
   * a much longer, websafe base 64 encoded string that has a longer expiration time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   NotificationChannelName name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *           "[PROJECT]", "[NOTIFICATION_CHANNEL]");
   *   GetNotificationChannelVerificationCodeResponse response =
   *       notificationChannelServiceClient.getNotificationChannelVerificationCode(name);
   * }
   * }</pre>
   *
   * @param name Required. The notification channel for which a verification code is to be generated
   *     and retrieved. This must name a channel that is already verified; if the specified channel
   *     is not verified, the request will fail.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetNotificationChannelVerificationCodeResponse
      getNotificationChannelVerificationCode(NotificationChannelName name) {
    GetNotificationChannelVerificationCodeRequest request =
        GetNotificationChannelVerificationCodeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getNotificationChannelVerificationCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests a verification code for an already verified channel that can then be used in a call to
   * VerifyNotificationChannel() on a different channel with an equivalent identity in the same or
   * in a different project. This makes it possible to copy a channel between projects without
   * requiring manual reverification of the channel. If the channel is not in the verified state,
   * this method will fail (in other words, this may only be used if the
   * SendNotificationChannelVerificationCode and VerifyNotificationChannel paths have already been
   * used to put the given channel into the verified state).
   *
   * <p>There is no guarantee that the verification codes returned by this method will be of a
   * similar structure or form as the ones that are delivered to the channel via
   * SendNotificationChannelVerificationCode; while VerifyNotificationChannel() will recognize both
   * the codes delivered via SendNotificationChannelVerificationCode() and returned from
   * GetNotificationChannelVerificationCode(), it is typically the case that the verification codes
   * delivered via SendNotificationChannelVerificationCode() will be shorter and also have a shorter
   * expiration (e.g. codes such as "G-123456") whereas GetVerificationCode() will typically return
   * a much longer, websafe base 64 encoded string that has a longer expiration time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   String name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *               "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *           .toString();
   *   GetNotificationChannelVerificationCodeResponse response =
   *       notificationChannelServiceClient.getNotificationChannelVerificationCode(name);
   * }
   * }</pre>
   *
   * @param name Required. The notification channel for which a verification code is to be generated
   *     and retrieved. This must name a channel that is already verified; if the specified channel
   *     is not verified, the request will fail.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetNotificationChannelVerificationCodeResponse
      getNotificationChannelVerificationCode(String name) {
    GetNotificationChannelVerificationCodeRequest request =
        GetNotificationChannelVerificationCodeRequest.newBuilder().setName(name).build();
    return getNotificationChannelVerificationCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests a verification code for an already verified channel that can then be used in a call to
   * VerifyNotificationChannel() on a different channel with an equivalent identity in the same or
   * in a different project. This makes it possible to copy a channel between projects without
   * requiring manual reverification of the channel. If the channel is not in the verified state,
   * this method will fail (in other words, this may only be used if the
   * SendNotificationChannelVerificationCode and VerifyNotificationChannel paths have already been
   * used to put the given channel into the verified state).
   *
   * <p>There is no guarantee that the verification codes returned by this method will be of a
   * similar structure or form as the ones that are delivered to the channel via
   * SendNotificationChannelVerificationCode; while VerifyNotificationChannel() will recognize both
   * the codes delivered via SendNotificationChannelVerificationCode() and returned from
   * GetNotificationChannelVerificationCode(), it is typically the case that the verification codes
   * delivered via SendNotificationChannelVerificationCode() will be shorter and also have a shorter
   * expiration (e.g. codes such as "G-123456") whereas GetVerificationCode() will typically return
   * a much longer, websafe base 64 encoded string that has a longer expiration time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   GetNotificationChannelVerificationCodeRequest request =
   *       GetNotificationChannelVerificationCodeRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .setExpireTime(Timestamp.newBuilder().build())
   *           .build();
   *   GetNotificationChannelVerificationCodeResponse response =
   *       notificationChannelServiceClient.getNotificationChannelVerificationCode(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetNotificationChannelVerificationCodeResponse
      getNotificationChannelVerificationCode(
          GetNotificationChannelVerificationCodeRequest request) {
    return getNotificationChannelVerificationCodeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests a verification code for an already verified channel that can then be used in a call to
   * VerifyNotificationChannel() on a different channel with an equivalent identity in the same or
   * in a different project. This makes it possible to copy a channel between projects without
   * requiring manual reverification of the channel. If the channel is not in the verified state,
   * this method will fail (in other words, this may only be used if the
   * SendNotificationChannelVerificationCode and VerifyNotificationChannel paths have already been
   * used to put the given channel into the verified state).
   *
   * <p>There is no guarantee that the verification codes returned by this method will be of a
   * similar structure or form as the ones that are delivered to the channel via
   * SendNotificationChannelVerificationCode; while VerifyNotificationChannel() will recognize both
   * the codes delivered via SendNotificationChannelVerificationCode() and returned from
   * GetNotificationChannelVerificationCode(), it is typically the case that the verification codes
   * delivered via SendNotificationChannelVerificationCode() will be shorter and also have a shorter
   * expiration (e.g. codes such as "G-123456") whereas GetVerificationCode() will typically return
   * a much longer, websafe base 64 encoded string that has a longer expiration time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   GetNotificationChannelVerificationCodeRequest request =
   *       GetNotificationChannelVerificationCodeRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .setExpireTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<GetNotificationChannelVerificationCodeResponse> future =
   *       notificationChannelServiceClient
   *           .getNotificationChannelVerificationCodeCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GetNotificationChannelVerificationCodeResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetNotificationChannelVerificationCodeRequest,
          GetNotificationChannelVerificationCodeResponse>
      getNotificationChannelVerificationCodeCallable() {
    return stub.getNotificationChannelVerificationCodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verifies a `NotificationChannel` by proving receipt of the code delivered to the channel as a
   * result of calling `SendNotificationChannelVerificationCode`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   NotificationChannelName name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *           "[PROJECT]", "[NOTIFICATION_CHANNEL]");
   *   String code = "code3059181";
   *   NotificationChannel response =
   *       notificationChannelServiceClient.verifyNotificationChannel(name, code);
   * }
   * }</pre>
   *
   * @param name Required. The notification channel to verify.
   * @param code Required. The verification code that was delivered to the channel as a result of
   *     invoking the `SendNotificationChannelVerificationCode` API method or that was retrieved
   *     from a verified channel via `GetNotificationChannelVerificationCode`. For example, one
   *     might have "G-123456" or "TKNZGhhd2EyN3I1MnRnMjRv" (in general, one is only guaranteed that
   *     the code is valid UTF-8; one should not make any assumptions regarding the structure or
   *     format of the code).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel verifyNotificationChannel(
      NotificationChannelName name, String code) {
    VerifyNotificationChannelRequest request =
        VerifyNotificationChannelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCode(code)
            .build();
    return verifyNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verifies a `NotificationChannel` by proving receipt of the code delivered to the channel as a
   * result of calling `SendNotificationChannelVerificationCode`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   String name =
   *       NotificationChannelName.ofProjectNotificationChannelName(
   *               "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *           .toString();
   *   String code = "code3059181";
   *   NotificationChannel response =
   *       notificationChannelServiceClient.verifyNotificationChannel(name, code);
   * }
   * }</pre>
   *
   * @param name Required. The notification channel to verify.
   * @param code Required. The verification code that was delivered to the channel as a result of
   *     invoking the `SendNotificationChannelVerificationCode` API method or that was retrieved
   *     from a verified channel via `GetNotificationChannelVerificationCode`. For example, one
   *     might have "G-123456" or "TKNZGhhd2EyN3I1MnRnMjRv" (in general, one is only guaranteed that
   *     the code is valid UTF-8; one should not make any assumptions regarding the structure or
   *     format of the code).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel verifyNotificationChannel(String name, String code) {
    VerifyNotificationChannelRequest request =
        VerifyNotificationChannelRequest.newBuilder().setName(name).setCode(code).build();
    return verifyNotificationChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verifies a `NotificationChannel` by proving receipt of the code delivered to the channel as a
   * result of calling `SendNotificationChannelVerificationCode`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   VerifyNotificationChannelRequest request =
   *       VerifyNotificationChannelRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .setCode("code3059181")
   *           .build();
   *   NotificationChannel response =
   *       notificationChannelServiceClient.verifyNotificationChannel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationChannel verifyNotificationChannel(
      VerifyNotificationChannelRequest request) {
    return verifyNotificationChannelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verifies a `NotificationChannel` by proving receipt of the code delivered to the channel as a
   * result of calling `SendNotificationChannelVerificationCode`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (NotificationChannelServiceClient notificationChannelServiceClient =
   *     NotificationChannelServiceClient.create()) {
   *   VerifyNotificationChannelRequest request =
   *       VerifyNotificationChannelRequest.newBuilder()
   *           .setName(
   *               NotificationChannelName.ofProjectNotificationChannelName(
   *                       "[PROJECT]", "[NOTIFICATION_CHANNEL]")
   *                   .toString())
   *           .setCode("code3059181")
   *           .build();
   *   ApiFuture<NotificationChannel> future =
   *       notificationChannelServiceClient.verifyNotificationChannelCallable().futureCall(request);
   *   // Do something.
   *   NotificationChannel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<VerifyNotificationChannelRequest, NotificationChannel>
      verifyNotificationChannelCallable() {
    return stub.verifyNotificationChannelCallable();
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

  public static class ListNotificationChannelDescriptorsPagedResponse
      extends AbstractPagedListResponse<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsResponse,
          NotificationChannelDescriptor,
          ListNotificationChannelDescriptorsPage,
          ListNotificationChannelDescriptorsFixedSizeCollection> {

    public static ApiFuture<ListNotificationChannelDescriptorsPagedResponse> createAsync(
        PageContext<
                ListNotificationChannelDescriptorsRequest,
                ListNotificationChannelDescriptorsResponse,
                NotificationChannelDescriptor>
            context,
        ApiFuture<ListNotificationChannelDescriptorsResponse> futureResponse) {
      ApiFuture<ListNotificationChannelDescriptorsPage> futurePage =
          ListNotificationChannelDescriptorsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListNotificationChannelDescriptorsPage,
              ListNotificationChannelDescriptorsPagedResponse>() {
            @Override
            public ListNotificationChannelDescriptorsPagedResponse apply(
                ListNotificationChannelDescriptorsPage input) {
              return new ListNotificationChannelDescriptorsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListNotificationChannelDescriptorsPagedResponse(
        ListNotificationChannelDescriptorsPage page) {
      super(page, ListNotificationChannelDescriptorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNotificationChannelDescriptorsPage
      extends AbstractPage<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsResponse,
          NotificationChannelDescriptor,
          ListNotificationChannelDescriptorsPage> {

    private ListNotificationChannelDescriptorsPage(
        PageContext<
                ListNotificationChannelDescriptorsRequest,
                ListNotificationChannelDescriptorsResponse,
                NotificationChannelDescriptor>
            context,
        ListNotificationChannelDescriptorsResponse response) {
      super(context, response);
    }

    private static ListNotificationChannelDescriptorsPage createEmptyPage() {
      return new ListNotificationChannelDescriptorsPage(null, null);
    }

    @Override
    protected ListNotificationChannelDescriptorsPage createPage(
        PageContext<
                ListNotificationChannelDescriptorsRequest,
                ListNotificationChannelDescriptorsResponse,
                NotificationChannelDescriptor>
            context,
        ListNotificationChannelDescriptorsResponse response) {
      return new ListNotificationChannelDescriptorsPage(context, response);
    }

    @Override
    public ApiFuture<ListNotificationChannelDescriptorsPage> createPageAsync(
        PageContext<
                ListNotificationChannelDescriptorsRequest,
                ListNotificationChannelDescriptorsResponse,
                NotificationChannelDescriptor>
            context,
        ApiFuture<ListNotificationChannelDescriptorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNotificationChannelDescriptorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsResponse,
          NotificationChannelDescriptor,
          ListNotificationChannelDescriptorsPage,
          ListNotificationChannelDescriptorsFixedSizeCollection> {

    private ListNotificationChannelDescriptorsFixedSizeCollection(
        List<ListNotificationChannelDescriptorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNotificationChannelDescriptorsFixedSizeCollection createEmptyCollection() {
      return new ListNotificationChannelDescriptorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNotificationChannelDescriptorsFixedSizeCollection createCollection(
        List<ListNotificationChannelDescriptorsPage> pages, int collectionSize) {
      return new ListNotificationChannelDescriptorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNotificationChannelsPagedResponse
      extends AbstractPagedListResponse<
          ListNotificationChannelsRequest,
          ListNotificationChannelsResponse,
          NotificationChannel,
          ListNotificationChannelsPage,
          ListNotificationChannelsFixedSizeCollection> {

    public static ApiFuture<ListNotificationChannelsPagedResponse> createAsync(
        PageContext<
                ListNotificationChannelsRequest,
                ListNotificationChannelsResponse,
                NotificationChannel>
            context,
        ApiFuture<ListNotificationChannelsResponse> futureResponse) {
      ApiFuture<ListNotificationChannelsPage> futurePage =
          ListNotificationChannelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListNotificationChannelsPage, ListNotificationChannelsPagedResponse>() {
            @Override
            public ListNotificationChannelsPagedResponse apply(ListNotificationChannelsPage input) {
              return new ListNotificationChannelsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListNotificationChannelsPagedResponse(ListNotificationChannelsPage page) {
      super(page, ListNotificationChannelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNotificationChannelsPage
      extends AbstractPage<
          ListNotificationChannelsRequest,
          ListNotificationChannelsResponse,
          NotificationChannel,
          ListNotificationChannelsPage> {

    private ListNotificationChannelsPage(
        PageContext<
                ListNotificationChannelsRequest,
                ListNotificationChannelsResponse,
                NotificationChannel>
            context,
        ListNotificationChannelsResponse response) {
      super(context, response);
    }

    private static ListNotificationChannelsPage createEmptyPage() {
      return new ListNotificationChannelsPage(null, null);
    }

    @Override
    protected ListNotificationChannelsPage createPage(
        PageContext<
                ListNotificationChannelsRequest,
                ListNotificationChannelsResponse,
                NotificationChannel>
            context,
        ListNotificationChannelsResponse response) {
      return new ListNotificationChannelsPage(context, response);
    }

    @Override
    public ApiFuture<ListNotificationChannelsPage> createPageAsync(
        PageContext<
                ListNotificationChannelsRequest,
                ListNotificationChannelsResponse,
                NotificationChannel>
            context,
        ApiFuture<ListNotificationChannelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNotificationChannelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNotificationChannelsRequest,
          ListNotificationChannelsResponse,
          NotificationChannel,
          ListNotificationChannelsPage,
          ListNotificationChannelsFixedSizeCollection> {

    private ListNotificationChannelsFixedSizeCollection(
        List<ListNotificationChannelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNotificationChannelsFixedSizeCollection createEmptyCollection() {
      return new ListNotificationChannelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNotificationChannelsFixedSizeCollection createCollection(
        List<ListNotificationChannelsPage> pages, int collectionSize) {
      return new ListNotificationChannelsFixedSizeCollection(pages, collectionSize);
    }
  }
}
