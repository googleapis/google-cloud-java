package com.google.gcloud.storage;

import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.storage.Storage;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.ServiceOptions;

import java.lang.reflect.Method;
import java.util.Set;

public class StorageServiceOptions extends ServiceOptions {

  private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
  private static final Set<String> SCOPES = ImmutableSet.of(GCS_SCOPE);
  private static final String DEFAULT_PATH_DELIMITER = "/";

  private final String project;
  private final String pathDelimiter;

  StorageServiceOptions(Builder builder) {
    super(builder);
    pathDelimiter = MoreObjects.firstNonNull(builder.pathDelimiter, DEFAULT_PATH_DELIMITER);
    project = builder.project != null ? builder.project :  getAppEngineProject();
    Preconditions.checkArgument(project != null, "Missing required project id");
  }

  private static String getAppEngineProject() {
    // TODO(ozarov): An alternative to reflection would be to depend on AE api jar:
    // http://mvnrepository.com/artifact/com.google.appengine/appengine-api-1.0-sdk/1.2.0
    try {
      Class<?> factoryClass =
          Class.forName("com.google.appengine.api.appidentity.AppIdentityServiceFactory");
      Method method = factoryClass.getMethod("getAppIdentityService");
      Object appIdentityService = method.invoke(null);
      method = appIdentityService.getClass().getMethod("getServiceAccountName");
      String serviceAccountName = (String) method.invoke(appIdentityService);
      int indexOfAtSign = serviceAccountName.indexOf('@');
      return serviceAccountName.substring(0, indexOfAtSign);
    } catch (Exception ex) {
      return null;
    }
  }

  public static class Builder extends ServiceOptions.Builder<Builder> {

    private String project;
    private String pathDelimiter;

    private Builder() {
    }

    private Builder(StorageServiceOptions options) {
      super(options);
    }

    public Builder project(String project) {
      this.project = project;
      return this;
    }

    public Builder pathDelimiter(String pathDelimiter) {
      this.pathDelimiter = pathDelimiter;
      return this;
    }

    @Override
    public StorageServiceOptions build() {
      return new StorageServiceOptions(this);
    }
  }

  @Override
  protected Set<String> scopes() {
    return SCOPES;
  }

  Storage getStorage() {
    return new Storage.Builder(httpTransport(), new JacksonFactory(), httpRequestInitializer())
        .build();
  }

  public String pathDelimiter() {
    return pathDelimiter;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(StorageServiceOptions options) {
    return new Builder(options);
  }
}
