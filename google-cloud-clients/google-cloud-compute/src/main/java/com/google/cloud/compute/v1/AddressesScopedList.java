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
public final class AddressesScopedList implements ApiMessage {
  private final List<Address> addresses;
  private final Warning warning;

  private AddressesScopedList() {
    this.addresses = null;
    this.warning = null;
  }

  private AddressesScopedList(List<Address> addresses, Warning warning) {
    this.addresses = addresses;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("addresses")) {
      return addresses;
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

  public List<Address> getAddressesList() {
    return addresses;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AddressesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AddressesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AddressesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AddressesScopedList();
  }

  public static class Builder {
    private List<Address> addresses;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(AddressesScopedList other) {
      if (other == AddressesScopedList.getDefaultInstance()) return this;
      if (other.getAddressesList() != null) {
        this.addresses = other.addresses;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(AddressesScopedList source) {
      this.addresses = source.addresses;
      this.warning = source.warning;
    }

    public List<Address> getAddressesList() {
      return addresses;
    }

    public Builder addAllAddresses(List<Address> addresses) {
      if (this.addresses == null) {
        this.addresses = new LinkedList<>();
      }
      this.addresses.addAll(addresses);
      return this;
    }

    public Builder addAddresses(Address addresses) {
      if (this.addresses == null) {
        this.addresses = new LinkedList<>();
      }
      this.addresses.add(addresses);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public AddressesScopedList build() {

      return new AddressesScopedList(addresses, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAddresses(this.addresses);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AddressesScopedList{" + "addresses=" + addresses + ", " + "warning=" + warning + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AddressesScopedList) {
      AddressesScopedList that = (AddressesScopedList) o;
      return Objects.equals(this.addresses, that.getAddressesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(addresses, warning);
  }
}
