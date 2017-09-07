#!/bin/sh


if [ -d .git ]; then
	#for f in $(git ls-tree --name-only -r HEAD)
	#do
		git blame -e src/CowsBulls.java | grep -i $1 | sed "s/.* (<\(.*\)> .* .* .* \(.*\)) \(.*\)/\1:\2:\3/"
	#done;
#else
	#git rev-parse --git-dir 2> /dev/null;
fi;
