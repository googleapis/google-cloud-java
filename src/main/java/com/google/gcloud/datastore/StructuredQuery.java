package com.google.gcloud.datastore;

import com.google.api.client.util.Preconditions;
import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

public final class StructuredQuery<T> extends Query<T> {

  private static final long serialVersionUID = 546838955624019594L;

  private final transient boolean keysOnly;
  private final transient String kind;
  private final transient ImmutableSet<String> projections;
  private final transient Cursor startCursor;
  private final transient Cursor endCursor;
  private final transient Integer offset;
  private final transient Integer limit;


  static class Builder {

    private String namespace;
    private String kind;
    private Cursor startCursor;
    private Cursor endCursor;
    private Integer offset;
    private Integer limit;

    public Builder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    public Builder startCursor(Cursor startCursor) {
      this.startCursor = startCursor;
      return this;
    }

    public Builder encCursor(Cursor endCursor) {
      this.endCursor = endCursor;
      return this;
    }

    public Builder offset(Integer offset) {
      Preconditions.checkArgument(offset == null || offset >= 0, "offset must not be negative");
      this.offset = offset;
      return this;
    }

    public Builder limit(Integer limit) {
      Preconditions.checkArgument(limit == null || offset > 0, "limit must be positive");
      this.limit = limit;
      return this;
    }

    public StructuredQuery<Entity> full() {
      return new StructuredQuery<>(ResultType.full(), this, false);
    }

    public StructuredQuery<PartialEntity> projection(String projection, String... other) {
      ImmutableSet<String> projections =
          ImmutableSet.<String>builder().add(projection).add(other).build();
      return new StructuredQuery<>(ResultType.projection(), this, projections);
    }

    public StructuredQuery<Key> keyOnly() {
      return new StructuredQuery<>(ResultType.keyOnly(), this, true);
    }
  }

  private StructuredQuery(ResultType<T> resultType, Builder builder,
      ImmutableSet<String> projections) {
    super(resultType, builder.namespace);
    kind = builder.kind;
    startCursor = builder.startCursor;
    endCursor = builder.endCursor;
    offset = builder.offset;
    limit = builder.limit;
    this.projections = projections;
    keysOnly = false;
  }

  private StructuredQuery(ResultType<T> resultType, Builder builder, boolean keysOnly) {
    super(resultType, builder.namespace);
    kind = builder.kind;
    startCursor = builder.startCursor;
    endCursor = builder.endCursor;
    offset = builder.offset;
    limit = builder.limit;
    this.keysOnly = keysOnly;
    projections = ImmutableSet.of();
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace(), kind, startCursor, endCursor, offset, limit);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof StructuredQuery)) {
      return false;
    }
    StructuredQuery<?> other = (StructuredQuery<?>) obj;
    return Objects.equals(namespace(), other.namespace())
        && Objects.equals(kind, other.kind)
        && Objects.equals(startCursor, other.startCursor)
        && Objects.equals(endCursor, other.endCursor)
        && Objects.equals(offset, other.offset)
        && Objects.equals(limit, other.limit);
  }

  @Override
  protected void populatePb(DatastoreV1.RunQueryRequest.Builder requestPb, int totalRead,
      ByteString batchCursor) {
    if (batchCursor == null) {
      requestPb.setQuery(toPb());
      return;
    }
    throw new UnsupportedOperationException("paging not implemented yet");
  }

  @Override
  protected Object fromPb(ResultType<T> resultType, String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException {
    return fromPb(resultType, namespace, DatastoreV1.Query.parseFrom(bytesPb));
  }

  @Override
  protected DatastoreV1.Query toPb() {
    DatastoreV1.Query.Builder queryPb = DatastoreV1.Query.newBuilder();
    if (kind != null) {
      queryPb.addKindBuilder().setName(kind);
    }
    if (startCursor != null) {
      queryPb.setStartCursor(startCursor.byteString());
    }
    if (endCursor != null) {
      queryPb.setEndCursor(endCursor.byteString());
    }
    if (offset != null) {
      queryPb.setOffset(offset);
    }
    if (limit != null) {
      queryPb.setLimit(limit);
    }
    return queryPb.build();
  }

  static <T> StructuredQuery<T> fromPb(ResultType<T> resultType, String namespace,
      DatastoreV1.Query queryPb) {
    return null;
  }
}
