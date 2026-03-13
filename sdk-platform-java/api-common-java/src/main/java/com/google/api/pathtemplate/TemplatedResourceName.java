/*
 * Copyright 2016, Google Inc.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.pathtemplate;

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
 * <p>A resource name is represented by {@link PathTemplate}, an assignment to variables in the
 * template, and an optional endpoint. The {@code ResourceName} class implements the map interface
 * (unmodifiable) to work with the variable assignments, and has methods to reproduce the string
 * representation of the name, to construct new names, and to dereference names into resources.
 *
 * <p>As a resource name essentially represents a match of a path template against a string, it can
 * be also used for other purposes than naming resources. However, not all provided methods may make
 * sense in all applications.
 *
 * <p>Usage examples:
 *
 * <pre>{@code
 * PathTemplate template = PathTemplate.create("shelves/*&#47;books/*");
 * TemplatedResourceName resourceName = TemplatedResourceName.create(template, "shelves/s1/books/b1");
 * assert resourceName.get("$1").equals("b1");
 * assert resourceName.parentName().toString().equals("shelves/s1/books");
 * }</pre>
 */
public class TemplatedResourceName implements Map<String, String> {

  // ResourceName Resolver
  // =====================

  /** Represents a resource name resolver which can be registered with this class. */
  public interface Resolver {
    /** Resolves the resource name into a resource by calling the underlying API. */
    <T> T resolve(Class<T> resourceType, TemplatedResourceName name, @Nullable String version);
  }

  // The registered resource name resolver.
  // TODO(wrwg): its a bit spooky to have this static global. Think of ways to
  // configure this from the outside instead if programmatically (e.g. java properties).
  private static volatile Resolver resourceNameResolver =
      new Resolver() {
        @Override
        public <T> T resolve(Class<T> resourceType, TemplatedResourceName name, String version) {
          throw new IllegalStateException(
              "No resource name resolver is registered in ResourceName class.");
        }
      };

  /**
   * Sets the resource name resolver which is used by the {@link #resolve(Class, String)} method. By
   * default, no resolver is registered.
   */
  public static void registerResourceNameResolver(Resolver resolver) {
    resourceNameResolver = resolver;
  }

  // ResourceName
  // ============

  /**
   * Creates a new resource name based on given template and path. The path must match the template,
   * otherwise null is returned.
   *
   * @throws ValidationException if the path does not match the template.
   */
  public static TemplatedResourceName create(PathTemplate template, String path) {
    Map<String, String> values = template.match(path);
    if (values == null) {
      throw new ValidationException("path '%s' does not match template '%s'", path, template);
    }
    return new TemplatedResourceName(template, values, null);
  }

  /**
   * Creates a new resource name from a template and a value assignment for variables.
   *
   * @throws ValidationException if not all variables in the template are bound.
   */
  public static TemplatedResourceName create(PathTemplate template, Map<String, String> values) {
    if (!values.keySet().containsAll(template.vars())) {
      Set<String> unbound = Sets.newLinkedHashSet(template.vars());
      unbound.removeAll(values.keySet());
      throw new ValidationException("unbound variables: %s", unbound);
    }
    return new TemplatedResourceName(template, values, null);
  }

  /**
   * Creates a new resource name based on given template and path, where the path contains an
   * endpoint. If the path does not match, null is returned.
   */
  @Nullable
  public static TemplatedResourceName createFromFullName(PathTemplate template, String path) {
    Map<String, String> values = template.matchFromFullName(path);
    if (values == null) {
      return null;
    }
    return new TemplatedResourceName(template, values, null);
  }

  private final PathTemplate template;
  private final ImmutableMap<String, String> values;
  private final String endpoint;

  private volatile String stringRepr;

  private TemplatedResourceName(
      PathTemplate template, Map<String, String> values, String endpoint) {
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
    if (!(obj instanceof TemplatedResourceName)) {
      return false;
    }
    TemplatedResourceName other = (TemplatedResourceName) obj;
    return Objects.equals(template, other.template)
        && Objects.equals(endpoint, other.endpoint)
        && Objects.equals(values, other.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template, endpoint, values);
  }

  /** Gets the template associated with this resource name. */
  public PathTemplate template() {
    return template;
  }

  /** Checks whether the resource name has an endpoint. */
  public boolean hasEndpoint() {
    return endpoint != null;
  }

  /** Returns the endpoint of this resource name, or null if none is defined. */
  @Nullable
  public String endpoint() {
    return endpoint;
  }

  /** Returns a resource name with specified endpoint. */
  public TemplatedResourceName withEndpoint(String endpoint) {
    return new TemplatedResourceName(template, values, Preconditions.checkNotNull(endpoint));
  }

  /**
   * Returns the parent resource name. For example, if the name is {@code shelves/s1/books/b1}, the
   * parent is {@code shelves/s1/books}.
   */
  public TemplatedResourceName parentName() {
    PathTemplate parentTemplate = template.parentTemplate();
    return new TemplatedResourceName(parentTemplate, values, endpoint);
  }

  /**
   * Returns true of the resource name starts with the parent resource name, i.e. is a child of the
   * parent.
   */
  public boolean startsWith(TemplatedResourceName parentName) {
    // TODO: more efficient implementation.
    return toString().startsWith(parentName.toString());
  }

  /**
   * Attempts to resolve a resource name into a resource, by calling the associated API. The
   * resource name must have an endpoint. An optional version can be specified to determine in which
   * version of the API to call.
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
