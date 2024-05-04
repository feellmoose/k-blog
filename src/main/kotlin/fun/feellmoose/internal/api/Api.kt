package `fun`.feellmoose.internal.api

import `fun`.feellmoose.internal.domain.article.Article
import `fun`.feellmoose.internal.domain.article.Author
import java.time.LocalDateTime

object Api {
    fun articleOfId(articleId: Long?): Article {
        return Author(123, "").createArticle(
            title = "Java代码是怎么跑起来的",
            markdown = """


当我们尝试运行 Java 代码时，这些代码会被编译为字节码文件并被加载运行于 JVM 上。如果能够更加细致的了解 Java 代码从编译到运行这个过程，那我们就可以在更好掌控代码的同时更加深入的理解 Java 的语法和其设计。

初次接触 Java 时，绝大部分同学都粗略了解过 Java 是如何运行的 —— 我们尝试运行代码时，这些代码便会被编译为字节码文件，然后加载运行在 JVM 上。

如果我们能够更加细致的了解从  Java 代码编译到运行的整个过程，自然可以更好掌控代码，同时能够以更加深入的视角的理解 Java 的语法和其设计。

JVM 是 Java 生态的核心技术，它与标准库一起构成了语言运行时。它能够执行字节码，有自己完善的硬件架构，如处理器、堆栈、寄存器等，还具有相应的指令系统。JVM 屏蔽了与具体操作系统平台相关的信息，使得字节码可以在多种平台上不加修改地运行。

接下来我们从 **编译 加载 运行** 三个方面简单分析 JVM 是如何处理我们的代码的。

---

#### 编译 Java 代码

在最开始我们会将 Java 编译为字节码文件，但是请注意在整个流程中编译并不会只发生在这里。

Java 的编译体系分为**前端编译**和**后端编译**，前端编译是将 Java 代码编译为**字节码**的过程，前端编译完成后，**每个 class 都会被编译成对应的字节码文件**，字节码可以直接由 JVM 加载并**解释**运行，我们来动手操作一下。

我们首先创建一个 java 文件 `Main.java` 并写入一个常见的 Java 类。

```Java
public class Main {
    //varible with value
	private boolean b = true;
    //static varible with value 
	public static int a = 1000;
    //static block
	static{
		a = 100;	
	}
    //main method
	public static void main(String[] args){
		System.out.println("Hello world!");
	}
    
    //inner class
	public static class Inner{
		private int i;
		public static double d;
        //constructer of inner class
        public Inner(int i){
            this.i = i;
        }
	}
    
}
```

接下来我们开始编译 Java 代码。使用 `javac Main.java ` 编译后得到了两个文件 `Main.class`  `Main${'$'}Inner.class` 。

得到的文件就是虚拟机加载运行的字节码文件，我们打开字节码文件，发现两个文件都是无法直接阅读的二进制机器码。为了更好的编辑和查看二进制文件，我们可以使用一些辅助插件。下面是编译好的十六进制的字节码，可以看到它们开头都具有相同的数字 `CAFEBABE` ，这串数字叫做 magic ，用来区分字节码和其他二进制代码。

```
CA FE BA BE 00 00 00 3E 00 2B 0A 00 02 00 03 07
00 04 0C 00 05 00 06 01 00 10 6A 61 76 61 2F 6C
...
00 00 02 00 25 00 26 00 00 00 04 00 01 00 27 00
29 00 00 00 0A 00 01 00 27 00 08 00 2A 00 09
```

```
CA FE BA BE 00 00 00 3E 00 19 0A 00 02 00 03 07
00 04 0C 00 05 00 06 01 00 10 6A 61 76 61 2F 6C
...
00 00 00 02 00 13 00 14 00 00 00 02 00 15 00 17
00 00 00 0A 00 01 00 08 00 15 00 18 00 09
```

Java 前端编译过程相较于 c 和 c++ 等语言来说非常迅速，因为字节码文件之间并不需要进行链接等费时操作。字节码文件中会带有虚拟机版本，不同版本的 JDK 的编译器编译结果可能有所不同，但总体来说不同版本之间一般满足向上兼容性。

Java 为帮助程序员阅读底层二进制代码，JDK 自带了分析工具 `javap` 辅助我们分析字节码文件。接下来我们使用 `javap -c Main.class`  `javap -c 'Main${'$'}Inner.class'` 查看字节码。

```java
Compiled from "Main.java"
public class Main {
  public static int a;

  public Main();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iconst_1
       6: putfield      #7                  // Field b:Z
       9: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #13                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #19                 // String Hello world!
       5: invokevirtual #21                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return

  static {};
    Code:
       0: sipush        1000
       3: putstatic     #27                 // Field a:I
       6: bipush        100
       8: putstatic     #27                 // Field a:I
      11: return
}
```

```java
Compiled from "Main.java"
public class Main${'$'}Inner {
  public static double d;

  public Main${'$'}Inner(int);
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iload_1
       6: putfield      #7                  // Field i:I
       9: return
}
```

我们注意到，Java 中**每个类会生成各自的字节码文件**，其中包括字节码版本，各自类的元数据和静态常量池，元数据就是各种类的信息如属性、方法、访问权限等，而静态常量池主要用来存储静态数据，如方法名、类名、常量等。在解释阶段，JVM 通过解释字节码将其翻译成对应的机器指令，逐条读入，逐条解释。

其中出现的 `<init>` 和 `<clinit>` 方法被用来初始化实例和类型，它们会在类型实例化和加载时被调用。其中如 `java/io/PrintStream` 被称为类的全限定名。

JVM 通过加载字节码来读取程序信息，而每个字节码文件分别对应一个类，也就是说一般情况下 JVM 运行所有的代码都是通过加载类来实现的，这也是为什么 Java 是一门纯粹的面向对象设计语言。

---

#### JVM 内存模型

编译完成后程序不会立即被解释运行， JVM 会首先加载并验证字节码文件。但在了解 JVM 加载字节码的过程之前，我们需要首先对 JVM 内存模型有大致的了解。

常见的简单内存模型通常由**内存**以及**线程**组成。在 JVM 中内存可以分为堆、栈和元空间。

##### 线程 

线程是程序运行的基本单位，一个程序一般对应一个进程，一个进程通常可以由个线程组成。能够同时运行多个线程的环境称为多线程环境，通过并发处理多个线程，可以高效利用 CPU 资源。

##### 元空间  

[元空间](https://wiki.openjdk.org/display/HotSpot/Metaspace)，存储类的元数据，字节码和运行时常量池等，内部使用一个虚函数表维持对于每个方法的引用，元空间在类加载时被分配，在类卸载时被释放。

##### 堆 

**堆内存**用来存储**实例**和**数组**等数据，每个实例拥有自己独立的变量内存并使用静态区公共的类方法。堆内存是 Java 程序最主要的内存区域，**堆是程序内所有线程共有的**。

##### 栈 

程序运行过程中**实际的变量位于栈区**，如果变量是实例则通过指针维持对于堆区对象的引用。栈区用于存储方法调用时的局部变量、方法参数和返回值等数据。栈内存由 JVM 自动分配和回收，**每个线程都有自己的独立栈空间**。

---

#### JVM 加载字节码

在运行字节码前，JVM会首先加载字节码文件，**字节码在 JVM 在运行过程中被动态地加载到程序中，在不需要时被动态卸载**。这一过程具体可以分为，加载、验证、准备、解析、初始化、使用、卸载，大体按照顺序穿插进行。

1. 加载 ，通过类的全限定名获取字节码文件读入虚拟机，并将读入的二进制字节流转换为相应的运行时结构如 [Klass]() (一种底层结构, 稍后会讲)，并向堆中加载一个 Class 对象 (也叫镜像类，主要用来执行反射操作) 。
2. 验证 ，验证阶段保证加载字节码文件符合运行要求，保护虚拟机安全。
3. 准备 ，为静态量赋值并初始化常量。
4. 解析 ，解析字段，接口和方法，将符号引用转换成直接引用，直接引用会直接入驻常量池，而符号引用则需要通过解析阶段来实际指向运行时常量池中的直接引用的地址。
5. 初始化 ，调用 `<clinit>` 方法对类进行初始化。
6. 卸载 ，在类的所有实例被回收且 Class 对象不被持有时被卸载，或当对应的 ClassLoader (类加载器)被回收时被卸载。

类的数据是在元数据区和堆上分别加载的，堆上的 Class 对象用来执行反射等操作，元数据区的 Klass 是一种 JVM 的底层结构，由 C++ 实现，被用来描述 Java 类。

---

#### JVM 对象模型与实例化

我们刚才提到了 Klass 这一底层结构，接下来我们来结合内存具体分析 JVM 内部的对象模型。也就是在 JVM 中，面向对象究竟是怎么实现的。

JVM 对面向对象底层采用了 [oop-Klass](https://wiki.openjdk.org/display/HotSpot/CompressedOops) 模型，实例在内存中存储是由 **oop (普通对象指针)** 实现的，用来表示对象的实例信息。在 Java 程序运行的过程中，先对 Klass 对象进行初始化工作，然后再用它来实例化 oop 对象。

以下代码取自 [openjdk/jdk17u-dev: https://openjdk.org/projects/jdk-updates (github.com)](https://github.com/openjdk/jdk17u-dev) ，强烈建议大家配合源码阅读。

##### oop

关于 oop 的历史可以追溯到另一门优秀的面向对象编程语言 smalltalk ，它对 C++ 和 Java 等语言有着深远的影响。Sun 收购其虚拟机 [strongtalk](https://www.strongtalk.org/) ，并用其技术提升 JVM 性能，oop 模型沿用至今，如今 strongtalk 虚拟机已被 Sun 公司开源。

> // oopDesc is the top baseclass for objects classes. The {name}Desc classes describe
> // the format of Java objects so the fields can be accessed from C++.
> // oopDesc is abstract.

我们首先来看 oop 体系的继承关系，oop 是 oop 体系中的最高父类，其子类分别是 InstanceOop 和 arrayOop ，前者表示Java中普通的对象，后者则表示数组对象。 ArrayOop 有两个子类， ObjArrayOop 表示普通对象类型的数组，而 typeArrayOopDesc 则表示基础类型的数组。

**在 HotSpot 虚拟机中，每个 oop 的布局可以分为对象头、对象体(实例数据)和对齐填充。**

1. 对象头，负责存储 markword ， Klass 类型指针，数组长度，其中 markword 的类型是 markOop 也继承自 oop，但不属于 Java 的 oop 体系，其中主要存储对象相关的信息如hash值、线程ID、分代年龄和锁信息。Klass 类型指针指向此 oop 的 Klass 。数组长度只有数组对象会存储。
2. 对象体， JVM 将 Java 对象的 field 存储在 oop 的对象体中，oop 提供了一系列的方法来获取和设置 field ，并且针对每种基础类型都提供了特有的实现。每个 field 在 oop 中都有一个对应的偏移量， oop 通过该偏移量得到该 field 的地址，再根据地址得到具体数据。
3. 对齐填充，对象的大小必须是8字节的整数倍，当对象实例数据部分没有对齐时，就需要通过对齐填充来补全。

```cpp
//...
class oopDesc {
 private:
  volatile markWord _mark;
  union _metadata {
    Klass*      _klass;
    narrowKlass _compressed_klass;
  } _metadata;
//...
}
//...
```

JVM 中，**每创建一个新的实例就是创建一个新的 oop** ，具体过程为堆上为其分配内存，初始化零值，设置对象头，并通过 `<init>` 方法初始化。

##### Klass

**Klass 继承了 Metadata ，被存储在元空间**。其 C++ 类的继承体系跟 oop 呈对应关系，不同的是， InstanceKlass 下有三个子类 InstanceMirrorKlass ， InstanceClassLoaderKlass 和 InstanceRefKlass ，分别用来表示 java/lang/Class ， ClassLoader  ，和 java/lang/ref/Reference 及其子类，这三种是 Klass 的特殊实现。

>// A Klass provides:
>//  1: language level class object (method dictionary etc.)
>//  2: provide vm dispatch behavior for the object
>// Both functions are combined into one C++ class.

**Klass 中保存了一个Java对象的类型信息，包括类名、限定符、常量池、虚函数表等**。每个字节码文件被 JVM 加载之后，会被解析成一个 Klass 对象存储在元空间中，同时 JVM 会在堆上加载一个 java/lang/Class 实例，用来表示类对象。Klass 内含有 java_mirror 字段，指向该类所对应的 Java 镜像 java/lang/Class 实例。同时 HotSpot 会给 Class 对象注入一个隐藏字段 klass ，用于指回到其对应的 Klass 。

```cpp
//...
class Klass : public Metadata {
 protected:
  // The "layout helper" is a combined descriptor of object layout.
  //...
  jint        _layout_helper;
  // Klass identifier used to implement devirtualized oop closure dispatching.
  const KlassID _id;
  // Processed access flags, for use by Class.getModifiers.
  jint        _modifier_flags;
  juint       _super_check_offset;
  // Class name.  Instance classes: java/lang/String, etc.  Array classes: [I,
  // [Ljava/lang/String;, etc.  Set to zero for all other kinds of classes.
  Symbol*     _name;
  Klass*      _secondary_super_cache;
  Array<Klass*>* _secondary_supers;
  Klass*      _primary_supers[_primary_super_limit];
  OopHandle   _java_mirror;
  Klass*      _super;
  Klass* volatile _subklass;
  // Sibling link (or NULL); links all subklasses of a klass
  Klass* volatile _next_sibling;
  // All klasses loaded by a class loader are chained through these links
  Klass*      _next_link;
  // The VM's representation of the ClassLoader used to load this class.
  // Provide access the corresponding instance java.lang.ClassLoader.
  ClassLoaderData* _class_loader_data;
  int _vtable_len;              // vtable length. This field may be read very often when we
                                // have lots of itable dispatches (e.g., lambdas and streams).
                                // Keep it away from the beginning of a Klass to avoid cacheline
                                // contention that may happen when a nearby object is modified.
  AccessFlags _access_flags;    // Access flags. The class/interface distinction is stored here.

  JFR_ONLY(DEFINE_TRACE_ID_FIELD;)
  // Biased locking implementation and statistics
  // (the 64-bit chunk goes first, to avoid some fragmentation)
  jlong    _last_biased_lock_bulk_revocation_time;
  markWord _prototype_header;   // Used when biased locking is both enabled and disabled for this type
  //...
}
//...
```

Klass 中通过虚函数表实现了对象的虚分派。所谓的虚分派，是 JVM 用来实现多态的一种机制。在调用方法时，JVM 会将它们绑定到正确的实现上，该机制的实现用到了 Klass 中的虚函数表。

虚函数表可看成是由多个 vtableEntry 组成的数组，其中每个元素都包含了一个方法的地址。在进行虚分派时，JVM会根据方法在虚函数表中的索引，找到对应的 vtableEntry ，进而得到方法的实际地址，最后根据该地址找到方法的字节码并执行。这样**每个实例也就是 oop 不必单独维护一张虚函数表，虚函数表都由 Klass 负责维护**。

---

#### 实例的动态管理

在生产过程中，内存空间交由程序员手动分配和清理内存会使得编写业务代码变得异常复杂，同时带来了内存泄露的风险。为了解决这些问题 Java 选择把直接创建和销毁对象的权力交给 JVM ，即让 JVM 自动管理内存空间。

与 C++ 类似，**Java 使用 new 关键字来为实例动态分配内存并创建**。不同的是，**创建对象后 JVM 便会接管对象，并在确保该对象不被使用时自动回收**，我们把不再被使用的对象称为 Garbage ，回收这些对象空间的算法就被称作 [Garbage Collection](https://wiki.openjdk.org/display/HotSpot/Garbage+Collection) 。

常见的分配内存方法有指针碰撞，空闲列表。常见的垃圾回收算法思想有引用计数算法，可达性分析算法，分代回收等。此外，不同的 GC 机制经常同时作用在 JVM 上，最新的 GC 算法有 [G1](https://wiki.openjdk.org/display/HotSpot/G1GC+Feedback) 和 [ZGC](https://wiki.openjdk.org/display/zgc) ，在这里我们先不深究每种算法的具体过程。

随版本不断迭代，JVM 的性能逐渐得到提升，众多 JVM 提供的优秀设计极大促进了 Java 生态的进步，可以说，JVM 的成功极大的推动了 Java 的成功。

---

#### JIT 技术

刚才我们讲到了前端编译，现在我们来看看后端编译，也就是我们常说的 JIT 技术。

**JIT (即时编译技术)是提升 JVM 运行时性能的重要优化手段。**

一般情况下， JVM 通过解释字节码运行，其执行速度必然会比可执行的二进制字节码程序慢很多。JVM 引入 JIT 技术来解决效率问题，当 JVM 发现某个方法或代码块运行特别频繁的时候，就会认为这是 Hot Spot Code ，JIT 会把部分 Hot Spot Code 翻译成本地机器相关的机器码，通过直接运行优化后的原生机器码，JVM 的性能的上限被显著提升。

JIT 优化中最重要的一个就是 Escape Analysis 逃逸分析。逃逸分析是一种静态分析技术，用于确定对象在程序中的作用域，在 Java SE 6u23+ 开始支持，并默认设置为启用状态。它的目的是分析对象在整个程序执行过程中的生命周期，并确定它是否可以被局部化或优化。使用逃逸分析，编译器可以对代码做如下优化。

**锁消除和锁粗化**，如果一个对象被发现只能从一个线程被访问到，那么对于这个对象的操作可以不考虑锁操作。如果逃逸分析确定某些对象的锁操作频繁并且没有逃逸，编译器可以将多个锁操作合并为一个更粗粒度的锁操作，减少了锁竞争的开销。

**方法内联**，当一个方法调用不逃逸时，编译器可以将方法的实现直接插入到调用的位置，避免了方法调用的开销，减少栈帧的创建和销毁成本，并且可以更好地进行其他优化，如代码消除、常量传播等。这可以提高应用程序的执行速度。

**标量替换**，有的对象可能不需要作为一个连续的内存结构存在也可以被访问到，那么对象的部分可以不存储在内存，而是存储在 CPU 寄存器中，在 JIT 阶段，如果经过逃逸分析，发现一个对象不会被外界访问的话，那么经过 JIT 优化，就会把这个对象拆解成若干个其中包含的若干个成员变量来代替，这个过程就是标量替换。同时，如果一个对象在子程序中被分配，并且指向该对象的指针永远不会逃逸，那么该对象可以直接在栈上分配，减少了内存分配和回收的开销。

**数组扁平化**，数组扁平化是指将多维数组转换为一维数组的过程。它的目的是提高对数组元素的访问效率，简化数组的处理和操作。在实际应用中，可以根据具体的数据结构和访问模式来决定是否进行数组扁平化，并根据优化策略进行相应的实现和调整，以达到最佳的访问效率。

JIT 对于 Java 来说是非常重要的一项面向未来的技术，它是 GraalVM 的前身，为 Java 云原生之路打下了良好基础。

#### 小结

本文带领大家了解 Java 是如何编译和运行在 JVM 上的，并粗浅带大家了解了 JVM 一部分运作原理和技术。时代在不断前进，技术在不断更新迭代，Java 的技术变革之路早已悄然发生。

拥抱新技术，面向新时代，是在变革浪潮中的我们唯一能做的事。


        """.trimIndent(), tags = listOf("test", "Java")
        )
    }

    fun createArticle(article: Article) {

    }

    fun publishArticle(article: Article) {

    }

    fun updateArticle(article: Article) {

    }

    fun cancelArticle(articleId: Long) {

    }

    fun deleteArticle(articleId: Long) {

    }
}

