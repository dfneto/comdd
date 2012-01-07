#!/bin/bash

java org.antlr.Tool *.g
javac *.java
java Test

