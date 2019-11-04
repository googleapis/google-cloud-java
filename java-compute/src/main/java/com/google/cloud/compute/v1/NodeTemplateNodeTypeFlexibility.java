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
public final class NodeTemplateNodeTypeFlexibility implements ApiMessage {
  private final String cpus;
  private final String localSsd;
  private final String memory;

  private NodeTemplateNodeTypeFlexibility() {
    this.cpus = null;
    this.localSsd = null;
    this.memory = null;
  }

  private NodeTemplateNodeTypeFlexibility(String cpus, String localSsd, String memory) {
    this.cpus = cpus;
    this.localSsd = localSsd;
    this.memory = memory;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("cpus".equals(fieldName)) {
      return cpus;
    }
    if ("localSsd".equals(fieldName)) {
      return localSsd;
    }
    if ("memory".equals(fieldName)) {
      return memory;
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

  public String getCpus() {
    return cpus;
  }

  public String getLocalSsd() {
    return localSsd;
  }

  public String getMemory() {
    return memory;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeTemplateNodeTypeFlexibility prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeTemplateNodeTypeFlexibility getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeTemplateNodeTypeFlexibility DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeTemplateNodeTypeFlexibility();
  }

  public static class Builder {
    private String cpus;
    private String localSsd;
    private String memory;

    Builder() {}

    public Builder mergeFrom(NodeTemplateNodeTypeFlexibility other) {
      if (other == NodeTemplateNodeTypeFlexibility.getDefaultInstance()) return this;
      if (other.getCpus() != null) {
        this.cpus = other.cpus;
      }
      if (other.getLocalSsd() != null) {
        this.localSsd = other.localSsd;
      }
      if (other.getMemory() != null) {
        this.memory = other.memory;
      }
      return this;
    }

    Builder(NodeTemplateNodeTypeFlexibility source) {
      this.cpus = source.cpus;
      this.localSsd = source.localSsd;
      this.memory = source.memory;
    }

    public String getCpus() {
      return cpus;
    }

    public Builder setCpus(String cpus) {
      this.cpus = cpus;
      return this;
    }

    public String getLocalSsd() {
      return localSsd;
    }

    public Builder setLocalSsd(String localSsd) {
      this.localSsd = localSsd;
      return this;
    }

    public String getMemory() {
      return memory;
    }

    public Builder setMemory(String memory) {
      this.memory = memory;
      return this;
    }

    public NodeTemplateNodeTypeFlexibility build() {

      return new NodeTemplateNodeTypeFlexibility(cpus, localSsd, memory);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCpus(this.cpus);
      newBuilder.setLocalSsd(this.localSsd);
      newBuilder.setMemory(this.memory);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeTemplateNodeTypeFlexibility{"
        + "cpus="
        + cpus
        + ", "
        + "localSsd="
        + localSsd
        + ", "
        + "memory="
        + memory
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeTemplateNodeTypeFlexibility) {
      NodeTemplateNodeTypeFlexibility that = (NodeTemplateNodeTypeFlexibility) o;
      return Objects.equals(this.cpus, that.getCpus())
          && Objects.equals(this.localSsd, that.getLocalSsd())
          && Objects.equals(this.memory, that.getMemory());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpus, localSsd, memory);
  }
}
