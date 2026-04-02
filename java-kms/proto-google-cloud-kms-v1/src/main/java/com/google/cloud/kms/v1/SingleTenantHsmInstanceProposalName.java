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

package com.google.cloud.kms.v1;

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
public class SingleTenantHsmInstanceProposalName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/singleTenantHsmInstances/{single_tenant_hsm_instance}/proposals/{proposal}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String singleTenantHsmInstance;
  private final String proposal;

  @Deprecated
  protected SingleTenantHsmInstanceProposalName() {
    project = null;
    location = null;
    singleTenantHsmInstance = null;
    proposal = null;
  }

  private SingleTenantHsmInstanceProposalName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    singleTenantHsmInstance = Preconditions.checkNotNull(builder.getSingleTenantHsmInstance());
    proposal = Preconditions.checkNotNull(builder.getProposal());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSingleTenantHsmInstance() {
    return singleTenantHsmInstance;
  }

  public String getProposal() {
    return proposal;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SingleTenantHsmInstanceProposalName of(
      String project, String location, String singleTenantHsmInstance, String proposal) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSingleTenantHsmInstance(singleTenantHsmInstance)
        .setProposal(proposal)
        .build();
  }

  public static String format(
      String project, String location, String singleTenantHsmInstance, String proposal) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSingleTenantHsmInstance(singleTenantHsmInstance)
        .setProposal(proposal)
        .build()
        .toString();
  }

  public static SingleTenantHsmInstanceProposalName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL.validatedMatch(
            formattedString,
            "SingleTenantHsmInstanceProposalName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("single_tenant_hsm_instance"),
        matchMap.get("proposal"));
  }

  public static List<SingleTenantHsmInstanceProposalName> parseList(List<String> formattedStrings) {
    List<SingleTenantHsmInstanceProposalName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SingleTenantHsmInstanceProposalName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SingleTenantHsmInstanceProposalName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL.matches(formattedString);
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
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (singleTenantHsmInstance != null) {
            fieldMapBuilder.put("single_tenant_hsm_instance", singleTenantHsmInstance);
          }
          if (proposal != null) {
            fieldMapBuilder.put("proposal", proposal);
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
    return PROJECT_LOCATION_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL.instantiate(
        "project",
        project,
        "location",
        location,
        "single_tenant_hsm_instance",
        singleTenantHsmInstance,
        "proposal",
        proposal);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SingleTenantHsmInstanceProposalName that = ((SingleTenantHsmInstanceProposalName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.singleTenantHsmInstance, that.singleTenantHsmInstance)
          && Objects.equals(this.proposal, that.proposal);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(singleTenantHsmInstance);
    h *= 1000003;
    h ^= Objects.hashCode(proposal);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/singleTenantHsmInstances/{single_tenant_hsm_instance}/proposals/{proposal}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String singleTenantHsmInstance;
    private String proposal;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSingleTenantHsmInstance() {
      return singleTenantHsmInstance;
    }

    public String getProposal() {
      return proposal;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSingleTenantHsmInstance(String singleTenantHsmInstance) {
      this.singleTenantHsmInstance = singleTenantHsmInstance;
      return this;
    }

    public Builder setProposal(String proposal) {
      this.proposal = proposal;
      return this;
    }

    private Builder(SingleTenantHsmInstanceProposalName singleTenantHsmInstanceProposalName) {
      this.project = singleTenantHsmInstanceProposalName.project;
      this.location = singleTenantHsmInstanceProposalName.location;
      this.singleTenantHsmInstance = singleTenantHsmInstanceProposalName.singleTenantHsmInstance;
      this.proposal = singleTenantHsmInstanceProposalName.proposal;
    }

    public SingleTenantHsmInstanceProposalName build() {
      return new SingleTenantHsmInstanceProposalName(this);
    }
  }
}
