package com.google.gcloud.datastore;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.gcloud.datastore.Validator.validateDataset;
import static com.google.gcloud.datastore.Validator.validateNamespace;

import com.google.api.services.datastore.client.DatastoreOptions;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.ServiceOptions;

import java.lang.reflect.Method;
import java.util.Set;

public class DatastoreServiceOptions extends ServiceOptions {

  private static final String DATASTORE_SCOPE = "https://www.googleapis.com/auth/datastore";
  private static final String USERINFO_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
  private static final Set<String> SCOPES = ImmutableSet.of(DATASTORE_SCOPE, USERINFO_SCOPE);
  private final String dataset;
  private final String namespace;
  private final boolean force;

  DatastoreServiceOptions(Builder builder) {
    super(builder);
    dataset = firstNonNull(builder.dataset, appEngineAppId());
    checkArgument(dataset != null, "missing dataset");
    namespace = builder.namespace != null ? builder.namespace : defaultNamespace();
    force = builder.force;
  }

  public static class Builder extends ServiceOptions.Builder<Builder> {

    private String dataset;
    private String namespace;
    private boolean force = false;

    private Builder() {
    }

    private Builder(DatastoreServiceOptions options) {
      super(options);
      dataset = options.dataset;
      force = options.force;
    }

    @Override
    public DatastoreServiceOptions build() {
      return new DatastoreServiceOptions(this);
    }

    public Builder dataset(String dataset) {
      this.dataset = validateDataset(dataset);
      return this;
    }

    public Builder namespace(String namespace) {
      this.namespace = validateNamespace(namespace);
      return this;
    }

    public Builder force(boolean force) {
      this.force = force;
      return this;
    }
  }

  public String dataset() {
    return dataset;
  }

  public String namespace() {
    return namespace;
  }

  private static String defaultNamespace() {
    // TODO(ozarov): An alternative to reflection would be to depend on AE api jar:
    // http://mvnrepository.com/artifact/com.google.appengine/appengine-api-1.0-sdk/1.2.0
    try {
      Class<?> clazz = Class.forName("com.google.appengine.api.NamespaceManager");
      Method method = clazz.getMethod("get");
      String namespace = (String) method.invoke(null);
      return "".equals(namespace) ? null : namespace;
    } catch (Exception ex) {
      return null;
    }
  }

  public boolean force() {
    return force;
  }

  @Override
  protected Set<String> scopes() {
    return SCOPES;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  DatastoreOptions toDatastoreOptions() {
    return new DatastoreOptions.Builder()
        .dataset(dataset())
        .host(host())
        .initializer(httpRequestInitializer())
        .build();
  }

  public static Builder builder() {
    return new Builder();
  }
}
