/*
 * Copyright 2019 Google LLC
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
public final class InstanceGroupManagersSetInstanceTemplateRequest implements ApiMessage {
  private final String instanceTemplate;

  private InstanceGroupManagersSetInstanceTemplateRequest() {
    this.instanceTemplate = null;
  }

  private InstanceGroupManagersSetInstanceTemplateRequest(String instanceTemplate) {
    this.instanceTemplate = instanceTemplate;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instanceTemplate".equals(fieldName)) {
      return instanceTemplate;
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
  public List<String> getFieldMask() {
    return null;
  }

  /**
   * The URL of the instance template that is specified for this managed instance group. The group
   * uses this template to create all new instances in the managed instance group.
   */
  public String getInstanceTemplate() {
    return instanceTemplate;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagersSetInstanceTemplateRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagersSetInstanceTemplateRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagersSetInstanceTemplateRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagersSetInstanceTemplateRequest();
  }

  public static class Builder {
    private String instanceTemplate;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagersSetInstanceTemplateRequest other) {
      if (other == InstanceGroupManagersSetInstanceTemplateRequest.getDefaultInstance())
        return this;
      if (other.getInstanceTemplate() != null) {
        this.instanceTemplate = other.instanceTemplate;
      }
      return this;
    }

    Builder(InstanceGroupManagersSetInstanceTemplateRequest source) {
      this.instanceTemplate = source.instanceTemplate;
    }

    /**
     * The URL of the instance template that is specified for this managed instance group. The group
     * uses this template to create all new instances in the managed instance group.
     */
    public String getInstanceTemplate() {
      return instanceTemplate;
    }

    /**
     * The URL of the instance template that is specified for this managed instance group. The group
     * uses this template to create all new instances in the managed instance group.
     */
    public Builder setInstanceTemplate(String instanceTemplate) {
      this.instanceTemplate = instanceTemplate;
      return this;
    }

    public InstanceGroupManagersSetInstanceTemplateRequest build() {
      return new InstanceGroupManagersSetInstanceTemplateRequest(instanceTemplate);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setInstanceTemplate(this.instanceTemplate);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagersSetInstanceTemplateRequest{"
        + "instanceTemplate="
        + instanceTemplate
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagersSetInstanceTemplateRequest) {
      InstanceGroupManagersSetInstanceTemplateRequest that =
          (InstanceGroupManagersSetInstanceTemplateRequest) o;
      return Objects.equals(this.instanceTemplate, that.getInstanceTemplate());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceTemplate);
  }
}
