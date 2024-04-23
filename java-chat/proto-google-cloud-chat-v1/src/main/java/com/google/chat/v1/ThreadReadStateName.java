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

package com.google.chat.v1;

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
public class ThreadReadStateName implements ResourceName {
  private static final PathTemplate USER_SPACE_THREAD =
      PathTemplate.createWithoutUrlEncoding(
          "users/{user}/spaces/{space}/threads/{thread}/threadReadState");
  private volatile Map<String, String> fieldValuesMap;
  private final String user;
  private final String space;
  private final String thread;

  @Deprecated
  protected ThreadReadStateName() {
    user = null;
    space = null;
    thread = null;
  }

  private ThreadReadStateName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    space = Preconditions.checkNotNull(builder.getSpace());
    thread = Preconditions.checkNotNull(builder.getThread());
  }

  public String getUser() {
    return user;
  }

  public String getSpace() {
    return space;
  }

  public String getThread() {
    return thread;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ThreadReadStateName of(String user, String space, String thread) {
    return newBuilder().setUser(user).setSpace(space).setThread(thread).build();
  }

  public static String format(String user, String space, String thread) {
    return newBuilder().setUser(user).setSpace(space).setThread(thread).build().toString();
  }

  public static ThreadReadStateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        USER_SPACE_THREAD.validatedMatch(
            formattedString, "ThreadReadStateName.parse: formattedString not in valid format");
    return of(matchMap.get("user"), matchMap.get("space"), matchMap.get("thread"));
  }

  public static List<ThreadReadStateName> parseList(List<String> formattedStrings) {
    List<ThreadReadStateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ThreadReadStateName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ThreadReadStateName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER_SPACE_THREAD.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (user != null) {
            fieldMapBuilder.put("user", user);
          }
          if (space != null) {
            fieldMapBuilder.put("space", space);
          }
          if (thread != null) {
            fieldMapBuilder.put("thread", thread);
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
    return USER_SPACE_THREAD.instantiate("user", user, "space", space, "thread", thread);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ThreadReadStateName that = ((ThreadReadStateName) o);
      return Objects.equals(this.user, that.user)
          && Objects.equals(this.space, that.space)
          && Objects.equals(this.thread, that.thread);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(space);
    h *= 1000003;
    h ^= Objects.hashCode(thread);
    return h;
  }

  /** Builder for users/{user}/spaces/{space}/threads/{thread}/threadReadState. */
  public static class Builder {
    private String user;
    private String space;
    private String thread;

    protected Builder() {}

    public String getUser() {
      return user;
    }

    public String getSpace() {
      return space;
    }

    public String getThread() {
      return thread;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    public Builder setThread(String thread) {
      this.thread = thread;
      return this;
    }

    private Builder(ThreadReadStateName threadReadStateName) {
      this.user = threadReadStateName.user;
      this.space = threadReadStateName.space;
      this.thread = threadReadStateName.thread;
    }

    public ThreadReadStateName build() {
      return new ThreadReadStateName(this);
    }
  }
}
