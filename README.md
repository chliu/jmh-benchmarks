# jmh-benchmarks

This project contains several micro-benchmarks to stress specific points of the my
compilation and runtime strategies.


## Building

This Maven project builds a self-contained executable Jar file in `target/`:

    $ mvn clean install

It uses the [OpenJDK JMH benchmark harness](http://openjdk.java.net/projects/code-tools/jmh/).

We tend to be on the bleeding-edge of JMH, so you may need to build yourself a local copy
from a Mercurial checkout:

    $ hg clone http://hg.openjdk.java.net/code-tools/jmh/ jmh
    $ cd jmh/
    $ mvn clean install -DskipTests=true

## Running

JMH-produced executable Jars support many options, so list them all:

    $ java -jar target/microbenchmarks.jar --help

A typical execution could look as follows:

    $ java -jar target/microbenchmarks.jar -f 1 -w 2s -r 2s
