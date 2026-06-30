# Google Auth Library

Open source authentication client library for Java.

[![stable](http://badges.github.io/stability-badges/dist/stable.svg)](http://github.com/badges/stability-badges)
[![Maven](https://img.shields.io/maven-central/v/com.google.auth/google-auth-library-credentials.svg)](https://img.shields.io/maven-central/v/com.google.auth/google-auth-library-credentials.svg)

## Documentation

See the [official guide](https://cloud.google.com/java/getting-started/getting-started-with-google-auth-library) for ways
to authenticate to Google Cloud and for more information about the Google Auth Library.

See the [API Documentation](https://cloud.google.com/java/docs/reference/google-auth-library/latest/overview.html) to see
the Javadocs for Google Auth Library.

## Versioning

This library follows [Semantic Versioning](http://semver.org/), but with some
additional qualifications:

1. Components marked with `@ObsoleteApi` are stable for usage in the current major version,
   but will be marked with `@Deprecated` in a future major version.
   **NOTE**: We reserve the right to mark anything as `@Deprecated` and introduce breaking
   changes in a minor version to fix any ***critical bugs and
   vulnerabilities***.

2. Components marked with `@InternalApi` are technically public, but are only
   public for technical reasons, because of the limitations of Java's access
   modifiers. For the purposes of semver, they should be considered private.

3. Components marked with `@InternalExtensionOnly` are stable for usage, but
   not for extension. Thus, methods will not be removed from interfaces marked
   with this annotation, but methods can be added, thus breaking any
   code implementing the interface. See the javadocs for more details on other
   consequences of this annotation.

4. Components marked with `@BetaApi` are considered to be "0.x" features inside
   a "1.x" library. This means they can change between minor and patch releases
   in incompatible ways. These features should not be used by any library "B"
   that itself has consumers, unless the components of library B that use
   `@BetaApi` features are also marked with `@BetaApi`. Features marked as
   `@BetaApi` are on a path to eventually become "1.x" features with the marker
   removed.

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING](CONTRIBUTING.md) documentation for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct](CODE_OF_CONDUCT.md) for more
information.

## Running the Tests

To run the tests you will need:

* Maven 3+

```bash
$ mvn test
```
   
## License

BSD 3-Clause - See [LICENSE](LICENSE) for more information.

[appengine-sdk-versions]: https://search.maven.org/search?q=g:com.google.appengine%20AND%20a:appengine-api-1.0-sdk&core=gav
[appengine-sdk-install]: https://github.com/googleapis/google-auth-library-java/blob/main/README.md#google-auth-library-appengine
[appengine-app-identity-service]: https://cloud.google.com/appengine/docs/java/javadoc/com/google/appengine/api/appidentity/AppIdentityService
[apiary-clients]: https://search.maven.org/search?q=g:com.google.apis
[http-credentials-adapter]: https://googleapis.dev/java/google-auth-library/latest/index.html?com/google/auth/http/HttpCredentialsAdapter.html
[http-request-initializer]: https://googleapis.dev/java/google-http-client/latest/index.html?com/google/api/client/http/HttpRequestInitializer.html
[token-verifier]: https://googleapis.dev/java/google-auth-library/latest/index.html?com/google/auth/oauth2/TokenVerifier.html
[token-verifier-builder]: https://googleapis.dev/java/google-auth-library/latest/index.html?com/google/auth/oauth2/TokenVerifier.Builder.html
[http-transport-factory]: https://googleapis.dev/java/google-auth-library/latest/index.html?com/google/auth/http/HttpTransportFactory.html
[google-credentials]: https://googleapis.dev/java/google-auth-library/latest/index.html?com/google/auth/oauth2/GoogleCredentials.html
