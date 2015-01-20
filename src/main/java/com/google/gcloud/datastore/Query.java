/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.Maps;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Map;


/**
 * A Google Cloud Datastore query.
 * For usage examples see {@link GqlQuery} and {@link StructuredQuery}.
 *
 * @param <V> the type of the values returned by this query.
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/queries">Datastore Queries</a>
 */
public abstract class Query<V> extends Serializable<GeneratedMessage> {

  private static final long serialVersionUID = -2748141759901313101L;

  private final Type<V> type;
  private final String namespace;

  /**
   * This class represents the expected type of the result.
   *   FULL: A complete {@link Entity}.
   *   PROJECTION: A partial entity, represented by {@link PartialEntity}.
   *   KEY_ONLY: An entity's {@link Key}.
   */
  public abstract static class Type<V> implements java.io.Serializable {

    private static final long serialVersionUID = 2104157695425806623L;
    private static final Map<DatastoreV1.EntityResult.ResultType, Type<?>>
        PB_TO_INSTANCE = Maps.newEnumMap(DatastoreV1.EntityResult.ResultType.class);

    static final Type<?> UNKNOWN = new Type<Object>(null, Object.class) {

      private static final long serialVersionUID = 1602329532153860907L;

      @Override protected Object convert(DatastoreV1.Entity entityPb) {
        if (entityPb.getPropertyCount() == 0) {
          if (!entityPb.hasKey()) {
            return null;
          }
          return Key.fromPb(entityPb.getKey());
        }
        return ProjectionEntity.fromPb(entityPb);
      }
    };

    public static final Type<Entity> FULL =
        new Type<Entity>(DatastoreV1.EntityResult.ResultType.FULL, Entity.class) {

      private static final long serialVersionUID = 7712959777507168274L;

      @Override protected Entity convert(DatastoreV1.Entity entityPb) {
        return Entity.fromPb(entityPb);
      }
    };

    public static final Type<Key> KEY_ONLY =
        new Type<Key>(DatastoreV1.EntityResult.ResultType.KEY_ONLY, Key.class) {

      private static final long serialVersionUID = -8514289244104446252L;

      @Override protected Key convert(DatastoreV1.Entity entityPb) {
        return Key.fromPb(entityPb.getKey());
      }
    };

    public static final Type<ProjectionEntity> PROJECTION = new Type<ProjectionEntity>(
        DatastoreV1.EntityResult.ResultType.PROJECTION, ProjectionEntity.class) {

          private static final long serialVersionUID = -7591409419690650246L;

          @Override protected ProjectionEntity convert(DatastoreV1.Entity entityPb) {
            return ProjectionEntity.fromPb(entityPb);
          }
    };

    private final Class<V> resultClass;
    private final DatastoreV1.EntityResult.ResultType resultType;

    private Type(DatastoreV1.EntityResult.ResultType typePb, Class<V> resultClass) {
      this.resultType = typePb;
      this.resultClass = checkNotNull(resultClass);
      if (typePb != null) {
        PB_TO_INSTANCE.put(typePb, this);
      }
    }

    public Class<V> resultClass() {
      return resultClass;
    }

    @Override
    public int hashCode() {
      return resultClass.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof Type)) {
        return false;
      }
      Type<?> other = (Type<?>) obj;
      return resultClass.equals(other.resultClass);
    }

    @Override
    public String toString() {
      ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
      toStringHelper.add("resultType", resultType);
      toStringHelper.add("resultClass", resultClass);
      return toStringHelper.toString();
    }

    boolean isAssignableFrom(Type<?> otherType) {
      return resultClass.isAssignableFrom(otherType.resultClass);
    }

    protected abstract V convert(DatastoreV1.Entity entityPb);

    static Type<?> fromPb(DatastoreV1.EntityResult.ResultType typePb) {
      return MoreObjects.firstNonNull(PB_TO_INSTANCE.get(typePb), UNKNOWN);
    }
  }

  Query(Type<V> type, String namespace) {
    this.type = checkNotNull(type);
    this.namespace = namespace;
  }

  Type<V> type() {
    return type;
  }

  public String namespace() {
    return namespace;
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    toStringHelper.add("type", type);
    toStringHelper.add("namespace", namespace);
    toStringHelper.add("queryPb", super.toString());
    return toStringHelper.toString();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(type, namespace, bytesPb);
  }

  protected abstract Object fromPb(Type<V> type, String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException;

  protected abstract void populatePb(DatastoreV1.RunQueryRequest.Builder requestPb);

  protected abstract Query<V> nextQuery(DatastoreV1.QueryResultBatch responsePb);
}
