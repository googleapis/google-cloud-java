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
public final class Key extends IncompleteKey {

  private static final long serialVersionUID = 3160994559785491356L;

  public static class Builder {

    private final IncompleteKey.Builder keyBuilder;
    private String name;
    private Long id;

    public Builder(String dataset, String kind, String name) {
      keyBuilder = new IncompleteKey.Builder(dataset, kind);
      this.name = name;
    }

    public Builder(String dataset, String kind, long id) {
      keyBuilder = new IncompleteKey.Builder(dataset, kind);
      this.id = id;
    }

    public Builder(IncompleteKey key, String name) {
      keyBuilder = new IncompleteKey.Builder(key);
      this.name = name;
    }

    public Builder(IncompleteKey key, long id) {
      keyBuilder = new IncompleteKey.Builder(key);
      this.id = id;
    }

    public Builder setDataset(String dataset) {
      keyBuilder.setDataset(checkNotNull(dataset));
      return this;
    }

    public Builder setNamespace(String namespace) {
      keyBuilder.setNamespace(checkNotNull(namespace));
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
      keyBuilder.addToPath(kind, id);
      return this;
    }

    public Builder addToPath(String kind, String name) {
      keyBuilder.addToPath(kind, name);
      return this;
    }

    public Builder clearPath() {
      keyBuilder.clearPath();
      return this;
    }

    public Key build() {
      IncompleteKey key = keyBuilder.build();
      return id == null ? new Key(key, name) : new Key(key, id);
    }
  }

  private Key(IncompleteKey key, String name) {
    super(key.getDataset(), key.getNamespace(), newPath(key, name));
  }

  private Key(IncompleteKey key, long id) {
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
  public static Key fromIncompleteKey(IncompleteKey key) {
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
    return fromIncompleteKey(IncompleteKey.fromPb(keyPb));
  }

  @Override
  @SuppressWarnings("unused")
  protected Object readResolve() throws ObjectStreamException {
    return fromIncompleteKey((IncompleteKey) super.readResolve());
  }

  private static ImmutableList<PathElement> newPath(IncompleteKey key, String name) {
    ImmutableList.Builder<PathElement> path = ImmutableList.builder();
    path.addAll(key.getAncestorPath());
    path.add(new PathElement(key.getKind(), name));
    return path.build();
  }

  private static ImmutableList<PathElement> newPath(IncompleteKey key, long id) {
    ImmutableList.Builder<PathElement> path = ImmutableList.builder();
    path.addAll(key.getAncestorPath());
    path.add(new PathElement(key.getKind(), id));
    return path.build();
  }
}
