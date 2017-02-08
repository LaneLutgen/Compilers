#!/bin/bash

THE_CLASSPATH=
for i in `ls ANTLR/*.jar`
  do
  THE_CLASSPATH=${THE_CLASSPATH}:${i}
done

javac -classpath ".:${THE_CLASSPATH}" ANTLR/generated/*.java src/task/*.java src/object/*.java src/driver/*.java src/client/*.java

if [ $? -eq 0 ]
then
  echo "compile worked!"
fi

sleep 5
