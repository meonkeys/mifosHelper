#!/bin/sh
set -ex
mkdir -p target
cd target
tar -xzf ../cvsexport-2010-11-23.tar.gz
cd maven-gettext-plugin
mvn install
