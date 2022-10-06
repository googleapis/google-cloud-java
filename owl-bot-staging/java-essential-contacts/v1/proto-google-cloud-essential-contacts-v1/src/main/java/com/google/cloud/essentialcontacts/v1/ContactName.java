/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.essentialcontacts.v1;

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
public class ContactName implements ResourceName {
  private static final PathTemplate PROJECT_CONTACT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/contacts/{contact}");
  private static final PathTemplate FOLDER_CONTACT =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/contacts/{contact}");
  private static final PathTemplate ORGANIZATION_CONTACT =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/contacts/{contact}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String contact;
  private final String folder;
  private final String organization;

  @Deprecated
  protected ContactName() {
    project = null;
    contact = null;
    folder = null;
    organization = null;
  }

  private ContactName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    contact = Preconditions.checkNotNull(builder.getContact());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_CONTACT;
  }

  private ContactName(FolderContactBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    contact = Preconditions.checkNotNull(builder.getContact());
    project = null;
    organization = null;
    pathTemplate = FOLDER_CONTACT;
  }

  private ContactName(OrganizationContactBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    contact = Preconditions.checkNotNull(builder.getContact());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_CONTACT;
  }

  public String getProject() {
    return project;
  }

  public String getContact() {
    return contact;
  }

  public String getFolder() {
    return folder;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectContactBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderContactBuilder newFolderContactBuilder() {
    return new FolderContactBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationContactBuilder newOrganizationContactBuilder() {
    return new OrganizationContactBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ContactName of(String project, String contact) {
    return newBuilder().setProject(project).setContact(contact).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ContactName ofProjectContactName(String project, String contact) {
    return newBuilder().setProject(project).setContact(contact).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ContactName ofFolderContactName(String folder, String contact) {
    return newFolderContactBuilder().setFolder(folder).setContact(contact).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ContactName ofOrganizationContactName(String organization, String contact) {
    return newOrganizationContactBuilder()
        .setOrganization(organization)
        .setContact(contact)
        .build();
  }

  public static String format(String project, String contact) {
    return newBuilder().setProject(project).setContact(contact).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectContactName(String project, String contact) {
    return newBuilder().setProject(project).setContact(contact).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderContactName(String folder, String contact) {
    return newFolderContactBuilder().setFolder(folder).setContact(contact).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationContactName(String organization, String contact) {
    return newOrganizationContactBuilder()
        .setOrganization(organization)
        .setContact(contact)
        .build()
        .toString();
  }

  public static ContactName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_CONTACT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CONTACT.match(formattedString);
      return ofProjectContactName(matchMap.get("project"), matchMap.get("contact"));
    } else if (FOLDER_CONTACT.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_CONTACT.match(formattedString);
      return ofFolderContactName(matchMap.get("folder"), matchMap.get("contact"));
    } else if (ORGANIZATION_CONTACT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_CONTACT.match(formattedString);
      return ofOrganizationContactName(matchMap.get("organization"), matchMap.get("contact"));
    }
    throw new ValidationException("ContactName.parse: formattedString not in valid format");
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
    return PROJECT_CONTACT.matches(formattedString)
        || FOLDER_CONTACT.matches(formattedString)
        || ORGANIZATION_CONTACT.matches(formattedString);
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
          if (contact != null) {
            fieldMapBuilder.put("contact", contact);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
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
      ContactName that = ((ContactName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.contact, that.contact)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.organization, that.organization);
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
    h ^= Objects.hashCode(contact);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/contacts/{contact}. */
  public static class Builder {
    private String project;
    private String contact;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getContact() {
      return contact;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setContact(String contact) {
      this.contact = contact;
      return this;
    }

    private Builder(ContactName contactName) {
      Preconditions.checkArgument(
          Objects.equals(contactName.pathTemplate, PROJECT_CONTACT),
          "toBuilder is only supported when ContactName has the pattern of projects/{project}/contacts/{contact}");
      this.project = contactName.project;
      this.contact = contactName.contact;
    }

    public ContactName build() {
      return new ContactName(this);
    }
  }

  /** Builder for folders/{folder}/contacts/{contact}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderContactBuilder {
    private String folder;
    private String contact;

    protected FolderContactBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getContact() {
      return contact;
    }

    public FolderContactBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderContactBuilder setContact(String contact) {
      this.contact = contact;
      return this;
    }

    public ContactName build() {
      return new ContactName(this);
    }
  }

  /** Builder for organizations/{organization}/contacts/{contact}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationContactBuilder {
    private String organization;
    private String contact;

    protected OrganizationContactBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getContact() {
      return contact;
    }

    public OrganizationContactBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationContactBuilder setContact(String contact) {
      this.contact = contact;
      return this;
    }

    public ContactName build() {
      return new ContactName(this);
    }
  }
}
