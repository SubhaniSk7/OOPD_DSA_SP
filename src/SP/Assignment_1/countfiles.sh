#!/bin/sh

if [ $# -eq 0 ] || [ $# -gt 2 ]		# comparing no.of parameters- if no.of parameters are not 1 or 2 then exit
then 
	echo "wrong no. of parameters"
	exit 0		# Normal exit
elif ! test -d "$1"	# testing a file is directory or not
then
	echo "not directory"
	exit 0
elif ! [ -r "$1" ]	# checking a file has read permissions or not
then
	echo "not readable directory"
	exit 0
fi

cd $1	# navigating to specified directory

if [ -z $2 ]	# checking extension(second parameter) is null string or not
then
	ls -p | grep -v / | wc -l	# counting regular files when No Extension
else
	ls -l *.$2 | wc -l	# counting regular files when Extension
fi
