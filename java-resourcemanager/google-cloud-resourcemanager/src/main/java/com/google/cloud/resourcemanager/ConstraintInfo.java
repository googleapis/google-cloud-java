/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.resourcemanager;

import com.google.api.services.cloudresourcemanager.model.BooleanConstraint;
import com.google.api.services.cloudresourcemanager.model.Constraint;
import com.google.api.services.cloudresourcemanager.model.ListConstraint;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * A Google Cloud Resource Manager constraint metadata object.
 *
 * @see <a
 *     href="https://cloud.google.com/resource-manager/reference/rest/v1/ListAvailableOrgPolicyConstraintsResponse#Constraint">Constraint</a>
 * @deprecated v3 GAPIC client of ResourceManager is now available
 */
@Deprecated
public class ConstraintInfo {

  static final Function<Constraint, ConstraintInfo> FROM_PROTOBUF_FUNCTION =
      new Function<Constraint, ConstraintInfo>() {
        @Override
        public ConstraintInfo apply(Constraint protobuf) {
          return ConstraintInfo.fromProtobuf(protobuf);
        }
      };
  static final Function<ConstraintInfo, Constraint> TO_PROTOBUF_FUNCTION =
      new Function<ConstraintInfo, Constraint>() {
        @Override
        public Constraint apply(ConstraintInfo constraintInfo) {
          return constraintInfo.toProtobuf();
        }
      };

  private BooleanConstraint booleanConstraint;
  private String constraintDefault;
  private String description;
  private String displayName;
  private Constraints constraints;
  private String name;
  private Integer version;

  /**
   * A Constraint that allows or disallows a list of string values, which are configured by an
   * Organization's policy administrator with a Policy.
   */
  static class Constraints {

    private final String suggestedValue;
    private final Boolean supportsUnder;

    Constraints(String suggestedValue, Boolean supportsUnder) {
      this.suggestedValue = suggestedValue;
      this.supportsUnder = supportsUnder;
    }

    /**
     * The Google Cloud Console tries to default to a configuration that matches the value specified
     * in this Constraint.
     */
    String getSuggestedValue() {
      return suggestedValue;
    }

    /**
     * Indicates whether subtrees of Cloud Resource Manager resource hierarchy can be used in
     * Policy.allowed_values and Policy.denied_values.
     */
    Boolean getSupportsUnder() {
      return supportsUnder;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("suggestedValue", getSuggestedValue())
          .add("supportsUnder", getSupportsUnder())
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(suggestedValue, supportsUnder);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Constraints that = (Constraints) o;
      return Objects.equals(suggestedValue, that.suggestedValue)
          && Objects.equals(supportsUnder, that.supportsUnder);
    }

    ListConstraint toProtobuf() {
      return new ListConstraint().setSuggestedValue(suggestedValue).setSupportsUnder(supportsUnder);
    }

    static Constraints fromProtobuf(ListConstraint listConstraint) {
      return new Constraints(listConstraint.getSuggestedValue(), listConstraint.getSupportsUnder());
    }
  }

  /** Builder for {@code ConstraintInfo}. */
  static class Builder {
    private BooleanConstraint booleanConstraint;
    private String constraintDefault;
    private String description;
    private String displayName;
    private Constraints constraints;
    private String name;
    private Integer version;

    Builder(String name) {
      this.name = name;
    }

    Builder(ConstraintInfo info) {
      this.booleanConstraint = info.booleanConstraint;
      this.constraintDefault = info.constraintDefault;
      this.description = info.description;
      this.displayName = info.displayName;
      this.constraints = info.constraints;
      this.name = info.name;
      this.version = info.version;
    }

    Builder setBooleanConstraint(BooleanConstraint booleanConstraint) {
      this.booleanConstraint = booleanConstraint;
      return this;
    }

    Builder setConstraintDefault(String constraintDefault) {
      this.constraintDefault = constraintDefault;
      return this;
    }

    Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    Builder setDisplayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    Builder setConstraints(Constraints constraints) {
      this.constraints = constraints;
      return this;
    }

    Builder setName(String name) {
      this.name = name;
      return this;
    }

    Builder setVersion(Integer version) {
      this.version = version;
      return this;
    }

    ConstraintInfo build() {
      return new ConstraintInfo(this);
    }
  }

  ConstraintInfo(Builder builder) {
    this.booleanConstraint = builder.booleanConstraint;
    this.constraintDefault = builder.constraintDefault;
    this.description = builder.description;
    this.displayName = builder.displayName;
    this.constraints = builder.constraints;
    this.name = builder.name;
    this.version = builder.version;
  }

  /** Returns the boolean constraint to check whether the constraint is enforced or not. */
  public BooleanConstraint getBooleanConstraint() {
    return booleanConstraint;
  }

  /** Returns the default behavior of the constraint. */
  public String getConstraintDefault() {
    return constraintDefault;
  }

  /** Returns the detailed description of the constraint. */
  public String getDescription() {
    return description;
  }

  /** Returns the human readable name of the constraint. */
  public String getDisplayName() {
    return displayName;
  }

  /** Returns the listConstraintInfo. */
  public Constraints getConstraints() {
    return constraints;
  }

  /** Returns the globally unique name of the constraint. */
  public String getName() {
    return name;
  }

  /** Returns the version of the Constraint. Default version is 0. */
  public Integer getVersion() {
    return version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstraintInfo that = (ConstraintInfo) o;
    return Objects.equals(booleanConstraint, that.booleanConstraint)
        && Objects.equals(constraintDefault, that.constraintDefault)
        && Objects.equals(description, that.description)
        && Objects.equals(displayName, that.displayName)
        && Objects.equals(constraints, that.constraints)
        && Objects.equals(name, that.name)
        && Objects.equals(version, that.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        booleanConstraint, constraintDefault, description, displayName, constraints, name, version);
  }

  /** Returns a builder for the {@link ConstraintInfo} object. */
  public static Builder newBuilder(String name) {
    return new Builder(name);
  }

  /** Returns a builder for the {@link ConstraintInfo} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  Constraint toProtobuf() {
    Constraint constraintProto = new Constraint();
    constraintProto.setBooleanConstraint(booleanConstraint);
    constraintProto.setConstraintDefault(constraintDefault);
    constraintProto.setDescription(description);
    constraintProto.setDisplayName(displayName);
    if (constraints != null) {
      constraintProto.setListConstraint(constraints.toProtobuf());
    }
    constraintProto.setName(name);
    constraintProto.setVersion(version);
    return constraintProto;
  }

  static ConstraintInfo fromProtobuf(Constraint constraintProtobuf) {
    Builder builder = newBuilder(constraintProtobuf.getName());
    builder.setBooleanConstraint(constraintProtobuf.getBooleanConstraint());
    builder.setConstraintDefault(constraintProtobuf.getConstraintDefault());
    builder.setDescription(constraintProtobuf.getDescription());
    builder.setDisplayName(constraintProtobuf.getDisplayName());
    if (constraintProtobuf.getListConstraint() != null) {
      builder.setConstraints(Constraints.fromProtobuf(constraintProtobuf.getListConstraint()));
    }
    if (constraintProtobuf.getName() != null && !constraintProtobuf.getName().equals("Unnamed")) {
      builder.setName(constraintProtobuf.getName());
    }
    builder.setVersion(constraintProtobuf.getVersion());
    return builder.build();
  }
}
