/*
 * Copyright 2018 Google LLC
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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class InterconnectAttachmentsScopedList implements ApiMessage {
  private final List<InterconnectAttachment> interconnectAttachments;
  private final Warning warning;

  private InterconnectAttachmentsScopedList() {
    this.interconnectAttachments = null;
    this.warning = null;
  }

  private InterconnectAttachmentsScopedList(
      List<InterconnectAttachment> interconnectAttachments, Warning warning) {
    this.interconnectAttachments = interconnectAttachments;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("interconnectAttachments")) {
      return interconnectAttachments;
    }
    if (fieldName.equals("warning")) {
      return warning;
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

  public List<InterconnectAttachment> getInterconnectAttachmentsList() {
    return interconnectAttachments;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InterconnectAttachmentsScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectAttachmentsScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InterconnectAttachmentsScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InterconnectAttachmentsScopedList();
  }

  public static class Builder {
    private List<InterconnectAttachment> interconnectAttachments;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(InterconnectAttachmentsScopedList other) {
      if (other == InterconnectAttachmentsScopedList.getDefaultInstance()) return this;
      if (other.getInterconnectAttachmentsList() != null) {
        this.interconnectAttachments = other.interconnectAttachments;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(InterconnectAttachmentsScopedList source) {
      this.interconnectAttachments = source.interconnectAttachments;
      this.warning = source.warning;
    }

    public List<InterconnectAttachment> getInterconnectAttachmentsList() {
      return interconnectAttachments;
    }

    public Builder addAllInterconnectAttachments(
        List<InterconnectAttachment> interconnectAttachments) {
      if (this.interconnectAttachments == null) {
        this.interconnectAttachments = new LinkedList<>();
      }
      this.interconnectAttachments.addAll(interconnectAttachments);
      return this;
    }

    public Builder addInterconnectAttachments(InterconnectAttachment interconnectAttachments) {
      if (this.interconnectAttachments == null) {
        this.interconnectAttachments = new LinkedList<>();
      }
      this.interconnectAttachments.add(interconnectAttachments);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public InterconnectAttachmentsScopedList build() {

      return new InterconnectAttachmentsScopedList(interconnectAttachments, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllInterconnectAttachments(this.interconnectAttachments);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectAttachmentsScopedList{"
        + "interconnectAttachments="
        + interconnectAttachments
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectAttachmentsScopedList) {
      InterconnectAttachmentsScopedList that = (InterconnectAttachmentsScopedList) o;
      return Objects.equals(this.interconnectAttachments, that.getInterconnectAttachmentsList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(interconnectAttachments, warning);
  }
}
