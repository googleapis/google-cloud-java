/*
 * Copyright 2026 Google LLC
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

package com.google.devicesandservices.health.v4.stub;

import static com.google.devicesandservices.health.v4.HealthProfileServiceClient.ListPairedDevicesPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devicesandservices.health.v4.GetIdentityRequest;
import com.google.devicesandservices.health.v4.GetIrnProfileRequest;
import com.google.devicesandservices.health.v4.GetPairedDeviceRequest;
import com.google.devicesandservices.health.v4.GetProfileRequest;
import com.google.devicesandservices.health.v4.GetSettingsRequest;
import com.google.devicesandservices.health.v4.Identity;
import com.google.devicesandservices.health.v4.IrnProfile;
import com.google.devicesandservices.health.v4.ListPairedDevicesRequest;
import com.google.devicesandservices.health.v4.ListPairedDevicesResponse;
import com.google.devicesandservices.health.v4.PairedDevice;
import com.google.devicesandservices.health.v4.Profile;
import com.google.devicesandservices.health.v4.Settings;
import com.google.devicesandservices.health.v4.UpdateProfileRequest;
import com.google.devicesandservices.health.v4.UpdateSettingsRequest;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the HealthProfileService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonHealthProfileServiceStub extends HealthProfileServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetProfileRequest, Profile> getProfileMethodDescriptor =
      ApiMethodDescriptor.<GetProfileRequest, Profile>newBuilder()
          .setFullMethodName("google.devicesandservices.health.v4.HealthProfileService/GetProfile")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProfileRequest>newBuilder()
                  .setPath(
                      "/v4/{name=users/*/profile}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetProfileRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetProfileRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Profile>newBuilder()
                  .setDefaultInstance(Profile.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateProfileRequest, Profile>
      updateProfileMethodDescriptor =
          ApiMethodDescriptor.<UpdateProfileRequest, Profile>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/UpdateProfile")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProfileRequest>newBuilder()
                      .setPath(
                          "/v4/{profile.name=users/*/profile}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "profile.name", request.getProfile().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("profile", request.getProfile(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Profile>newBuilder()
                      .setDefaultInstance(Profile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSettingsRequest, Settings>
      getSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/GetSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSettingsRequest>newBuilder()
                      .setPath(
                          "/v4/{name=users/*/settings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Settings>newBuilder()
                      .setDefaultInstance(Settings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSettingsRequest, Settings>
      updateSettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateSettingsRequest, Settings>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/UpdateSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSettingsRequest>newBuilder()
                      .setPath(
                          "/v4/{settings.name=users/*/settings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "settings.name", request.getSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("settings", request.getSettings(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Settings>newBuilder()
                      .setDefaultInstance(Settings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIdentityRequest, Identity>
      getIdentityMethodDescriptor =
          ApiMethodDescriptor.<GetIdentityRequest, Identity>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/GetIdentity")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIdentityRequest>newBuilder()
                      .setPath(
                          "/v4/{name=users/*/identity}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIdentityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIdentityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Identity>newBuilder()
                      .setDefaultInstance(Identity.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIrnProfileRequest, IrnProfile>
      getIrnProfileMethodDescriptor =
          ApiMethodDescriptor.<GetIrnProfileRequest, IrnProfile>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/GetIrnProfile")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIrnProfileRequest>newBuilder()
                      .setPath(
                          "/v4/{name=users/*/irnProfile}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIrnProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIrnProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IrnProfile>newBuilder()
                      .setDefaultInstance(IrnProfile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPairedDeviceRequest, PairedDevice>
      getPairedDeviceMethodDescriptor =
          ApiMethodDescriptor.<GetPairedDeviceRequest, PairedDevice>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/GetPairedDevice")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPairedDeviceRequest>newBuilder()
                      .setPath(
                          "/v4/{name=users/*/pairedDevices/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPairedDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPairedDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PairedDevice>newBuilder()
                      .setDefaultInstance(PairedDevice.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPairedDevicesRequest, ListPairedDevicesResponse>
      listPairedDevicesMethodDescriptor =
          ApiMethodDescriptor.<ListPairedDevicesRequest, ListPairedDevicesResponse>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/ListPairedDevices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPairedDevicesRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=users/*}/pairedDevices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPairedDevicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPairedDevicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPairedDevicesResponse>newBuilder()
                      .setDefaultInstance(ListPairedDevicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetProfileRequest, Profile> getProfileCallable;
  private final UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable;
  private final UnaryCallable<GetIdentityRequest, Identity> getIdentityCallable;
  private final UnaryCallable<GetIrnProfileRequest, IrnProfile> getIrnProfileCallable;
  private final UnaryCallable<GetPairedDeviceRequest, PairedDevice> getPairedDeviceCallable;
  private final UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesResponse>
      listPairedDevicesCallable;
  private final UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesPagedResponse>
      listPairedDevicesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHealthProfileServiceStub create(
      HealthProfileServiceStubSettings settings) throws IOException {
    return new HttpJsonHealthProfileServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHealthProfileServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHealthProfileServiceStub(
        HealthProfileServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonHealthProfileServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHealthProfileServiceStub(
        HealthProfileServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHealthProfileServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHealthProfileServiceStub(
      HealthProfileServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonHealthProfileServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHealthProfileServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHealthProfileServiceStub(
      HealthProfileServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetProfileRequest, Profile> getProfileTransportSettings =
        HttpJsonCallSettings.<GetProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(getProfileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateProfileRequest, Profile> updateProfileTransportSettings =
        HttpJsonCallSettings.<UpdateProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(updateProfileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("profile.name", String.valueOf(request.getProfile().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        HttpJsonCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateSettingsRequest, Settings> updateSettingsTransportSettings =
        HttpJsonCallSettings.<UpdateSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("settings.name", String.valueOf(request.getSettings().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIdentityRequest, Identity> getIdentityTransportSettings =
        HttpJsonCallSettings.<GetIdentityRequest, Identity>newBuilder()
            .setMethodDescriptor(getIdentityMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetIrnProfileRequest, IrnProfile> getIrnProfileTransportSettings =
        HttpJsonCallSettings.<GetIrnProfileRequest, IrnProfile>newBuilder()
            .setMethodDescriptor(getIrnProfileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetPairedDeviceRequest, PairedDevice> getPairedDeviceTransportSettings =
        HttpJsonCallSettings.<GetPairedDeviceRequest, PairedDevice>newBuilder()
            .setMethodDescriptor(getPairedDeviceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListPairedDevicesRequest, ListPairedDevicesResponse>
        listPairedDevicesTransportSettings =
            HttpJsonCallSettings.<ListPairedDevicesRequest, ListPairedDevicesResponse>newBuilder()
                .setMethodDescriptor(listPairedDevicesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getProfileCallable =
        callableFactory.createUnaryCallable(
            getProfileTransportSettings, settings.getProfileSettings(), clientContext);
    this.updateProfileCallable =
        callableFactory.createUnaryCallable(
            updateProfileTransportSettings, settings.updateProfileSettings(), clientContext);
    this.getSettingsCallable =
        callableFactory.createUnaryCallable(
            getSettingsTransportSettings, settings.getSettingsSettings(), clientContext);
    this.updateSettingsCallable =
        callableFactory.createUnaryCallable(
            updateSettingsTransportSettings, settings.updateSettingsSettings(), clientContext);
    this.getIdentityCallable =
        callableFactory.createUnaryCallable(
            getIdentityTransportSettings, settings.getIdentitySettings(), clientContext);
    this.getIrnProfileCallable =
        callableFactory.createUnaryCallable(
            getIrnProfileTransportSettings, settings.getIrnProfileSettings(), clientContext);
    this.getPairedDeviceCallable =
        callableFactory.createUnaryCallable(
            getPairedDeviceTransportSettings, settings.getPairedDeviceSettings(), clientContext);
    this.listPairedDevicesCallable =
        callableFactory.createUnaryCallable(
            listPairedDevicesTransportSettings,
            settings.listPairedDevicesSettings(),
            clientContext);
    this.listPairedDevicesPagedCallable =
        callableFactory.createPagedCallable(
            listPairedDevicesTransportSettings,
            settings.listPairedDevicesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getProfileMethodDescriptor);
    methodDescriptors.add(updateProfileMethodDescriptor);
    methodDescriptors.add(getSettingsMethodDescriptor);
    methodDescriptors.add(updateSettingsMethodDescriptor);
    methodDescriptors.add(getIdentityMethodDescriptor);
    methodDescriptors.add(getIrnProfileMethodDescriptor);
    methodDescriptors.add(getPairedDeviceMethodDescriptor);
    methodDescriptors.add(listPairedDevicesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetProfileRequest, Profile> getProfileCallable() {
    return getProfileCallable;
  }

  @Override
  public UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable() {
    return updateProfileCallable;
  }

  @Override
  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return getSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    return updateSettingsCallable;
  }

  @Override
  public UnaryCallable<GetIdentityRequest, Identity> getIdentityCallable() {
    return getIdentityCallable;
  }

  @Override
  public UnaryCallable<GetIrnProfileRequest, IrnProfile> getIrnProfileCallable() {
    return getIrnProfileCallable;
  }

  @Override
  public UnaryCallable<GetPairedDeviceRequest, PairedDevice> getPairedDeviceCallable() {
    return getPairedDeviceCallable;
  }

  @Override
  public UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesResponse>
      listPairedDevicesCallable() {
    return listPairedDevicesCallable;
  }

  @Override
  public UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesPagedResponse>
      listPairedDevicesPagedCallable() {
    return listPairedDevicesPagedCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
