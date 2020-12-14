/*
 * Copyright 2020 Google LLC
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
public class UserLinkName implements ResourceName {
  private static final PathTemplate ACCOUNT_USER_LINK =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/userLinks/{user_link}");
  private static final PathTemplate PROPERTY_USER_LINK =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/userLinks/{user_link}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String account;
  private final String userLink;
  private final String property;

  @Deprecated
  protected UserLinkName() {
    account = null;
    userLink = null;
    property = null;
  }

  private UserLinkName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    userLink = Preconditions.checkNotNull(builder.getUserLink());
    property = null;
    pathTemplate = ACCOUNT_USER_LINK;
  }

  private UserLinkName(PropertyUserLinkBuilder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    userLink = Preconditions.checkNotNull(builder.getUserLink());
    account = null;
    pathTemplate = PROPERTY_USER_LINK;
  }

  public String getAccount() {
    return account;
  }

  public String getUserLink() {
    return userLink;
  }

  public String getProperty() {
    return property;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newAccountUserLinkBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static PropertyUserLinkBuilder newPropertyUserLinkBuilder() {
    return new PropertyUserLinkBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static UserLinkName of(String account, String userLink) {
    return newBuilder().setAccount(account).setUserLink(userLink).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static UserLinkName ofAccountUserLinkName(String account, String userLink) {
    return newBuilder().setAccount(account).setUserLink(userLink).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static UserLinkName ofPropertyUserLinkName(String property, String userLink) {
    return newPropertyUserLinkBuilder().setProperty(property).setUserLink(userLink).build();
  }

  public static String format(String account, String userLink) {
    return newBuilder().setAccount(account).setUserLink(userLink).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatAccountUserLinkName(String account, String userLink) {
    return newBuilder().setAccount(account).setUserLink(userLink).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatPropertyUserLinkName(String property, String userLink) {
    return newPropertyUserLinkBuilder()
        .setProperty(property)
        .setUserLink(userLink)
        .build()
        .toString();
  }

  public static UserLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ACCOUNT_USER_LINK.matches(formattedString)) {
      Map<String, String> matchMap = ACCOUNT_USER_LINK.match(formattedString);
      return ofAccountUserLinkName(matchMap.get("account"), matchMap.get("user_link"));
    } else if (PROPERTY_USER_LINK.matches(formattedString)) {
      Map<String, String> matchMap = PROPERTY_USER_LINK.match(formattedString);
      return ofPropertyUserLinkName(matchMap.get("property"), matchMap.get("user_link"));
    }
    throw new ValidationException("UserLinkName.parse: formattedString not in valid format");
  }

  public static List<UserLinkName> parseList(List<String> formattedStrings) {
    List<UserLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<UserLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (UserLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_USER_LINK.matches(formattedString)
        || PROPERTY_USER_LINK.matches(formattedString);
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
          if (userLink != null) {
            fieldMapBuilder.put("user_link", userLink);
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
    if (o != null || getClass() == o.getClass()) {
      UserLinkName that = ((UserLinkName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.userLink, that.userLink)
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
    h ^= Objects.hashCode(userLink);
    h *= 1000003;
    h ^= Objects.hashCode(property);
    return h;
  }

  /** Builder for accounts/{account}/userLinks/{user_link}. */
  public static class Builder {
    private String account;
    private String userLink;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getUserLink() {
      return userLink;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setUserLink(String userLink) {
      this.userLink = userLink;
      return this;
    }

    private Builder(UserLinkName userLinkName) {
      Preconditions.checkArgument(
          Objects.equals(userLinkName.pathTemplate, ACCOUNT_USER_LINK),
          "toBuilder is only supported when UserLinkName has the pattern of accounts/{account}/userLinks/{user_link}");
      account = userLinkName.account;
      userLink = userLinkName.userLink;
    }

    public UserLinkName build() {
      return new UserLinkName(this);
    }
  }

  /** Builder for properties/{property}/userLinks/{user_link}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class PropertyUserLinkBuilder {
    private String property;
    private String userLink;

    protected PropertyUserLinkBuilder() {}

    public String getProperty() {
      return property;
    }

    public String getUserLink() {
      return userLink;
    }

    public PropertyUserLinkBuilder setProperty(String property) {
      this.property = property;
      return this;
    }

    public PropertyUserLinkBuilder setUserLink(String userLink) {
      this.userLink = userLink;
      return this;
    }

    public UserLinkName build() {
      return new UserLinkName(this);
    }
  }
}
