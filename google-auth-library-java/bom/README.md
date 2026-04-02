# Google Auth Library Bill of Materials

The `google-auth-library-bom` is a pom that can be used to import consistent versions of
`google-auth-library` components plus its dependencies.

To use it in Maven, add the following to your `pom.xml`:

[//]: # ({x-version-update-start:google-auth-library-bom:released})
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.auth</groupId>
      <artifactId>google-auth-library-bom</artifactId>
      <version>0.17.1</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```
[//]: # ({x-version-update-end})

## License

Apache 2.0 - See [LICENSE] for more information.

[LICENSE]: https://github.com/googleapis/google-auth-library-java/blob/main/LICENSE
