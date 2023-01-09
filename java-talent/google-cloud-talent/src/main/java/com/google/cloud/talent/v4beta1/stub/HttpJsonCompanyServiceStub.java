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

package com.google.cloud.talent.v4beta1.stub;

import static com.google.cloud.talent.v4beta1.CompanyServiceClient.ListCompaniesPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4beta1.Company;
import com.google.cloud.talent.v4beta1.CreateCompanyRequest;
import com.google.cloud.talent.v4beta1.DeleteCompanyRequest;
import com.google.cloud.talent.v4beta1.GetCompanyRequest;
import com.google.cloud.talent.v4beta1.ListCompaniesRequest;
import com.google.cloud.talent.v4beta1.ListCompaniesResponse;
import com.google.cloud.talent.v4beta1.UpdateCompanyRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CompanyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCompanyServiceStub extends CompanyServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateCompanyRequest, Company>
      createCompanyMethodDescriptor =
          ApiMethodDescriptor.<CreateCompanyRequest, Company>newBuilder()
              .setFullMethodName("google.cloud.talent.v4beta1.CompanyService/CreateCompany")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCompanyRequest>newBuilder()
                      .setPath(
                          "/v4beta1/{parent=projects/*/tenants/*}/companies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCompanyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v4beta1/{parent=projects/*}/companies")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCompanyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Company>newBuilder()
                      .setDefaultInstance(Company.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCompanyRequest, Company> getCompanyMethodDescriptor =
      ApiMethodDescriptor.<GetCompanyRequest, Company>newBuilder()
          .setFullMethodName("google.cloud.talent.v4beta1.CompanyService/GetCompany")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetCompanyRequest>newBuilder()
                  .setPath(
                      "/v4beta1/{name=projects/*/tenants/*/companies/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetCompanyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths("/v4beta1/{name=projects/*/companies/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetCompanyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Company>newBuilder()
                  .setDefaultInstance(Company.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateCompanyRequest, Company>
      updateCompanyMethodDescriptor =
          ApiMethodDescriptor.<UpdateCompanyRequest, Company>newBuilder()
              .setFullMethodName("google.cloud.talent.v4beta1.CompanyService/UpdateCompany")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCompanyRequest>newBuilder()
                      .setPath(
                          "/v4beta1/{company.name=projects/*/tenants/*/companies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCompanyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "company.name", request.getCompany().getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v4beta1/{company.name=projects/*/companies/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCompanyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Company>newBuilder()
                      .setDefaultInstance(Company.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCompanyRequest, Empty>
      deleteCompanyMethodDescriptor =
          ApiMethodDescriptor.<DeleteCompanyRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.talent.v4beta1.CompanyService/DeleteCompany")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCompanyRequest>newBuilder()
                      .setPath(
                          "/v4beta1/{name=projects/*/tenants/*/companies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCompanyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v4beta1/{name=projects/*/companies/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCompanyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCompaniesRequest, ListCompaniesResponse>
      listCompaniesMethodDescriptor =
          ApiMethodDescriptor.<ListCompaniesRequest, ListCompaniesResponse>newBuilder()
              .setFullMethodName("google.cloud.talent.v4beta1.CompanyService/ListCompanies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCompaniesRequest>newBuilder()
                      .setPath(
                          "/v4beta1/{parent=projects/*/tenants/*}/companies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCompaniesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v4beta1/{parent=projects/*}/companies")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCompaniesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "requireOpenJobs", request.getRequireOpenJobs());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCompaniesResponse>newBuilder()
                      .setDefaultInstance(ListCompaniesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateCompanyRequest, Company> createCompanyCallable;
  private final UnaryCallable<GetCompanyRequest, Company> getCompanyCallable;
  private final UnaryCallable<UpdateCompanyRequest, Company> updateCompanyCallable;
  private final UnaryCallable<DeleteCompanyRequest, Empty> deleteCompanyCallable;
  private final UnaryCallable<ListCompaniesRequest, ListCompaniesResponse> listCompaniesCallable;
  private final UnaryCallable<ListCompaniesRequest, ListCompaniesPagedResponse>
      listCompaniesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCompanyServiceStub create(CompanyServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCompanyServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCompanyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCompanyServiceStub(
        CompanyServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCompanyServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCompanyServiceStub(
        CompanyServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCompanyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCompanyServiceStub(
      CompanyServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCompanyServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCompanyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCompanyServiceStub(
      CompanyServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateCompanyRequest, Company> createCompanyTransportSettings =
        HttpJsonCallSettings.<CreateCompanyRequest, Company>newBuilder()
            .setMethodDescriptor(createCompanyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetCompanyRequest, Company> getCompanyTransportSettings =
        HttpJsonCallSettings.<GetCompanyRequest, Company>newBuilder()
            .setMethodDescriptor(getCompanyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateCompanyRequest, Company> updateCompanyTransportSettings =
        HttpJsonCallSettings.<UpdateCompanyRequest, Company>newBuilder()
            .setMethodDescriptor(updateCompanyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteCompanyRequest, Empty> deleteCompanyTransportSettings =
        HttpJsonCallSettings.<DeleteCompanyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCompanyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListCompaniesRequest, ListCompaniesResponse>
        listCompaniesTransportSettings =
            HttpJsonCallSettings.<ListCompaniesRequest, ListCompaniesResponse>newBuilder()
                .setMethodDescriptor(listCompaniesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createCompanyCallable =
        callableFactory.createUnaryCallable(
            createCompanyTransportSettings, settings.createCompanySettings(), clientContext);
    this.getCompanyCallable =
        callableFactory.createUnaryCallable(
            getCompanyTransportSettings, settings.getCompanySettings(), clientContext);
    this.updateCompanyCallable =
        callableFactory.createUnaryCallable(
            updateCompanyTransportSettings, settings.updateCompanySettings(), clientContext);
    this.deleteCompanyCallable =
        callableFactory.createUnaryCallable(
            deleteCompanyTransportSettings, settings.deleteCompanySettings(), clientContext);
    this.listCompaniesCallable =
        callableFactory.createUnaryCallable(
            listCompaniesTransportSettings, settings.listCompaniesSettings(), clientContext);
    this.listCompaniesPagedCallable =
        callableFactory.createPagedCallable(
            listCompaniesTransportSettings, settings.listCompaniesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createCompanyMethodDescriptor);
    methodDescriptors.add(getCompanyMethodDescriptor);
    methodDescriptors.add(updateCompanyMethodDescriptor);
    methodDescriptors.add(deleteCompanyMethodDescriptor);
    methodDescriptors.add(listCompaniesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateCompanyRequest, Company> createCompanyCallable() {
    return createCompanyCallable;
  }

  @Override
  public UnaryCallable<GetCompanyRequest, Company> getCompanyCallable() {
    return getCompanyCallable;
  }

  @Override
  public UnaryCallable<UpdateCompanyRequest, Company> updateCompanyCallable() {
    return updateCompanyCallable;
  }

  @Override
  public UnaryCallable<DeleteCompanyRequest, Empty> deleteCompanyCallable() {
    return deleteCompanyCallable;
  }

  @Override
  public UnaryCallable<ListCompaniesRequest, ListCompaniesResponse> listCompaniesCallable() {
    return listCompaniesCallable;
  }

  @Override
  public UnaryCallable<ListCompaniesRequest, ListCompaniesPagedResponse>
      listCompaniesPagedCallable() {
    return listCompaniesPagedCallable;
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
