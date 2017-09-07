#!/bin/sh

IS_IN_REPO = $(git rev-parse --is-inside-work-tree)

if [ ${IS_IN_REPO} == "true" ];
then echo "yes"
else echo "no"
fi
