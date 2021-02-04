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

package com.google.logging.v2;

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
public class LogSinkName implements ResourceName {
  private static final PathTemplate PROJECT_SINK =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/sinks/{sink}");
  private static final PathTemplate ORGANIZATION_SINK =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/sinks/{sink}");
  private static final PathTemplate FOLDER_SINK =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/sinks/{sink}");
  private static final PathTemplate BILLING_ACCOUNT_SINK =
      PathTemplate.createWithoutUrlEncoding("billingAccounts/{billing_account}/sinks/{sink}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String sink;
  private final String organization;
  private final String folder;
  private final String billingAccount;

  @Deprecated
  protected LogSinkName() {
    project = null;
    sink = null;
    organization = null;
    folder = null;
    billingAccount = null;
  }

  private LogSinkName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    sink = Preconditions.checkNotNull(builder.getSink());
    organization = null;
    folder = null;
    billingAccount = null;
    pathTemplate = PROJECT_SINK;
  }

  private LogSinkName(OrganizationSinkBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    sink = Preconditions.checkNotNull(builder.getSink());
    project = null;
    folder = null;
    billingAccount = null;
    pathTemplate = ORGANIZATION_SINK;
  }

  private LogSinkName(FolderSinkBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    sink = Preconditions.checkNotNull(builder.getSink());
    project = null;
    organization = null;
    billingAccount = null;
    pathTemplate = FOLDER_SINK;
  }

  private LogSinkName(BillingAccountSinkBuilder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    sink = Preconditions.checkNotNull(builder.getSink());
    project = null;
    organization = null;
    folder = null;
    pathTemplate = BILLING_ACCOUNT_SINK;
  }

  public String getProject() {
    return project;
  }

  public String getSink() {
    return sink;
  }

  public String getOrganization() {
    return organization;
  }

  public String getFolder() {
    return folder;
  }

  public String getBillingAccount() {
    return billingAccount;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectSinkBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationSinkBuilder newOrganizationSinkBuilder() {
    return new OrganizationSinkBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderSinkBuilder newFolderSinkBuilder() {
    return new FolderSinkBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static BillingAccountSinkBuilder newBillingAccountSinkBuilder() {
    return new BillingAccountSinkBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LogSinkName of(String project, String sink) {
    return newBuilder().setProject(project).setSink(sink).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogSinkName ofProjectSinkName(String project, String sink) {
    return newBuilder().setProject(project).setSink(sink).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogSinkName ofOrganizationSinkName(String organization, String sink) {
    return newOrganizationSinkBuilder().setOrganization(organization).setSink(sink).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogSinkName ofFolderSinkName(String folder, String sink) {
    return newFolderSinkBuilder().setFolder(folder).setSink(sink).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogSinkName ofBillingAccountSinkName(String billingAccount, String sink) {
    return newBillingAccountSinkBuilder().setBillingAccount(billingAccount).setSink(sink).build();
  }

  public static String format(String project, String sink) {
    return newBuilder().setProject(project).setSink(sink).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectSinkName(String project, String sink) {
    return newBuilder().setProject(project).setSink(sink).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationSinkName(String organization, String sink) {
    return newOrganizationSinkBuilder()
        .setOrganization(organization)
        .setSink(sink)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderSinkName(String folder, String sink) {
    return newFolderSinkBuilder().setFolder(folder).setSink(sink).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatBillingAccountSinkName(String billingAccount, String sink) {
    return newBillingAccountSinkBuilder()
        .setBillingAccount(billingAccount)
        .setSink(sink)
        .build()
        .toString();
  }

  public static LogSinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_SINK.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SINK.match(formattedString);
      return ofProjectSinkName(matchMap.get("project"), matchMap.get("sink"));
    } else if (ORGANIZATION_SINK.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SINK.match(formattedString);
      return ofOrganizationSinkName(matchMap.get("organization"), matchMap.get("sink"));
    } else if (FOLDER_SINK.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_SINK.match(formattedString);
      return ofFolderSinkName(matchMap.get("folder"), matchMap.get("sink"));
    } else if (BILLING_ACCOUNT_SINK.matches(formattedString)) {
      Map<String, String> matchMap = BILLING_ACCOUNT_SINK.match(formattedString);
      return ofBillingAccountSinkName(matchMap.get("billing_account"), matchMap.get("sink"));
    }
    throw new ValidationException("LogSinkName.parse: formattedString not in valid format");
  }

  public static List<LogSinkName> parseList(List<String> formattedStrings) {
    List<LogSinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LogSinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LogSinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SINK.matches(formattedString)
        || ORGANIZATION_SINK.matches(formattedString)
        || FOLDER_SINK.matches(formattedString)
        || BILLING_ACCOUNT_SINK.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (sink != null) {
            fieldMapBuilder.put("sink", sink);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (billingAccount != null) {
            fieldMapBuilder.put("billing_account", billingAccount);
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
      LogSinkName that = ((LogSinkName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.sink, that.sink)
          && Objects.equals(this.organization, that.organization)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.billingAccount, that.billingAccount);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(sink);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    return h;
  }

  /** Builder for projects/{project}/sinks/{sink}. */
  public static class Builder {
    private String project;
    private String sink;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getSink() {
      return sink;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSink(String sink) {
      this.sink = sink;
      return this;
    }

    private Builder(LogSinkName logSinkName) {
      Preconditions.checkArgument(
          Objects.equals(logSinkName.pathTemplate, PROJECT_SINK),
          "toBuilder is only supported when LogSinkName has the pattern of projects/{project}/sinks/{sink}");
      project = logSinkName.project;
      sink = logSinkName.sink;
    }

    public LogSinkName build() {
      return new LogSinkName(this);
    }
  }

  /** Builder for organizations/{organization}/sinks/{sink}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationSinkBuilder {
    private String organization;
    private String sink;

    protected OrganizationSinkBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSink() {
      return sink;
    }

    public OrganizationSinkBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationSinkBuilder setSink(String sink) {
      this.sink = sink;
      return this;
    }

    public LogSinkName build() {
      return new LogSinkName(this);
    }
  }

  /** Builder for folders/{folder}/sinks/{sink}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderSinkBuilder {
    private String folder;
    private String sink;

    protected FolderSinkBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getSink() {
      return sink;
    }

    public FolderSinkBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderSinkBuilder setSink(String sink) {
      this.sink = sink;
      return this;
    }

    public LogSinkName build() {
      return new LogSinkName(this);
    }
  }

  /** Builder for billingAccounts/{billing_account}/sinks/{sink}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class BillingAccountSinkBuilder {
    private String billingAccount;
    private String sink;

    protected BillingAccountSinkBuilder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getSink() {
      return sink;
    }

    public BillingAccountSinkBuilder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public BillingAccountSinkBuilder setSink(String sink) {
      this.sink = sink;
      return this;
    }

    public LogSinkName build() {
      return new LogSinkName(this);
    }
  }
}
