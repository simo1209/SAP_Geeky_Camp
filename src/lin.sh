#!/bin/sh

for f in $(find .)
do
	echo $(git blame ${f})
done
