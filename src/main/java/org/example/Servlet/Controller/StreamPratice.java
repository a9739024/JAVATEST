package org.example.Servlet.Controller;

import org.example.Servlet.Models.Employee;
import org.example.Servlet.Models.ShangHu;
import org.example.Servlet.Models.Trader;
import org.example.Servlet.Models.Transaction;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPratice {
    private Trader raoul = new Trader("Raoul", "Cambridge");
    private Trader mario = new Trader("Mario", "Milan");
    private Trader alan = new Trader("Alan", "Cambridge");
    private Trader brian = new Trader("Brian", "Cambridge");

    private List<Transaction> transactionList = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    //TODO ... 待添加的方法...

    @Test
    void test_01 () {
        /*
        * 找出2011年发生的所有交易，并按交易额排序（从高到低）。
        * */
        List<Transaction> transactions = transactionList.stream().filter(i->i.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue).reversed()).collect(Collectors.toList());
        System.out.println("找出2011年发生的所有交易，并按交易额排序（从高到低）:" + transactions);
    }

    @Test
    void test_02 () {
        /*
         * 交易员都在哪些不同的城市工作过？
         * */
        List<String> areas = transactionList.stream().map(Transaction::getTrader).map(Trader::getCity).collect(Collectors.toList());
        System.out.println("交易员都在哪些不同的城市工作过:" + areas);
    }

    @Test
    void test_03 () {
        /*
         * 查找所有来自Cambridge的交易员，并按姓名排序。
         * */
        List<Trader> traders = transactionList.stream().map(Transaction::getTrader).distinct()
                .filter(t->t.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println("查找所有来自Cambridge的交易员，并按姓名排序:" + traders);
    }

    @Test
    void test_04 () {
        /*
         * 返回所有交易员的姓名字符串，按字母顺序排序。
         * */
        List<String> names = transactionList.stream().map(Transaction::getTrader).map(Trader::getName).sorted().collect(Collectors.toList());
        System.out.println("返回所有交易员的姓名字符串，按字母顺序排序:" + names);

    }

    @Test
    void test_05 () {
        /*
         * 有没有交易员在Milan工作。
         * */
        List<Trader> milans = transactionList.stream().map(Transaction::getTrader).distinct().filter(t->t.getCity().equals("Milan")).collect(Collectors.toList());
        System.out.println("有没有交易员在Milan工作:" + milans);
    }

    @Test
    void test_06 () {
        /*
         * 打印生活在Cambridge的交易员的所有交易额。
         * */
        int total = transactionList.stream().mapToInt(Transaction::getValue).sum();
        System.out.println("打印生活在Cambridge的交易员的所有交易额:" + total);
    }

    @Test
    void test_07 () {
        /*
         * 所有的交易额中，最高的交易额是多少？
         * */
        int max = transactionList.stream().mapToInt(Transaction::getValue).max().getAsInt();
        System.out.println("所有的交易额中，最高的交易额是多少:" + max);
    }

    @Test
    void test_08 () {
        /*
         * 所有的交易额中，找到交易额最小的交易
         * */
        int min = transactionList.stream().mapToInt(Transaction::getValue).min().getAsInt();
        System.out.println("所有的交易额中，找到交易额最小的交易:" + min);
    }

    public static void main(String[] Args){
        StreamPratice mainApp = new StreamPratice();
        mainApp.test_01();
        mainApp.test_02();
        mainApp.test_03();
        mainApp.test_04();
        mainApp.test_05();
        mainApp.test_06();
        mainApp.test_07();
        mainApp.test_08();

        //1.请使用 Java Stream 实现将 List 转换为 Map，key 是字符串的长度，value 是该长度的字符串列表
        List<String> stringList = Arrays.asList("aa","bbb","uuuuuuuu","cccd","dddef","oo");
        Map<Integer,List<String>> listMap = stringList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("请使用 Java Stream 实现将 List 转换为 Map，key 是字符串的长度，value 是该长度的字符串列表:" + listMap);

        //2.请使用 Java Stream 实现过滤出 List 中所有大于等于 10 的元素
        List<Integer> list= Arrays.asList(1,3,5,10,11,45,25);
        List<Integer> biggerTen = list.stream().filter(n->n > 10).collect(Collectors.toList());
        System.out.println("请使用 Java Stream 实现过滤出 List 中所有大于等于 10 的元素:" + biggerTen);

        //3.请使用 Java Stream 合并两个 List，去重，然后升序排列
        List<Integer> a= Arrays.asList(1,5,2);
        List<Integer> b= Arrays.asList(2,6,3,10,5);
        List<Integer> merge = Stream.concat(a.stream(),b.stream()).distinct().sorted().collect(Collectors.toList());
        System.out.println("请使用 Java Stream 合并两个 List，去重，然后升序排列:" + merge);

        //4.请使用 Java Stream 将 Map 中所有 value 转换为列表
        Map<Integer,Integer> intMap = new HashMap<>();
        intMap.put(1,10);
        intMap.put(2,20);
        intMap.put(3,30);
        List<Integer> values = intMap.values().stream().collect(Collectors.toList());
        System.out.println("请使用 Java Stream 将 Map 中所有 value 转换为列表:" + values);

        //5.请使用 Java Stream 实现对 List 中每个元素进行平方操作
        List<Integer> squaredList = Arrays.asList(1,2,3,4,5);
        List<Integer> doubleD = squaredList.stream().map(x->x *x).collect(Collectors.toList());
        System.out.println("请使用 Java Stream 实现对 List 中每个元素进行平方操作:" + doubleD);

        //6.使用Stream流来完成以下操作 (1)生成id为key ,名称为value的map (2) 获取所有评分大于4.5,菜品包含A,B两类的所有商户的评价数之和
        List<ShangHu> sh = new ArrayList<>();
        sh.add(new ShangHu("1","商户A",5, Arrays.asList("A1","B1"),10));
        sh.add(new ShangHu("2","商户B",6, Arrays.asList("A2","B3"),20));
        sh.add(new ShangHu("3","商户C",10, Arrays.asList("A4","B5"),1));
        sh.add(new ShangHu("4","商户D",3, Arrays.asList("C6","C7"),5));
        sh.add(new ShangHu("5","商户E",7, Arrays.asList("D1","E1"),6));
        Map<String,String> maps = sh.stream().collect(Collectors.toMap(ShangHu::getId, ShangHu::getName));
        System.out.println("生成id为key ,名称为value的map:" + maps);
        System.out.println("===============================");
        int sum = sh.stream().filter(pf->pf.getPingFen() > 4.5)
                .filter(x-> x.getCaiPin().stream().anyMatch(y->y.startsWith("A")))
                .filter(x-> x.getCaiPin().stream().anyMatch(y->y.startsWith("B")))
                        .mapToInt(ShangHu::getPingJiaShu).sum();
        System.out.println("获取所有评分大于4.5,菜品包含A,B两类的所有商户的评价数之和:" + sum);

        //7.计算List<Integer>中所有偶数的平均值
        List<Integer> avgList = Arrays.asList(1,2,3,4,5,6);
        double avg = avgList.stream().filter(n->n % 2 == 0).mapToDouble(x->x).average().orElse(0.0);
        System.out.println("计算List<Integer>中所有偶数的平均值:" + avg);

        //8. 将List<String>中的字符串连接成一个单独的字符串，并用逗号分隔
        List<String> buildList = Arrays.asList("a","b","c","d","e");
        String bb = buildList.stream().collect(Collectors.joining(","));
        System.out.println("将List<String>中的字符串连接成一个单独的字符串，并用逗号分隔:" + bb);

        //9. 将List<Employee>中的年龄进行排序，并输出排序后的员工列表
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1,10));
        emp.add(new Employee(2,1));
        emp.add(new Employee(3,30));
        List<Employee> employeeLst = emp.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
        System.out.println("将List<Employee>中的年龄进行排序，并输出排序后的员工列表:" + employeeLst);

        //10.将List<Integer>中的元素拼接成一个由逗号分隔的字符串，并去重
        List<Integer> reDupli = Arrays.asList(1,2,3,3,4,5);
        String reB = reDupli.stream().distinct().map(Object::toString).collect(Collectors.joining(","));
        System.out.println("将List<Integer>中的元素拼接成一个由逗号分隔的字符串，并去重:" + reB);

        //11.计算List<Double>中的最大值、最小值、总和以及平均值
        List<Double> doubles = Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0);
        double max = doubles.stream().max(Double::compare).get();
        double min = doubles.stream().min(Double::compare).get();
        double averages = doubles.stream().mapToDouble(x->x).average().getAsDouble();
        double sums = doubles.stream().mapToDouble(x->x).sum();
        System.out.println("max:" + max + " min:" + min + " sumDouble:" + sums +" average:" + averages);

    }

}
