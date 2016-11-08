/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore;

import static com.google.cloud.datastore.Validator.validateNamespace;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.cloud.HttpServiceOptions;
import com.google.cloud.datastore.spi.DatastoreRpc;
import com.google.cloud.datastore.spi.DatastoreRpcFactory;
import com.google.cloud.datastore.spi.DefaultDatastoreRpc;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;

public class DatastoreOptions
    extends HttpServiceOptions<Datastore, DatastoreRpc, DatastoreOptions> {

  private static final long serialVersionUID = -1018382430058137336L;
  private static final String DATASTORE_SCOPE = "https://www.googleapis.com/auth/datastore";
  private static final Set<String> SCOPES = ImmutableSet.of(DATASTORE_SCOPE);

  private final String namespace;

  public static class DefaultDatastoreFactory implements DatastoreFactory {

    private static final DatastoreFactory INSTANCE = new DefaultDatastoreFactory();

    @Override
    public Datastore create(DatastoreOptions options) {
      return new DatastoreImpl(options);
    }
  }

  public static class DefaultDatastoreRpcFactory implements DatastoreRpcFactory {

    private static final DatastoreRpcFactory INSTANCE = new DefaultDatastoreRpcFactory();

    @Override
    public DatastoreRpc create(DatastoreOptions options) {
      return new DefaultDatastoreRpc(options);
    }
  }

  public static class Builder extends
      HttpServiceOptions.Builder<Datastore, DatastoreRpc, DatastoreOptions, Builder> {

    private String namespace;

    private Builder() {
    }

    private Builder(DatastoreOptions options) {
      super(options);
      namespace = options.namespace;
    }

    @Override
    public DatastoreOptions build() {
      return new DatastoreOptions(this);
    }

    /**
     * Sets the default namespace to be used by the datastore service.
     */
    @Deprecated
    public Builder namespace(String namespace) {
      return setNamespace(namespace);
    }

    /**
     * Sets the default namespace to be used by the datastore service.
     */
    public Builder setNamespace(String namespace) {
      this.namespace = validateNamespace(namespace);
      return this;
    }
  }

  private DatastoreOptions(Builder builder) {
    super(DatastoreFactory.class, DatastoreRpcFactory.class, builder);
    namespace = builder.namespace != null ? builder.namespace : defaultNamespace();
  }

  @Override
  public HttpRequestInitializer getHttpRequestInitializer() {
    final HttpRequestInitializer delegate = super.getHttpRequestInitializer();
    return new HttpRequestInitializer() {
      @Override
      public void initialize(HttpRequest httpRequest) throws IOException {
        delegate.initialize(httpRequest);
        httpRequest.getHeaders().setUserAgent(getApplicationName());
      }
    };
  }

  @Override
  protected String getDefaultHost() {
    String host = System.getProperty(
        com.google.datastore.v1.client.DatastoreHelper.LOCAL_HOST_ENV_VAR,
        System.getenv(com.google.datastore.v1.client.DatastoreHelper.LOCAL_HOST_ENV_VAR));
    return host != null ? host : com.google.datastore.v1.client.DatastoreFactory.DEFAULT_HOST;
  }

  @Override
  protected String getDefaultProject() {
    String projectId = System.getProperty(
        com.google.datastore.v1.client.DatastoreHelper.PROJECT_ID_ENV_VAR,
        System.getenv(com.google.datastore.v1.client.DatastoreHelper.PROJECT_ID_ENV_VAR));
    return projectId != null ? projectId : super.getDefaultProject();
  }

  @Override
  protected DatastoreFactory getDefaultServiceFactory() {
    return DefaultDatastoreFactory.INSTANCE;
  }

  @Override
  protected DatastoreRpcFactory getDefaultRpcFactory() {
    return DefaultDatastoreRpcFactory.INSTANCE;
  }

  /**
   * Returns the default namespace to be used by the datastore service.
   */
  @Deprecated
  public String namespace() {
    return getNamespace();
  }

  /**
   * Returns the default namespace to be used by the datastore service.
   */
  public String getNamespace() {
    return namespace;
  }

  /**
   * Returns a default {@code DatastoreOptions} instance.
   */
  @Deprecated
  public static DatastoreOptions defaultInstance() {
    return getDefaultInstance();
  }

  /**
   * Returns a default {@code DatastoreOptions} instance.
   */
  public static DatastoreOptions getDefaultInstance() {
    return newBuilder().build();
  }

  private static String defaultNamespace() {
    try {
      Class<?> clazz = Class.forName("com.google.appengine.api.NamespaceManager");
      Method method = clazz.getMethod("get");
      String namespace = (String) method.invoke(null);
      return MoreObjects.firstNonNull(namespace, "");
    } catch (Exception ignore) {
      // return empty string (Datastore default namespace) if could not automatically determine
      return "";
    }
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), namespace);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof DatastoreOptions)) {
      return false;
    }
    DatastoreOptions other = (DatastoreOptions) obj;
    return baseEquals(other) && Objects.equals(namespace, other.namespace);
  }

  @Deprecated
  public static Builder builder() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
