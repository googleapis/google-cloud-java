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
public final class InstanceMoveRequest implements ApiMessage {
  private final String destinationZone;
  private final String targetInstance;

  private InstanceMoveRequest() {
    this.destinationZone = null;
    this.targetInstance = null;
  }

  private InstanceMoveRequest(String destinationZone, String targetInstance) {
    this.destinationZone = destinationZone;
    this.targetInstance = targetInstance;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("destinationZone".equals(fieldName)) {
      return destinationZone;
    }
    if ("targetInstance".equals(fieldName)) {
      return targetInstance;
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
   * The URL of the destination zone to move the instance. This can be a full or partial URL. For
   * example, the following are all valid URLs to a zone: -
   * https://www.googleapis.com/compute/v1/projects/project/zones/zone - projects/project/zones/zone
   * - zones/zone
   */
  public String getDestinationZone() {
    return destinationZone;
  }

  /**
   * The URL of the target instance to move. This can be a full or partial URL. For example, the
   * following are all valid URLs to an instance: -
   * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/instance -
   * projects/project/zones/zone/instances/instance - zones/zone/instances/instance
   */
  public String getTargetInstance() {
    return targetInstance;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceMoveRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceMoveRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceMoveRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceMoveRequest();
  }

  public static class Builder {
    private String destinationZone;
    private String targetInstance;

    Builder() {}

    public Builder mergeFrom(InstanceMoveRequest other) {
      if (other == InstanceMoveRequest.getDefaultInstance()) return this;
      if (other.getDestinationZone() != null) {
        this.destinationZone = other.destinationZone;
      }
      if (other.getTargetInstance() != null) {
        this.targetInstance = other.targetInstance;
      }
      return this;
    }

    Builder(InstanceMoveRequest source) {
      this.destinationZone = source.destinationZone;
      this.targetInstance = source.targetInstance;
    }

    /**
     * The URL of the destination zone to move the instance. This can be a full or partial URL. For
     * example, the following are all valid URLs to a zone: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone -
     * projects/project/zones/zone - zones/zone
     */
    public String getDestinationZone() {
      return destinationZone;
    }

    /**
     * The URL of the destination zone to move the instance. This can be a full or partial URL. For
     * example, the following are all valid URLs to a zone: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone -
     * projects/project/zones/zone - zones/zone
     */
    public Builder setDestinationZone(String destinationZone) {
      this.destinationZone = destinationZone;
      return this;
    }

    /**
     * The URL of the target instance to move. This can be a full or partial URL. For example, the
     * following are all valid URLs to an instance: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/instance -
     * projects/project/zones/zone/instances/instance - zones/zone/instances/instance
     */
    public String getTargetInstance() {
      return targetInstance;
    }

    /**
     * The URL of the target instance to move. This can be a full or partial URL. For example, the
     * following are all valid URLs to an instance: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/instance -
     * projects/project/zones/zone/instances/instance - zones/zone/instances/instance
     */
    public Builder setTargetInstance(String targetInstance) {
      this.targetInstance = targetInstance;
      return this;
    }

    public InstanceMoveRequest build() {

      return new InstanceMoveRequest(destinationZone, targetInstance);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDestinationZone(this.destinationZone);
      newBuilder.setTargetInstance(this.targetInstance);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceMoveRequest{"
        + "destinationZone="
        + destinationZone
        + ", "
        + "targetInstance="
        + targetInstance
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceMoveRequest) {
      InstanceMoveRequest that = (InstanceMoveRequest) o;
      return Objects.equals(this.destinationZone, that.getDestinationZone())
          && Objects.equals(this.targetInstance, that.getTargetInstance());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationZone, targetInstance);
  }
}
