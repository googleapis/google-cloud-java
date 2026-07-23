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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.ThirdPartyCompanyServiceClient.ListThirdPartyCompaniesPagedResponse;

import com.google.ads.admanager.v1.GetThirdPartyCompanyRequest;
import com.google.ads.admanager.v1.ListThirdPartyCompaniesRequest;
import com.google.ads.admanager.v1.ListThirdPartyCompaniesResponse;
import com.google.ads.admanager.v1.ThirdPartyCompany;
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
 * REST stub implementation for the ThirdPartyCompanyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonThirdPartyCompanyServiceStub extends ThirdPartyCompanyServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetThirdPartyCompanyRequest, ThirdPartyCompany>
      getThirdPartyCompanyMethodDescriptor =
          ApiMethodDescriptor.<GetThirdPartyCompanyRequest, ThirdPartyCompany>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ThirdPartyCompanyService/GetThirdPartyCompany")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetThirdPartyCompanyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/thirdPartyCompanies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetThirdPartyCompanyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetThirdPartyCompanyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ThirdPartyCompany>newBuilder()
                      .setDefaultInstance(ThirdPartyCompany.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse>
      listThirdPartyCompaniesMethodDescriptor =
          ApiMethodDescriptor
              .<ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ThirdPartyCompanyService/ListThirdPartyCompanies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListThirdPartyCompaniesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/thirdPartyCompanies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListThirdPartyCompaniesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListThirdPartyCompaniesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListThirdPartyCompaniesResponse>newBuilder()
                      .setDefaultInstance(ListThirdPartyCompaniesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetThirdPartyCompanyRequest, ThirdPartyCompany>
      getThirdPartyCompanyCallable;
  private final UnaryCallable<ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse>
      listThirdPartyCompaniesCallable;
  private final UnaryCallable<ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesPagedResponse>
      listThirdPartyCompaniesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonThirdPartyCompanyServiceStub create(
      ThirdPartyCompanyServiceStubSettings settings) throws IOException {
    return new HttpJsonThirdPartyCompanyServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonThirdPartyCompanyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonThirdPartyCompanyServiceStub(
        ThirdPartyCompanyServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonThirdPartyCompanyServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonThirdPartyCompanyServiceStub(
        ThirdPartyCompanyServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonThirdPartyCompanyServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonThirdPartyCompanyServiceStub(
      ThirdPartyCompanyServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonThirdPartyCompanyServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonThirdPartyCompanyServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonThirdPartyCompanyServiceStub(
      ThirdPartyCompanyServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetThirdPartyCompanyRequest, ThirdPartyCompany>
        getThirdPartyCompanyTransportSettings =
            HttpJsonCallSettings.<GetThirdPartyCompanyRequest, ThirdPartyCompany>newBuilder()
                .setMethodDescriptor(getThirdPartyCompanyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse>
        listThirdPartyCompaniesTransportSettings =
            HttpJsonCallSettings
                .<ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse>newBuilder()
                .setMethodDescriptor(listThirdPartyCompaniesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getThirdPartyCompanyCallable =
        callableFactory.createUnaryCallable(
            getThirdPartyCompanyTransportSettings,
            settings.getThirdPartyCompanySettings(),
            clientContext);
    this.listThirdPartyCompaniesCallable =
        callableFactory.createUnaryCallable(
            listThirdPartyCompaniesTransportSettings,
            settings.listThirdPartyCompaniesSettings(),
            clientContext);
    this.listThirdPartyCompaniesPagedCallable =
        callableFactory.createPagedCallable(
            listThirdPartyCompaniesTransportSettings,
            settings.listThirdPartyCompaniesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getThirdPartyCompanyMethodDescriptor);
    methodDescriptors.add(listThirdPartyCompaniesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetThirdPartyCompanyRequest, ThirdPartyCompany>
      getThirdPartyCompanyCallable() {
    return getThirdPartyCompanyCallable;
  }

  @Override
  public UnaryCallable<ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse>
      listThirdPartyCompaniesCallable() {
    return listThirdPartyCompaniesCallable;
  }

  @Override
  public UnaryCallable<ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesPagedResponse>
      listThirdPartyCompaniesPagedCallable() {
    return listThirdPartyCompaniesPagedCallable;
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
