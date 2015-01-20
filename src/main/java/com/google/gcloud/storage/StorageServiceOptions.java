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

import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.storage.Storage;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.ServiceOptions;

import java.util.Set;

public class StorageServiceOptions extends ServiceOptions {

  private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
  private static final Set<String> SCOPES = ImmutableSet.of(GCS_SCOPE);
  private static final String DEFAULT_PATH_DELIMITER = "/";

  private final String project;
  private final String pathDelimiter;

  private StorageServiceOptions(Builder builder) {
    super(builder);
    pathDelimiter = MoreObjects.firstNonNull(builder.pathDelimiter, DEFAULT_PATH_DELIMITER);
    project = builder.project != null ? builder.project :  getAppEngineProjectId();
    Preconditions.checkArgument(project != null, "Missing required project id");
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
