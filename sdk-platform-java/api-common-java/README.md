API Common for Java
==============================

[![Build Status](https://travis-ci.org/googleapis/api-common-java.svg?branch=main)](https://travis-ci.org/googleapis/api-common-java)

- [Documentation](https://googleapis.dev/java/api-common/latest/index.html)

API Common for Java is a library for foundational types relating to Google
APIs. It currently contains the following packages:
- core: Core library containing API stability annotations and wrappers around
  Guava types
- pathtemplate: Path Template library for manipulating strings that are
  formatted as Google API resource names.
- resourcenames: Resource Name library used by generated resource name types

Java Versions
-------------

Java 8 or above is required for using this library.

To build this project, JDK 11 or above is required.
The build produces Java bytecode targeted for Java 8.

The project uses Maven to build.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/), but with some
additional qualifications:

1. Components marked with `@BetaApi` are considered to be "0.x" features inside
   a "1.x" library. This means they can change between minor and patch releases
   in incompatible ways. These features should not be used by any library "B"
   that itself has consumers, unless the components of library B that use
   `@BetaApi` features are also marked with `@BetaApi`. Features marked as
   `@BetaApi` are on a path to eventually become "1.x" features with the marker
   removed.
1. Components marked with `@InternalApi` are technically public, but are only
   public for technical reasons, because of the limitations of Java's access
   modifiers. For the purposes of semver, they should be considered private.

This library is currently in major version one (``1.y.z``), which means that
any public API not specifically marked as `@BetaApi` or `@InternalApi` can be considered
stable. They will not change without incrementing the major version to 2.x or later,
and probably not then.

License
-------

BSD 3-Clause - See [LICENSE] for more information.

Build and Test
--------------
To build this library, please do the following.

```sh
mvn clean install
```

After making changes, run the following commands to format your code and test your changes.

```sh
mvn fmt:format
mvn test
```

[CONTRIBUTING]:https://github.com/googleapis/api-common-java/blob/main/CONTRIBUTING.md
[LICENSE]: https://github.com/googleapis/api-common-java/blob/main/LICENSE

