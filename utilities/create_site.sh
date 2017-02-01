#!/bin/bash

set -e

SITE_VERSION=$1

echo "Creating docs for google-cloud-java $SITE_VERSION"

if [ -z "$SITE_VERSION" ]; then
    echo "First arg (version) not provided, so we're exiting."
    exit 1
fi

git clone --branch gh-pages --single-branch https://github.com/GoogleCloudPlatform/google-cloud-java/ tmp_gh-pages
mkdir -p tmp_gh-pages/$SITE_VERSION
mvn site -DskipTests=true -Djava.util.logging.config.file=logging.properties
mvn site:stage --quiet -Djava.util.logging.config.file=logging.properties -DtopSiteURL=http://googlecloudplatform.github.io/google-cloud-java/site/${SITE_VERSION}/
cd tmp_gh-pages

for dir in ../target/staging/${SITE_VERSION}*
do
    cp -r ${dir}/* $SITE_VERSION/
done

sed -i "s/{{SITE_VERSION}}/$SITE_VERSION/g" ${SITE_VERSION}/index.html # Update "Quickstart with Maven" to reflect version change
git add $SITE_VERSION
echo "<html><head><meta http-equiv=\"refresh\" content=\"0; URL='http://GoogleCloudPlatform.github.io/google-cloud-java/${SITE_VERSION}/index.html'\" /></head><body></body></html>" > index.html
git add index.html
echo "<html><head><script>window.location.replace('/google-cloud-java/${SITE_VERSION}/apidocs' + location.search)</script></head><body></body></html>" > apidocs/index.html
git add apidocs/index.html

echo "Site generated under tmp_gh-pages/. The changes must be committed from that directory."
echo "Recommended commands: (this will push the new site to the gh-pages branch)"
echo "  cd tmp_gh-pages"
echo "  git commit -m \"Added a new site for version $SITE_VERSION and updated the root directory's redirect. [ci skip]\""
echo "  git push"
