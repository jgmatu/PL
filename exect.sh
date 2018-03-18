#!/bin/bash

rm parser.class
rm parser.java
rm sym.java
rm sym.class
rm AnalizadorLexico.java


sleep 1

jflex lexico.flex
java -jar java-cup-11b.jar -dump parser.cup

export CLASSPATH=$CLASSPATH:/home/javi/PL/java-cup-11b.jar
export CLASSPATH=$CLASSPATH:/usr/bin/jflex
export CLASSPATH=$CLASSPATH:/home/javi/PL/java-cup-11b-runtime.jar

javac -Xlint Analizador.java

java Analizador test.c

