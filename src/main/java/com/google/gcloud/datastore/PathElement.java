package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

/**
 * Represents a single element in a key's path.
 */
public final class PathElement extends Serializable<DatastoreV1.Key.PathElement> {

  private static final long serialVersionUID = -7968078857690784595L;

  private final transient String kind;
  private final transient Long id;
  private final transient String name;

  PathElement(String kind) {
    this(kind, null);
  }

  public PathElement(String kind, long id) {
    this.kind = kind;
    this.id = id;
    name = null;
  }

  public PathElement(String kind, String name) {
    this.kind = kind;
    this.name = name;
    id = null;
  }

  public String kind() {
    return kind;
  }

  public boolean hasId() {
    return id != null;
  }

  public Long id() {
    return id;
  }

  public boolean hasName() {
    return name != null;
  }

  public String name() {
    return name;
  }

  public Object nameOrId() {
    return id == null ? name : id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof PathElement)) {
      return false;
    }
    PathElement other = (PathElement) obj;
    return Objects.equals(kind, other.kind)
        && Objects.equals(id, other.id)
        && Objects.equals(name, other.name);
  }

  @Override
  protected DatastoreV1.Key.PathElement toPb() {
    DatastoreV1.Key.PathElement.Builder pathElementPb = DatastoreV1.Key.PathElement.newBuilder();
    pathElementPb.setKind(kind);
    if (id != null) {
      pathElementPb.setId(id);
    } else if (name != null) {
      pathElementPb.setName(name);
    }
    return pathElementPb.build();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Key.PathElement.parseFrom(bytesPb));
  }

  static PathElement fromPb(DatastoreV1.Key.PathElement pathElementPb) {
    String kind = pathElementPb.getKind();
    if (pathElementPb.hasId()) {
      return new PathElement(kind, pathElementPb.getId());
    } else if (pathElementPb.hasName()) {
      return new PathElement(kind, pathElementPb.getName());
    }
    return new PathElement(kind);
  }
}
