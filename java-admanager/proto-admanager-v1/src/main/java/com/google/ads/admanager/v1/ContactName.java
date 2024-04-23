/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ads.admanager.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class ContactName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CONTACT =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/contacts/{contact}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String contact;

  @Deprecated
  protected ContactName() {
    networkCode = null;
    contact = null;
  }

  private ContactName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    contact = Preconditions.checkNotNull(builder.getContact());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getContact() {
    return contact;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ContactName of(String networkCode, String contact) {
    return newBuilder().setNetworkCode(networkCode).setContact(contact).build();
  }

  public static String format(String networkCode, String contact) {
    return newBuilder().setNetworkCode(networkCode).setContact(contact).build().toString();
  }

  public static ContactName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CONTACT.validatedMatch(
            formattedString, "ContactName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("contact"));
  }

  public static List<ContactName> parseList(List<String> formattedStrings) {
    List<ContactName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ContactName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ContactName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CONTACT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (networkCode != null) {
            fieldMapBuilder.put("network_code", networkCode);
          }
          if (contact != null) {
            fieldMapBuilder.put("contact", contact);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return NETWORK_CODE_CONTACT.instantiate("network_code", networkCode, "contact", contact);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ContactName that = ((ContactName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.contact, that.contact);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(contact);
    return h;
  }

  /** Builder for networks/{network_code}/contacts/{contact}. */
  public static class Builder {
    private String networkCode;
    private String contact;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getContact() {
      return contact;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setContact(String contact) {
      this.contact = contact;
      return this;
    }

    private Builder(ContactName contactName) {
      this.networkCode = contactName.networkCode;
      this.contact = contactName.contact;
    }

    public ContactName build() {
      return new ContactName(this);
    }
  }
}
