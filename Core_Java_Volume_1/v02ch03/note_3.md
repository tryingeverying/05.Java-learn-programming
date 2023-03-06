#   Java基本程序设计结构

## Java的类名的要求

> 必须是以字母开头后面可以是字母和数字的任意组合，长度原则上没有限制。推荐使用驼峰命名法(CamelCase):即以大写字母开头，如若是由多个单词组成的则每个单词的首字母大写。
> **重点** 源代码的文件名和公共类的名字必须相同

## 字符串的界定

> java和C++一样都是采用的“”界定字符串的，和python的''和""可以混用的不一样。

## 输入

> java的打印结果是调用的System.out里的println方法和print方法，区别是println方法后面自带换行，print则没有换行

## 注释

1. //待注释内容到行尾
2. /* 多行注释 */
3. /** 自动生成注释文档*/ 这个优点类似于python里的"""待注释内容"""

## 变量的声明

> 和C语言一样Java的变量也需要在使用前进行声明变量的类型，但是和C语言有所不同的是Java可是在任何位置进行变量的声明。但是变量的声明要尽可能的接近第一次使用的位置
> 自Java10后对于**局部变量**如果可以从初始值判断出他的类型则只需使用关键词var即可，无需指定类型。

```java
var vacationDays = 12;
var greeting = "Hello";
```

## 常量

> java中利用关键字final表明常量，fianl表示后面的变量只能被赋值一次，一旦被赋值则不可被更改，习惯上常量名全部使用大写字母

```java
final double CM_PER_INCH = 2.54;
```

> 如果一个常量需要在一个类中的多个方法被称为  `类常量`(class constant),可以使用staticfinal设置类常量，但是类常量的定义需要在main方法的外部

```java
public class Constants2
{
    public static final double CM_PER_INCH = 2.54;
    public static void main(String[] args)
    {
        double paperWidth = 2.5;
        double paperHeight = 11;
        System.out.println("Paper size in centimeters:" + paperWidth * CM_PER_INCH + "by" + paperHeight * CM_PER_INCH);
    }
}
```

## java的运算

> 当/运算符的两端都是整数时，在java中表示取整运算eg:15/2=7,两端至少有一个为浮点型的时候才是浮点除法。
> %表示求余运算
> 幂运算，Java中没有内置幂运算，因此需要借助Math类中的pow方法

```java
double y = Math.pow(x,a);
```

表示y的值为x的n次幂

> 求余运算floorMod(position + adjustment,12)总会得到一个0~11的数，不论position + adjustment的正负

## 类型转换

> 一个二元运算符连接两个值的时候先要将两个操作数转换为一个类型再进行计算,eg: n + f n是整数 f是浮点数
>
> - 如果两个操作数中只有一个是double则另一个也被转化为double
> - 否则其中是float，则另一个也被转化为float
> - 否则一个是long，另一个也被自动转化为long
> - 再否则才会两个都被转化为int
> - 即double>float>long>int

### 强制类型转化

> 语法格式是在()中给出想转换的目标类型，后面紧跟待转换的变量名

```java
double x = 9.997;
int nx = (int) x;
```

> 上面那个是取整，即强制截取，nx是9。如果想四舍五入则需要Math.round方法

```java
double x = 9.997;
int nx = (int) Math.round(x);
```

> 现在nx的值变成了10

## 结合赋值和运算符

> 如果x是int,则
> x +=3.5;
> 虽然不会出bug但是等效于(int)(x+3.5)

## 自增和自减运算

> i++ 和 ++i都能使用但是2++这种对于常量的操作是不合法的
> i++ 和 ++i的区别
> i++如果被调用是先执行调用操作后执行自增操作
> ++i如果被调用是先执行自增操行调用操作

```java
int m = 7;
int n = 7;
int a = 2 * ++m; //a是16, m是8
int b = 2 * n++; //a是14, n是8
```

## 逻辑运算

> && 表示与
> || 表示或
> java的 与/或 逻辑运算也是有短路方法的 &&运算中前面哪个只要是false后面的不判断直接输出false，|| 运算只要前面是true后面的不判断直接输出true。
> 三元操作符? 语法如下
> condition ? expression1 : expression2
> 如果condition判断为true则返回expression1，false则返回expression2
> x < y ? x:y
> 返回x，y中较小的哪个

## 检测字符串是否相等

> 不可以使用==进行判断在java里==运算符只能确定两个字符串是否存放在一个位置
> 判断字符串是否相等要使用equals()方法
> eg:s.equals(t)就是判断字符串s和t是否相等，相等返回true 不等返回false
> .equalsIgnoreCase()是在不区分大小写的情况下判断字符串是否相等
