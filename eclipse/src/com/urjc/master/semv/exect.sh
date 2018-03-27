#!/bin/bash

rm parser.class
rm parser.java
rm sym.java
rm sym.class
rm AnalizadorLexico.java


sleep 1

jflex lexico.flex
java -jar java-cup-11b.jar parser.cup

javac -Xlint *.java

java Analizador test.c

