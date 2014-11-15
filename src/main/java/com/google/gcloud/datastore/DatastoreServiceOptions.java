package com.google.gcloud.datastore;

import com.google.common.collect.ImmutableSet;
import com.google.gcloud.ServiceOptions;

import java.util.Set;

public class DatastoreServiceOptions extends ServiceOptions {

  private static final String DATASTORE_SCOPE = "https://www.googleapis.com/auth/datastore";
  private static final String USERINFO_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
  private static final Set<String> SCOPES = ImmutableSet.of(DATASTORE_SCOPE, USERINFO_SCOPE);

  private final String dataset;

  DatastoreServiceOptions(Builder builder) {
    super(builder);
    dataset = builder.dataset;
  }

  public static class Builder extends ServiceOptions.Builder {

    private String dataset;

    public Builder() {}

    public Builder(DatastoreServiceOptions options) {
      super(options);
      dataset = options.dataset;
    }

    @Override
    public DatastoreServiceOptions build() {
      return new DatastoreServiceOptions(this);
    }

    public Builder setDataset(String dataset) {
      this.dataset = dataset;
      return this;
    }
  }

  public String getDataset() {
    return dataset;
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }
}
