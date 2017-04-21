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

import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.cloud.datastore.spi.DatastoreRpcFactory;
import com.google.cloud.datastore.spi.v1.HttpDatastoreRpc;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;

public class DatastoreOptions
    extends ServiceOptions<Datastore, DatastoreOptions> {

  private static final long serialVersionUID = -1018382430058137336L;
  private static final String API_SHORT_NAME = "Datastore";
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
    public ServiceRpc create(DatastoreOptions options) {
      return new HttpDatastoreRpc(options);
    }
  }

  public static class Builder extends
      ServiceOptions.Builder<Datastore, DatastoreOptions, Builder> {

    private String namespace;

    private Builder() {
    }

    private Builder(DatastoreOptions options) {
      super(options);
      namespace = options.namespace;
    }

    @Override
    public Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof HttpTransportOptions)) {
        throw new IllegalArgumentException(
            "Only http transport is allowed for " + API_SHORT_NAME + ".");
      }
      return super.setTransportOptions(transportOptions);
    }

    @Override
    public DatastoreOptions build() {
      return new DatastoreOptions(this);
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
    super(DatastoreFactory.class, DatastoreRpcFactory.class, builder, new DatastoreDefaults());
    namespace = builder.namespace != null ? builder.namespace : defaultNamespace();
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

  private static class DatastoreDefaults implements
      ServiceDefaults<Datastore, DatastoreOptions> {

    @Override
    public DatastoreFactory getDefaultServiceFactory() {
      return DefaultDatastoreFactory.INSTANCE;
    }

    @Override
    public DatastoreRpcFactory getDefaultRpcFactory() {
      return DefaultDatastoreRpcFactory.INSTANCE;
    }

    @Override
    public TransportOptions getDefaultTransportOptions() {
      return getDefaultHttpTransportOptions();
    }
  }

  public static HttpTransportOptions getDefaultHttpTransportOptions() {
    return HttpTransportOptions.newBuilder().build();
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

  protected DatastoreRpc getDatastoreRpcV1() {
    return (DatastoreRpc) getRpc();
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


  public static Builder newBuilder() {
    return new Builder();
  }
}
