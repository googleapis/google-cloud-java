/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.support.v2beta;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class SupportEventSubscriptionName implements ResourceName {
  private static final PathTemplate ORGANIZATION_SUPPORT_EVENT_SUBSCRIPTION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/supportEventSubscriptions/{support_event_subscription}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String supportEventSubscription;

  @Deprecated
  protected SupportEventSubscriptionName() {
    organization = null;
    supportEventSubscription = null;
  }

  private SupportEventSubscriptionName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    supportEventSubscription = Preconditions.checkNotNull(builder.getSupportEventSubscription());
  }

  public String getOrganization() {
    return organization;
  }

  public String getSupportEventSubscription() {
    return supportEventSubscription;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SupportEventSubscriptionName of(
      String organization, String supportEventSubscription) {
    return newBuilder()
        .setOrganization(organization)
        .setSupportEventSubscription(supportEventSubscription)
        .build();
  }

  public static String format(String organization, String supportEventSubscription) {
    return newBuilder()
        .setOrganization(organization)
        .setSupportEventSubscription(supportEventSubscription)
        .build()
        .toString();
  }

  public static SupportEventSubscriptionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_SUPPORT_EVENT_SUBSCRIPTION.validatedMatch(
            formattedString,
            "SupportEventSubscriptionName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("support_event_subscription"));
  }

  public static List<SupportEventSubscriptionName> parseList(List<String> formattedStrings) {
    List<SupportEventSubscriptionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SupportEventSubscriptionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SupportEventSubscriptionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_SUPPORT_EVENT_SUBSCRIPTION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (supportEventSubscription != null) {
            fieldMapBuilder.put("support_event_subscription", supportEventSubscription);
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
    return ORGANIZATION_SUPPORT_EVENT_SUBSCRIPTION.instantiate(
        "organization", organization, "support_event_subscription", supportEventSubscription);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SupportEventSubscriptionName that = ((SupportEventSubscriptionName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.supportEventSubscription, that.supportEventSubscription);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(supportEventSubscription);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/supportEventSubscriptions/{support_event_subscription}.
   */
  public static class Builder {
    private String organization;
    private String supportEventSubscription;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSupportEventSubscription() {
      return supportEventSubscription;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setSupportEventSubscription(String supportEventSubscription) {
      this.supportEventSubscription = supportEventSubscription;
      return this;
    }

    private Builder(SupportEventSubscriptionName supportEventSubscriptionName) {
      this.organization = supportEventSubscriptionName.organization;
      this.supportEventSubscription = supportEventSubscriptionName.supportEventSubscription;
    }

    public SupportEventSubscriptionName build() {
      return new SupportEventSubscriptionName(this);
    }
  }
}
