/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * A full or valid partial URL to a health check service. For example, the following are valid URLs:
 * -
 * https://www.googleapis.com/compute/beta/projects/project-id/regions/us-west1/healthCheckServices/health-check-service
 * - projects/project-id/regions/us-west1/healthCheckServices/health-check-service -
 * regions/us-west1/healthCheckServices/health-check-service
 */
public final class HealthCheckServiceReference implements ApiMessage {
  private final String healthCheckService;

  private HealthCheckServiceReference() {
    this.healthCheckService = null;
  }

  private HealthCheckServiceReference(String healthCheckService) {
    this.healthCheckService = healthCheckService;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("healthCheckService".equals(fieldName)) {
      return healthCheckService;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  public String getHealthCheckService() {
    return healthCheckService;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HealthCheckServiceReference prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HealthCheckServiceReference getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HealthCheckServiceReference DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HealthCheckServiceReference();
  }

  public static class Builder {
    private String healthCheckService;

    Builder() {}

    public Builder mergeFrom(HealthCheckServiceReference other) {
      if (other == HealthCheckServiceReference.getDefaultInstance()) return this;
      if (other.getHealthCheckService() != null) {
        this.healthCheckService = other.healthCheckService;
      }
      return this;
    }

    Builder(HealthCheckServiceReference source) {
      this.healthCheckService = source.healthCheckService;
    }

    public String getHealthCheckService() {
      return healthCheckService;
    }

    public Builder setHealthCheckService(String healthCheckService) {
      this.healthCheckService = healthCheckService;
      return this;
    }

    public HealthCheckServiceReference build() {
      return new HealthCheckServiceReference(healthCheckService);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHealthCheckService(this.healthCheckService);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HealthCheckServiceReference{" + "healthCheckService=" + healthCheckService + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HealthCheckServiceReference) {
      HealthCheckServiceReference that = (HealthCheckServiceReference) o;
      return Objects.equals(this.healthCheckService, that.getHealthCheckService());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(healthCheckService);
  }
}
