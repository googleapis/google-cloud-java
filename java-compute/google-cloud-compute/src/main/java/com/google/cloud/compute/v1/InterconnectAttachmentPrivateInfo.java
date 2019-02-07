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
/**
 * Information for an interconnect attachment when this belongs to an interconnect of type
 * DEDICATED.
 */
public final class InterconnectAttachmentPrivateInfo implements ApiMessage {
  private final Integer tag8021q;

  private InterconnectAttachmentPrivateInfo() {
    this.tag8021q = null;
  }

  private InterconnectAttachmentPrivateInfo(Integer tag8021q) {
    this.tag8021q = tag8021q;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("tag8021q".equals(fieldName)) {
      return tag8021q;
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
   * [Output Only] 802.1q encapsulation tag to be used for traffic between Google and the customer,
   * going to and from this network and region.
   */
  public Integer getTag8021q() {
    return tag8021q;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InterconnectAttachmentPrivateInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectAttachmentPrivateInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InterconnectAttachmentPrivateInfo DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InterconnectAttachmentPrivateInfo();
  }

  public static class Builder {
    private Integer tag8021q;

    Builder() {}

    public Builder mergeFrom(InterconnectAttachmentPrivateInfo other) {
      if (other == InterconnectAttachmentPrivateInfo.getDefaultInstance()) return this;
      if (other.getTag8021q() != null) {
        this.tag8021q = other.tag8021q;
      }
      return this;
    }

    Builder(InterconnectAttachmentPrivateInfo source) {
      this.tag8021q = source.tag8021q;
    }

    /**
     * [Output Only] 802.1q encapsulation tag to be used for traffic between Google and the
     * customer, going to and from this network and region.
     */
    public Integer getTag8021q() {
      return tag8021q;
    }

    /**
     * [Output Only] 802.1q encapsulation tag to be used for traffic between Google and the
     * customer, going to and from this network and region.
     */
    public Builder setTag8021q(Integer tag8021q) {
      this.tag8021q = tag8021q;
      return this;
    }

    public InterconnectAttachmentPrivateInfo build() {
      return new InterconnectAttachmentPrivateInfo(tag8021q);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setTag8021q(this.tag8021q);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectAttachmentPrivateInfo{" + "tag8021q=" + tag8021q + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectAttachmentPrivateInfo) {
      InterconnectAttachmentPrivateInfo that = (InterconnectAttachmentPrivateInfo) o;
      return Objects.equals(this.tag8021q, that.getTag8021q());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(tag8021q);
  }
}
