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

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import com.google.cloud.ServiceOptions;
import com.google.cloud.datastore.spi.DatastoreRpc;
import com.google.cloud.datastore.spi.DatastoreRpcFactory;
import com.google.cloud.datastore.spi.DefaultDatastoreRpc;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;

public class DatastoreOptions extends ServiceOptions<Datastore, DatastoreRpc, DatastoreOptions> {

  private static final long serialVersionUID = 5056049000758143852L;
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
      ServiceOptions.Builder<Datastore, DatastoreRpc, DatastoreOptions, Builder> {

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

    public Builder namespace(String namespace) {
      this.namespace = validateNamespace(namespace);
      return this;
    }
  }

  private DatastoreOptions(Builder builder) {
    super(DatastoreFactory.class, DatastoreRpcFactory.class, builder);
    namespace = builder.namespace != null ? builder.namespace : defaultNamespace();
  }

  @Override
  protected String defaultHost() {
    String host = System.getProperty(
        com.google.datastore.v1beta3.client.DatastoreHelper.LOCAL_HOST_ENV_VAR,
        System.getenv(com.google.datastore.v1beta3.client.DatastoreHelper.LOCAL_HOST_ENV_VAR));
    return host != null ? host : com.google.datastore.v1beta3.client.DatastoreFactory.DEFAULT_HOST;
  }

  @Override
  protected String defaultProject() {
    String projectId = System.getProperty(
        com.google.datastore.v1beta3.client.DatastoreHelper.PROJECT_ID_ENV_VAR,
        System.getenv(com.google.datastore.v1beta3.client.DatastoreHelper.PROJECT_ID_ENV_VAR));
    return projectId != null ? projectId : super.defaultProject();
  }

  @Override
  protected DatastoreFactory defaultServiceFactory() {
    return DefaultDatastoreFactory.INSTANCE;
  }

  @Override
  protected DatastoreRpcFactory defaultRpcFactory() {
    return DefaultDatastoreRpcFactory.INSTANCE;
  }

  public String namespace() {
    return namespace;
  }

  /**
   * Returns a default {@code DatastoreOptions} instance.
   */
  public static DatastoreOptions defaultInstance() {
    return builder().build();
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
  protected Set<String> scopes() {
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

  public static Builder builder() {
    return new Builder();
  }
}
