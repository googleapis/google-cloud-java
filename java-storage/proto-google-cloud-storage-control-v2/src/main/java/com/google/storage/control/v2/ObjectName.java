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

package com.google.storage.control.v2;

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
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class ObjectName implements ResourceName {
  private static final PathTemplate PROJECT_BUCKET_OBJECT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/buckets/{bucket}/objects/{object}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String bucket;
  private final String object;

  @Deprecated
  protected ObjectName() {
    project = null;
    bucket = null;
    object = null;
  }

  private ObjectName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    object = Preconditions.checkNotNull(builder.getObject());
  }

  public String getProject() {
    return project;
  }

  public String getBucket() {
    return bucket;
  }

  public String getObject() {
    return object;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ObjectName of(String project, String bucket, String object) {
    return newBuilder().setProject(project).setBucket(bucket).setObject(object).build();
  }

  public static String format(String project, String bucket, String object) {
    return newBuilder().setProject(project).setBucket(bucket).setObject(object).build().toString();
  }

  public static @Nullable ObjectName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_BUCKET_OBJECT.validatedMatch(
            formattedString, "ObjectName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("bucket"), matchMap.get("object"));
  }

  public static List<ObjectName> parseList(List<String> formattedStrings) {
    List<ObjectName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable ObjectName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ObjectName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_BUCKET_OBJECT.matches(formattedString);
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
          if (bucket != null) {
            fieldMapBuilder.put("bucket", bucket);
          }
          if (object != null) {
            fieldMapBuilder.put("object", object);
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
    return PROJECT_BUCKET_OBJECT.instantiate(
        "project", project, "bucket", bucket, "object", object);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ObjectName that = ((ObjectName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.bucket, that.bucket)
          && Objects.equals(this.object, that.object);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(bucket);
    h *= 1000003;
    h ^= Objects.hashCode(object);
    return h;
  }

  /** Builder for projects/{project}/buckets/{bucket}/objects/{object}. */
  public static class Builder {
    private String project;
    private String bucket;
    private String object;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getBucket() {
      return bucket;
    }

    public String getObject() {
      return object;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public Builder setObject(String object) {
      this.object = object;
      return this;
    }

    private Builder(ObjectName objectName) {
      this.project = objectName.project;
      this.bucket = objectName.bucket;
      this.object = objectName.object;
    }

    public ObjectName build() {
      return new ObjectName(this);
    }
  }
}
