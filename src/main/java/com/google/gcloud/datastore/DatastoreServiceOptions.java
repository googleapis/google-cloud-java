package com.google.gcloud.datastore;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.datastore.client.DatastoreOptions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.ServiceOptions;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.regex.Pattern;

public class DatastoreServiceOptions extends ServiceOptions {

  private static final String DATASTORE_SCOPE = "https://www.googleapis.com/auth/datastore";
  private static final String USERINFO_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
  private static final Set<String> SCOPES = ImmutableSet.of(DATASTORE_SCOPE, USERINFO_SCOPE);
  private static final Pattern PATTERN = Pattern.compile(
      "([a-z\\d\\-]{1,100}~)?([a-z\\d][a-z\\d\\-\\.]{0,99}\\:)?([a-z\\d][a-z\\d\\-]{0,99})");

  private final String dataset;
  private final boolean force;

  DatastoreServiceOptions(Builder builder) {
    super(builder);
    dataset = firstNonNull(builder.dataset, getAppEngineAppId());
    checkArgument(dataset != null, "missing dataset");
    force = builder.force;
  }

  public static class Builder extends ServiceOptions.Builder<Builder> {

    private String dataset;
    private boolean force = false;

    public Builder() {}

    public Builder(DatastoreServiceOptions options) {
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

    public Builder force(boolean force) {
      this.force = force;
      return this;
    }
  }

  static String validateDataset(String dataset) {
    if (Strings.isNullOrEmpty(dataset)) {
      throw new IllegalArgumentException("dataset can't be empty or null");
    }
    if (!PATTERN.matcher(dataset).matches()) {
      throw new IllegalArgumentException(
          "dataset must match the following pattern: " + PATTERN.pattern());
    }
    return dataset;
  }

  public String dataset() {
    return dataset;
  }

  public String defaultNamespace() {
    // TODO(ozarov): An alternative to reflection would be to depend on AE api jar:
    // http://mvnrepository.com/artifact/com.google.appengine/appengine-api-1.0-sdk/1.2.0
    try {
      Class<?> clazz = Class.forName("com.google.appengine.api.NamespaceManager");
      Method method = clazz.getMethod("get");
      return (String) method.invoke(null);
    } catch (Exception ex) {
      return "";
    }
  }

  public boolean force() {
    return force;
  }

  @Override
  protected Set<String> scopes() {
    return SCOPES;
  }

  DatastoreOptions toDatastoreOptions() {
    return new DatastoreOptions.Builder()
        .dataset(dataset())
        .host(host())
        .initializer(httpRequestInitializer())
        .build();
  }
}
