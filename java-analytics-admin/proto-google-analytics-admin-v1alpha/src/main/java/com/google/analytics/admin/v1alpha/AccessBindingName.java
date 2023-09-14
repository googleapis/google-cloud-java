/*
 * Copyright 2023 Google LLC
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

package com.google.analytics.admin.v1alpha;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class AccessBindingName implements ResourceName {
  private static final PathTemplate ACCOUNT_ACCESS_BINDING =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/accessBindings/{access_binding}");
  private static final PathTemplate PROPERTY_ACCESS_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/accessBindings/{access_binding}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String account;
  private final String accessBinding;
  private final String property;

  @Deprecated
  protected AccessBindingName() {
    account = null;
    accessBinding = null;
    property = null;
  }

  private AccessBindingName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    accessBinding = Preconditions.checkNotNull(builder.getAccessBinding());
    property = null;
    pathTemplate = ACCOUNT_ACCESS_BINDING;
  }

  private AccessBindingName(PropertyAccessBindingBuilder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    accessBinding = Preconditions.checkNotNull(builder.getAccessBinding());
    account = null;
    pathTemplate = PROPERTY_ACCESS_BINDING;
  }

  public String getAccount() {
    return account;
  }

  public String getAccessBinding() {
    return accessBinding;
  }

  public String getProperty() {
    return property;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newAccountAccessBindingBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static PropertyAccessBindingBuilder newPropertyAccessBindingBuilder() {
    return new PropertyAccessBindingBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccessBindingName of(String account, String accessBinding) {
    return newBuilder().setAccount(account).setAccessBinding(accessBinding).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AccessBindingName ofAccountAccessBindingName(String account, String accessBinding) {
    return newBuilder().setAccount(account).setAccessBinding(accessBinding).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AccessBindingName ofPropertyAccessBindingName(
      String property, String accessBinding) {
    return newPropertyAccessBindingBuilder()
        .setProperty(property)
        .setAccessBinding(accessBinding)
        .build();
  }

  public static String format(String account, String accessBinding) {
    return newBuilder().setAccount(account).setAccessBinding(accessBinding).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatAccountAccessBindingName(String account, String accessBinding) {
    return newBuilder().setAccount(account).setAccessBinding(accessBinding).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatPropertyAccessBindingName(String property, String accessBinding) {
    return newPropertyAccessBindingBuilder()
        .setProperty(property)
        .setAccessBinding(accessBinding)
        .build()
        .toString();
  }

  public static AccessBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ACCOUNT_ACCESS_BINDING.matches(formattedString)) {
      Map<String, String> matchMap = ACCOUNT_ACCESS_BINDING.match(formattedString);
      return ofAccountAccessBindingName(matchMap.get("account"), matchMap.get("access_binding"));
    } else if (PROPERTY_ACCESS_BINDING.matches(formattedString)) {
      Map<String, String> matchMap = PROPERTY_ACCESS_BINDING.match(formattedString);
      return ofPropertyAccessBindingName(matchMap.get("property"), matchMap.get("access_binding"));
    }
    throw new ValidationException("AccessBindingName.parse: formattedString not in valid format");
  }

  public static List<AccessBindingName> parseList(List<String> formattedStrings) {
    List<AccessBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccessBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccessBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_ACCESS_BINDING.matches(formattedString)
        || PROPERTY_ACCESS_BINDING.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (account != null) {
            fieldMapBuilder.put("account", account);
          }
          if (accessBinding != null) {
            fieldMapBuilder.put("access_binding", accessBinding);
          }
          if (property != null) {
            fieldMapBuilder.put("property", property);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AccessBindingName that = ((AccessBindingName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.accessBinding, that.accessBinding)
          && Objects.equals(this.property, that.property);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(accessBinding);
    h *= 1000003;
    h ^= Objects.hashCode(property);
    return h;
  }

  /** Builder for accounts/{account}/accessBindings/{access_binding}. */
  public static class Builder {
    private String account;
    private String accessBinding;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getAccessBinding() {
      return accessBinding;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setAccessBinding(String accessBinding) {
      this.accessBinding = accessBinding;
      return this;
    }

    private Builder(AccessBindingName accessBindingName) {
      Preconditions.checkArgument(
          Objects.equals(accessBindingName.pathTemplate, ACCOUNT_ACCESS_BINDING),
          "toBuilder is only supported when AccessBindingName has the pattern of accounts/{account}/accessBindings/{access_binding}");
      this.account = accessBindingName.account;
      this.accessBinding = accessBindingName.accessBinding;
    }

    public AccessBindingName build() {
      return new AccessBindingName(this);
    }
  }

  /** Builder for properties/{property}/accessBindings/{access_binding}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class PropertyAccessBindingBuilder {
    private String property;
    private String accessBinding;

    protected PropertyAccessBindingBuilder() {}

    public String getProperty() {
      return property;
    }

    public String getAccessBinding() {
      return accessBinding;
    }

    public PropertyAccessBindingBuilder setProperty(String property) {
      this.property = property;
      return this;
    }

    public PropertyAccessBindingBuilder setAccessBinding(String accessBinding) {
      this.accessBinding = accessBinding;
      return this;
    }

    public AccessBindingName build() {
      return new AccessBindingName(this);
    }
  }
}
