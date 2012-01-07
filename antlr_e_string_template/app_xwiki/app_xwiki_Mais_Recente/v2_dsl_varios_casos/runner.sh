#!/bin/bash


./cleaner.sh &> /dev/null
java org.antlr.Tool *.g
javac *.java
java Main
