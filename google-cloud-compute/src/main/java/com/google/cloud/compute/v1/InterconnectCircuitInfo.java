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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class InterconnectCircuitInfo implements ApiMessage {
  private final String customerDemarcId;
  private final String googleCircuitId;
  private final String googleDemarcId;

  private InterconnectCircuitInfo() {
    this.customerDemarcId = null;
    this.googleCircuitId = null;
    this.googleDemarcId = null;
  }


  private InterconnectCircuitInfo(
      String customerDemarcId,
      String googleCircuitId,
      String googleDemarcId
      ) {
    this.customerDemarcId = customerDemarcId;
    this.googleCircuitId = googleCircuitId;
    this.googleDemarcId = googleDemarcId;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("customerDemarcId") && customerDemarcId != null) {
      fieldMap.put("customerDemarcId", Collections.singletonList(String.valueOf(customerDemarcId)));
    }
    if (fieldNames.contains("googleCircuitId") && googleCircuitId != null) {
      fieldMap.put("googleCircuitId", Collections.singletonList(String.valueOf(googleCircuitId)));
    }
    if (fieldNames.contains("googleDemarcId") && googleDemarcId != null) {
      fieldMap.put("googleDemarcId", Collections.singletonList(String.valueOf(googleDemarcId)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("customerDemarcId")) {
      return String.valueOf(customerDemarcId);
    }
    if (fieldName.equals("googleCircuitId")) {
      return String.valueOf(googleCircuitId);
    }
    if (fieldName.equals("googleDemarcId")) {
      return String.valueOf(googleDemarcId);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getCustomerDemarcId() {
    return customerDemarcId;
  }

  public String getGoogleCircuitId() {
    return googleCircuitId;
  }

  public String getGoogleDemarcId() {
    return googleDemarcId;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(InterconnectCircuitInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectCircuitInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final InterconnectCircuitInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new InterconnectCircuitInfo();
  }

  public static class Builder {
    private String customerDemarcId;
    private String googleCircuitId;
    private String googleDemarcId;

    Builder() {}

    public Builder mergeFrom(InterconnectCircuitInfo other) {
      if (other == InterconnectCircuitInfo.getDefaultInstance()) return this;
      if (other.getCustomerDemarcId() != null) {
        this.customerDemarcId = other.customerDemarcId;
      }
      if (other.getGoogleCircuitId() != null) {
        this.googleCircuitId = other.googleCircuitId;
      }
      if (other.getGoogleDemarcId() != null) {
        this.googleDemarcId = other.googleDemarcId;
      }
      return this;
    }

    Builder(InterconnectCircuitInfo source) {
      this.customerDemarcId = source.customerDemarcId;
      this.googleCircuitId = source.googleCircuitId;
      this.googleDemarcId = source.googleDemarcId;
    }

    public String getCustomerDemarcId() {
      return customerDemarcId;
    }

    public Builder setCustomerDemarcId(String customerDemarcId) {
      this.customerDemarcId = customerDemarcId;
      return this;
    }

    public String getGoogleCircuitId() {
      return googleCircuitId;
    }

    public Builder setGoogleCircuitId(String googleCircuitId) {
      this.googleCircuitId = googleCircuitId;
      return this;
    }

    public String getGoogleDemarcId() {
      return googleDemarcId;
    }

    public Builder setGoogleDemarcId(String googleDemarcId) {
      this.googleDemarcId = googleDemarcId;
      return this;
    }


    public InterconnectCircuitInfo build() {


      return new InterconnectCircuitInfo(
        customerDemarcId,
        googleCircuitId,
        googleDemarcId
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCustomerDemarcId(this.customerDemarcId);
      newBuilder.setGoogleCircuitId(this.googleCircuitId);
      newBuilder.setGoogleDemarcId(this.googleDemarcId);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectCircuitInfo{"
        + "customerDemarcId=" + customerDemarcId + ", "
        + "googleCircuitId=" + googleCircuitId + ", "
        + "googleDemarcId=" + googleDemarcId
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectCircuitInfo) {
      InterconnectCircuitInfo that = (InterconnectCircuitInfo) o;
      return
          Objects.equals(this.customerDemarcId, that.getCustomerDemarcId()) &&
          Objects.equals(this.googleCircuitId, that.getGoogleCircuitId()) &&
          Objects.equals(this.googleDemarcId, that.getGoogleDemarcId())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      customerDemarcId,
      googleCircuitId,
      googleDemarcId
    );
  }
}
