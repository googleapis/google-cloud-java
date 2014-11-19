package com.google.gcloud.datastore;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.ServiceOptions;

import java.util.Set;
import java.util.regex.Pattern;

public class DatastoreServiceOptions extends ServiceOptions {

  private static final String DATASTORE_SCOPE = "https://www.googleapis.com/auth/datastore";
  private static final String USERINFO_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
  private static final Set<String> SCOPES = ImmutableSet.of(DATASTORE_SCOPE, USERINFO_SCOPE);
  private static final Pattern PATTERN = Pattern.compile(
      "([a-z\\d\\-]{1,100}~)?([a-z\\d][a-z\\d\\-\\.]{0,99}\\:)?([a-z\\d][a-z\\d\\-]{0,99})");
  private final String dataset;

  DatastoreServiceOptions(Builder builder) {
    super(builder);
    dataset = firstNonNull(builder.dataset, getAppEngineAppId());
    checkArgument(dataset != null, "missing dataset");
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
      this.dataset = validateDataset(dataset);
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

  public String getDataset() {
    return dataset;
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }
}
