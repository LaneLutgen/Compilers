#!/bin/bash

THE_CLASSPATH=
for i in `ls ANTLR/*.jar`
  do
  THE_CLASSPATH=${THE_CLASSPATH}:${i}
done

THE_CLASSPATH=${THE_CLASSPATH}:ANTLR
THE_CLASSPATH=${THE_CLASSPATH}:src

javac -classpath ".:${THE_CLASSPATH}" ANTLR/generated/*.java src/task/*.java src/object/*.java src/driver/*.java src/client/*.java

java -cp ${THE_CLASSPATH} client.Main $1

sleep 2
