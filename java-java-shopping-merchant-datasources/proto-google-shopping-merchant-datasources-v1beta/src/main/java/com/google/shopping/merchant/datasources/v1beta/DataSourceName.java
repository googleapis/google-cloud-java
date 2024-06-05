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

package com.google.shopping.merchant.datasources.v1beta;

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
public class DataSourceName implements ResourceName {
  private static final PathTemplate ACCOUNT_DATASOURCE =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/dataSources/{datasource}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String datasource;

  @Deprecated
  protected DataSourceName() {
    account = null;
    datasource = null;
  }

  private DataSourceName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    datasource = Preconditions.checkNotNull(builder.getDatasource());
  }

  public String getAccount() {
    return account;
  }

  public String getDatasource() {
    return datasource;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataSourceName of(String account, String datasource) {
    return newBuilder().setAccount(account).setDatasource(datasource).build();
  }

  public static String format(String account, String datasource) {
    return newBuilder().setAccount(account).setDatasource(datasource).build().toString();
  }

  public static DataSourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_DATASOURCE.validatedMatch(
            formattedString, "DataSourceName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("datasource"));
  }

  public static List<DataSourceName> parseList(List<String> formattedStrings) {
    List<DataSourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataSourceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataSourceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_DATASOURCE.matches(formattedString);
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
          if (datasource != null) {
            fieldMapBuilder.put("datasource", datasource);
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
    return ACCOUNT_DATASOURCE.instantiate("account", account, "datasource", datasource);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DataSourceName that = ((DataSourceName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.datasource, that.datasource);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(datasource);
    return h;
  }

  /** Builder for accounts/{account}/dataSources/{datasource}. */
  public static class Builder {
    private String account;
    private String datasource;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getDatasource() {
      return datasource;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setDatasource(String datasource) {
      this.datasource = datasource;
      return this;
    }

    private Builder(DataSourceName dataSourceName) {
      this.account = dataSourceName.account;
      this.datasource = dataSourceName.datasource;
    }

    public DataSourceName build() {
      return new DataSourceName(this);
    }
  }
}
