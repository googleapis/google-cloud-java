package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

/**
 * Represents a single element in a key's path.
 */
public final class KeyPathElement extends Serializable<DatastoreV1.Key.PathElement> {

  private static final long serialVersionUID = -7968078857690784595L;

  private final transient String kind;
  private final transient Long id;
  private final transient String name;

  KeyPathElement(String kind) {
    this(kind, null);
  }

  public KeyPathElement(String kind, long id) {
    this.kind = kind;
    this.id = id;
    name = null;
  }

  public KeyPathElement(String kind, String name) {
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
    if (!(obj instanceof KeyPathElement)) {
      return false;
    }
    KeyPathElement other = (KeyPathElement) obj;
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

  static KeyPathElement fromPb(DatastoreV1.Key.PathElement pathElementPb) {
    String kind = pathElementPb.getKind();
    if (pathElementPb.hasId()) {
      return new KeyPathElement(kind, pathElementPb.getId());
    } else if (pathElementPb.hasName()) {
      return new KeyPathElement(kind, pathElementPb.getName());
    }
    return new KeyPathElement(kind);
  }
}
