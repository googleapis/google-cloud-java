package io.gapi.gax.protobuf;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * Class for representing and working with resource names.
 *
 * <p>A resource name is represented by {@link PathTemplate}, an assignment to variables in
 * the template, and an optional endpoint. The {@code ResourceName} class implements
 * the map interface (unmodifiable) to work with the variable assignments, and has methods
 * to reproduce the string representation of the name, to construct new names, and to dereference
 * names into resources.
 *
 * <p>As a resource name essentially represents a match of a path template against a string, it
 * can be also used for other purposes than naming resources. However, not all provided methods
 * may make sense in all applications.
 *
 * <p>Usage examples:
 *
 * <pre>
 *   PathTemplate template = PathTemplate.create("shelves/*&#47;books/*");
 *   ResourceName resourceName = ResourceName.create(template, "shelves/s1/books/b1");
 *   assert resourceName.get("$1").equals("b1");
 *   assert resourceName.parentName().toString().equals("shelves/s1/books");
 * </pre>
 */
@Beta
public class ResourceName implements Map<String, String> {

  // ResourceName Resolver
  // =====================

  /**
   * Represents a resource name resolver which can be registered with this class.
   */
  public interface Resolver {
    /**
     * Resolves the resource name into a resource by calling the underlying API.
     */
    <T> T resolve(Class<T> resourceType, ResourceName name, @Nullable String version);
  }

  // The registered resource name resolver.
  // TODO(wgg): its a bit spooky to have this static global. Think of ways to
  // configure this from the outside instead if programmatically (e.g. java properties).
  private static volatile Resolver resourceNameResolver = new Resolver() {
    @Override
    public <T> T resolve(Class<T> resourceType, ResourceName name, String version) {
      throw new IllegalStateException(
          "No resource name resolver is registered in ResourceName class.");
    }
  };

  /**
   * Sets the resource name resolver which is used by the {@link #resolve(Class, String)} method.
   * By default, no resolver is registered.
   */
  public static void registerResourceNameResolver(Resolver resolver) {
    resourceNameResolver = resolver;
  }

  // ResourceName
  // ============

  /**
   * Creates a new resource name based on given template and path. The path must match
   * the template, otherwise null is returned.
   *
   * @throws ValidationException if the path does not match the template.
   */
  public static ResourceName create(PathTemplate template, String path) {
    ImmutableMap<String, String> values = template.match(path);
    if (values == null) {
      throw new ValidationException("path '%s' does not match template '%s'", path, template);
    }
    return new ResourceName(template, values, null);
  }

  /**
   * Creates a new resource name from a template and a value assignment for variables.
   *
   * @throws ValidationException if not all variables in the template are bound.
   */
  public static ResourceName create(PathTemplate template, Map<String, String> values) {
    if (!values.keySet().containsAll(template.vars())) {
      Set<String> unbound = Sets.newLinkedHashSet(template.vars());
      unbound.removeAll(values.keySet());
      throw new ValidationException("unbound variables: %s", unbound);
    }
    return new ResourceName(template, values, null);
  }

  /**
   * Creates a new resource name based on given template and path, where the path contains an
   * endpoint. If the path does not match, null is returned.
   */
  @Nullable
  public static ResourceName createFromFullName(PathTemplate template, String path) {
    ImmutableMap<String, String> values = template.matchFromFullName(path);
    if (values == null) {
      return null;
    }
    return new ResourceName(template, values, null);
  }

  private final PathTemplate template;
  private final ImmutableMap<String, String> values;
  private final String endpoint;

  private volatile String stringRepr;

  private ResourceName(PathTemplate template, Map<String, String> values, String endpoint) {
    this.template = template;
    this.values = ImmutableMap.copyOf(values);
    this.endpoint = endpoint;
  }

  @Override
  public String toString() {
    if (stringRepr == null) {
      stringRepr = template.instantiate(values);
    }
    return stringRepr;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof ResourceName)) {
      return false;
    }
    ResourceName other = (ResourceName) obj;
    return Objects.equals(template, other.template)
        && Objects.equals(endpoint,  other.endpoint)
        && Objects.equals(values, other.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template, endpoint, values);
  }

  /**
   * Gets the template associated with this resource name.
   */
  public PathTemplate template() {
    return template;
  }

  /**
   * Checks whether the resource name has an endpoint.
   */
  public boolean hasEndpoint() {
    return endpoint != null;
  }

  /**
   * Returns the endpoint of this resource name, or null if none is defined.
   */
  @Nullable
  public String endpoint() {
    return endpoint;
  }

  /**
   * Returns a resource name with specified endpoint.
   */
  public ResourceName withEndpoint(String endpoint) {
    return new ResourceName(template, values, Preconditions.checkNotNull(endpoint));
  }

  /**
   * Returns the parent resource name. For example, if the name is {@code shelves/s1/books/b1}, the
   * parent is {@code shelves/s1/books}.
   */
  public ResourceName parentName() {
    PathTemplate parentTemplate = template.parentTemplate();
    return new ResourceName(parentTemplate, values, endpoint);
  }

  /**
   * Returns true of the resource name starts with the parent resource name, i.e. is a child
   * of the parent.
   */
  public boolean startsWith(ResourceName parentName) {
    // TODO(wgg): more efficient implementation.
    return toString().startsWith(parentName.toString());
  }

  /**
   * Attempts to resolve a resource name into a resource, by calling the associated API.
   * The resource name must have an endpoint. An optional version can be specified to
   * determine in which version of the API to call.
   */
  public <T> T resolve(Class<T> resourceType, @Nullable String version) {
    Preconditions.checkArgument(hasEndpoint(), "Resource name must have an endpoint.");
    return resourceNameResolver.resolve(resourceType, this, version);
  }

  // Map Interface
  // =============

  @Override
  public int size() {
    return values.size();
  }

  @Override
  public boolean isEmpty() {
    return values.isEmpty();
  }

  @Override
  public boolean containsKey(Object key) {
    return values.containsKey(key);
  }

  @Override
  public boolean containsValue(Object value) {
    return values.containsValue(value);
  }

  @Override
  public String get(Object key) {
    return values.get(key);
  }

  @Override
  @Deprecated
  public String put(String key, String value) {
    return values.put(key, value);
  }

  @Override
  @Deprecated
  public String remove(Object key) {
    return values.remove(key);
  }

  @Override
  @Deprecated
  public void putAll(Map<? extends String, ? extends String> m) {
    values.putAll(m);
  }

  @Override
  @Deprecated
  public void clear() {
    values.clear();
  }

  @Override
  public Set<String> keySet() {
    return values.keySet();
  }

  @Override
  public Collection<String> values() {
    return values.values();
  }

  @Override
  public Set<Entry<String, String>> entrySet() {
    return values.entrySet();
  }
}
