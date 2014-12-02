package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.ObjectStreamException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * A key that is guaranteed to be complete.
 */
public final class Key extends PartialKey {

  private static final long serialVersionUID = 3160994559785491356L;

  public static class Builder {

    private final PartialKey.Builder delegate;
    private String name;
    private Long id;

    public Builder(String dataset, String kind, String name) {
      delegate = new PartialKey.Builder(dataset, kind);
      this.name = name;
    }

    public Builder(String dataset, String kind, long id) {
      delegate = new PartialKey.Builder(dataset, kind);
      this.id = id;
    }

    public Builder(PartialKey key, String name) {
      delegate = new PartialKey.Builder(key);
      this.name = name;
    }

    public Builder(PartialKey key, long id) {
      delegate = new PartialKey.Builder(key);
      this.id = id;
    }

    public Builder setDataset(String dataset) {
      delegate.setDataset(checkNotNull(dataset));
      return this;
    }

    public Builder setNamespace(String namespace) {
      delegate.setNamespace(checkNotNull(namespace));
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      this.id = null;
      return this;
    }

    public Builder setId(long id) {
      this.id = id;
      this.name = null;
      return this;
    }

    public Builder addToPath(String kind, long id) {
      delegate.addToPath(kind, id);
      return this;
    }

    public Builder addToPath(String kind, String name) {
      delegate.addToPath(kind, name);
      return this;
    }

    public Builder clearPath() {
      delegate.clearPath();
      return this;
    }

    public Key build() {
      PartialKey key = delegate.build();
      return id == null ? new Key(key, name) : new Key(key, id);
    }
  }

  private Key(PartialKey key, String name) {
    super(key.getDataset(), key.getNamespace(), newPath(key, name));
  }

  private Key(PartialKey key, long id) {
    super(key.getDataset(), key.getNamespace(), newPath(key, id));
  }

  public Long getId() {
    return getLeaf().getId();
  }

  public String getName() {
    return getLeaf().getName();
  }

  public Object getNameOrId() {
    PathElement leaf = getLeaf();
    return leaf.hasId() ? leaf.getId() : leaf.getName();
  }

  public String toUrlSafe() {
    try {
      return URLEncoder.encode(toString(), UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Unxpeced encoding exception", e);
    }
  }

  public static Key fromUrlSafe(String urlSafe) {
    try {
      String utf8Str = URLDecoder.decode(urlSafe, UTF_8.name());
      DatastoreV1.Key keyPb = DatastoreV1.Key.parseFrom(ByteString.copyFromUtf8(utf8Str));
      return Key.fromPb(keyPb);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Unxpeced decoding exception", e);
    } catch (InvalidProtocolBufferException e) {
      throw new RuntimeException("Could not parse key", e);
    }
  }

  /**
   * Convert an {@code IncompleteKey} to a {@code Key} provided that the key has
   * either name or id (complete).

   * @throws IllegalArgumentException if provided key is not complete.
   */
  public static Key fromIncompleteKey(PartialKey key) {
    if (key instanceof Key) {
      return (Key) key;
    }
    PathElement leaf = key.getLeaf();
    if (leaf.hasId()) {
      return new Key(key, leaf.getId());
    } else if (leaf.hasName()) {
      return new Key(key, leaf.getName());
    }
    throw new IllegalArgumentException("Key is missing name or id");
  }

  static Key fromPb(DatastoreV1.Key keyPb) {
    return fromIncompleteKey(PartialKey.fromPb(keyPb));
  }

  @Override
  protected Object readResolve() throws ObjectStreamException {
    return fromIncompleteKey((PartialKey) super.readResolve());
  }

  private static ImmutableList<PathElement> newPath(PartialKey key, String name) {
    ImmutableList.Builder<PathElement> path = ImmutableList.builder();
    path.addAll(key.getAncestorPath());
    path.add(new PathElement(key.getKind(), name));
    return path.build();
  }

  private static ImmutableList<PathElement> newPath(PartialKey key, long id) {
    ImmutableList.Builder<PathElement> path = ImmutableList.builder();
    path.addAll(key.getAncestorPath());
    path.add(new PathElement(key.getKind(), id));
    return path.build();
  }
}
