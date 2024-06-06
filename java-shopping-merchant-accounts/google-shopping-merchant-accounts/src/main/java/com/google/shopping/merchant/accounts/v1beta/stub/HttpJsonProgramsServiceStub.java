/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.ProgramsServiceClient.ListProgramsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest;
import com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest;
import com.google.shopping.merchant.accounts.v1beta.GetProgramRequest;
import com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse;
import com.google.shopping.merchant.accounts.v1beta.Program;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ProgramsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonProgramsServiceStub extends ProgramsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetProgramRequest, Program> getProgramMethodDescriptor =
      ApiMethodDescriptor.<GetProgramRequest, Program>newBuilder()
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.ProgramsService/GetProgram")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProgramRequest>newBuilder()
                  .setPath(
                      "/accounts/v1beta/{name=accounts/*/programs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetProgramRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetProgramRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Program>newBuilder()
                  .setDefaultInstance(Program.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListProgramsRequest, ListProgramsResponse>
      listProgramsMethodDescriptor =
          ApiMethodDescriptor.<ListProgramsRequest, ListProgramsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.ProgramsService/ListPrograms")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProgramsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*}/programs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProgramsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProgramsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProgramsResponse>newBuilder()
                      .setDefaultInstance(ListProgramsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EnableProgramRequest, Program>
      enableProgramMethodDescriptor =
          ApiMethodDescriptor.<EnableProgramRequest, Program>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.ProgramsService/EnableProgram")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableProgramRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/programs/*}:enable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnableProgramRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnableProgramRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Program>newBuilder()
                      .setDefaultInstance(Program.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DisableProgramRequest, Program>
      disableProgramMethodDescriptor =
          ApiMethodDescriptor.<DisableProgramRequest, Program>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.ProgramsService/DisableProgram")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableProgramRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/programs/*}:disable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisableProgramRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisableProgramRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Program>newBuilder()
                      .setDefaultInstance(Program.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetProgramRequest, Program> getProgramCallable;
  private final UnaryCallable<ListProgramsRequest, ListProgramsResponse> listProgramsCallable;
  private final UnaryCallable<ListProgramsRequest, ListProgramsPagedResponse>
      listProgramsPagedCallable;
  private final UnaryCallable<EnableProgramRequest, Program> enableProgramCallable;
  private final UnaryCallable<DisableProgramRequest, Program> disableProgramCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProgramsServiceStub create(ProgramsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonProgramsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProgramsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonProgramsServiceStub(
        ProgramsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonProgramsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProgramsServiceStub(
        ProgramsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProgramsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProgramsServiceStub(
      ProgramsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonProgramsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProgramsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProgramsServiceStub(
      ProgramsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetProgramRequest, Program> getProgramTransportSettings =
        HttpJsonCallSettings.<GetProgramRequest, Program>newBuilder()
            .setMethodDescriptor(getProgramMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListProgramsRequest, ListProgramsResponse> listProgramsTransportSettings =
        HttpJsonCallSettings.<ListProgramsRequest, ListProgramsResponse>newBuilder()
            .setMethodDescriptor(listProgramsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EnableProgramRequest, Program> enableProgramTransportSettings =
        HttpJsonCallSettings.<EnableProgramRequest, Program>newBuilder()
            .setMethodDescriptor(enableProgramMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DisableProgramRequest, Program> disableProgramTransportSettings =
        HttpJsonCallSettings.<DisableProgramRequest, Program>newBuilder()
            .setMethodDescriptor(disableProgramMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getProgramCallable =
        callableFactory.createUnaryCallable(
            getProgramTransportSettings, settings.getProgramSettings(), clientContext);
    this.listProgramsCallable =
        callableFactory.createUnaryCallable(
            listProgramsTransportSettings, settings.listProgramsSettings(), clientContext);
    this.listProgramsPagedCallable =
        callableFactory.createPagedCallable(
            listProgramsTransportSettings, settings.listProgramsSettings(), clientContext);
    this.enableProgramCallable =
        callableFactory.createUnaryCallable(
            enableProgramTransportSettings, settings.enableProgramSettings(), clientContext);
    this.disableProgramCallable =
        callableFactory.createUnaryCallable(
            disableProgramTransportSettings, settings.disableProgramSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getProgramMethodDescriptor);
    methodDescriptors.add(listProgramsMethodDescriptor);
    methodDescriptors.add(enableProgramMethodDescriptor);
    methodDescriptors.add(disableProgramMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetProgramRequest, Program> getProgramCallable() {
    return getProgramCallable;
  }

  @Override
  public UnaryCallable<ListProgramsRequest, ListProgramsResponse> listProgramsCallable() {
    return listProgramsCallable;
  }

  @Override
  public UnaryCallable<ListProgramsRequest, ListProgramsPagedResponse> listProgramsPagedCallable() {
    return listProgramsPagedCallable;
  }

  @Override
  public UnaryCallable<EnableProgramRequest, Program> enableProgramCallable() {
    return enableProgramCallable;
  }

  @Override
  public UnaryCallable<DisableProgramRequest, Program> disableProgramCallable() {
    return disableProgramCallable;
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
