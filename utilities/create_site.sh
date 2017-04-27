#!/bin/bash

set -e

SITE_VERSION=$1
SITE_VERSION_BASE=$(sed -r 's/([0-9]+\.[0-9]+\.[0-9]+).*/\1/' <<< "$SITE_VERSION")

echo "Creating site for google-cloud-java $SITE_VERSION_BASE"

if [ -z "$SITE_VERSION_BASE" ]; then
    echo "First arg (version) not provided, so we're exiting."
    exit 1
fi

git clone --branch gh-pages --single-branch https://github.com/GoogleCloudPlatform/google-cloud-java/ tmp_gh-pages
mkdir -p tmp_gh-pages/$SITE_VERSION_BASE
mvn site -DskipITs -Djava.util.logging.config.file=logging.properties
mvn site:stage --quiet -Djava.util.logging.config.file=logging.properties -DtopSiteURL=http://googlecloudplatform.github.io/google-cloud-java/site/${SITE_VERSION_BASE}/
cd tmp_gh-pages

for dir in ../target/staging/${SITE_VERSION_BASE}*
do
    cp -r ${dir}/* $SITE_VERSION_BASE/
done

sed -i "s/{{SITE_VERSION}}/$SITE_VERSION/g" ${SITE_VERSION_BASE}/index.html # Update "Quickstart with Maven" to reflect version change
git add $SITE_VERSION_BASE
echo "<html><head><meta http-equiv=\"refresh\" content=\"0; URL='http://GoogleCloudPlatform.github.io/google-cloud-java/${SITE_VERSION_BASE}/index.html'\" /></head><body></body></html>" > index.html
git add index.html
echo "<html><head><script>window.location.replace('/google-cloud-java/${SITE_VERSION_BASE}/apidocs' + location.search)</script></head><body></body></html>" > apidocs/index.html
git add apidocs/index.html

echo "Site generated under tmp_gh-pages/. The changes must be committed from that directory."
