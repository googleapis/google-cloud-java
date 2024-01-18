# Docker container for Owl Bot Postprocessor

This container runs when Owl Bot Postprocessor runs on this google-cloud-java
monorepo. The Cloud Build in the repo-automation-bots GCP project publishes
`gcr.io/cloud-devrel-public-resources/owlbot-java-monorepo` image.

Note that the split repositories (such as [googleapis/java-bigquery](
https://github.com/googleapis/java-bigquery)) continue to use the
`gcr.io/cloud-devrel-public-resources/owlbot-java` image, maintained in
[googleapis/synthtool](
https://github.com/googleapis/synthtool/tree/master/docker/owlbot/java)
repository.

This separation allows us to focus on monorepo-specific postprocessor logic in
this `owlbot-java-monorepo` image, without interfering the split repositories.

# Principles

## Thin Container
This docker container is "thin", meaning that we do not install the
postprocessor logic into the container. Rather, the container executes scripts
that live in the repository.

This design allows us the template logic changes and affected file changes
within one pull request. No need to rebuild the postprocessor image.

## Secure by Cloud Build

Executing the scripts within the container in Owl Bot's Cloud Build environment
ensures the secure runtime that only allows access to the repository
(no access to credentials).

# How to Build

You can build the container locally:

```
~/google-cloud-java$ docker build -f owl-bot-postprocessor/Dockerfile owl-bot-postprocessor
```
