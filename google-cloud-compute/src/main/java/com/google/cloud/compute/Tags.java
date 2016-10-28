/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.compute;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A list of tags for a Google Compute Engine Instance; with associated fingerprint. Tags are used
 * to identify valid sources or targets for network firewalls and are specified by the client
 * during instance creation. Each tag within the list must comply with RFC1035.
 *
 * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
 */
public final class Tags implements Serializable {

  static final Function<com.google.api.services.compute.model.Tags, Tags> FROM_PB_FUNCTION =
      new Function<com.google.api.services.compute.model.Tags, Tags>() {
        @Override
        public Tags apply(com.google.api.services.compute.model.Tags pb) {
          return Tags.fromPb(pb);
        }
      };
  static final Function<Tags, com.google.api.services.compute.model.Tags> TO_PB_FUNCTION =
      new Function<Tags, com.google.api.services.compute.model.Tags>() {
        @Override
        public com.google.api.services.compute.model.Tags apply(Tags tags) {
          return tags.toPb();
        }
      };

  private static final long serialVersionUID = 5627093820497225322L;

  private final List<String> values;
  private final String fingerprint;

  /**
   * A builder for {@code Tags} objects.
   */
  public static final class Builder {

    private List<String> values;
    private String fingerprint;

    private Builder() {
      values = Lists.newArrayList();
    }

    private Builder(Tags tags) {
      this.values = tags.values != null ? Lists.newArrayList(tags.values)
          : Lists.<String>newArrayList();
      this.fingerprint = tags.fingerprint;
    }

    /**
     * Sets a list of tags to apply to an instance. Tags are used to identify valid sources or
     * targets for network firewalls. Each tag within the list must comply with RFC1035.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
     */
    @Deprecated
    public Builder values(Iterable<String> values) {
      return setValues(values);
    }

    /**
     * Sets a list of tags to apply to an instance. Tags are used to identify valid sources or
     * targets for network firewalls. Each tag within the list must comply with RFC1035.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
     */
    public Builder setValues(Iterable<String> values) {
      this.values = Lists.newArrayList(values);
      return this;
    }

    /**
     * Sets a list of tags to apply to an instance. Tags are used to identify valid sources or
     * targets for network firewalls. Each tag within the list must comply with RFC1035.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
     */
    @Deprecated
    public Builder values(String... values) {
      return setValues(values);
    }

    /**
     * Sets a list of tags to apply to an instance. Tags are used to identify valid sources or
     * targets for network firewalls. Each tag within the list must comply with RFC1035.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
     */
    public Builder setValues(String... values) {
      this.values = Lists.newArrayList(Arrays.asList(checkNotNull(values)));
      return this;
    }

    /**
     * Adds a tag to the list of tags. Tags are used to identify valid sources or targets for
     * network firewalls. The tag must comply with RFC1035.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
     */
    public Builder add(String tag) {
      this.values.add(tag);
      return this;
    }

    /**
     * Sets the fingerprint for the tags. This value is needed to update instance's tags.
     */
    @Deprecated
    public Builder fingerprint(String fingerprint) {
      return setFingerprint(fingerprint);
    }

    /**
     * Sets the fingerprint for the tags. This value is needed to update instance's tags.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /**
     * Creates a {@code Tags} object.
     */
    public Tags build() {
      return new Tags(this);
    }
  }

  private Tags(Builder builder) {
    this.values = ImmutableList.copyOf(builder.values);
    this.fingerprint = builder.fingerprint;
  }

  /**
   * Returns a list of tags to apply to an instance. Tags are used to identify valid sources or
   * targets for network firewalls. Each tag within the list must comply with RFC1035.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  @Deprecated
  public List<String> values() {
    return getValues();
  }

  /**
   * Returns a list of tags to apply to an instance. Tags are used to identify valid sources or
   * targets for network firewalls. Each tag within the list must comply with RFC1035.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public List<String> getValues() {
    return values;
  }

  /**
   * Returns the fingerprint for the tags. This value is needed to update instance's tags.
   */
  @Deprecated
  public String fingerprint() {
    return getFingerprint();
  }

  /**
   * Returns the fingerprint for the tags. This value is needed to update instance's tags.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * Returns a builder for the current instance tags.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("values", values)
        .add("fingerprint", fingerprint)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(values, fingerprint);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj instanceof Tags && Objects.equals(toPb(), ((Tags) obj).toPb());
  }

  com.google.api.services.compute.model.Tags toPb() {
    com.google.api.services.compute.model.Tags tagsPb =
        new com.google.api.services.compute.model.Tags();
    tagsPb.setFingerprint(fingerprint);
    tagsPb.setItems(values);
    return tagsPb;
  }

  /**
   * Returns a builder for a {@code Tags} object given the tags to apply to the instance. Each tag
   * within the list must comply with RFC1035.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  @Deprecated
  public static Builder builder(Iterable<String> values) {
    return newBuilder(values);
  }

  /**
   * Returns a builder for a {@code Tags} object given the tags to apply to the instance. Each tag
   * within the list must comply with RFC1035.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static Builder newBuilder(Iterable<String> values) {
    return new Builder().setValues(values);
  }

  /**
   * Returns a builder for a {@code Tags} object given the tags to apply to the instance. Each tag
   * within the list must comply with RFC1035.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  @Deprecated
  public static Builder builder(String... values) {
    return newBuilder(values);
  }

  /**
   * Returns a builder for a {@code Tags} object given the tags to apply to the instance. Each tag
   * within the list must comply with RFC1035.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static Builder newBuilder(String... values) {
    return new Builder().setValues(values);
  }

  /**
   * Returns a {@code Tags} object given the tags to apply to the instance. Each tag within the
   * list must comply with RFC1035.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static Tags of(Iterable<String> values) {
    return newBuilder(values).build();
  }

  /**
   * Returns a {@code Tags} object given the tags to apply to the instance. Each tag within the
   * list must comply with RFC1035.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static Tags of(String... values) {
    return newBuilder(values).build();
  }

  static Tags fromPb(com.google.api.services.compute.model.Tags tagsPb) {
    Builder builder =
        newBuilder(tagsPb.getItems() != null ? tagsPb.getItems() : ImmutableList.<String>of());
    return builder.setFingerprint(tagsPb.getFingerprint()).build();
  }
}
