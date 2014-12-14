package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;


// TODO(ozarov): add a usage examples (gql and regular)
/**
 * A Google Cloud Datastore query.
 *
 * @param <T> the type of the values returned by this query.
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/queries">Datastore Queries</a>
 */
public abstract class Query<T> extends Serializable<GeneratedMessage> {

  private static final long serialVersionUID = -2748141759901313101L;

  private final ResultClass<T> resultClass;
  private final String namespace;

  public static class ResultClass<T> implements java.io.Serializable {

    private static final long serialVersionUID = 2104157695425806623L;
    private static final ResultClass<?> UNKNOWN = new ResultClass<>(Object.class);
    private static final ResultClass<Entity> FULL = new ResultClass<>(Entity.class);
    private static final ResultClass<Key> KEY_ONLY = new ResultClass<>(Key.class);
    private static final ResultClass<PartialEntity> PROJECTION =
        new ResultClass<>(PartialEntity.class);

    private final Class<T> value;

    private ResultClass(Class<T> value) {
      this.value = checkNotNull(value);
    }

    public Class<T> value() {
      return value;
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof ResultClass)) {
        return false;
      }
      ResultClass<?> other = (ResultClass<?>) obj;
      return value.equals(other.value);
    }

    @Override
    public String toString() {
      ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
      toStringHelper.add("value", value);
      return toStringHelper.toString();
    }

    boolean isAssignableFrom(ResultClass<?> resultClass) {
      return value.isAssignableFrom(resultClass.value);
    }

    static ResultClass<?> unknown() {
      return UNKNOWN;
    }

    public static ResultClass<Entity> full() {
      return FULL;
    }

    public static ResultClass<PartialEntity> projection() {
      return PROJECTION;
    }

    public static ResultClass<Key> keyOnly() {
      return KEY_ONLY;
    }
  }

  /**
   * Possible results types are:
   *   FULL: A complete {@link Entity}.
   *   PROJECTION: A partial entity, represented by {@link PartialEntity}.
   *   KEY_ONLY: An entity's {@link Key}.
   */
  public static enum Type {

    FULL {
      @Override
      @SuppressWarnings("unchecked")
      Entity convert(DatastoreV1.Entity value) {
        return Entity.fromPb(value);
      }

      @Override
      ResultClass<Entity> resultClass() {
        return ResultClass.full();
      }
    },

    PROJECTION  {

      @Override
      @SuppressWarnings("unchecked")
      PartialEntity convert(DatastoreV1.Entity value) {
        return PartialEntity.fromPb(value);
      }

      @Override
      ResultClass<PartialEntity> resultClass() {
        return ResultClass.projection();
      }
    },

    KEY_ONLY {

      @Override
      @SuppressWarnings("unchecked")
      Key convert(DatastoreV1.Entity value) {
        return Key.fromPb(value.getKey());
      }

      @Override
      ResultClass<PartialEntity> resultClass() {
        return ResultClass.projection();
      }
    };

    abstract <T> T convert(DatastoreV1.Entity value);

    abstract ResultClass<?> resultClass();
  }

  Query(ResultClass<T> resultClass, String namespace) {
    this.resultClass = checkNotNull(resultClass);
    this.namespace = namespace;
  }

  ResultClass<T> getResultClass() {
    return resultClass;
  }

  public String namespace() {
    return namespace;
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    toStringHelper.add("namespace", namespace);
    toStringHelper.add("queryPb", super.toString());
    return toStringHelper.toString();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(resultClass, namespace, bytesPb);
  }

  protected abstract Object fromPb(ResultClass<T> resultClass, String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException;

  protected abstract void populatePb(DatastoreV1.RunQueryRequest.Builder requestPb);

  protected abstract Query<T> nextQuery(DatastoreV1.QueryResultBatch responsePb);
}
