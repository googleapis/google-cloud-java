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
public final class VpnGatewaysGetStatusResponse implements ApiMessage {
  private final VpnGatewayStatus result;

  private VpnGatewaysGetStatusResponse() {
    this.result = null;
  }

  private VpnGatewaysGetStatusResponse(VpnGatewayStatus result) {
    this.result = result;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("result".equals(fieldName)) {
      return result;
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

  public VpnGatewayStatus getResult() {
    return result;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VpnGatewaysGetStatusResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VpnGatewaysGetStatusResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VpnGatewaysGetStatusResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VpnGatewaysGetStatusResponse();
  }

  public static class Builder {
    private VpnGatewayStatus result;

    Builder() {}

    public Builder mergeFrom(VpnGatewaysGetStatusResponse other) {
      if (other == VpnGatewaysGetStatusResponse.getDefaultInstance()) return this;
      if (other.getResult() != null) {
        this.result = other.result;
      }
      return this;
    }

    Builder(VpnGatewaysGetStatusResponse source) {
      this.result = source.result;
    }

    public VpnGatewayStatus getResult() {
      return result;
    }

    public Builder setResult(VpnGatewayStatus result) {
      this.result = result;
      return this;
    }

    public VpnGatewaysGetStatusResponse build() {
      return new VpnGatewaysGetStatusResponse(result);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setResult(this.result);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VpnGatewaysGetStatusResponse{" + "result=" + result + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VpnGatewaysGetStatusResponse) {
      VpnGatewaysGetStatusResponse that = (VpnGatewaysGetStatusResponse) o;
      return Objects.equals(this.result, that.getResult());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }
}
