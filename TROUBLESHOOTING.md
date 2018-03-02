# Troubleshooting

## "ALPN is not configured properly"

This exception usually indicates that Netty isn't set up properly.

If using gRPC version 1.9.0 or newer, consider using `io.grpc:grpc-netty-shaded`
dependency so that it does not conflict with other packages that also require Netty.

If your gRPC dependency is older than 1.9.0, consider updating.
As of 0.35.0, packages in `google-cloud-java` already declare a dependency on `grpc-netty-shaded`.

The versions of `gprc-netty-shaded` must match the version of other gRPC dependencies.
Packages in `google-cloud-java` already do this for you.
However, if you need to declare dependency on gRPC yourself, we recommend doing it like this:
```
<properties>
  <grpc.version>1.9.0</grpc.version>
</properties>

<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>io.grpc</groupId>
      <artifactId>grpc-core</artifactId>
      <version>${grpc.version}</version>
    </dependency>
    <dependency>
      <groupId>io.grpc</groupId>
      <artifactId>grpc-netty-shaded</artifactId>
      <version>${grpc.version}</version>
    </dependency>
  </dependencies>
</dependencyManagement>
```
so that versions cannot go out of sync.

See [gRPC documentation](https://github.com/grpc/grpc-java/blob/master/SECURITY.md#troubleshooting)
for more details.

## `ClassNotFoundException` or `NoSuchMethodError`

This is usually caused by multiple packages depending on different versions
of the same dependencies.
`com.google.protobuf:protobuf-java` and `com.google.guava:guava` are the usual culprits,
since they are widely used.

Consider using the [Enforcer Plugin](https://maven.apache.org/enforcer/maven-enforcer-plugin/index.html)
to verify version convergence.

Alternatively, consider [shading](https://maven.apache.org/plugins/maven-shade-plugin/)
these dependencies.
