#!/bin/sh


if [ -d .git ]; then
	for f in $(find .)
	do
		git 
else
	git rev-parse --git-dir 2> /dev/null;
fi;
