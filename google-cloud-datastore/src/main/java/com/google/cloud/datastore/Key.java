/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.TextFormat;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * A key that is guaranteed to be complete and could be used to reference a Google Cloud Datastore
 * {@link Entity}. This class is immutable.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore
 *     Entities, Properties, and Keys</a>
 */
public final class Key extends IncompleteKey {

  private static final long serialVersionUID = 2563249643000943477L;

  public static final class Builder extends BaseKey.Builder<Builder> {

    private String name;
    private Long id;

    private Builder(String projectId, String kind, String name) {
      super(projectId, kind);
      this.name = name;
    }

    private Builder(String projectId, String kind, long id) {
      super(projectId, kind);
      this.id = id;
    }

    private Builder(String projectId, String kind, long id, String databaseId) {
      super(projectId, kind);
      this.id = id;
      this.databaseId = databaseId;
    }

    private Builder(String projectId, String kind, String name, String databaseId) {
      super(projectId, kind);
      this.name = name;
      this.databaseId = databaseId;
    }

    private Builder(IncompleteKey copyFrom, String name) {
      super(copyFrom);
      this.name = name;
    }

    private Builder(IncompleteKey copyFrom, long id) {
      super(copyFrom);
      this.id = id;
    }

    private Builder(Key copyFrom) {
      super(copyFrom);
      if (copyFrom.hasId()) {
        id = copyFrom.getId();
      } else {
        name = copyFrom.getName();
      }
    }

    /** Sets the name of this key. */
    public Builder setName(String name) {
      this.name = name;
      id = null;
      return this;
    }

    /** Sets the ID of this key. */
    public Builder setId(long id) {
      this.id = id;
      name = null;
      return this;
    }

    @Override
    public Key build() {
      ImmutableList.Builder<PathElement> pathBuilder =
          ImmutableList.<PathElement>builder().addAll(ancestors);
      if (id == null) {
        pathBuilder.add(PathElement.of(kind, name));
      } else {
        pathBuilder.add(PathElement.of(kind, id));
      }
      return new Key(projectId, namespace, databaseId, pathBuilder.build());
    }
  }

  Key(String projectId, String namespace, ImmutableList<PathElement> path) {
    super(projectId, namespace, path);
    Preconditions.checkArgument(getNameOrId() != null);
  }

  Key(String projectId, String namespace, String databaseId, ImmutableList<PathElement> path) {
    super(projectId, namespace, databaseId, path);
    Preconditions.checkArgument(getNameOrId() != null);
  }

  public boolean hasId() {
    return getLeaf().hasId();
  }

  /** Returns the key's id or {@code null} if it has a name instead. */
  public Long getId() {
    return getLeaf().getId();
  }

  public boolean hasName() {
    return getLeaf().hasName();
  }

  /** Returns the key's name or {@code null} if it has an id instead. */
  public String getName() {
    return getLeaf().getName();
  }

  /** Returns the key's ID (as {@link Long}) or name (as {@link String}). Never {@code null}. */
  public Object getNameOrId() {
    return getLeaf().getNameOrId();
  }

  /** Returns the key in an encoded form that can be used as part of a URL. */
  public String toUrlSafe() {
    try {
      return URLEncoder.encode(TextFormat.printToString(toPb()), UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException("Unexpected encoding exception", e);
    }
  }

  /**
   * Create a {@code Key} given its URL safe encoded form.
   *
   * @throws IllegalArgumentException when decoding fails
   */
  public static Key fromUrlSafe(String urlSafe) {
    try {
      String utf8Str = URLDecoder.decode(urlSafe, UTF_8.name());
      com.google.datastore.v1.Key.Builder builder = com.google.datastore.v1.Key.newBuilder();
      TextFormat.merge(utf8Str, builder);
      return fromPb(builder.build());
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException("Unexpected decoding exception", e);
    } catch (TextFormat.ParseException e) {
      throw new IllegalArgumentException("Could not parse key", e);
    }
  }

  static Key fromPb(com.google.datastore.v1.Key keyPb) {
    IncompleteKey key = IncompleteKey.fromPb(keyPb);
    Preconditions.checkState(key instanceof Key, "Key is not complete");
    return (Key) key;
  }

  public static Builder newBuilder(String projectId, String kind, String name) {
    return new Builder(projectId, kind, name);
  }

  public static Builder newBuilder(String projectId, String kind, String name, String databaseId) {
    return new Builder(projectId, kind, name, databaseId);
  }

  public static Builder newBuilder(String projectId, String kind, long id) {
    return new Builder(projectId, kind, id);
  }

  public static Builder newBuilder(String projectId, String kind, long id, String databaseId) {
    return new Builder(projectId, kind, id, databaseId);
  }

  public static Builder newBuilder(Key copyFrom) {
    return new Builder(copyFrom);
  }

  public static Builder newBuilder(IncompleteKey copyFrom, String name) {
    return new Builder(copyFrom, name);
  }

  public static Builder newBuilder(IncompleteKey copyFrom, long id) {
    return new Builder(copyFrom, id);
  }

  public static Builder newBuilder(Key parent, String kind, String name) {
    Builder builder = newBuilder(parent.getProjectId(), kind, name, parent.getDatabaseId());
    addParentToBuilder(parent, builder);
    return builder;
  }

  public static Builder newBuilder(Key parent, String kind, long id) {
    Builder builder = newBuilder(parent.getProjectId(), kind, id, parent.getDatabaseId());
    addParentToBuilder(parent, builder);
    return builder;
  }

  private static void addParentToBuilder(Key parent, Builder builder) {
    builder.setNamespace(parent.getNamespace());
    builder.addAncestors(parent.getAncestors());
    if (parent.hasId()) {
      builder.addAncestors(PathElement.of(parent.getKind(), parent.getId()));
    } else {
      builder.addAncestors(PathElement.of(parent.getKind(), parent.getName()));
    }
  }
}
