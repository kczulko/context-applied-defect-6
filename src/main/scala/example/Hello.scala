/**
    Running this code will throw:
    
    sbt:context-applied-bug> run
    [info] Compiling 1 Scala source to /home/karol/Projects/context-applied-bug/target/scala-2.12/classes ...
    [info] Done compiling.
    [info] running example.Main 
    [error] (run-main-2) java.lang.ClassFormatError: Illegal class name "example/SomeClass$Witness.Aux$A$" in class file example/SomeClass
    [error] java.lang.ClassFormatError: Illegal class name "example/SomeClass$Witness.Aux$A$" in class file example/SomeClass
    [error] 	at java.lang.ClassLoader.defineClass1(Native Method)
    [error] 	at java.lang.ClassLoader.defineClass(ClassLoader.java:757)
    [error] 	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
    [error] 	at java.net.URLClassLoader.defineClass(URLClassLoader.java:468)
    [error] 	at java.net.URLClassLoader.access$100(URLClassLoader.java:74)
    [error] 	at java.net.URLClassLoader$1.run(URLClassLoader.java:369)
    [error] 	at java.net.URLClassLoader$1.run(URLClassLoader.java:363)
    [error] 	at java.security.AccessController.doPrivileged(Native Method)
    [error] 	at java.net.URLClassLoader.findClass(URLClassLoader.java:362)
    [error] stack trace is suppressed; run last Compile / bgRun for the full output
    [error] Nonzero exit code: 1
    [error] (Compile / run) Nonzero exit code: 1
    [error] Total time: 0 s, completed 2020-04-17 21:45:11
*/

package example

import shapeless.Witness

abstract class SomeClass[A <: String](implicit w: Witness.Aux[A]) {
  type B
  def aName: String = w.value
}

object Main {

  object One extends SomeClass[Witness.`"One"`.T]
  
  def main(args: Array[String]): Unit = {
    println(One.aName)
  }
}
