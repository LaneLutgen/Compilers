#!/bin/bash

THE_CLASSPATH=
for i in `ls ANTLR/*.jar`
  do
  THE_CLASSPATH=${THE_CLASSPATH}:${i}
done

THE_CLASSPATH=${THE_CLASSPATH}:ANTLR/generated
THE_CLASSPATH=${THE_CLASSPATH}:src

echo ${THE_CLASSPATH}

javac -classpath ".:${THE_CLASSPATH}" ANTLR/generated/*.java src/task/*.java src/object/*.java src/driver/*.java src/client/*.java

java -cp ${THE_CLASSPATH} client.Main

sleep 2
