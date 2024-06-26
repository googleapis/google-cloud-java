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

package com.google.cloud.gdchardwaremanagement.v1alpha;

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
public class CommentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ORDER_COMMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/orders/{order}/comments/{comment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String order;
  private final String comment;

  @Deprecated
  protected CommentName() {
    project = null;
    location = null;
    order = null;
    comment = null;
  }

  private CommentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    order = Preconditions.checkNotNull(builder.getOrder());
    comment = Preconditions.checkNotNull(builder.getComment());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getOrder() {
    return order;
  }

  public String getComment() {
    return comment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CommentName of(String project, String location, String order, String comment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setOrder(order)
        .setComment(comment)
        .build();
  }

  public static String format(String project, String location, String order, String comment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setOrder(order)
        .setComment(comment)
        .build()
        .toString();
  }

  public static CommentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ORDER_COMMENT.validatedMatch(
            formattedString, "CommentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("order"),
        matchMap.get("comment"));
  }

  public static List<CommentName> parseList(List<String> formattedStrings) {
    List<CommentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CommentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CommentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ORDER_COMMENT.matches(formattedString);
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
          if (order != null) {
            fieldMapBuilder.put("order", order);
          }
          if (comment != null) {
            fieldMapBuilder.put("comment", comment);
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
    return PROJECT_LOCATION_ORDER_COMMENT.instantiate(
        "project", project, "location", location, "order", order, "comment", comment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CommentName that = ((CommentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.order, that.order)
          && Objects.equals(this.comment, that.comment);
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
    h ^= Objects.hashCode(order);
    h *= 1000003;
    h ^= Objects.hashCode(comment);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/orders/{order}/comments/{comment}. */
  public static class Builder {
    private String project;
    private String location;
    private String order;
    private String comment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getOrder() {
      return order;
    }

    public String getComment() {
      return comment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setOrder(String order) {
      this.order = order;
      return this;
    }

    public Builder setComment(String comment) {
      this.comment = comment;
      return this;
    }

    private Builder(CommentName commentName) {
      this.project = commentName.project;
      this.location = commentName.location;
      this.order = commentName.order;
      this.comment = commentName.comment;
    }

    public CommentName build() {
      return new CommentName(this);
    }
  }
}
