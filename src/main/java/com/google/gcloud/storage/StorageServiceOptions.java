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

package com.google.gcloud.storage;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.ServiceOptions;
import com.google.gcloud.spi.ServiceRpcProvider;
import com.google.gcloud.spi.StorageRpc;

import java.util.Set;

public class StorageServiceOptions extends ServiceOptions<StorageRpc, StorageServiceOptions> {

  private static final long serialVersionUID = -7804860602287801084L;
  private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
  private static final Set<String> SCOPES = ImmutableSet.of(GCS_SCOPE);
  private static final String DEFAULT_PATH_DELIMITER = "/";
  private static final String PROJECT_ENV_NAME = "default_project_id";

  private final String project;
  private final String pathDelimiter;

  public static class Builder extends
      ServiceOptions.Builder<StorageRpc, StorageServiceOptions, Builder> {

    private String project;
    private String pathDelimiter;

    private Builder() {}

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

  private StorageServiceOptions(Builder builder) {
    super(builder);
    pathDelimiter = MoreObjects.firstNonNull(builder.pathDelimiter, DEFAULT_PATH_DELIMITER);
    project = builder.project != null ? builder.project : defaultProject();
    Preconditions.checkArgument(project != null, "Missing required project id");
  }

  @Override
  protected Set<String> scopes() {
    return SCOPES;
  }

  StorageRpc storageRpc() {
    if (serviceRpcFactory() != null) {
      return serviceRpcFactory().create(this);
    }
    return ServiceRpcProvider.storage(this);
  }

  public String project() {
    return project;
  }

  public String pathDelimiter() {
    return pathDelimiter;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  private static String defaultProject() {
    String projectId = System.getProperty(PROJECT_ENV_NAME, System.getenv(PROJECT_ENV_NAME));
    if (projectId == null) {
      projectId = getAppEngineProjectId();
    }
    return projectId != null ? projectId : googleCloudProjectId();
  }

  public static Builder builder() {
    return new Builder();
  }
}
